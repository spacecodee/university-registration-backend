package com.spacecodee.universityregistration.service.course;

import com.spacecodee.universityregistration.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ICourseService extends JpaRepository<CourseEntity, Integer> {
    CourseEntity findCourseEntityByCourseName(String courseName);

    boolean existsCourseEntityByCourseName(String courseName);
}
