package org.example.dto;

import org.example.entity.Subject;
import org.example.entity.Teachway;
import org.example.entity.User;

public class UserDTO {
    private int id;

    private String name;

    private String surname;

    private Integer age;

    private String university;

    private Integer point;

    private String experience;

    private Integer teachwayId;

    private Integer subjectId;

    private Teachway teachway;

    private Subject subject;

    private String email;

    private String code;

    private Double cost;

    private String password;

    public UserDTO() {
    }

    public UserDTO(User u) {
        this.id = u.getId();
        this.name =u.getName();
        this.surname = u.getSurname();
        this.age = u.getAge();
        this.university = u.getUniversity();
        this.point = u.getPoint();
        this.experience = u.getExperience();
        this.teachwayId = u.getTeachwayId();
        this.subjectId = u.getSubjectId();
        this.teachway = u.getTeachway();
        this.subject = u.getSubject();
        this.email = u.getEmail();
        this.code = u.getCode();
        this.cost = u.getCost();
        this.password = u.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Integer getTeachwayId() {
        return teachwayId;
    }

    public void setTeachwayId(Integer teachwayId) {
        this.teachwayId = teachwayId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Teachway getTeachway() {
        return teachway;
    }

    public void setTeachway(Teachway teachway) {
        this.teachway = teachway;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
