 package com.learing.forall.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.learing.forall.domain.Course;
import com.learing.forall.view.CourseView;

/**
 * DataSource Management for the Courses at the University.
 *
 * Created by maryellenbowman
 */
public interface CourseRepository extends CrudRepository<Course,Integer>{

    Course findByName(String name);

    List<Course> findByDepartmentChairMemberLastName(String chair);

    @Query("Select c from Course c where c.department.chair.member.lastName=:chair")
    List<Course> findByChairLastName(@Param("chair")String chairLastName);

    @Query("Select c from Course c join c.prerequisites p where p.id = ?1")
    List<Course> findCourseByPrerequisite(int id);

    @Query("Select new com.learing.forall.view.CourseView" +
            "(c.name, c.instructor.member.lastName, c.department.name) from Course c where c.id=?1")
    CourseView getCourseView(int courseId) ;

    List<Course> findByCredits(@Param("credits") int credits);

    Page<Course> findByCredits(@Param("credits") int credits, Pageable pageable);

//      Common Querying Mistake
//      Uncomment to Debug.
//
//    Course findByDeptName(String deptName);
//
//    @Query("Select new com.learing.forall.view.CourseView" +
//            "(c.name, c.instructor.member.lastName, c.department.name) from course c where c.name=?1")
//    Course getCourseViewByName(String name);

}