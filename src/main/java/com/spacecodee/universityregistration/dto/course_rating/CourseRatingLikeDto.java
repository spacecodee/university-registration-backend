package com.spacecodee.universityregistration.dto.course_rating;

import com.spacecodee.universityregistration.dto.course.CourseDto;
import com.spacecodee.universityregistration.dto.student.StudentDto;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseRatingLikeDto implements Serializable {
    private StudentDto studentDto;
    private CourseDto courseDto;
    private byte rating;
}
