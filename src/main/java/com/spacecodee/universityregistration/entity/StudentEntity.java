package com.spacecodee.universityregistration.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "course_like_student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_like_course_id"))
    @ToString.Exclude
    private List<CourseEntity> courseLikesByStudentId = new ArrayList<>();
}
