package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Subject;
import org.example.entity.Teachway;
import org.example.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
