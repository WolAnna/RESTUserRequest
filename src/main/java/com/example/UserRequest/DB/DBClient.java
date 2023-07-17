package com.example.UserRequest.DB;

import com.example.UserRequest.DB.modelDB.UserRequestDB;
import com.example.UserRequest.DB.repositories.UserRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DBClient {

    private final UserRequestRepository userRequestRepository;

    public void saveRequestByLogin(String login) {
        UserRequestDB user = userRequestRepository.getUserByLogin(login);

        if (user == null)//nie ma użytkownika w BD
            user = new UserRequestDB(login);
        else
            user.IncreaseRequestCount();

        userRequestRepository.save(user);
    }

}
