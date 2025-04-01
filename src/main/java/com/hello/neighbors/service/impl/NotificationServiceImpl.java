package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Notification;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.NotificationCreateDto;
import com.hello.neighbors.entity.dto.NotificationDeleteDto;
import com.hello.neighbors.entity.dto.NotificationMarkAsDto;
import com.hello.neighbors.repository.NotificationRepository;
import com.hello.neighbors.service.NotificationService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = LogManager.getLogger();

    private NotificationRepository notificationRepository;

    @Override
    public Notification create(NotificationCreateDto dto) {
        Subscriber recipient = new Subscriber();
        recipient.setId(dto.getRecipientId());

        Notification notification = new Notification(
                dto.getType(),
                dto.getContent(),
                LocalDateTime.now(),
                false,
                false,
                recipient
        );

        return notificationRepository.save(notification);
    }

    @Override
    public Notification read(NotificationMarkAsDto dto) {
        Notification notificationToUpdate = notificationRepository.findById(dto.getNotificationId())
                .orElseThrow(() -> new EntityNotFoundException("Notification not found"));
        notificationToUpdate.setRead(true);
        return notificationRepository.save(notificationToUpdate);
    }

    @Override
    public Notification archive(NotificationMarkAsDto dto) {
        Notification notificationToUpdate = notificationRepository.findById(dto.getNotificationId())
                .orElseThrow(() -> new EntityNotFoundException("Notification not found"));
        notificationToUpdate.setArchived(true);
        return notificationRepository.save(notificationToUpdate);
    }

    @Override
    public void delete(NotificationDeleteDto dto) {
        Optional<Notification> notificationToDelete = notificationRepository.findById(dto.getNotificationId());
        if (notificationToDelete.isEmpty()) {
            logger.info("Notification not find with ID :" + dto.getNotificationId());
            notificationRepository.deleteById(dto.getNotificationId());
        }
    }

    @Autowired
    public void setNotificationRepository(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
}
