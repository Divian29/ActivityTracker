package com.henry.activityTracker.model;

import com.henry.activityTracker.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Entity
    @Table(name = "task_table")
    public class ClientTaskModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;
        private String description;

        @Enumerated(EnumType.STRING)
        private Status status;

        @CreationTimestamp
        private Instant createdTime;

        private LocalDateTime dueDate;

        private Instant completedTime;

    }




