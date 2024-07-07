package com.tbemerencio.salesnotification.controllers.dto;

import com.tbemerencio.salesnotification.entities.Channel;
import com.tbemerencio.salesnotification.entities.Notification;
import com.tbemerencio.salesnotification.entities.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDTO(
        LocalDateTime dateTime,
        String destination,
        String message,
        Channel.ChannelEnums channel) {

    public Notification toNotification(){
        return new Notification(dateTime, destination, message,
                channel.toChannel(), Status.StatusEnums.PENDING.toStatus());
    }
}
