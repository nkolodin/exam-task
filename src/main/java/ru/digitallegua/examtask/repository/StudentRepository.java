package ru.digitallegua.examtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.digitallegua.examtask.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,Long> {
}
