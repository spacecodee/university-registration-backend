package com.spacecodee.universityregistration.dto.course_rating;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CoursesRatingDto implements Serializable {

    private int studentId;
    private String studentIdentification;
    private String studentName;
    private List<CourseRatingDto> ratingDtoList;
}
