package com.auth.auth.entity;

public enum Erole {
    ROLE_USER("User"),
    ROLE_ADMIN("Admin"),
    ROLE_SECRETARY("Secretary"),
    ROLE_ProjectManager("ProjectManager");
    
    private String role;

    private Erole(String role) {
        this.role = role;
    }   

    public String getRole() {
        return role;
    }

}

