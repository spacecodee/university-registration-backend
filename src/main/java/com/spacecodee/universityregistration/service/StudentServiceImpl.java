package com.spacecodee.universityregistration.service;

import com.spacecodee.universityregistration.dto.student.ListCoursesLikesDto;
import com.spacecodee.universityregistration.entity.StudentEntity;
import com.spacecodee.universityregistration.mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {

    private final IStudentService studentLikesCourseService;

    public StudentServiceImpl(IStudentService studentLikesCourseService) {
        this.studentLikesCourseService = studentLikesCourseService;
    }

    public ListCoursesLikesDto getCoursesLikeByStudentId(int studentId) {
        StudentEntity studentEntity = studentLikesCourseService.findStudentEntityByStudentId(studentId);

        if (studentEntity == null) return null;
        return StudentMapper.mapDaoStudentLikeToDto(studentEntity);
    }
}
