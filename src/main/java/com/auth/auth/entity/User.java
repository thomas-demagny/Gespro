package com.auth.auth.entity;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import javax.validation.constraints.*;
import lombok.*;

/**
 * The type User.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "file_number")
    private String fileNumber;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "street_label")
    private String streetLabel;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private int zipCode;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_phases", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "phase_id", referencedColumnName = "id"))
    private Set<Phase> phases = new HashSet<>();

    /**
     * Sets created at.
     *
     * @param localDateTime the local date time
     */
    public void setCreatedAt(String localDateTime) {
        if (localDateTime == null  || localDateTime.equals(""))
            return;
        DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd['T'HH[:mm][:ss][.n]]")
                .toFormatter(Locale.FRANCE);
        this.createdAt = LocalDateTime.parse(localDateTime, df);
    }

    /**
     * Sets created at.
     *
     * @param localDateTime the local date time
     */
    public void setCreatedAt(LocalDateTime localDateTime) {
        if (localDateTime == null)
            return;
        this.createdAt = localDateTime;
    }

    /**
     * Sets updated at.
     *
     * @param localDateTime the local date time
     */
    public void setUpdatedAt(String localDateTime) {
        if (localDateTime == null || localDateTime.equals(""))
            return;
        DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd['T'HH[:mm][:ss][.n]]")
                .toFormatter(Locale.FRANCE);
        this.updatedAt = LocalDateTime.parse(localDateTime, df);
    }

    /**
     * Sets updated at.
     *
     * @param localDateTime the local date time
     */
    public void setUpdatedAt(LocalDateTime localDateTime) {
         this.updatedAt = localDateTime;
    }

    /**
     * Add roles.
     *
     * @param role the role
     */
    public void addRoles(Erole... role) {
        for (Erole rol : role){
            roles.add(new Role(rol) );
        }
    }


}