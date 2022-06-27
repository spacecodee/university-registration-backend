package com.spacecodee.universityregistration.entity;

import com.spacecodee.universityregistration.entity.course_like.CourseRatingEntity;
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
    @OneToMany(mappedBy = "studentEntity")
    @ToString.Exclude
    private Set<CourseRatingEntity> courseRatingEntities = new HashSet<>();

    public StudentEntity(String studentName) {
        this.studentName = studentName;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity)) return false;
        StudentEntity that = (StudentEntity) o;
        return getStudentId() == that.getStudentId() && getStudentName().equals(
                that.getStudentName()) && getCourseRatingEntities().equals(that.getCourseRatingEntities());
    }

    @Override public int hashCode() {
        return Objects.hash(getStudentId(), getStudentName(), getCourseRatingEntities());
    }
}
