package com.spacecodee.universityregistration.service;

import com.spacecodee.universityregistration.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentService extends JpaRepository<StudentEntity, Integer> {

    StudentEntity findStudentEntityByStudentId(int studentId);
}
