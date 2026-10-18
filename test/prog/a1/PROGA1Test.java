package prog.a1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PROGA1Test {

    PROGA1 user = new PROGA1("Kyle", "Peterson");

    @Test
    public void testUsernameCorrect() {
        boolean result = user.verifyUserName("kyl_1");
        assertTrue(result);
    }

    @Test
    public void testUsernameWrong() {
        boolean result = user.verifyUserName("kyle!!!!!!!");
        assertFalse(result);
    }

    @Test
    public void testPasswordCorrect() {
        boolean result = user.checkPasswordComplexity("Ch&8sec@ke89!");
        assertTrue(result);
    }

    @Test
    public void testPasswordWrong() {
        boolean result = user.checkPasswordComplexity("password");
        assertFalse(result);
    }

    @Test
    public void testCellCorrect() {
        boolean result = user.checkCellPhoneNumber("+27838969876");
        assertTrue(result);
    }

    @Test
    public void testCellWrong() {
        boolean result = user.checkCellPhoneNumber("08966553");
        assertFalse(result);
    }

    @Test
    public void testLoginSuccess() {
        user.registerUser("kyl_1", "Ch&8sec@ke89!", "+27838969876");
        boolean logged = user.loginUser("kyl_1", "Ch&8sec@ke89!");
        assertTrue(logged);
        assertEquals("Welcome Kyle, Peterson! It is great to see you again.", user.returnLoginStatus(logged));
    }

    @Test
    public void testLoginFail() {
        user.registerUser("kyl_1", "Ch&8sec@ke89!", "+27838969876");
        boolean logged = user.loginUser("kyl_1", "wrongPass");
        assertFalse(logged);
    }

    @Test
    public void testRegisterMessage() {
        String msg = user.registerUser("kyl_1", "Ch&8sec@ke89!", "+27838969876");
        assertTrue(msg.contains("successfully"));
    }
}