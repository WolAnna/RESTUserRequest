package com.example.UserRequest.webclient;

import com.example.UserRequest.REST.modelREST.RestUserDTO;
import com.example.UserRequest.webclient.dto.GitHubUserDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubClient {
    private static final String STR_URL = new String("https://api.github.com/");
    private RestTemplate restTemplate = new RestTemplate();

    public RestUserDTO getGitHubUserByLogin(String login) {
        GitHubUserDTO gitHubUserDTO = restTemplate.getForObject(STR_URL + "users/{login}",
                GitHubUserDTO.class, login);
        return new RestUserDTO(gitHubUserDTO);
    }

}
