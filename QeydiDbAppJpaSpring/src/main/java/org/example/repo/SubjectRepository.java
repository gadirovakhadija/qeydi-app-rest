package org.example.repo;


import org.example.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    Subject findById(int id);

    Subject findBySubject(String subject);

    void deleteSubjectById(int id);
}
