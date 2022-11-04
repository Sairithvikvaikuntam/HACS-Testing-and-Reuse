package test;

import hacs.Solution;
import hacs.SolutionIterator;
import hacs.SolutionList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestSolutionIterator {

    /* Test when given solution to solution list solution iterator has next */
    @Test
    public void testHasNext() {
        Solution sol = new Solution();
        sol.solutionFileName = "Rithvik";
        SolutionList list = new SolutionList();
        list.add(sol);
        SolutionIterator test = new SolutionIterator(list);
        assertEquals(true, test.hasNext());
    }

    /* Test when given empty solution list if solution iterator has next */
    @Test
    public void testHasNextNull() {
        SolutionList solutionList = new SolutionList();
        SolutionIterator solutionIterator = new SolutionIterator(solutionList);
        assertEquals(false, solutionIterator.hasNext());
    }

    /* Test when given a new solution and added to solution list if solution iterator has next */
    @Test
    public void testNext() {
        Solution solution = new Solution();
        solution.solutionFileName = "Rithvik";
        SolutionList solutionList = new SolutionList();
        solutionList.add(solution);
        SolutionIterator solutionIterator = new SolutionIterator(solutionList);
        Solution testSolution = (Solution) solutionIterator.next();
        assertEquals(solution.solutionFileName, testSolution.solutionFileName);
    }

    /* Test when given empty solution list whether solution iterator becomes null */
    @Test
    public void testNextNull() {
        SolutionList solutionList = new SolutionList();
        SolutionIterator solutionIterator = new SolutionIterator(solutionList);
        Solution solution = (Solution) solutionIterator.next();
        assertNull(solution);
    }


    @Test
    void testMoveToHead() {
    }

    @Test
    void testRemove() {
    }
}
