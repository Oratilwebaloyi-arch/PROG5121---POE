package prog.a1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {
    @Before
    public void setUp() {
        Message.clearMessages();
    }
    @Test
    public void testMessageLength_Success() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertTrue(msg.checkMessageLength());
    }
    @Test
    public void testMessageLength_Failure_TooLong() {
        String longMsg = "a".repeat(251);
        Message msg = new Message("0012345678", 0, "+27718693002", longMsg);
        assertFalse(msg.checkMessageLength());
    }
    @Test
    public void testRecipient_Valid() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertTrue(msg.isRecipientValid());
    }
    @Test
    public void testRecipient_Invalid() {
        Message msg = new Message("0012345678", 0, "08575975889", "Hi Keegan, did you receive the payment?");
        assertFalse(msg.isRecipientValid());
    }
    @Test
    public void testMessageHash_Correctness() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("00:0:HITONIGHT", msg.createMessageHash());
    }
    @Test
    public void testSendMessage() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message successfully sent.", msg.SentMessage(1));
        assertEquals(1, msg.returnTotalMessages());
    }
    @Test
    public void testDisregardMessage() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Press 0 to delete the message.", msg.SentMessage(2));
        assertEquals(0, msg.returnTotalMessages());
    }
    @Test
    public void testStoreMessage() {
        Message msg = new Message("0012345678", 0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message successfully stored.", msg.SentMessage(3));
    }
    @Test
    public void testTotalMessagesCounter() {
        Message msg1 = new Message("0012345678", 0, "+27718693002", "Hi Mike");
        Message msg2 = new Message("0012345679", 1, "+27718693003", "Hello there");
        msg1.SentMessage(1);
        msg2.SentMessage(1);
        assertEquals(2, Message.getTotalMessagesSent());
    }
    @Test
    public void testMessageID_Valid() {
        Message msg = new Message("0123456789", 0, "+27718693002", "Test");
        assertTrue(msg.checkMessageID());
    }
}