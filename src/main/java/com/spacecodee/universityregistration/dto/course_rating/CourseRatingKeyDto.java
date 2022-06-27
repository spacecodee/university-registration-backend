package com.spacecodee.universityregistration.dto.course_rating;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseRatingKeyDto implements Serializable {
    private int studentId;
    private int courseId;
}
