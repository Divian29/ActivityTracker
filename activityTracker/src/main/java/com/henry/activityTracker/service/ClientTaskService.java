package com.henry.activityTracker.service;

import com.henry.activityTracker.model.ClientTaskModel;
import com.henry.activityTracker.repository.ClientTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
    @Service
    public class ClientTaskService {
        private final ClientTaskRepository clientTaskRepository;

        @Autowired
        public ClientTaskService(ClientTaskRepository clientTaskRepository) {
            this.clientTaskRepository = clientTaskRepository;
        }

        public ClientTaskModel createTask(ClientTaskModel clientTaskModel) {
            return clientTaskRepository.save(clientTaskModel);
        }

        public ClientTaskModel getTaskById(Long id) {
            return clientTaskRepository.findById(id).orElse(null);
        }

        public Iterable<ClientTaskModel> getAllTasks() {

            return clientTaskRepository.findAll();
        }

        public ClientTaskModel updateTask(Long id, ClientTaskModel updatedTask) {
            ClientTaskModel existingTask = getTaskById(id);
            if (existingTask != null) {
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setStatus(updatedTask.getStatus());
                existingTask.setDueDate(LocalDateTime.now());
                existingTask.setCompletedTime(updatedTask.getCompletedTime());
                return clientTaskRepository.save(existingTask);
            }
            return null; // Task not found
        }

    }




