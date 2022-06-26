package com.spacecodee.universityregistration.dto.student;

import com.spacecodee.universityregistration.dto.course.CourseDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ListCoursesLikesDto {

    private int studentId;
    private String studentName;
    private List<CourseDto> courseDtos;
}
