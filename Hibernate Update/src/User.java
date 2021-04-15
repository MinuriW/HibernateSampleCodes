  import java.io.Serializable;
  public class User implements Serializable{
  private int authenticate;
  private int userid;
  private String username; 
  private String password;   
  private String name;
  private String email; 

  public User() {}
  public User(int authenticate, String username, String password,int userid,String name,String email) {
      this.authenticate = authenticate;
      this.userid=userid;
      this.username = username;
      this.password= password;
      this.name= name;
      this.email= email;
   }
  public int getAuthenticate() {
     return authenticate;
  }
  public void setAuthenticate( int authenticate ) {
     this.authenticate = authenticate;
  }
  public int getuserid() {
      return userid;
   }
   public void setuserid( int userid ) {
      this.userid = userid;
   }
  public String getUsername() {
     return username;
  }
  public void setUsername( String username ) {
     this.username = username;
  }
  public String getpassword() {
     return password;
  }
  public void setpassword( String password ) {
     this.password = password;
  }
  public String getname() {
      return name;
   }
   public void setname( String name ) {
      this.name = name;
   }
      public String getemail() {
          return email;
       }
       public void setemail( String email ) {
          this.email = email;
       }
     
 
}

