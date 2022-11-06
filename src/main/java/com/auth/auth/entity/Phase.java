package com.auth.auth.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phase")
public class Phase {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "started_at", nullable = false)
    private Date startedAt;

    @Column(name = "ended_at")
    private Date endedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


    @ManyToMany(mappedBy = "phases", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<User> users = new HashSet<>();


    @OneToMany(mappedBy = "phase")
    @JsonBackReference
    private Set<Bill> bills = new HashSet<>();

    @OneToMany
    @JsonBackReference
    @JoinColumn(name = "phase_id")
    private Set<Document> documents = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}