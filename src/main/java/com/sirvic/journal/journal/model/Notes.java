package com.sirvic.journal.journal.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Notes {
    @Id
    @SequenceGenerator(
            name="notes_sequence",
            sequenceName = "notes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notes_sequence"
    )

    private Long id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String textBody;
    @Column(nullable = false)
    private LocalDate createdOn;

    public Notes() {
    }

    public Notes(Long id, Long userId, String title, String textBody, LocalDate createdOn) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.textBody = textBody;
        this.createdOn = createdOn;
    }

    public Notes(Long userId, String title, String textBody, LocalDate createdOn) {
        this.userId = userId;
        this.title = title;
        this.textBody = textBody;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", textBody='" + textBody + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
