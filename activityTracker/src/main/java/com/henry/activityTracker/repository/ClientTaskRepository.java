package com.henry.activityTracker.repository;

import com.henry.activityTracker.model.ClientTaskModel;
import com.henry.activityTracker.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface ClientTaskRepository extends JpaRepository<ClientTaskModel, Long> {

        List<ClientTaskModel> findByStatus(Status status);
    }



