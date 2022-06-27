package com.spacecodee.universityregistration.service.student;

import com.spacecodee.universityregistration.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentService extends JpaRepository<StudentEntity, Integer> {

    StudentEntity findStudentEntityByStudentId(int studentId);

    StudentEntity findStudentEntityByStudentIdentification(String studentName);

    boolean existsStudentEntityByStudentIdentification(String studentIdentification);
}
