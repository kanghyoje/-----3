package kr.hs.dgsw.ex3.repository;

import kr.hs.dgsw.ex3.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class CourseQueryRepositoryTest {

    @Autowired
    private CourseQueryRepository courseQueryRepository;

    @Sql("/insert-courses.sql")
    @Test
    void findByCategory() {

        List<Course> result = courseQueryRepository
                .findByCategoryNative("JavaScript");

        assertThat(result) // 검증
                .hasSize(2)
                .allMatch(c -> "JavaScript".equals(c.getCategory()));
    }

    @Sql("/insert-courses.sql")
    @Test
    void findByNameOrCategory() {

        List<Course> result
                = courseQueryRepository
                .findByNameOrCategory(
                        "Java Fundamentals",
                        "Python"
                );

        assertThat(result)
                .extracting(Course::getCategory)
                .contains("Java", "Python");
    }
}