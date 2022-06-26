package com.spacecodee.universityregistration.service;

import com.spacecodee.universityregistration.dto.student.ListCoursesLikesDto;
import com.spacecodee.universityregistration.entity.StudentEntity;
import com.spacecodee.universityregistration.mapper.StudentLikesCourseMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentLikesCourseServiceImpl {

    private final IStudentLikesCourseService studentLikesCourseService;

    public StudentLikesCourseServiceImpl(IStudentLikesCourseService studentLikesCourseService) {
        this.studentLikesCourseService = studentLikesCourseService;
    }

    public ListCoursesLikesDto getCoursesLikesByStudentId(int studentId) {
        StudentEntity studentEntity = studentLikesCourseService.getCoursesLikesByStudentId(studentId);

        if (studentEntity == null) return null;
        return StudentLikesCourseMapper.mapDaoStudentLikeToDto(studentEntity);
    }

    public boolean addCourseLike(int studentId, int courseId) {
        return studentLikesCourseService.addCourseLike(studentId, courseId);
    }
}
