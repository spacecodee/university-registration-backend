package com.spacecodee.universityregistration.dto.student;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {

    private int id;
    private String identification;
    private String name;
}
