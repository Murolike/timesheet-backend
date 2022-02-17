package org.control.timesheet.models.core;

import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "positions")
@DynamicInsert
@DynamicUpdate
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NotNull
    @Length(min = 3, max = 255, message = "Position name must be length between 3 and 255")
    private String name;

    @Column(name = "is_active")
    @Range(min = 0, max = 1)
    @ColumnDefault(value = "1")
    @Generated(GenerationTime.INSERT)
    private Integer isActive;

    @Column(name = "created_at", insertable = false, updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Position() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
