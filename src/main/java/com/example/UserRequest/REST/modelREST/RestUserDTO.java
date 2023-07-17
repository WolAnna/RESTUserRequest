package com.example.UserRequest.REST.modelREST;

import com.example.UserRequest.webclient.dto.GitHubUserDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class RestUserDTO {
    private Integer id;
    private String login;
    private String name;
    private String type;
    private String avatar_url;
    private String created_at;
    private Double calculations;
    private String test;

    public RestUserDTO(GitHubUserDTO gitHubUserDTO){
        this.id = gitHubUserDTO.getId();
        this.login = gitHubUserDTO.getLogin();
        this.name = gitHubUserDTO.getName();
        this.type = gitHubUserDTO.getType();
        this.avatar_url = gitHubUserDTO.getAvatar_url();
        this.created_at = gitHubUserDTO.getCreated_at();
        setCalculation(gitHubUserDTO.getFollowers(), gitHubUserDTO.getPublic_repos());
    }

    private void setCalculation(Integer intFollowers, Integer intPublicRes){
        if (intFollowers==null)
            intFollowers = 0;

        if (intPublicRes == null)
            intPublicRes = 0;

        if (intFollowers == 0)
            calculations = 0D;
        else
            calculations = (double)(6/intFollowers.doubleValue())*(2+intPublicRes.doubleValue());
    }

}
