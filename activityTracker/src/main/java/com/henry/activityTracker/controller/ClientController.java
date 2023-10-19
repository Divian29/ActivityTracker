package com.henry.activityTracker.controller;

import com.henry.activityTracker.model.ClientRegistrationModel;
import com.henry.activityTracker.service.ClientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class ClientController {

        private ClientRegistrationService clientRegistrationService;

        @Autowired
        public ClientController(ClientRegistrationService clientRegistrationService) {
            this.clientRegistrationService = clientRegistrationService;
        }

        @GetMapping("/cus_register")
        public String Registration(Model model){
            model.addAttribute("customerModel", new ClientRegistrationModel());
            return "customer_register_page";
        }

        @PostMapping("/cus_register")
        public String RegisterPost(@ModelAttribute ClientRegistrationModel clientRegistrationModel){
            ClientRegistrationModel registeredCustomer = clientRegistrationService.registerCustomer(clientRegistrationModel.getFirstName(),clientRegistrationModel.getLastName(),clientRegistrationModel.getEmail(),clientRegistrationModel.getUserName(),
                    clientRegistrationModel.getAge(),clientRegistrationModel.getPassword());

            return registeredCustomer == null ? "errorPage" : "customerLogin";
        }
    }



