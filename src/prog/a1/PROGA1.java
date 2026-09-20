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
     private String cellPhone;
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
        PROGA1 user =new PROGA1("kyle","peterson");
        System.out.println(user.verifyUserName("kyl_1"));
    }
    
     //password requirements 
    public boolean verifyPasswordRequirements(String password){
        boolean containsUppercase = password.matches(".*[A-Z].*");
        boolean containsNumber = password.matches(".*[0-9].*");
        boolean containsUniqueCharacter = password.matches(".*[!@#$%^&*()<>?\":{}|<>].*");
        boolean correctLength = password.length()>=8;
        
        return containsUppercase && containsNumber && containsUniqueCharacter && correctLength;
}
       //cellPhone verification 
    public boolean verifyCellPhone(String cellPhone){
      // +27 then the 9 digits
      return cellPhone.matches("^\\+27\\d{9,10}$");
} 
      //register the user
    public String registerUser(String username ,String password ,String cellPhone){
       if (!verifyUserName(username)) {
           return "Username not correctly formatted; please ensure that your username contains an undercore and does not have more than five characters in length.";
           
       }
       if (!verifyPasswordRequirements(password)){
           return "Password not correctly formated;please ensure that the password contains atleast eight characters,a capital letter ,number and a special character.";
           
       }
       if (!verifyCellPhone(cellPhone)){
           return "Cell phone not correctly formatted or does not contain the international code.";
           
       }
        // if details are correct save them 
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
        
        return "user registered";
    } 
        //user login
    public boolean loginUser(String username , String password){
        return this.username.equals(username)&& this.password.equals(password);
    }
     //login status
    public String returnLoginStatus(String username ,String password){
       if (loginUser(username ,password)){
           return "Welcome"+name +","+ surname + "great to see you again";
        }else{
             return "username or password incorrect , try again";
             
    } 
  }  
}
 