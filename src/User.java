public class User {
String username,photo,email,phoneno,gender;

    public User(String username, String photo, String email, String phoneno, String gender) {
        this.username = username;
        this.photo = photo;
        this.email = email;
        this.phoneno = phoneno;
        this.gender = gender;
        smssender.sendSMS("9852", "");
    }


    
   

}
