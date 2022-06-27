package com.spacecodee.universityregistration.dto.course_like;

import com.spacecodee.universityregistration.dto.course.CourseRatingDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CoursesLikesDto {

    private int studentId;
    private String studentName;
    private List<CourseRatingDto> ratingDtoList;
}
