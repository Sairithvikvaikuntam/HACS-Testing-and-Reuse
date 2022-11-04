package test;

import hacs.Course;
import hacs.CourseMenu;
import hacs.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestStudent {

    /* Test add course to student */
    @Test
    public void testAddCourse() {
        Student student = new Student();
        Course course = new Course("SER594", 0);
        student.addCourse(course);
        assertEquals(course, student.courseList.get(0));
    }

    /* Test get all the list of courses of a student after adding course */
    @Test
    public void testGetCourseList() {
        Student student = new Student();
        Course course = new Course("SER594", 0);
        student.addCourse(course);
        assertEquals(course, student.getCourseList().get(0));
    }

    /* Test create course menu of low level courses */
    @Test
    public void testCreateCourseMenuLowLevel() {
        Student student = new Student();
        Course course = new Course("SER594", 0);
        CourseMenu courseMenu = student.createCourseMenu(course, 0);
    }

    /* Test create course menu of high level courses */
    @Test
    public void testCreateCourseMenuHighLevel() {
        Student student = new Student();
        Course course = new Course("SER594", 0);
        CourseMenu courseMenu = student.createCourseMenu(course, 1);
    }

    @Test
    void testCreateCourseMenu() {
    }

    @Test
    void testShowMenu() {
    }
}
