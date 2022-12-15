package com.auth.auth.entity;

/**
 * The enum Erole.
 */
public enum Erole {
    /**
     * Role user erole.
     */
    ROLE_USER("User"),
    /**
     * Role admin erole.
     */
    ROLE_ADMIN("Admin"),
    /**
     * Role secretary erole.
     */
    ROLE_SECRETARY("Secretary"),
    /**
     * The Role project manager.
     */
    ROLE_ProjectManager("Project Manager");
    

    private String role;

    private Erole(String role) {
        this.role = role;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

}

