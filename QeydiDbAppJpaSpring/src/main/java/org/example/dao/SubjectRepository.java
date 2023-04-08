package org.example.dao;


import org.example.dao.impl.SubjectRepositoryCustom;
import org.example.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long>, SubjectRepositoryCustom {

    Subject findById(int id);

    Subject findBySubject(String subject);

    void deleteSubjectById(int id);
}
