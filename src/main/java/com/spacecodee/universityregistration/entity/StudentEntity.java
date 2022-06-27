package com.spacecodee.universityregistration.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spacecodee.universityregistration.entity.course_rating.CourseRatingEntity;
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
    @Column(name = "student_identification", unique = true)
    private String studentIdentification;
    @Column(name = "student_name")
    private String studentName;
    @OneToMany(mappedBy = "studentEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CourseRatingEntity> courseRatingEntities = new ArrayList<>();

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
