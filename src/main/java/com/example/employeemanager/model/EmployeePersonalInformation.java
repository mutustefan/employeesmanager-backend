package com.example.employeemanager.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class EmployeePersonalInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Past
    private LocalDate birthDate;
    @Pattern(regexp = "^m|f$", message="Not matching the pattern 'm' or 'f'")
    private String sex;
    @NotBlank(message = "country field is blank")
    private String country;
    @NotBlank(message = "address field is blank")
    private String address;
    @Pattern(regexp = "^married|single$", message="Not matching the pattern 'married' or 'single'")
    private String familyStatus;
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;
    // private List<String> languages;


    public EmployeePersonalInformation() {
    }

    public EmployeePersonalInformation(Long id, LocalDate birthDate, String sex, String country, String address, String familyStatus, Employee employee) {
        this.id = id;
        this.birthDate = birthDate;
        this.sex = sex;
        this.country = country;
        this.address = address;
        this.familyStatus = familyStatus;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "EmployeePersonalInformation{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", familyStatus='" + familyStatus + '\'' +
                ", employee=" + employee +
                '}';
    }
}
