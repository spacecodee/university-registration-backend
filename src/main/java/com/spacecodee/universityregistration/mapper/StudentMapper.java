package com.spacecodee.universityregistration.mapper;

import com.spacecodee.universityregistration.dto.course.CourseDto;
import com.spacecodee.universityregistration.dto.student.ListCoursesLikesDto;
import com.spacecodee.universityregistration.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static ListCoursesLikesDto mapDaoStudentLikeToDto(StudentEntity studentEntity) {
        ListCoursesLikesDto coursesLikesDto = new ListCoursesLikesDto();
        List<CourseDto> courseDtoList = new ArrayList<>();

        coursesLikesDto.setStudentId(studentEntity.getStudentId());
        coursesLikesDto.setStudentName(studentEntity.getStudentName());
        for (int i = 0; i < studentEntity.getCourseLikesByStudentId().size(); i++) {
            CourseDto courseDto = new CourseDto();
            courseDto.setCourseName(studentEntity.getCourseLikesByStudentId().get(i).getCourseRating());
            courseDtoList.add(courseDto);
        }
        coursesLikesDto.setCourseDtos(courseDtoList);
        return coursesLikesDto;
    }
}
