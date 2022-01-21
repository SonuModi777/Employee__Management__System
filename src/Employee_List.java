import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Employee_List extends JFrame implements ActionListener{
    JTable j1;
    JButton b1;
    String h[]={"Emp id","Name","Gender","Address","State","City","Email","Phone"};
    String d[][]=new String[30][8];
    int i=0,j=0;
    
    Employee_List(){
        super("View Employee");
        
        setSize(1000,400);
        setLocation(450,200);
        
        try{
            String q = "select * from employee order by id";
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("name");
                d[i][j++]=rs.getString("gender");
                d[i][j++]=rs.getString("address");
                d[i][j++]=rs.getString("state");
                d[i][j++]=rs.getString("city");
                d[i][j++]=rs.getString("email");
                d[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            j1=new JTable(d,h);
        }
        catch(Exception e){ }
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane s1 = new JScrollPane(j1);
        add(s1);
        b1.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){ }
    }
    
    public static void main(String[] args){
        new Employee_List().setVisible(true);
    }
}
