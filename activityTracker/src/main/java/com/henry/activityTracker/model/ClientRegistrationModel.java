package com.henry.activityTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "client_table")
    @Entity
    public class ClientRegistrationModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String userName;
        private int age;
        private String password;

    }



