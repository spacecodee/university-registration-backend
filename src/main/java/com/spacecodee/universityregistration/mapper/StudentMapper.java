package com.spacecodee.universityregistration.mapper;

import com.spacecodee.universityregistration.dto.course.CourseRatingDto;
import com.spacecodee.universityregistration.dto.course_like.CourseRatingLikeDto;
import com.spacecodee.universityregistration.dto.course_like.CoursesLikesDto;
import com.spacecodee.universityregistration.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static CoursesLikesDto mapEntityStudentLikeToDto(StudentEntity studentEntity) {
        CoursesLikesDto coursesLikesDto = new CoursesLikesDto();
        List<CourseRatingDto> courseRatingDtoList = new ArrayList<>();

        coursesLikesDto.setStudentId(studentEntity.getStudentId());
        coursesLikesDto.setStudentName(studentEntity.getStudentName());
        for (int i = 0; i < studentEntity.getCourseRatingEntities().size(); i++) {
            CourseRatingDto courseRatingDto = new CourseRatingDto();
            courseRatingDto.setName(studentEntity.getCourseRatingEntities().get(i).getCourseEntity().getCourseName());
            courseRatingDto.setRating(studentEntity.getCourseRatingEntities().get(i).getRating());
            courseRatingDtoList.add(courseRatingDto);
        }
        coursesLikesDto.setRatingDtoList(courseRatingDtoList);
        return coursesLikesDto;
    }

    public static StudentEntity mapCourseRatingAddDtoToStudentEntity(CourseRatingLikeDto courseRatingLikeDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(courseRatingLikeDto.getStudentDto().getId());
        studentEntity.setStudentName(courseRatingLikeDto.getStudentDto().getName());
        return studentEntity;
    }
}
