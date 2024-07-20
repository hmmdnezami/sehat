package com.life.support.sehat.service.impl;

import com.life.support.sehat.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    /**
     * @param driverId
     * @return
     */
    @Override
    public boolean pushNotificationToDriver(long driverId) {
        return false;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public boolean pushNotificationToUser(long userId) {
        return false;
    }
}
