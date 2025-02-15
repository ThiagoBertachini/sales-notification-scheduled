package com.tbemerencio.salesnotification.repositories;

import com.tbemerencio.salesnotification.entities.Notification;
import com.tbemerencio.salesnotification.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
