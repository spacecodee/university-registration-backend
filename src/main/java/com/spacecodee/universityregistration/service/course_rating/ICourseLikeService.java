package com.spacecodee.universityregistration.service.course_rating;

import com.spacecodee.universityregistration.entity.course_like.CourseRatingEntity;
import com.spacecodee.universityregistration.entity.course_like.CourseRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseLikeService extends JpaRepository<CourseRatingEntity, CourseRatingKey> {
}
