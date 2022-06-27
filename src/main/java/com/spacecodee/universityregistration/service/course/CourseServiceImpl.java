package com.spacecodee.universityregistration.service.course;

import com.spacecodee.universityregistration.entity.CourseEntity;
import com.spacecodee.universityregistration.exceptions.InvalidInsuranceAmountException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl {

    private final ICourseService iCourseService;

    public CourseServiceImpl(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    public List<CourseEntity> courseEntityList() {
        return iCourseService.findAll();
    }


    public CourseEntity findCourseByName(String courseName) {
        return this.iCourseService.findCourseEntityByCourseName(courseName);
    }

    public boolean existsCourseByName(String courseName) {
        return this.iCourseService.existsCourseEntityByCourseName(courseName);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean addUpdateCourse(CourseEntity courseEntity) {
        try {
            this.iCourseService.save(courseEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return true;
        }
    }

    public boolean deleteCourseById(int courseId) {
        try {
            iCourseService.deleteById(courseId);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
}
