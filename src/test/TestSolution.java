package test;

import hacs.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestSolution {

    /* Test solution set reported function true */
    @Test
    public void testIsReportedTrue() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.setReported(false);
        assertEquals(false, solution.isReported());
    }

    /* Test solution set reported function false */
    @Test
    public void testIsReportedFalse() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.setReported(false);
        assertNotEquals(true, solution.isReported());
    }

    /* Test solution status not reported */
    @Test
    public void testToStringNotReported() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.grade = 9;
        solution.reported = false;
        String string = "Rithvik" + "  " + "Solution" + " Grade=" + "9" + "  " + "not reported";
        assertEquals(solution.toString(), string);
    }

    /*  Test solution status is marked as reported */
    @Test
    public void testToStringReported() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.grade = 9;
        solution.reported = true;
        String string = "Rithvik" + "  " + "Solution" + " Grade=" + "9" + "  " + "reported";
        assertEquals(solution.toString(), string);
    }

    /* Test of solution grade is set false */
    @Test
    public void testGetGradeIntReportedFalse() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.grade = 9;
        solution.reported = true;
        assertNotEquals("8", solution.getGradeString());
    }

    /* Test of solution grade is set true*/
    @Test
    public void testGetGradeIntReportedTrue() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.grade = 9;
        solution.reported = true;
        assertEquals("9", solution.getGradeString());
    }

    /* Test solution grade when solution is not reported */
    @Test
    public void testGetGradeIntNotReported() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.grade = 9;
        solution.reported = false;
        assertEquals("-1", solution.getGradeString());
    }

    /* test solution grade type casting to int */
    @Test
    public void testGetGradeInt() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.grade = 9;
        assertEquals(9, solution.getGradeInt());
    }

    /* Test solution not reported function */
    @Test
    public void testSetReported() {
        Solution solution = new Solution();
        solution.author = "Rithvik";
        solution.solutionFileName = "Solution";
        solution.setReported(false);
        assertEquals(false, solution.reported);
    }

    @Test
    void testToString() {
    }

    @Test
    void testGetGradeString() {
    }

}
