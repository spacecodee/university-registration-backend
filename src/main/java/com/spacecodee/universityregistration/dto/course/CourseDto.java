package com.spacecodee.universityregistration.dto.course;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseDto implements Serializable {

    private String courseName;
}
