package com.spacecodee.universityregistration.mapper;

import com.spacecodee.universityregistration.dto.course_like.CourseRatingLikeDto;
import com.spacecodee.universityregistration.entity.CourseEntity;
import com.spacecodee.universityregistration.entity.StudentEntity;
import com.spacecodee.universityregistration.entity.course_like.CourseRatingEntity;
import com.spacecodee.universityregistration.entity.course_like.CourseRatingKey;

public class CourseRatingMapper {

    public static CourseRatingEntity mapCourseRatingDtoToCourseRatingEntity(CourseRatingLikeDto courseRatingDto) {
        final StudentEntity studentEntity = new StudentEntity();
        final CourseEntity courseEntity = new CourseEntity();
        final CourseRatingEntity courseRatingEntity = new CourseRatingEntity();

        courseEntity.setCourseName(courseRatingDto.getCourseDto().getName());
        studentEntity.setStudentName(courseRatingDto.getStudentDto().getName());

        courseRatingEntity.setId(new CourseRatingKey());
        courseRatingEntity.setStudentEntity(studentEntity);
        courseRatingEntity.setCourseEntity(courseEntity);
        courseRatingEntity.setRating(courseRatingDto.getRating());

        return courseRatingEntity;
    }

    public static CourseEntity mapCourseRatingAddDtoToCourseEntity(CourseRatingLikeDto courseRatingLikeDto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(courseRatingLikeDto.getCourseDto().getId());
        courseEntity.setCourseName(courseRatingLikeDto.getCourseDto().getName());
        return courseEntity;
    }
}
