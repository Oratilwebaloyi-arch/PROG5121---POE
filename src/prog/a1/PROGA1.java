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

    /**
     * @param args the command line arguments
     */
     //Attributes to store user details
     private String username;
     private String password;
     private String phoneNumber;
     private String name;
     private String surname;
     
       // Contractor
    public PROGA1(String name,String surname){
        this.name = name;
        this.surname = surname;
}
      //username verification 
    public boolean verifyUserName(String username){
      // the username must contain an underscore and the characters <= 5
        return username.contains("_") && username.length()<= 5;
        
}
    public static void main(String[] args) {
        PROGA1 user =new PROGA1("John","Doe");
        System.out.println(user.verifyUserName("john_d"));
    }
    
     //password requirements 
    public boolean verifyPasswordRequirements(String password){
        boolean containsUppercase = password.matches(".*[A-Z].*");
        boolean containsNumber = password.matches(".*[0-9].*");
        boolean containsUniqueCharacter = password.matches(".*[!@#$%^&*()<>?\":{}|<>].*");
        boolean correctLength = password.length()>=8;
        
        return containsUppercase && containsNumber && containsUniqueCharacter && correctLength;
}
       //cell phone verification 
    public boolean verifyCellphone(String cellPhone){
      // +27 then the 9 digits
      return cellPhone.matches("^\\+27\\d{9,10}$");
}
    
     
             
             
    }
    
}
 