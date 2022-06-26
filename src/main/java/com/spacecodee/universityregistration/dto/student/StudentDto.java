package com.spacecodee.universityregistration.dto.student;

import com.spacecodee.universityregistration.dto.course.CourseDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {

    private int studentId;
    private CourseDto courseDto;
}
