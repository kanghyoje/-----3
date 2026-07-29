package kr.hs.dgsw.ex3.repository;

import kr.hs.dgsw.ex3.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CourseQueryMethodRepositoryTest {

    @Autowired
    private CourseQueryMethodRepository courseQueryMethodRepository;

    @Sql("/insert-courses.sql")
    @Test
    void findByName() {

        Optional<Course> existingCourse
                = courseQueryMethodRepository.findByName("Java Fundamentals");
        Optional<Course> nonExistingCourse
                = courseQueryMethodRepository.findByName("Kotlin Basics");

        assertThat(existingCourse).isPresent(); // 존재하는 강의
        assertThat(existingCourse.get().getCategory()).isEqualTo("Java");
        assertThat(nonExistingCourse).isNotPresent();
    }
}