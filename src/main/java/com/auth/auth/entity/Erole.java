package com.auth.auth.entity;

public enum Erole {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_SECRETARY("ROLE_SECRETARY"),
    ROLE_MODERATOR("ROLE_MODERATOR");
    
    private String role;

    private Erole(String role) {
        this.role = role;
    }   


    /**
     * @return String return the role
     */
    public String getRole() {
        return role;
    }

}

