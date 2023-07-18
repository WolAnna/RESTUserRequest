package com.example.UserRequest.REST.modelREST;

import com.example.UserRequest.webclient.dto.GitHubUserDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
@RequiredArgsConstructor
public class RestUserDTO {
    private Integer id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private Double calculations;

    public RestUserDTO(GitHubUserDTO gitHubUserDTO){
        this.id = gitHubUserDTO.getId();
        this.login = gitHubUserDTO.getLogin();
        this.name = gitHubUserDTO.getName();
        this.type = gitHubUserDTO.getType();
        this.avatarUrl = gitHubUserDTO.getAvatar_url();
        this.createdAt = gitHubUserDTO.getCreated_at();
        setCalculation(gitHubUserDTO.getFollowers(), gitHubUserDTO.getPublic_repos());
    }

    private void setCalculation(Integer intFollowers, Integer intPublicRes){
        if (intFollowers==null)
            intFollowers = 0;

        if (intPublicRes == null)
            intPublicRes = 0;

        if (intFollowers == 0)
            calculations = 0d;
        else
            calculations = 6/intFollowers.doubleValue()*(2+intPublicRes.doubleValue());
    }

}
