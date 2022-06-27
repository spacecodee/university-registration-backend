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
@Table(name = "course")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    @OneToMany(mappedBy = "courseEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<CourseRatingEntity> studentEntities = new HashSet<>();

    public CourseEntity(String courseName) {
        this.courseName = courseName;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseEntity)) return false;
        CourseEntity that = (CourseEntity) o;
        return getCourseId() == that.getCourseId() && getCourseName().equals(
                that.getCourseName()) && getStudentEntities().equals(that.getStudentEntities());
    }

    @Override public int hashCode() {
        return Objects.hash(getCourseId(), getCourseName(), getStudentEntities());
    }
}
