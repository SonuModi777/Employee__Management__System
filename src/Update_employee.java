import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_employee extends JFrame implements ActionListener,ItemListener{
JLabel l1,l2,l3,l4,l5,l6,l7,emp;
JTextField t1,t2,t3,t4,t5,t6,t7;
JButton b1,b2;
Choice c1,c2;
    
Update_employee(){
        
super("Update Employee");
        
setLayout(null);
getContentPane().setBackground(Color.WHITE);
        
c2 = new Choice();
c2.setForeground(Color.WHITE);
c2.setBackground(Color.BLACK);
c2.setBounds(160,40,200,20);
       
try{
conn c = new conn();
ResultSet rs = c.s.executeQuery("select * from employee");
      
while(rs.next()){
c2.add(rs.getString("id"));    
}
}catch(Exception e){ }
       
emp = new JLabel("Select Empno");
emp.setForeground(Color.WHITE);
emp.setBackground(Color.BLACK);
emp.setBounds(40,40,100,20);
add(emp);
add(c2);
        
l1 = new JLabel("Name : ");
l1.setForeground(Color.WHITE);
l1.setBackground(Color.BLACK);

t1 = new JTextField(15);
t1.setForeground(Color.WHITE);
t1.setBackground(Color.BLACK);
        
l1.setBounds(40,80,100,20);
t1.setBounds(160,80,200,20);
add(l1);
add(t1);
       
c1 = new Choice();
c1.setForeground(Color.WHITE);
c1.setBackground(Color.BLACK);

c1.add("Male");
c1.add("Female");
       
l2 = new JLabel("Gender : ");
l2.setForeground(Color.WHITE);
l2.setBackground(Color.BLACK);

l2.setBounds(40,120,100,20);
c1.setBounds(160,120,200,20);
add(l2);
add(c1);
        
l3 = new JLabel("Address : ");
l3.setForeground(Color.WHITE);
l3.setBackground(Color.BLACK);

t3 = new JTextField(15);
t3.setForeground(Color.WHITE);
t3.setBackground(Color.BLACK);

l3.setBounds(40,160,100,20);
t3.setBounds(160,160,200,20);
add(l3);
add(t3);
        
l4 = new JLabel("State : ");
l4.setForeground(Color.WHITE);
l4.setBackground(Color.BLACK);
t4 = new JTextField(15);
t4.setForeground(Color.WHITE);
t4.setBackground(Color.BLACK);

l4.setBounds(40,200,100,20);
t4.setBounds(160,200,200,20);
add(l4);
add(t4); 
        
l5 = new JLabel("City : ");
l5.setForeground(Color.WHITE);
l5.setBackground(Color.BLACK);

t5 = new JTextField(15);
t5.setForeground(Color.WHITE);
t5.setBackground(Color.BLACK);

l5.setBounds(40,240,100,20);
t5.setBounds(160,240,200,20);
add(l5);
add(t5);
        
l6 = new JLabel("Email : ");
l6.setForeground(Color.WHITE);
l6.setBackground(Color.BLACK);

t6 = new JTextField(15);
t6.setForeground(Color.WHITE);
t6.setBackground(Color.BLACK);

l6.setBounds(40,280,100,20);
t6.setBounds(160,280,200,20);
add(l6);
add(t6);
        
l7 = new JLabel("Phone : ");
l7.setForeground(Color.WHITE);
l7.setBackground(Color.BLACK);

t7= new JTextField(15);
t7.setForeground(Color.WHITE);
t7.setBackground(Color.BLACK);

l7.setBounds(40,320,100,20);
t7.setBounds(160,320,200,20);
add(l7);
add(t7);
        
b1 =new JButton("Update");
b2 = new JButton("Delete");
        
b1.setBounds(40,400,150,30);
b2.setBounds(200,400,150,30);
add(b1);
add(b2);
        
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
        
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
        
b1.addActionListener(this);
b2.addActionListener(this);
        
c2.addItemListener(this);
        
setVisible(true);
setSize(400,550);
setLocation(600,200);
        
getContentPane().setBackground(Color.BLACK);
}
    
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){String n = t1.getText();
String g = c1.getSelectedItem();
String a = t3.getText();
String s = t4.getText();
String c = t5.getText();String e = t6.getText();
String p = t7.getText();
String qry = "update employee set name='"+n+"',gender='"+g+"',address='"+a+"',state='"+s+"',city='"+c+"',email='"+e+"',phone='"+p+"'   where id="+c2.getSelectedItem();
       
try{
conn c1 = new conn();
c1.s.executeUpdate(qry);
JOptionPane.showMessageDialog(null,"Employee Updated");
}
catch(Exception ee){
ee.printStackTrace();
}
}
        
if(ae.getSource()==b2){
try{
conn c1 = new conn();
c1.s.executeUpdate("delete from employee where id="+c2.getSelectedItem());
JOptionPane.showMessageDialog(null,"Employee Deleted");
this.setVisible(false);
}catch(Exception ee){
ee.printStackTrace();
}
}
}
    
public void itemStateChanged(ItemEvent ie){
try{
conn c1 = new conn();
ResultSet rs = c1.s.executeQuery("select * from employee where id="+c2.getSelectedItem());
            
if(rs.next()){
t1.setText(rs.getString("name"));
t3.setText(rs.getString("address"));
t4.setText(rs.getString("state"));
t5.setText(rs.getString("city"));
t6.setText(rs.getString("email"));
t7.setText(rs.getString("phone"));
}
}

catch(Exception ee){
ee.printStackTrace();
}
}
    
public static void main(String[] args){
    new Update_employee();
}    
}
