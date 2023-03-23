package org.example.dto;

public class TeachwayDTO {
    private int id;

    private String teachway;

    public TeachwayDTO() {
    }

    public TeachwayDTO(int id, String teachway) {
        this.id = id;
        this.teachway = teachway;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeachway() {
        return teachway;
    }

    public void setTeachway(String teachway) {
        this.teachway = teachway;
    }
}
