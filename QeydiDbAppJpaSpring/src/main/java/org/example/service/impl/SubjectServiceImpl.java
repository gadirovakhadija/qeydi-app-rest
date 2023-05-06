package org.example.service.impl;

import org.example.repo.SubjectRepository;
import org.example.entity.Subject;
import org.example.service.inter.SubjectServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectServiceInter {
    @Autowired
    SubjectRepository subjRepo;
    @Override
    public String findSubjectById(int id) {
        return subjRepo.findById(id).getSubject();
    }

    @Override
    public int findIdBySubject(String subject) {
        return subjRepo.findBySubject(subject).getId();
    }

    @Override
    public void addSubject(Subject s) {
        subjRepo.save(s);
    }

    @Override
    public void deleteSubjectById(int id) {
        subjRepo.deleteSubjectById(id);
    }
}
