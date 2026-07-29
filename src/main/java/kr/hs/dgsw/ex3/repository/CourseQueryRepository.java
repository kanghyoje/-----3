package kr.hs.dgsw.ex3.repository;

import kr.hs.dgsw.ex3.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CourseQueryRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM course WHERE category = :category", nativeQuery = true)
    List<Course> findByCategoryNative(
            @Param("category") String category
    );

    @Query("SELECT c FROM Course c WHERE  c.name = :name OR c.category = :category")
    List<Course> findByNameOrCategory(
            @Param("name") String name,
            @Param("category") String category
    );
}
