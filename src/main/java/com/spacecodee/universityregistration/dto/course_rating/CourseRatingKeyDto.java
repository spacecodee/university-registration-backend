package com.spacecodee.universityregistration.dto.course_rating;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseRatingKeyDto {
    private int studentId;
    private int courseId;
}
