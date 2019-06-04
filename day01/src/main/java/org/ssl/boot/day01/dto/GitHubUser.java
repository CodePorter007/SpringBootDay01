package org.ssl.boot.day01.Dto;

public class GitHubUser {
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "name='" + login + '\'' +
                ", id=" + id +
                ", bio='" + node_id + '\'' +
                '}';
    }

    private String login;
    private Long id;
    private String node_id;
}
