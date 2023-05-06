package org.example.repo;

import org.example.entity.Teachway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachwayRepository extends JpaRepository<Teachway, Long> {

    Teachway findById(int id);

    Teachway findByTeachway(String teachway);

    void deleteTeachwayById(int id);
}
