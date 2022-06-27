package com.spacecodee.universityregistration.dto.student;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto implements Serializable {

    private int id;
    private String identification;
    private String name;
}
