package test;

import hacs.Assignment;
import hacs.ListIterator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */

class TestListIterator {


    /* Test when added assignment check if list iterator has next */
    @Test
    public void testHasNextTrue() {
        ArrayList<Object> arrayList = new ArrayList<>();
        Assignment assignment = new Assignment();
        arrayList.add(assignment);
        ListIterator listIterator = new ListIterator(arrayList);
        assertTrue(listIterator.hasNext());
    }

    /* Test when looping over arraylist check if the list iterator has next item */
    @Test
    public void testHasNextFalse() {
        ArrayList<Object> arrayList = new ArrayList<>();
        ListIterator listIterator = new ListIterator(arrayList);
        assertFalse(listIterator.hasNext());
    }

    /* Test when added new assignment to array list check if the list iterator has next */
    @Test
    public void testNext() {
        ArrayList<Object> arrayList = new ArrayList<>();
        Assignment assignment = new Assignment();
        arrayList.add(assignment);
        ListIterator listIterator = new ListIterator(arrayList);
        assertEquals(assignment, listIterator.next());
    }

    /* Test list iterator has next null in array list true */
    @Test
    public void testNextNullTrue() {
        ArrayList<Object> arrayList = new ArrayList<>();
        ListIterator listIterator = new ListIterator(arrayList);
        assertNull(listIterator.next());
    }

    /* Test list iterator has next null in array list false */
    @Test
    public void testNextNullFalse() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new Object());
        ListIterator listIterator = new ListIterator(arrayList);
        assertNotNull(listIterator.next());
    }

    @Test
    void testHasNext() {
    }

    @Test
    void testRemove() {
    }
}
