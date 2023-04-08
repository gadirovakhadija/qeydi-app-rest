package org.example.service.inter;

import org.example.entity.Teachway;

public interface TeachwayServiceInter {
    public String findTeachwayById(int id);
    public int findIdByTeachway(String teachway);
    public void addTeachway(Teachway t);
    public void deleteTeachwayById(int id);
}
