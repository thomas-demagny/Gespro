package com.auth.auth.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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

/**
 * The type Phase.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phase")
public class Phase implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;

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
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @ManyToMany(mappedBy = "phases", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<User> users = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference(value = "project")
    private Project project;

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
/*    @OneToMany(mappedBy = "phase")
    @JsonBackReference
    private Set<Bill> bills = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "phase_id")
    private Set<Document> documents = new HashSet<>();

    
    public void addBill(Bill bill) {
        bills.add(bill);
        bill.setPhase(this);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
        bill.setPhase(null);
    }

    public void addDocument(Document document) {
        documents.add(document);
        document.setPhase(this);
    }

    public void removeDocument(Document document) {
        documents.remove(document);
        document.setPhase(null);
    }
*/
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Sets started at.
     *
     * @param startedAt the started at
     */
    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    /**
     * Sets ended at.
     *
     * @param endedAt the ended at
     */
    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }
    
}