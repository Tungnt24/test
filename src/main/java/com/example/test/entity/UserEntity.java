package com.example.test.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "user", schema = "test")
@Entity
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "code")
    private String code;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_approve")
    private boolean isApprove;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "code_expired")
    private Timestamp codeExpired;

    @Column(name = "code_valid")
    private Timestamp codeValid;

    public String getFullName() {
        return this.lastName + " " + this.firstName;
    }

    @PreUpdate
    void updateUser() {
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

}
