package com.spacecodee.universityregistration.entity.course_rating;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class CourseRatingKey implements Serializable {
    private static final long serialVersionUID = -7514804454632257661L;

    private int studentId;
    private int courseId;

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseRatingKey)) return false;
        CourseRatingKey that = (CourseRatingKey) o;
        return getStudentId() == that.getStudentId() && getCourseId() == that.getCourseId();
    }

    @Override public int hashCode() {
        return Objects.hash(getStudentId(), getCourseId());
    }
}
