package com.auth.auth.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * The type Role.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role implements Serializable {

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
        ROLE_ProjectManager("Project-Manager");

        Erole(String userRole) {

        }
    }

    @Serial
    private final static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private Erole name;

    public Role(Erole name) {
        this.name = name;
    }
}