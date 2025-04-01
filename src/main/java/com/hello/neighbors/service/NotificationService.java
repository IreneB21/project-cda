package com.hello.neighbors.service;

import com.hello.neighbors.entity.Notification;
import com.hello.neighbors.entity.dto.NotificationCreateDto;
import com.hello.neighbors.entity.dto.NotificationDeleteDto;
import com.hello.neighbors.entity.dto.NotificationMarkAsDto;

public interface NotificationService {

    Notification create(NotificationCreateDto dto);
    Notification read(NotificationMarkAsDto dto);
    Notification archive(NotificationMarkAsDto dto);
    void delete(NotificationDeleteDto dto);
}
