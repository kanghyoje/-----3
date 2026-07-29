package kr.hs.dgsw.ex3.repository;

import kr.hs.dgsw.ex3.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseQueryMethodRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String name);

}
