package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    Choice cpackage;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelemail,labelprice;
    JButton checkprice,bookpackage,back;
    JTextField tfcount;
    BookPackage(String username){
        this.username=username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,70,150,25);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        labelusername=new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,150,25);
        add(labelusername);
        
        
        JLabel lblpackage=new JLabel("Select Package");
        lblpackage.setBounds(40,110,150,25);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        
        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,25);
        add(cpackage);
        
        
        JLabel lblcount=new JLabel("Total Persons");
        lblcount.setBounds(40,150,150,25);
        lblcount.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblcount);
        
        tfcount=new JTextField();
        tfcount.setBounds(250,150,200,25);
        add(tfcount);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(40,190,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        
        labelid=new JLabel();
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelid.setBounds(250,190,200,25);
        add(labelid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(40,230,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber=new JLabel();
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
        JLabel lblphone=new JLabel("Phone No");
        lblphone.setBounds(40,270,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone=new JLabel();
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelphone.setBounds(250,270,150,25);
        add(labelphone);
        
        JLabel lblemail=new JLabel("Email Id");
        lblemail.setBounds(40,310,150,25);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblemail);
        
        labelemail=new JLabel();
        labelemail.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelemail.setBounds(250,310,150,25);
        add(labelemail);
        
        JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,350,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelprice.setBounds(250,350,150,25);
        add(labelprice);
        
        try{
            Conn conn=new Conn();
            String query="select * from customer where username='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
         
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice=new JButton("Check Price");
        checkprice.setBounds(60,400,120,25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage=new JButton("Book Package");
        bookpackage.setBounds(200,400,120,25);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("Back");
        back.setBounds(340,400,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Copy of Bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package")){
                cost+=12000;
            }else if(pack.equals("Silver Package")){
                cost+=25000;
            }else{
                cost+=32000;
            }
            int persons=Integer.parseInt(tfcount.getText());
            cost*=persons;
            labelprice.setText("Rs "+cost);
            
        }else if(ae.getSource()==bookpackage){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfcount.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelemail.getText()+"','"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Package Booked Succesfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            
            }    
        }else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new BookPackage("Harika");
    }
}
