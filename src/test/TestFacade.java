package test;

import hacs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sai Rithvik Vaikuntam
 * @version 1.0
 */
class TestFacade {

    /* Test using facade creating new user info item */
    @Test
    public void testCreateUserTrue() {
        Facade facade = new Facade();
        UserInfoItem userInfoItem = new UserInfoItem();
        userInfoItem.userType = UserInfoItem.UserType.Student;
        userInfoItem.strUserName = "Rithvik";
        facade.createUser(userInfoItem);
        assertEquals(facade.person.userName, "Rithvik");
    }

    /* Test creating false new user info item using facade */
    @Test
    public void testCreateUserFalse() {
        Facade facade = new Facade();
        UserInfoItem userInfoItem = new UserInfoItem();
        userInfoItem.userType = UserInfoItem.UserType.Student;
        userInfoItem.strUserName = "Divya";
        facade.createUser(userInfoItem);
        assertNotEquals(facade.person.userName, "Rithvik");
    }

    /* Test new assignment adding to a course using facade */
    @Test
    public void testAddAssignment() {
        Facade facade = new Facade();
        Course course = new Course("CSE551", 0);
        facade.person = new Student();
        facade.addAssignment(course);
        assertEquals(course.assignmentList.get(0).getClass(), Assignment.class);
    }

    @Test
    void testLogin() {
    }

    @Test
    void testViewAssignment() {
    }

    @Test
    void testRemind() {
    }

    @Test
    void testCreateCourseList() {
    }

    @Test
    void testAttachCourseToUser() {
    }

    @Test
    void testSelectCourse() {
    }

    @Test
    void testCourseOperation() {
    }
}
