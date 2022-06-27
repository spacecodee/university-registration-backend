package com.spacecodee.universityregistration.dto.course_like;

import com.spacecodee.universityregistration.dto.course.CourseDto;
import com.spacecodee.universityregistration.dto.student.StudentDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseRatingLikeDto {
    private StudentDto studentDto;
    private CourseDto courseDto;
    private byte rating;
}
