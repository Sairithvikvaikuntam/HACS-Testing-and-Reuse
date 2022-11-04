package test;

import hacs.Course;
import hacs.CourseMenu;
import hacs.HighLevelCourseMenu;
import hacs.Instructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestInstructor {

    /* Test getting the true courses list assigned to an instructor */
    @Test
    public void testGetCourseListTrue() {
        Course course = new Course("CSE551", 0);
        Instructor instructor = new Instructor();
        instructor.addCourse(course);
        assertEquals(course, instructor.getCourseList().get(0));
    }

    /* Test getting the false courses list assigned to an instructor */
    @Test
    public void testGetCourseListFalse() {
        Course course = new Course("CSE551", 0);
        Course course2 = new Course("CSE552", 0);
        Instructor instructor = new Instructor();
        instructor.addCourse(course);
        assertNotEquals(course2, instructor.getCourseList().get(0));
    }

    /* Test creation of a low level course menu */
    @Test
    public void testCreateCourseMenuLowLevel() {
        Course course = new Course("CSE551", 0);
        Instructor instructor = new Instructor();
        CourseMenu courseMenu = instructor.createCourseMenu(course, 0);
        assertEquals(courseMenu.getClass(), HighLevelCourseMenu.class);
    }

    /* Test creation of a high level course menu */
    @Test
    public void testCreateCourseMenuHighLevel() {
        Course course = new Course("CSE551", 0);
        Instructor instructor = new Instructor();
        CourseMenu courseMenu = instructor.createCourseMenu(course, 1);
        assertEquals(courseMenu.getClass(), HighLevelCourseMenu.class);
    }

    /* Test instructor is assigned with a new course true */
    @Test
    public void testAddCourseTrue() {
        Course course = new Course("CSE551", 0);
        Instructor instructor = new Instructor();
        instructor.addCourse(course);
        assertEquals(course, instructor.courseList.get(0));
    }

    /* Test instructor is assigned with a new course false */
    @Test
    public void testAddCourseFalse() {
        Course course = new Course("CSE551", 0);
        Course course2 = new Course("CSE552", 0);
        Instructor instructor = new Instructor();
        instructor.addCourse(course);
        assertNotEquals(course2, instructor.courseList.get(0));
    }

    @Test
    void testCreateCourseMenu() {
    }

    @Test
    void testShowMenu() {
    }
}
