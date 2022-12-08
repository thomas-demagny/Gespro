package com.auth.auth.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "street_label")
    private String streetLabel;

    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private int zipCode;

    @OneToMany(mappedBy = "organization")
    private List<Project> projects;

    public Project addProject(Project project) {
        getProjects().add(project);
        project.setOrganization(this);

        return project;
    }

    public Project removeProject(Project project) {
        getProjects().remove(project);
        project.setOrganization(null);

        return project;
    }

}
