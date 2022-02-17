package org.control.timesheet.models.core;

import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 255, message = "Employee surname length between 3 or 255")
    private String surname;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 255, message = "Employee name length between 3 or 255")
    private String name;

    private String patronymic;

//    @NotNull
//    @Column(name = "fid_group")
//    private Integer group;
//
//    @NotNull
//    @Column(name = "fid_position")
//    private Integer position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fid_group", referencedColumnName = "id", nullable = false)
    private Group group;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fid_position", referencedColumnName = "id", nullable = false)
    private Position position;

    @Range(min = 0, max = 1)
    @ColumnDefault(value = "1")
    @Column(name = "is_active")
    @Generated(GenerationTime.INSERT)
    private Integer isActive;

    @Column(name = "created_at", insertable = false, updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "hiring_at")
    private Timestamp hiringAt;

    @Column(name = "dismissal_at")
    private Timestamp dismissalAt;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getHiringAt() {
        return hiringAt;
    }

    public void setHiringAt(Timestamp hiringAt) {
        this.hiringAt = hiringAt;
    }

    public Timestamp getDismissalAt() {
        return dismissalAt;
    }

    public void setDismissalAt(Timestamp dismissalAt) {
        this.dismissalAt = dismissalAt;
    }

//    public Integer getGroup() {
//        return group;
//    }
//
//    public void setGroup(Integer group) {
//        this.group = group;
//    }
//
//    public Integer getPosition() {
//        return position;
//    }
//
//    public void setPosition(Integer position) {
//        this.position = position;
//    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
