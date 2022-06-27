package com.spacecodee.universityregistration.service.course_rating;

import com.spacecodee.universityregistration.entity.course_rating.CourseRatingEntity;
import com.spacecodee.universityregistration.entity.course_rating.CourseRatingKey;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseRatingServiceImpl {

    private final ICourseRatingService iCourseRatingService;

    public CourseRatingServiceImpl(ICourseRatingService iCourseRatingService) {
        this.iCourseRatingService = iCourseRatingService;
    }

    public boolean addCourseLike(CourseRatingEntity courseRatingEntity) {
        try {
            iCourseRatingService.save(courseRatingEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCourseRating(CourseRatingKey courseRatingKey) {
        try {
            this.iCourseRatingService.deleteById(courseRatingKey);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
}
