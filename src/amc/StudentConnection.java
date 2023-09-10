
package amc;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class StudentConnection {
     String url = "jdbc:mysql://localhost:3306/";
    String dbName = "studentdatabase";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";
    Connection conn = null;
    Statement st = null;
    PreparedStatement pst=null;
    ResultSet res= null;
    String susn =null;
    public void Initialise(String sql)
    {
        try {
          Class.forName(driver).newInstance();
          conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
          st = (Statement) conn.createStatement();
         // pst=(PreparedStatement)conn.prepareStatement(sql)
          pst= conn.prepareStatement(sql);
          } catch (Exception e) {
          }
    }
     public int Select(String usernam,String passwrd,String subcode)
    {
        try{ res = st.executeQuery("SELECT * FROM  faculty where username  = '"+usernam+"'");
         while (res.next()) {
          String pwd = res.getString("password");
          String Sub=res.getString("sub_code");
          if(passwrd.equals(pwd)&& subcode.equals(Sub))
          {
             // JOptionPane.showMessageDialog(null, "Valid");
              return 1;
          }
         else
          {
              //JOptionPane.showMessageDialog(null, "Invalid");
              return 0;
          }
         }
        }

        catch(SQLException e){
        }
        return 0;

    }
      public int Select1(String usn1)
    {
        try{ res = st.executeQuery("SELECT * FROM  student where USN  = '"+usn1+"'");
         while (res.next()) {
           susn = res.getString("USN");
          if(susn.equals(usn1))
          {
            
              return 1;
          }
         else
          {
              //JOptionPane.showMessageDialog(null, "Invalid");
              return 0;
          }
         }
        }

        catch(SQLException e){
        }
        return 0;

    }
    public Boolean add(String usn,String iia,String iiia,String iiiia,String subcode)
    {
        String sql="INSERT INTO editia(USN,IIA,IIIA,IIIIA,subcode) VALUES ('"+usn+"','"+iia+"','"+iiia+"','"+iiiia+"','"+subcode+"')";
        try
        {
           conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
            st = (Statement) conn.prepareStatement(sql);
            st.execute(sql);
            return true;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Data is already inserted");
        }
        return false;
    }
     public Boolean addatten(String usn,String iia,String iiia,String iiiia,String subcode)
    {
        String sql="INSERT INTO editattendance(USN,IIA,IIIA,IIIIA,subcode) VALUES ('"+usn+"','"+iia+"','"+iiia+"','"+iiiia+"','"+subcode+"')";
        try
        {
           conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
            st = (Statement) conn.prepareStatement(sql);
            st.execute(sql);
            return true;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Data is already inserted");
        }
        return false;
    }
   /* public DefaultTableModel getData()
    {
        DefaultTableModel dm=new DefaultTableModel();
        String sql="SELECT * FROM editia";
        try
        {
            st = (Statement) conn.prepareStatement(sql);
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                String usn=rs.getString(1);
                String iia=rs.getString(2);
                String iiia=rs.getString(3);
                String iiiia=rs.getString(4);
                dm.addRow(new String[]{usn,iia,iiia,iiiia});
            }
            return dm;

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;

    }*/
     public Boolean update(String usn,String usn1,String iia,String iiia,String iiiia,String subcod)
    {
         String sql="UPDATE  editia SET usn='"+usn1+"',  IIA='"+iia+"',IIIA='"+iiia+"',IIIIA='"+iiiia+"',SUBCODE='"+subcod+"' WHERE USN='"+usn+"'";
        try
        {
            conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
            st = (Statement) conn.prepareStatement(sql);
            st.execute(sql);
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
     public Boolean updateatten(String usn,String usn1,String iia,String iiia,String iiiia,String subcode)
    {
        String sql="UPDATE  editattendance SET usn='"+usn1+"', IIA='"+iia+"',IIIA='"+iiia+"',IIIIA='"+iiiia+"',SUBCODE='"+subcode+"' WHERE USN='"+usn+"'";
        try
        {
            conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
            st = (Statement) conn.prepareStatement(sql);
            st.execute(sql);
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
      public Boolean delete(String usn,String subcod)
    {
        String sql="DELETE FROM editia WHERE USN='"+usn+"' AND subcode='"+subcod+"'";
        try
        {
           conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
            st = (Statement) conn.prepareStatement(sql);
            st.execute(sql);
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
       public Boolean deleteatten(String usn,String subcod)
    {
        String sql="DELETE FROM editattendance WHERE USN='"+usn+"'AND subcode='"+subcod+"'";
        try
        {
           conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
            st = (Statement) conn.prepareStatement(sql);
            st.execute(sql);
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
      public String Select2()
    {
       
              return susn;
          }
        

       
    
  
        

              
    
          
          
          
      
      public static void main(String[] args)
    {
          StudentConnection sql1 = new StudentConnection();
          sql1.Initialise(null);


}
}
