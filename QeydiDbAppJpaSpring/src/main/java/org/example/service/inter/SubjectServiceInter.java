package org.example.service.inter;

import org.example.entity.Subject;

public interface SubjectServiceInter {
    public String findSubjectById(int id);
    public int findIdBySubject(String subject);
    public void addSubject(Subject s);
    public void deleteSubjectById(int id);
}
