package org.control.timesheet.models.core;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "timesheet")
@DynamicInsert
@DynamicUpdate
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotNull
    public Integer month;

    @NotNull
    public Integer year;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fid_employee", referencedColumnName = "id", nullable = false)
    public Employee employee;

    public String d01;
    public String d02;
    public String d03;
    public String d04;
    public String d05;
    public String d06;
    public String d07;
    public String d08;
    public String d09;
    public String d10;
    public String d11;
    public String d12;
    public String d13;
    public String d14;
    public String d15;
    public String d16;
    public String d17;
    public String d18;
    public String d19;
    public String d20;
    public String d21;
    public String d22;
    public String d23;
    public String d24;
    public String d25;
    public String d26;
    public String d27;
    public String d28;
    public String d29;
    public String d30;
    public String d31;

    @Column(name = "created_at", insertable = false, updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Generated(GenerationTime.ALWAYS)
    private Timestamp updatedAt;

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getD01() {
        return d01;
    }

    public void setD01(String d01) {
        this.d01 = d01;
    }

    public String getD02() {
        return d02;
    }

    public void setD02(String d02) {
        this.d02 = d02;
    }

    public String getD03() {
        return d03;
    }

    public void setD03(String d03) {
        this.d03 = d03;
    }

    public String getD04() {
        return d04;
    }

    public void setD04(String d04) {
        this.d04 = d04;
    }

    public String getD05() {
        return d05;
    }

    public void setD05(String d05) {
        this.d05 = d05;
    }

    public String getD06() {
        return d06;
    }

    public void setD06(String d06) {
        this.d06 = d06;
    }

    public String getD07() {
        return d07;
    }

    public void setD07(String d07) {
        this.d07 = d07;
    }

    public String getD08() {
        return d08;
    }

    public void setD08(String d08) {
        this.d08 = d08;
    }

    public String getD09() {
        return d09;
    }

    public void setD09(String d09) {
        this.d09 = d09;
    }

    public String getD10() {
        return d10;
    }

    public void setD10(String d10) {
        this.d10 = d10;
    }

    public String getD11() {
        return d11;
    }

    public void setD11(String d11) {
        this.d11 = d11;
    }

    public String getD12() {
        return d12;
    }

    public void setD12(String d12) {
        this.d12 = d12;
    }

    public String getD13() {
        return d13;
    }

    public void setD13(String d13) {
        this.d13 = d13;
    }

    public String getD14() {
        return d14;
    }

    public void setD14(String d14) {
        this.d14 = d14;
    }

    public String getD15() {
        return d15;
    }

    public void setD15(String d15) {
        this.d15 = d15;
    }

    public String getD16() {
        return d16;
    }

    public void setD16(String d16) {
        this.d16 = d16;
    }

    public String getD17() {
        return d17;
    }

    public void setD17(String d17) {
        this.d17 = d17;
    }

    public String getD18() {
        return d18;
    }

    public void setD18(String d18) {
        this.d18 = d18;
    }

    public String getD19() {
        return d19;
    }

    public void setD19(String d19) {
        this.d19 = d19;
    }

    public String getD20() {
        return d20;
    }

    public void setD20(String d20) {
        this.d20 = d20;
    }

    public String getD21() {
        return d21;
    }

    public void setD21(String d21) {
        this.d21 = d21;
    }

    public String getD22() {
        return d22;
    }

    public void setD22(String d22) {
        this.d22 = d22;
    }

    public String getD23() {
        return d23;
    }

    public void setD23(String d23) {
        this.d23 = d23;
    }

    public String getD24() {
        return d24;
    }

    public void setD24(String d24) {
        this.d24 = d24;
    }

    public String getD25() {
        return d25;
    }

    public void setD25(String d25) {
        this.d25 = d25;
    }

    public String getD26() {
        return d26;
    }

    public void setD26(String d26) {
        this.d26 = d26;
    }

    public String getD27() {
        return d27;
    }

    public void setD27(String d27) {
        this.d27 = d27;
    }

    public String getD28() {
        return d28;
    }

    public void setD28(String d28) {
        this.d28 = d28;
    }

    public String getD29() {
        return d29;
    }

    public void setD29(String d29) {
        this.d29 = d29;
    }

    public String getD30() {
        return d30;
    }

    public void setD30(String d30) {
        this.d30 = d30;
    }

    public String getD31() {
        return d31;
    }

    public void setD31(String d31) {
        this.d31 = d31;
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
}
