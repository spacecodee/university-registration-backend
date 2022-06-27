package com.spacecodee.universityregistration.entity.course_rating;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spacecodee.universityregistration.entity.CourseEntity;
import com.spacecodee.universityregistration.entity.StudentEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "course_rating")
public class CourseRatingEntity {

    @EmbeddedId
    private CourseRatingKey id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("studentId")
    @JoinColumn(name = "course_like_student_id")
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private StudentEntity studentEntity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("courseId")
    @JoinColumn(name = "course_like_course_id")
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CourseEntity courseEntity;
    @Column(name = "course_like_rating")
    private byte rating;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseRatingEntity)) return false;
        CourseRatingEntity that = (CourseRatingEntity) o;
        return getRating() == that.getRating() && getId().equals(that.getId()) && getStudentEntity().equals(
                that.getStudentEntity()) && getCourseEntity().equals(that.getCourseEntity());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getStudentEntity(), getCourseEntity(), getRating());
    }
}
