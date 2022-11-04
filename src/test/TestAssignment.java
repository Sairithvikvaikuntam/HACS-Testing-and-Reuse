package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hacs.Solution;
import hacs.Assignment;

import java.util.Date;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestAssignment {

    /* Test setting assignment Specification */
    @Test
    public void testSetAssSpec() {
        Assignment assignment = new Assignment();
        assignment.setAssSpec("Test");
        assertEquals(assignment.assSpec, "Test");
    }

    /* Test for setting due date for assignment */
    @Test
    public void testSetDueDate() {
        Assignment assignment = new Assignment();
        Date date = new Date(2022 - 11 - 02);
        assignment.setDueDate(date);
        assertEquals(date, assignment.dueDate);
    }

    /* Test getting due date of an assignment */
    @Test
    void testGetDueDateString() {
        Assignment assignment = new Assignment();
        String dueDate = assignment.getDueDateString();
        assertEquals("11/3/22", dueDate);
    }

    /* Test Assignment Name return value */
    @Test
    public String testToString() {
        Assignment assignment = new Assignment();
        assignment.assName = "Test";
        assertEquals("Test", assignment.toString());
        return null;
    }

    /* Test due date not overdue condition */
    @Test
    public void testOverDueFalse() {
        Assignment assignment = new Assignment();
        assignment.setDueDate(new Date());
        assertFalse(assignment.isOverDue());
    }

    /* Test due date overdue condition */
    @Test
    public void testOverDueTrue() {
        Assignment assignment = new Assignment();
        Date date = new Date(2020 - 10 - 31);
        assignment.setDueDate(date);
        assertTrue(assignment.isOverDue());
    }

    /* Test adding solution to the assignment  */
    @Test
    public void testAddSolution() {
        Assignment assignment = new Assignment();
        Solution solution = assignment.addSolution();
        assertNotNull(solution);
    }

    /* Test adding solution along with the attribute */
    @Test
    public void testAddSolutionWithAttribute() {
        Assignment assignment = new Assignment();
        Solution firstSolution = assignment.addSolution();
        assignment.addSolution(firstSolution);
        Solution testSolution = assignment.solutionList.get(0);
        assertEquals(firstSolution, testSolution);
    }

    @Test
    void testGetSolutionIterator() {
    }

    @Test
    void testAccept() {
    }
}
