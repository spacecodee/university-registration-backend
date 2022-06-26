package com.spacecodee.universityregistration.service;

import com.spacecodee.universityregistration.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IStudentLikesCourseService extends JpaRepository<StudentEntity, Integer> {

    @Query(
            value = "SELECT * " +
                    "FROM course_like c " +
                    "         INNER JOIN student s on c.course_like_student_id = s.student_id " +
                    "         INNER JOIN course c2 on c.course_like_course_id = c2.course_id " +
                    "WHERE s.student_id = ?1",
            nativeQuery = true
    )
    StudentEntity getCoursesLikesByStudentId(int studentId);

    @Modifying @Query(
            value = "INSERT INTO course_like (course_like_student_id, course_like_course_id) " +
                    "VALUES (?, ?)",
            nativeQuery = true
    )
    boolean addCourseLike(int studentId, int courseId);
}
