package com.henry.activityTracker.service;

import com.henry.activityTracker.model.ClientRegistrationModel;
import com.henry.activityTracker.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 @Service
    public class ClientRegistrationService {
        private ClientRepository clientRepository;

        @Autowired
        public ClientRegistrationService(ClientRepository customerRepository) {
            this.clientRepository = customerRepository;
        }


        public ClientRegistrationModel registerCustomer(String firstName, String lastName, String email, String userName, Integer age, String password){

            if(userName == null || password == null){
                return null;
            }
            else {
                if(clientRepository.findFirstByUserName(userName).isPresent()){
                    return null;
                }
                else {
                    ClientRegistrationModel clientModel = new ClientRegistrationModel();

                    clientModel.setFirstName(firstName);
                    clientModel.setLastName(lastName);
                    clientModel.setEmail(email);
                    clientModel.setUserName(userName);
                    clientModel.setAge(age);
                    clientModel.setPassword(password);

                    clientRepository.save(clientModel);
                    return clientModel;
                }

            }
        }
        public ClientRegistrationModel loginSer(String userName, String password){
            return clientRepository.findCustomerModelByUserNameAndPassword(userName,password).orElse(null);
        }

    }



