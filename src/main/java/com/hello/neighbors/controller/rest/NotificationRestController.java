package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.Notification;
import com.hello.neighbors.entity.dto.NotificationDeleteDto;
import com.hello.neighbors.entity.dto.NotificationMarkAsDto;
import com.hello.neighbors.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest/hello/neighbors/notification")
@CrossOrigin("${front.url}")
public class NotificationRestController {

    private NotificationService notificationService;

    //////////////// Endpoints ////////////////

    @PutMapping("/read")
    public ResponseEntity<Notification> readNotification(@RequestBody NotificationMarkAsDto dto) {
        Notification notification = notificationService.read(dto);
        return ResponseEntity.ok(notification);
    }

    @PutMapping("/archive")
    public ResponseEntity<Notification> archiveNotification(@RequestBody NotificationMarkAsDto dto) {
        Notification notification = notificationService.archive(dto);
        return ResponseEntity.ok(notification);
    }

    @DeleteMapping("/delete")
    public void deleteNotification(@RequestBody NotificationDeleteDto dto) {
        notificationService.delete(dto);
    }

    //////////////// Setters ////////////////

    @Autowired
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
