package com.kien.model.user;

public enum UserRole {
    ADMIN(new String[]{"ROLE_USER","ROLE_ADMIN"}),
    USER(new String[]{"ROLE_USER"});

    private String[] roles;

    UserRole(String[] roles) {
        this.roles = roles;
    }

    public String[] getRoles() {
        return roles;
    }
}
