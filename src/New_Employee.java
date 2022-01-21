import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class New_Employee extends JFrame implements ActionListener{
    JLabel l0,l1,l2,l3,l4,l5,l6,l7;
    JTextField t0,t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;
    
    New_Employee(){
        super("New Employee");
        
        setSize(600,650);
        setLocation(600,200);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        
        p1.setLayout(new GridLayout(10,3,12,44));
        l0 = new JLabel("ID");
        t0 = new JTextField(15);
        p1.add(l0);
        p1.add(t0);
        
        l1 = new JLabel("NAME");
        t1 = new JTextField(15);
        p1.add(l1);
        p1.add(t1);
        
        c1 = new Choice();
        c1.add("MALE");
        c1.add("FEMALE");
        
        l2 = new JLabel("GENDER");
        p1.add(l2);
        p1.add(c1);
        
        l3 = new JLabel("ADDRESS");
        t3 = new JTextField(30);
        p1.add(l3);
        p1.add(t3);
        
        l4 = new JLabel("State");
        t4 = new JTextField(15);
        p1.add(l4);
        p1.add(t4);
        
        l5 = new JLabel("City");
        t5 = new JTextField(15);
        p1.add(l5);
        p1.add(t5);
        
        l6 = new JLabel("Email");
        t6 = new JTextField(20);
        p1.add(l6);
        p1.add(t6);
        
        l7 = new JLabel("Phone");
        t7 = new JTextField(10);
        p1.add(l7);
        p1.add(t7);
        
        b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
        b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));
        p1.add(b1);
        p1.add(b2);
        
        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/new_employee.png"))),"West");
        add(p1,"Center");
        
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String i = t0.getText();
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        String p = t7.getText();
        String qry = "insert into employee values('"+i+"','"+n+"','"+g+"','"+a+"','"+s+"','"+c+"','"+e+"','"+p+"')";
       
        try{
            conn c1 = new conn();
            String q = "select id from employee where id='"+i+"'";
            ResultSet rs = c1.s.executeQuery(q);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Employee id already exist");
            }else{
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Employee Created");
                this.setVisible(false);
            }  
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new New_Employee().setVisible(true);
    }
    
}




