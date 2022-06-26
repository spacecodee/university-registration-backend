package com.spacecodee.universityregistration.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "course")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    @ManyToMany(mappedBy = "courseLikesByStudentId")
    @ToString.Exclude
    private List<StudentEntity> courseLikesByCourseId = new ArrayList<>();
}
