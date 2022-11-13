
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer extends JHTTPServer {

    String username, password, phoneno, email, secques, secans, gender, photo, opassword, npassword, name;
    String title,cphoto,caption;
    public MyServer(int port) throws IOException {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
        // return super.serve(uri, method, header, parms, files); //To change body of generated methods, choose Tools | Templates.
        Response res = null;
        String ans = "";

        if (uri.contains("/signup")) {
            username = parms.getProperty("username");

            ResultSet rs = DBLoader.executestatment("select users.* from users where username='" + username + "'");
            try {
                if (rs.next()) {
                    ans = "already exists";
                } else {
                    password = parms.getProperty("password");
                    phoneno = parms.getProperty("phoneno");
                    email = parms.getProperty("email");
                    secans = parms.getProperty("secans");
                    secques = parms.getProperty("secques");
                    gender = parms.getProperty("gender");
                    String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/Pics");

                    rs.moveToInsertRow();
                    rs.updateString("username", username);
                    rs.updateString("password", password);
                    rs.updateString("phoneno", phoneno);
                    rs.updateString("email", email);
                    rs.updateString("sec_ques", secques);
                    rs.updateString("sec_ans", secans);
                    rs.updateString("photo", "src/Pics/" + filename);
                    rs.updateString("gender", gender);
                    rs.insertRow();
                    ans = "inserted";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (uri.contains("/checklogin")) {
            username = parms.getProperty("username");
            password = parms.getProperty("password");
            ResultSet rs = DBLoader.executestatment("select * from users where username='" + username + "' and password='" + password + "'");
            try {
                if (rs.next()) {
                    ans=rs.getString("username");
//                    ans = "login successful";
                } else {
                    ans = "login failed";
                }

                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/changepassword")) {
            username = parms.getProperty("username");
            opassword = parms.getProperty("opassword");
            npassword = parms.getProperty("npassword");
            ResultSet rs = DBLoader.executestatment("select users.* from users where username='" + username + "' and password='" + opassword + "'");
            try {
                if (rs.next()) {
                    rs.updateString("password", npassword);
                    rs.updateRow();
                    ans = "password changed";

                } else {
                    ans = "invalid old password";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/searchfriend")) {
            username = parms.getProperty("username");
            ResultSet rs = DBLoader.executestatment("select * from users where username like '%" + username + "%'");
            try {
                while (rs.next()) {
                    username = rs.getString("username");
                    phoneno = rs.getString("phoneno");
                    photo = rs.getString("photo");
                    email = rs.getString("email");
                    gender = rs.getString("gender");
                    ans = ans + username + ";" + phoneno + ";" + photo + ";" + email + ";" + gender + "~";
                }

                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/getresource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri);
            res = sendCompleteFile(uri);
        } else if (uri.contains("/followrequest")) {
            username = parms.getProperty("username");
            name = parms.getProperty("name");
//          String operation=parms.getProperty("operation");
            System.out.println(name);
            ResultSet rs = DBLoader.executestatment("select follow.* from follow where followed_by='" + username + "' and followed_to='" + name + "'");

            try {
                if (rs.next()) {
                    rs.deleteRow();
                    //ans= "already followed";

                } else {
                    rs.moveToInsertRow();
                    rs.updateString("followed_by", username);
                    rs.updateString("followed_to", name);
                    rs.insertRow();
                    ans = "inserted";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            res = new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("/checkfollowing")) {
            username = parms.getProperty("username");
            name = parms.getProperty("name");
            ResultSet rs = DBLoader.executestatment("select * from follow where followed_by='" + username + "' and followed_to='" + name + "'");
            System.out.println(username);
            System.out.println(name);
            try {
                if (rs.next()) {
                    ans = "yes";
                } else {
                    ans = "no";
                }
                System.out.println(ans);
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (uri.contains("/getfollowers")) {
            username = parms.getProperty("username");
            ResultSet rs = DBLoader.executestatment("select * from follow where followed_to='" + username + "'");
            try {
                while (rs.next()) {
                    String user=rs.getString("followed_by");
                    ResultSet rs2=DBLoader.executestatment("select * from users where username='"+user+"'");
                    if(rs2.next()){
                        phoneno=rs2.getString("phoneno");
                        email=rs2.getString("email");
                        photo=rs2.getString("photo");
                        gender=rs2.getString("gender");
                        ans=ans+user+";"+phoneno+";"+email+";"+photo+";"+gender+"~";
                        System.out.println(ans);
                    }
                }
                res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        else if (uri.contains("/getfollowings")) {
            username = parms.getProperty("username");
            ResultSet rs = DBLoader.executestatment("select * from follow where followed_by='" + username + "'");
            try {
                while (rs.next()) {
                    String user=rs.getString("followed_to");
                    ResultSet rs2=DBLoader.executestatment("select * from users where username='"+user+"'");
                    if(rs2.next()){
                        phoneno=rs2.getString("phoneno");
                        email=rs2.getString("email");
                        photo=rs2.getString("photo");
                        gender=rs2.getString("gender");
                        ans=ans+user+";"+phoneno+";"+email+";"+photo+";"+gender+"~";
                        System.out.println(ans);
                    }
                }
                res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(uri.contains("/addpost")){
            title=parms.getProperty("title");
            username=parms.getProperty("username");
            String filename=saveFileOnServerWithRandomName(files, parms, "photo", "src/Pics");
          //  cphoto=parms.getProperty("photo");
            ResultSet rs=DBLoader.executestatment("select Posts.* from Posts");
            try {
                rs.moveToInsertRow();
                rs.updateString("title",title);
                rs.updateString("username",username);
//                Date d=new Date();
//               int date= d.getDate();
//                System.out.println("Date : "+date);
                rs.updateString("cover_photo", "src/Pics/"+filename);
                rs.insertRow();
                ResultSet rs1=DBLoader.executestatment("select Max(pid) as pid from Posts");
                if(rs1.next()){
                  int  pid=rs1.getInt("pid");
                    System.out.println(pid);
                    ans=pid+"";
                    System.out.println("pid"+ans);
                }
                else{
                    System.out.println("Wrong query");
                }
                res=new Response(HTTP_OK,"text/plain",ans);
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(uri.contains("/addstory")){
            String stringid=parms.getProperty("pid");
            System.out.println(Integer.parseInt(stringid)+"");
            caption=parms.getProperty("caption");
            String filename=saveFileOnServerWithRandomName(files, parms, "photo", "src/Pics");
            ResultSet rs=DBLoader.executestatment("select story_pics.* from story_pics");
            try {
                rs.moveToInsertRow();
                rs.updateInt("pid", Integer.parseInt(stringid));
                rs.updateString("caption", caption);
                        rs.updateString("photo","src/Pics/"+filename);
                        rs.insertRow();
                        ans="inserted";
                        res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
        else if(uri.contains("/getstories")){
            int sid;
            int pid=Integer.parseInt(parms.getProperty("pid"));
            ResultSet rs=DBLoader.executestatment("select * from story_pics where pid='"+pid+"'");
            try {
                while(rs.next()){
                   caption=rs.getString("caption");
                   photo=rs.getString("photo");
                   sid=rs.getInt("sid");
                   ans=ans+sid+";"+photo+";"+caption+"~";
                }
                res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(uri.contains("/deletestory")){
            int sid=Integer.parseInt(parms.getProperty("sid"));
            ResultSet rs=DBLoader.executestatment("select * from story_pics where sid='"+sid+"'");
            try {
                if(rs.next()){
                    rs.deleteRow();
                                ans="deleted";
                                System.out.println(ans);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            res=new Response(HTTP_OK,"text/plain",ans);
        }
        else if(uri.contains("/loadposts")){
            String username=parms.getProperty("username");
            
            ResultSet rs=DBLoader.executestatment("select * from follow where followed_by='"+username+"'");
            System.out.println("Username"+username);
            try {
                while(rs.next()){
                    String user=rs.getString("followed_to");
                    System.out.println("User"+user);
                    ResultSet rs2=DBLoader.executestatment("select * from Posts where username='"+user+"' ");
                    while(rs2.next()){
                        int pid=Integer.parseInt(rs2.getString("pid"));
                        String coverphoto=rs2.getString("cover_photo");
                        String title=rs2.getString("title");
                        String datetime=rs2.getString("datetime");
                        ans=ans+pid+";"+user+";"+title+";"+coverphoto+";"+datetime+"~";
                        System.out.println("ans"+ans);
                    }
                }
                res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(uri.contains("/editprofile")){
            String username,phoneno,email,gender,photo;
            username=parms.getProperty("username");
            phoneno=parms.getProperty("phoneno");
            email=parms.getProperty("email");
            gender=parms.getProperty("gender");
            String filename=saveFileOnServerWithRandomName(files, parms, "photo", "src/Pics");
            ResultSet rs=DBLoader.executestatment("select users.* from users where username='"+username+"'");
            try {
                if(rs.next()){
                    rs.updateString("gender",gender );
                    rs.updateString("phoneno",phoneno);
                    rs.updateString("email", email);
                    rs.updateString("photo","src/Pics/"+filename);
                    rs.updateRow();
                    ans="updated";
                }
                res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(uri.contains("/fetchstories")){
            int pid=Integer.parseInt(parms.getProperty("pid"));
            ResultSet rs=DBLoader.executestatment("select * from story_pics where pid='"+pid+"'");
            try {
                while(rs.next()){
                  String photo=rs.getString("photo");  
                  ans=ans+photo+";";
                }
                res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
        else if(uri.contains("/checklikes")){
            String username;
            int pid;
            username=parms.getProperty("username");
            pid=Integer.parseInt(parms.getProperty("pid"));
            ResultSet rs=DBLoader.executestatment("select * from like_posts where username='"+username+"' and pid='"+pid+"'");
            try {
                if(rs.next()){
                    ans="exists";
                }
                else{
                    ans="not exists";
                }
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
            res=new Response(HTTP_OK,"text/plain",ans);
        }
        else if(uri.contains("/likepost")){
            String username;
            int pid;
            username=parms.getProperty("username");
            pid=Integer.parseInt(parms.getProperty("pid"));
            ResultSet rs=DBLoader.executestatment("select like_posts.* from like_posts where username='"+username+"' and pid='"+pid+"'");
            try {
                if(rs.next()){
                    rs.deleteRow();
                    ans="deleted";
                }
                else{
                    rs.moveToInsertRow();
                    rs.updateInt("pid",pid);
                    rs.updateString("username", username);
                    rs.insertRow();
                    ans="inserted";
                }
                res=new Response(HTTP_OK,"text/plain",ans);
            } catch (Exception ex) {
                    ex.printStackTrace();
            }

        }
        else if(uri.contains("/countlikes")){
            int pid=Integer.parseInt(parms.getProperty("pid"));
            ResultSet rs=DBLoader.executestatment("select * from like_posts where pid='"+pid+"'");
            int count=0;
            try {
                while(rs.next()){
                    count++;
                }
                System.out.println("count:"+count);
                res=new Response(HTTP_OK,"text/plain",count+"");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
                    
                    
        }
        
        return res;

    }

}
