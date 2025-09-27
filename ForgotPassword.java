package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener {
    JButton search,retrieve,back;
    JTextField txtusername,txtpassword,txtname,txtquestion,txtanswer;
    ForgotPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Copy of forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,25);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblusername);
        
        txtusername=new JTextField();
        txtusername.setBounds(220,20,150,25);
        txtusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtusername);
        
        search =new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(40,55,100,25);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblname);
        
        txtname=new JTextField();
        txtname.setBounds(220,55,150,25);
        txtname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtname);
        
        JLabel lblquestion=new JLabel("Security Question");
        lblquestion.setBounds(40,100,130,25);
        lblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblquestion);
        
        txtquestion=new JTextField();
        txtquestion.setBounds(220,100,150,25);
        txtquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtquestion);
        
        JLabel lblanswer=new JLabel("Answer");
        lblanswer.setBounds(40,145,100,25);
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblanswer);
                
        txtanswer=new JTextField();
        txtanswer.setBounds(220,145,150,25);
        txtanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtanswer);
        
        retrieve=new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,145,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,190,100,25);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblpassword);
        
        txtpassword=new JTextField();
        txtpassword.setBounds(220,190,150,25);
        txtpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtpassword);
        
        back=new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,235,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query="select * from account where username='"+txtusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet ra=c.s.executeQuery(query);
                while(ra.next()){
                    txtname.setText(ra.getString("name"));
                    txtquestion.setText(ra.getString("securityQ"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == retrieve){
            try{
            String query="select * from account where answer= '"+txtanswer.getText()+"' AND username='"+txtusername.getText()+"'";
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                txtpassword.setText(rs.getString("password"));
            }
            
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } else{
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new ForgotPassword();
    }
}
