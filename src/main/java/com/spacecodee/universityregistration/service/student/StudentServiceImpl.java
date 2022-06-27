package com.spacecodee.universityregistration.service.student;

import com.spacecodee.universityregistration.dto.course_rating.CoursesRatingDto;
import com.spacecodee.universityregistration.entity.StudentEntity;
import com.spacecodee.universityregistration.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl {

    private final IStudentService studentLikesCourseService;

    public StudentServiceImpl(IStudentService studentLikesCourseService) {
        this.studentLikesCourseService = studentLikesCourseService;
    }

    public List<StudentEntity> courseEntityList() {
        return studentLikesCourseService.findAll();
    }

    public StudentEntity findStudentByIdentification(String studentIdentification) {
        return studentLikesCourseService.findStudentEntityByStudentIdentification(studentIdentification);
    }

    public boolean existsStudentByIdentification(String studentIdentification) {
        return studentLikesCourseService.existsStudentEntityByStudentIdentification(studentIdentification);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean addUpdateStudent(StudentEntity studentEntity) {
        try {
            this.studentLikesCourseService.save(studentEntity);
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

    public CoursesRatingDto getCoursesLikeByStudentId(int studentId) {
        StudentEntity studentEntity = studentLikesCourseService.findStudentEntityByStudentId(studentId);

        if (studentEntity == null) return null;
        return StudentMapper.mapEntityStudentLikeToDto(studentEntity);
    }
}
