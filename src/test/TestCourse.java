package test;

import hacs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestCourse {

    /* Test Returning Course Name */
    @Test
    public void testToString() {
        Course course = new Course("CSE551", 0);
        assertEquals("CSE551", course.toString());
    }

    /* Test adding an assignment to a course */
    @Test
    public void testAddAssignment() {
        Assignment assignment = new Assignment();
        Course course = new Course("CSE551", 0);
        course.addAssignment(assignment);
        assertEquals(assignment, course.assignmentList.get(0));
    }

    @Test
    void testAccept() {
    }
}
