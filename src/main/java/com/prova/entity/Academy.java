package com.prova.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
public class Academy implements Serializable {


    @Id
    @Column(length=50,nullable = false,updatable = false)
    @Size(min=4,max=4,message = "code must be of 4 characters")
    private String code;

    @Column(length=50,nullable = false)
    private String title;

    @Column(name="city_location",length=50,nullable = false)
    private String cityLocation;



    @Column(columnDefinition = "SMALLINT(3)",name="students_number",nullable = false,scale = 2)
    private int studentsNumber;


    public void setCode(String code) {

        this.code = code;
    }

    public String getCode() {

        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public int getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(int studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    protected Academy(){

    }

    public Academy(String code, String title, String cityLocation, int studentsNumber) {

        this.code = code;
        this.title = title;
        this.cityLocation = cityLocation;
        this.studentsNumber = studentsNumber;

    }
}
