package com.litviniuk.project.EquipmentServiceApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "hospital")
public class Hospital {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, max = 100, message = "Name length must not be more than 100 and less than 2")
    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "phone_number")
    private int hospitalPhoneNumber;

    public Hospital(){
    }

    public Hospital(String hospitalName, int hospitalPhoneNumber) {
        this.hospitalName = hospitalName;
        this.hospitalPhoneNumber = hospitalPhoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setHospitalPhoneNumber(int hospitalPhoneNumber) {
        this.hospitalPhoneNumber = hospitalPhoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public int getHospitalPhoneNumber() {
        return hospitalPhoneNumber;
    }
}
