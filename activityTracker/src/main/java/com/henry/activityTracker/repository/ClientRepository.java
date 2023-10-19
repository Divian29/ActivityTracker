package com.henry.activityTracker.repository;

import com.henry.activityTracker.model.ClientRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
    @Repository
    public interface ClientRepository extends JpaRepository<ClientRegistrationModel,Long> {
        Optional<ClientRegistrationModel> findCustomerModelByUserNameAndPassword (String userName, String password);
        Optional<ClientRegistrationModel> findFirstByUserName(String userName);
    }



