package com.example.employeemanager.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Size(min = 3, max = 20, message = "Name length is incorrect 3 - 20")
    private String name;
    @Email(message = "invalid email")
    private String email;
    @NotBlank(message = "job title should not be blank")
    private String jobTitle;
    @NotBlank(message = "phone should not be blank")
    private String phone;
    @NotBlank(message = "image URL should not be blank")
    private String imageURL;
    @OneToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "personal_information_id")
    private EmployeePersonalInformation personalInformation;

    public Employee() {
    }

    public Employee(Long id, String name, String email, String jobTitle, String phone, String imageURL, EmployeePersonalInformation personalInformation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageURL = imageURL;
        this.personalInformation = personalInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public EmployeePersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(EmployeePersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", personalInformation=" + personalInformation +
                '}';
    }
}
