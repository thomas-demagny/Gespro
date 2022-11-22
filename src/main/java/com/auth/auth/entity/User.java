package com.auth.auth.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import javax.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user",
uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
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
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();
    

   @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_phases",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "phase_id", referencedColumnName = "id"))
    private Set<Phase> phases = new HashSet<>();


    public void setCreatedAt(String createdAt) {
        if (createdAt == null) return;
        DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd['T'HH[:mm][:ss][.n]]").toFormatter(Locale.FRANCE);
        this.createdAt = Date.from(LocalDate.parse(createdAt, df).atStartOfDay().toInstant(java.time.ZoneOffset.UTC));
    }

} 