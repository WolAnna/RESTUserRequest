package com.example.UserRequest.webclient.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
dane z githubAPI
*/

@Setter @Getter
@ToString
public class GitHubUserDTO {
    private Integer id;
    private String login;
    private String name;
    private String type;
    private String avatar_url;
    private String created_at;
    private Integer followers;
    private Integer public_repos;
}
