package com.henry.activityTracker.controller;

import com.henry.activityTracker.model.ClientTaskModel;
import com.henry.activityTracker.service.ClientTaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

    @Controller
    public class ClientTaskStatusController {

        private ClientTaskStatusService clientTaskStatusService;

        @Autowired
        public ClientTaskStatusController(ClientTaskStatusService clientTaskStatusService) {
            this.clientTaskStatusService = clientTaskStatusService;
        }



        @GetMapping("/tasks/done")
        public String getTasksWithStatusDone(Model model) {
            System.out.println("are you here");
            List<ClientTaskModel> tasks = clientTaskStatusService.getTasksWithStatusDone();
            System.out.println("did you get to this place");
            model.addAttribute("tasks", tasks);
            System.out.println("welcome here");
            return "taskDone";
        }
        @GetMapping("/tasks/progress")
        public String getTasksWithStatusInProgress(Model model) {
            List<ClientTaskModel> tasks = clientTaskStatusService.getTasksWithStatusInProgress();
            model.addAttribute("tasks", tasks);
            return "taskDone";
        }

        @GetMapping("/tasks/todo")
        public String getTasksWithStatusTodo(Model model) {
            List<ClientTaskModel> tasks = clientTaskStatusService.getTasksWithStatusTodo();
            model.addAttribute("tasks", tasks);
            return "taskDone";
        }
    }



