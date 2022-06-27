package com.spacecodee.universityregistration.service.course_rating;

import com.spacecodee.universityregistration.entity.course_like.CourseRatingEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseLikeServiceImpl {

    private final ICourseLikeService iCourseLikeService;

    public CourseLikeServiceImpl(ICourseLikeService iCourseLikeService) {
        this.iCourseLikeService = iCourseLikeService;
    }

    public boolean addCourseLike(CourseRatingEntity courseRatingEntity) {
        try {
            iCourseLikeService.save(courseRatingEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
}
