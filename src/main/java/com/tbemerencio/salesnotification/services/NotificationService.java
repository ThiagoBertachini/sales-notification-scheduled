package com.tbemerencio.salesnotification.services;

import com.tbemerencio.salesnotification.controllers.dto.ScheduleNotificationDTO;
import com.tbemerencio.salesnotification.entities.Notification;
import com.tbemerencio.salesnotification.entities.Status;
import com.tbemerencio.salesnotification.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDTO dto){
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> getNotification(Long notificationId){
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId){
        var notification = notificationRepository.findById(notificationId);

        if (notification.isPresent()){
            notification.get().setStatus(Status.StatusEnums.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime){
        List<Notification> notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(Status.StatusEnums.ERROR.toStatus(),
                        Status.StatusEnums.PENDING.toStatus()),
                dateTime
        );

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            // TODO: sent notification
            notification.setStatus(Status.StatusEnums.SUCCESS.toStatus());
            notificationRepository.save(notification);
        };
    }
}
