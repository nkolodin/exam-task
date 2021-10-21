package ru.digitallegua.examtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.digitallegua.examtask.model.TeacherModel;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel,Long> {
}
