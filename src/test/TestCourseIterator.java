package test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.CourseIterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestCourseIterator {

    /* Test last course in the list with null value for course iterator */
    @Test
    public void testCourseIteratorNextNull() {
        ClassCourseList classCourseList = new ClassCourseList();
        CourseIterator courseIterator = new CourseIterator(classCourseList);
        assertNull(courseIterator.next());
    }

    /* Test class course initialisation list from file */
    @Test
    public void testClassCourseListInitFromFile() {
        String fileName = "Courses.txt";
        ClassCourseList classCourseList = new ClassCourseList();
        classCourseList.initializeFromFile(fileName);
    }

    /* Test initialisation of course list */
    @Test
    public void testCourseListInitialisation() {
        String fileName = "Courses.txt";
        ClassCourseList classCourseList = new ClassCourseList();
        classCourseList.initializeFromFile(fileName);
    }

    /* Test course iterator has next functionality */
    @Test
    public void testCourseIteratorHasNext() {
        ClassCourseList classCourseList = new ClassCourseList();
        CourseIterator courseIterator = new CourseIterator(classCourseList);
        assertFalse(courseIterator.hasNext());
    }

    /* Test given attribute has next null value for course iterator */
    @Test
    public void testNextWithAttributeNull() {
        String fileName = "Courses.txt";
        ClassCourseList classCourseList = new ClassCourseList();
        classCourseList.initializeFromFile(fileName);
        CourseIterator courseIterator = new CourseIterator(classCourseList);
        Course course = (Course) courseIterator.next("CSE572");
        assertEquals(null, course);
    }


    @Test
    void testHasNext() {
    }

    @Test
    void testNext() {
    }

    @Test
    void testRemove() {
    }
}
