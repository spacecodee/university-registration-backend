package com.spacecodee.universityregistration.service.course_rating;

import com.spacecodee.universityregistration.entity.course_rating.CourseRatingEntity;
import com.spacecodee.universityregistration.entity.course_rating.CourseRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRatingService extends JpaRepository<CourseRatingEntity, CourseRatingKey> {

    void deleteById(CourseRatingKey courseId);
}
