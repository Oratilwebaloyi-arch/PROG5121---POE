package prog.a1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Message {
    private String messageId;
    private int numMessagesSent;
    private String recipient;
    private String messageContent;
    private String messageHash;
    private static List<Message> sentMessages = new ArrayList<>();
    private static int totalMessagesSent = 0;
    private static int messageCounter = 0;

    public Message(String messageId, int numMessagesSent, String recipient, String messageContent) {
        this.messageId = messageId;
        this.numMessagesSent = numMessagesSent;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.messageHash = createMessageHash();
    }

    public static String generateMessageId() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }

    public boolean checkMessageID() {
        return messageId != null && messageId.length() <= 10;
    }

    public String checkRecipientCell() {
        if (recipient == null) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        if (recipient.startsWith("+") && recipient.length() >= 10 && recipient.length() <= 13 && recipient.substring(1).matches("\\d+")) {
            return "Cell phone number is correctly formatted.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public boolean isRecipientValid() {
        return recipient != null && recipient.startsWith("+") && recipient.length() >= 10 && recipient.length() <= 13 && recipient.substring(1).matches("\\d+");
    }

    public boolean checkMessageLength() {
        return messageContent != null && messageContent.length() <= 250;
    }

    public String createMessageHash() {
        if (messageId == null || messageId.length() < 2 || messageContent == null) {
            return "";
        }
        String firstTwo = messageId.substring(0, 2);
        String[] words = messageContent.trim().split("\\s+");
        if (words.length == 0) return firstTwo + ":" + numMessagesSent + ":";
        String firstWord = words[0].replaceAll("[^A-Za-z0-9]", "").toUpperCase();
        String lastWord = words[words.length - 1].replaceAll("[^A-Za-z0-9]", "").toUpperCase();
        return firstTwo + ":" + numMessagesSent + ":" + firstWord + lastWord;
    }

    public String SentMessage(int choice) {
        switch (choice) {
            case 1:
                sentMessages.add(this);
                totalMessagesSent++;
                messageCounter++;
                storeMessage();
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                storeMessage();
                return "Message successfully stored.";
            default:
                return "Invalid choice.";
        }
    }

    public String printMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages sent yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (Message m : sentMessages) {
            sb.append("MessageID: ").append(m.messageId).append("\n");
            sb.append("MessageHash: ").append(m.messageHash).append("\n");
            sb.append("Recipient: ").append(m.recipient).append("\n");
            sb.append("Message: ").append(m.messageContent).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }

    public int returnTotalMessages() {
        return totalMessagesSent;
    }

    public static int getTotalMessagesSent() {
        return totalMessagesSent;
    }

    public static void clearMessages() {
        sentMessages.clear();
        totalMessagesSent = 0;
        messageCounter = 0;
    }

    public void storeMessage() {
        try (FileWriter file = new FileWriter("stored_messages.json", true)) {
            String json = String.format("{\"messageId\":\"%s\",\"messageHash\":\"%s\",\"recipient\":\"%s\",\"message\":\"%s\",\"num\":%d},\n",
                messageId, messageHash, recipient, messageContent.replace("\"", "'"), numMessagesSent);
            file.write(json);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error storing message: " + e.getMessage());
        }
    }

    public String getFullDetails() {
        return "MessageID: " + messageId + "\nMessageHash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + messageContent;
    }
}