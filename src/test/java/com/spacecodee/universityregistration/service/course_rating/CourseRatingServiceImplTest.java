package com.spacecodee.universityregistration.service.course_rating;

import com.spacecodee.universityregistration.entity.CourseEntity;
import com.spacecodee.universityregistration.entity.StudentEntity;
import com.spacecodee.universityregistration.entity.course_rating.CourseRatingEntity;
import com.spacecodee.universityregistration.entity.course_rating.CourseRatingKey;
import com.spacecodee.universityregistration.service.course.ICourseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class CourseRatingServiceImplTest {

    private final ICourseService iCourseLikeService;
    private final EntityManager entityManager;

    public CourseRatingServiceImplTest(ICourseService iCourseLikeService, EntityManager entityManager) {
        this.iCourseLikeService = iCourseLikeService;
        this.entityManager = entityManager;
    }

    @Test
    void addCourses() {
        CourseEntity courseEntity1 = new CourseEntity("Java");
        CourseEntity courseEntity2 = new CourseEntity("Node");
        CourseEntity courseEntity3 = new CourseEntity("JavaScript");

        this.entityManager.persist(courseEntity1);
        this.entityManager.persist(courseEntity2);
        this.entityManager.persist(courseEntity3);
    }

    @Test
    void addCourseLike() {
        CourseEntity courseEntity = new CourseEntity("Java");
        this.entityManager.persist(courseEntity);
        StudentEntity studentEntity = new StudentEntity("Test Student");
        this.entityManager.persist(studentEntity);


        CourseEntity course1 = this.entityManager.find(CourseEntity.class, "Java");
        StudentEntity student1 = this.entityManager.find(StudentEntity.class, "Test Student");
        CourseRatingKey courseRatingKey = new CourseRatingKey(course1.getCourseId(), student1.getStudentId());
        this.entityManager.persist(courseRatingKey);

        CourseRatingEntity courseRatingEntity =
                new CourseRatingEntity(courseRatingKey, studentEntity, courseEntity, (byte) 5);
    }
}