package com.life.support.sehat.service;

import com.life.support.sehat.models.Booking;

public interface NotificationService {
    boolean pushNotificationToDriver(long driverId);
    boolean pushNotificationToUser(long userId);

}
