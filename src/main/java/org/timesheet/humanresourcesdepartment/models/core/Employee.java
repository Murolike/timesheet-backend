package org.timesheet.humanresourcesdepartment.models.core;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Time;
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

    @Range(min = 0, max = 1)
    private Integer isActive;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "hiring_at")
    private Timestamp hiringAt;

    @Column(name = "dismissal_at")
    private Timestamp dismissalAt;
}
