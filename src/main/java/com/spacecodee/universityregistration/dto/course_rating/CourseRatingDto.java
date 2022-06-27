package com.spacecodee.universityregistration.dto.course_rating;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseRatingDto implements Serializable {

    private String name;
    private byte rating;
}
