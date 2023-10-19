package com.henry.activityTracker.service;

import com.henry.activityTracker.model.ClientTaskModel;
import com.henry.activityTracker.model.enums.Status;
import com.henry.activityTracker.repository.ClientTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
    @Service
    public class ClientTaskStatusService {

        private ClientTaskRepository clientTaskRepository;

        @Autowired
        public ClientTaskStatusService(ClientTaskRepository clientTaskRepository) {
            this.clientTaskRepository = clientTaskRepository;
        }

        public List<ClientTaskModel> getTasksWithStatusDone() {
            return clientTaskRepository.findByStatus(Status.DONE);
        }
        public List<ClientTaskModel> getTasksWithStatusInProgress() {
            return clientTaskRepository.findByStatus(Status.IN_PROGRESS);
        }
        public List<ClientTaskModel> getTasksWithStatusTodo() {
            return clientTaskRepository.findByStatus(Status.TODO);
        }
    }



