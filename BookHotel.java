package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,croom,cfood;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelemail,labelprice;
    JButton checkprice,bookhotel,back;
    JTextField tfcount,tfnodays;
    BookHotel(String username){
        this.username=username;
        setBounds(350,200,1100,600);
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
        
        
        JLabel lblhotel=new JLabel("Select Hotel");
        lblhotel.setBounds(40,110,150,25);
        lblhotel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblhotel);
        
        
        chotel=new Choice();
        chotel.setBounds(250,110,200,25);
        add(chotel);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel lblcount=new JLabel("Total Persons");
        lblcount.setBounds(40,150,150,25);
        lblcount.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblcount);
        
        tfcount=new JTextField("1");
        tfcount.setBounds(250,150,200,25);
        add(tfcount);
        
        JLabel lblnodays=new JLabel("No of Days");
        lblnodays.setBounds(40,190,150,25);
        lblnodays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnodays);
        
        tfnodays=new JTextField("1");
        tfnodays.setBounds(250,190,200,25);
        add(tfnodays);
        
        JLabel lblroom=new JLabel("AC/NON-AC");
        lblroom.setBounds(40,230,150,25);
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblroom);
        
        croom=new Choice();
        croom.add("AC");
        croom.add("NON-AC");
        croom.setBounds(250,230,200,25);
        add(croom);
        
        JLabel lblfood=new JLabel("Want Food");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfood);
        
        cfood=new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,25);
        add(cfood);
        
        
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(40,310,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        
        labelid=new JLabel();
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelid.setBounds(250,310,200,25);
        add(labelid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(40,350,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber=new JLabel();
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);
        
        JLabel lblphone=new JLabel("Phone No");
        lblphone.setBounds(40,390,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone=new JLabel();
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelphone.setBounds(250,390,150,25);
        add(labelphone);
        
        JLabel lblemail=new JLabel("Email Id");
        lblemail.setBounds(40,430,150,25);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblemail);
        
        labelemail=new JLabel();
        labelemail.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelemail.setBounds(250,430,150,25);
        add(labelemail);
        
        JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,470,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelprice.setBounds(250,470,150,25);
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
        checkprice.setBounds(60,510,120,25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel=new JButton("Book Hotel");
        bookhotel.setBounds(200,510,120,25);
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back=new JButton("Back");
        back.setBounds(340,510,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Copy of book.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,50,500,300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
               int cost=Integer.parseInt(rs.getString("costperperson"));
               int food=Integer.parseInt(rs.getString("foodincluded"));
               int room=Integer.parseInt(rs.getString("acroon"));
               
               int persons=Integer.parseInt(tfcount.getText());
               int days=Integer.parseInt(tfnodays.getText());
               String acselected=croom.getSelectedItem();
               String foodselected=cfood.getSelectedItem();
               
               if(persons*days>0){
                   int total=0;
                   total+=acselected.equals("AC")?room:0;
                   total+=foodselected.equals("Yes")?food:0;
                   total+=cost;
                   total=total*persons*days;
                   labelprice.setText("Rs "+total);
               }else{
                   JOptionPane.showMessageDialog(null, "Please Enter valid Details");
               }
            }
}
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==bookhotel){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfcount.getText()+"', '"+tfnodays.getText()+"', '"+croom.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelemail.getText()+"','"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Hotel Booked Succesfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            
            }    
        }else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new BookHotel("Harika");
    }
}
