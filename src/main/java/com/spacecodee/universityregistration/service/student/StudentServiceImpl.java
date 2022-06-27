package com.spacecodee.universityregistration.service.student;

import com.spacecodee.universityregistration.dto.course_like.CoursesLikesDto;
import com.spacecodee.universityregistration.entity.StudentEntity;
import com.spacecodee.universityregistration.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

    private final IStudentService studentLikesCourseService;

    public StudentServiceImpl(IStudentService studentLikesCourseService) {
        this.studentLikesCourseService = studentLikesCourseService;
    }

    public List<StudentEntity> courseEntityList() {
        return studentLikesCourseService.findAll();
    }

    public StudentEntity findStudentByName(String studentName) {
        return studentLikesCourseService.findStudentEntityByStudentName(studentName);
    }

    public boolean addUpdateStudent(StudentEntity studentEntity) {
        try {
            studentLikesCourseService.save(studentEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean deleteStudentById(int courseId) {
        try {
            studentLikesCourseService.deleteById(courseId);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public CoursesLikesDto getCoursesLikeByStudentId(int studentId) {
        StudentEntity studentEntity = studentLikesCourseService.findStudentEntityByStudentId(studentId);

        if (studentEntity == null) return null;
        return StudentMapper.mapEntityStudentLikeToDto(studentEntity);
    }
}
