package org.example.service.impl;

import org.example.repo.TeachwayRepository;
import org.example.entity.Teachway;
import org.example.service.inter.TeachwayServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeachwayServiceImpl implements TeachwayServiceInter {
    @Autowired
    TeachwayRepository teachRepo;

    @Override
    public String findTeachwayById(int id){
        return teachRepo.findById(id).getTeachway();
    }
    @Override
    public int findIdByTeachway(String teachway){
        return teachRepo.findByTeachway(teachway).getId();
    }

    @Override
    public void addTeachway(Teachway t){
        teachRepo.save(t);
    }
    @Override
    public void deleteTeachwayById(int id){
        teachRepo.deleteTeachwayById(id);
    }
}
