package com.textitout.chat.service.implementation;

import com.textitout.chat.model.Notification;
import com.textitout.chat.repository.NotificationRepository;
import com.textitout.chat.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImplementation implements NotificationService{

    private final NotificationRepository notificationRepository;

    public NotificationServiceImplementation(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> getAllNotifications() {
        return null;
    }
}
