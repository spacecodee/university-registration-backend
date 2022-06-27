package com.spacecodee.universityregistration.entity.course_like;

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
@Table(name = "course_like")
public class CourseRatingEntity {

    @EmbeddedId
    private CourseRatingKey id;
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "course_like_student_id")
    private StudentEntity studentEntity;
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_like_course_id")
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
