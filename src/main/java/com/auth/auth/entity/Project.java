package com.auth.auth.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The type Project.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Project implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "started_at")
    private Date startedAt;

    @Column(name = "ended_at")
    private Date endedAt;

    @Column(name = "amount")
    private double amount;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


    @ManyToOne
    @JsonBackReference(value = "user")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JsonBackReference(value = "organization")
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Set<Phase> phases = new HashSet<>();


}