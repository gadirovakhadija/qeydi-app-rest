package org.example.dao;

import org.example.dao.impl.TeachwayRepositoryCustom;
import org.example.entity.Teachway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachwayRepository extends JpaRepository<Teachway, Long>, TeachwayRepositoryCustom {

    Teachway findById(int id);

    Teachway findByTeachway(String teachway);

    void deleteTeachwayById(int id);
}
