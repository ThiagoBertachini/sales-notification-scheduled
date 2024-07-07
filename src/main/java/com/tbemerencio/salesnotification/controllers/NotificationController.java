package com.tbemerencio.salesnotification.controllers;

import com.tbemerencio.salesnotification.controllers.dto.ScheduleNotificationDTO;
import com.tbemerencio.salesnotification.entities.Notification;
import com.tbemerencio.salesnotification.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO dto){
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/{notificationId}")
    private ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long id){
        var notification = notificationService.getNotification(id);
        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{notificationId}")
    private ResponseEntity<Void> deletetNotification(@PathVariable("notificationId") Long id){
        notificationService.cancelNotification(id);
        return ResponseEntity.noContent().build();
    }
}
