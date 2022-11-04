package test;

import hacs.ClassCourseList;
import hacs.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestClassCourseList {

    /// Testing finding a course by its name not existing
    @Test
    public void testFindCourseByNameFalse() {
        String fileName = "Courses.txt";
        ClassCourseList classCourseList = new ClassCourseList();
        classCourseList.initializeFromFile(fileName);
        assertNull(classCourseList.findCourseByCourseName("SER816"));
    }

    ///Test to check the existing Course by Finding Course By Name
    @Test
    public void testFindCourseByNameTrue() {
        ClassCourseList classCourseList = new ClassCourseList();
        Course course = new Course("SER517", 0);
        classCourseList.add(course);
        assertEquals(null, classCourseList.findCourseByCourseName("SER517"));
    }
}
