/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog.a1;

/**
 *
 * @author Student
 */


public class PROGA1 {
    // Fields
    private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;

    // Constructor
    public PROGA1(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean verifyUserName(String username) {
        // Must contain underscore and be max 5 chars
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean capital = !password.equals(password.toLowerCase());
        boolean number = password.matches(".*[0-9].*");
        boolean special = password.matches(".*[!@#$%^&*].*");
        
        return length && capital && number && special;
    }

    public boolean checkCellPhoneNumber(String cell) {
        // Should be +27 + 9 digits like +27838969876
        if (cell.length() == 12 && cell.startsWith("+27")) {
            return true;
        }
        return false;
    }

    public String registerUser(String user, String pass, String cell) {
        if (!verifyUserName(user)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(pass)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cell)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.username = user;
        this.password = pass;
        this.cellNumber = cell;
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    public boolean loginUser(String u, String p) {
        return u.equals(username) && p.equals(password);
    }

    public String returnLoginStatus(boolean isLogged) {
        if (isLogged) {
            return "Welcome " + firstName + ", " + lastName + "! It is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}