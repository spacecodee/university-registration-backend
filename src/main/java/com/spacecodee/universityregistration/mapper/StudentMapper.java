package com.spacecodee.universityregistration.mapper;

import com.spacecodee.universityregistration.dto.course_rating.CourseRatingDto;
import com.spacecodee.universityregistration.dto.course_rating.CourseRatingLikeDto;
import com.spacecodee.universityregistration.dto.course_rating.CoursesRatingDto;
import com.spacecodee.universityregistration.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static CoursesRatingDto mapEntityStudentLikeToDto(StudentEntity studentEntity) {
        CoursesRatingDto coursesRatingDto = new CoursesRatingDto();
        List<CourseRatingDto> courseRatingDtoList = new ArrayList<>();

        coursesRatingDto.setStudentId(studentEntity.getStudentId());
        coursesRatingDto.setStudentIdentification(studentEntity.getStudentIdentification());
        coursesRatingDto.setStudentName(studentEntity.getStudentName());
        for (int i = 0; i < studentEntity.getCourseRatingEntities().size(); i++) {
            CourseRatingDto courseRatingDto = new CourseRatingDto();
            courseRatingDto.setName(studentEntity.getCourseRatingEntities().get(i).getCourseEntity().getCourseName());
            courseRatingDto.setRating(studentEntity.getCourseRatingEntities().get(i).getRating());
            courseRatingDtoList.add(courseRatingDto);
        }
        coursesRatingDto.setRatingDtoList(courseRatingDtoList);
        return coursesRatingDto;
    }

    public static StudentEntity mapCourseRatingAddDtoToStudentEntity(CourseRatingLikeDto courseRatingLikeDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(courseRatingLikeDto.getStudentDto().getId());
        studentEntity.setStudentIdentification(courseRatingLikeDto.getStudentDto().getIdentification());
        studentEntity.setStudentName(courseRatingLikeDto.getStudentDto().getName());
        return studentEntity;
    }
}
