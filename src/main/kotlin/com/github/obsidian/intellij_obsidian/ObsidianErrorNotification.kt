package com.github.obsidian.intellij_obsidian

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

class ObsidianErrorNotification {
    companion object {
        fun notifyError(project: Project, content: String) {
            NotificationGroupManager.getInstance()
                    .getNotificationGroup("Balloon Notification")
                    .createNotification(content, NotificationType.ERROR)
                    .notify(project);
        }
    }
}
