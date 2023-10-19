package com.henry.activityTracker.controller;

import com.henry.activityTracker.model.ClientRegistrationModel;
import com.henry.activityTracker.service.ClientRegistrationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


    @Controller
    public class ClientLoginController {
        private final ClientRegistrationService customerService;

        @Autowired
        public ClientLoginController(ClientRegistrationService customerService) {
            this.customerService = customerService;
        }

        @GetMapping("/cus_login")
        public String login(Model model){
            model.addAttribute("customerModel", new ClientRegistrationModel());
            return "customerLogin";
        }
        @GetMapping("/MainHomePage")
        public String mainHomePage(Model model){
            model.addAttribute("customerModel", new ClientRegistrationModel());
            return "homePage";
        }

        @PostMapping("/cus_login")
        public String loginPost(@ModelAttribute ClientRegistrationModel customerModel, Model model, HttpSession httpSession){
            ClientRegistrationModel checkModel = customerService.loginSer(customerModel.getUserName(),customerModel.getPassword());
            if(checkModel != null){
                model.addAttribute("checkLogin", checkModel.getFirstName());
                httpSession.setAttribute("customerId",checkModel.getId());
                return "redirect:/MainHomePage";
            }
            else {
                return "errorPage";
            }
        }
    }




