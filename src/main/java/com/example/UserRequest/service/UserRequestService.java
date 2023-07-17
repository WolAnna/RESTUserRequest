package com.example.UserRequest.service;

import com.example.UserRequest.REST.modelREST.RestUserDTO;
import com.example.UserRequest.webclient.GitHubClient;
import lombok.RequiredArgsConstructor;
import com.example.UserRequest.DB.DBClient;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserRequestService {
    private final GitHubClient gitHubClient;
    private final DBClient dbClient;

    public RestUserDTO getRestUserByLogin(String login) {
        RestUserDTO restUserDTO = gitHubClient.getGitHubUserByLogin(login);

        if (restUserDTO != null) {
            dbClient.saveRequestByLogin(login);
        }
        return restUserDTO;
    }

}

