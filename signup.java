package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener{
    JButton create,back;
    JTextField txtname,txtusername,txtpassword,txtanswer;
    Choice security;
    signup(){
        
        setSize(900,400);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBounds(0,0,500,400);
        p1.setBackground(new Color(133,193,233));
        p1.setLayout(null);
        add(p1);
        
       // JPanel p2=new JPanel();
        
        
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(50,30,125,25);
        lblusername.setFont(new Font("Tahona",Font.BOLD,14));
        p1.add(lblusername);
        
        txtusername=new JTextField();
        txtusername.setBounds(250,30,150,25);
        txtusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtusername);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,75,125,25);
        lblname.setFont(new Font("Tahona",Font.BOLD,14));
        p1.add(lblname);
        
        txtname=new JTextField();
        txtname.setBounds(250,75,150,25);
        txtname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtname);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(50,120,125,25);
        lblpassword.setFont(new Font("Tahona",Font.BOLD,14));
        p1.add(lblpassword);
        
        txtpassword=new JTextField();
        txtpassword.setBounds(250,120,150,25);
        txtpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtpassword);
        
        JLabel lblsecurity=new JLabel("Security Question");
        lblsecurity.setBounds(50,165,125,25);
        lblsecurity.setFont(new Font("Tahona",Font.BOLD,14));
        p1.add(lblsecurity);
        
        security=new Choice();
        security.add("Your Fav Sport");
        security.add("Your Fav Hero");
        security.add("Your Birth Place");
        security.add("Your lucky number");
        security.setBounds(250,165,150,25);
        p1.add(security);
        
        JLabel lblanswer=new JLabel("Answer");
        lblanswer.setBounds(50,210,125,25);
        lblanswer.setFont(new Font("Tahona",Font.BOLD,14));
        p1.add(lblanswer);
        
        txtanswer=new JTextField();
        txtanswer.setBounds(250,210,150,25);
        txtanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtanswer);
        
        create=new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(90,255,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        back=new JButton("Back Login");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(220,255,150,30);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Copy of signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==create){
            String username=txtusername.getText();
            String name=txtname.getText();
            String pwd=txtpassword.getText();
            String answer=txtanswer.getText();
            String securityQ=security.getSelectedItem();
            
            String query="insert into account values('"+username+"', '"+name+"', '"+pwd+"', '"+securityQ+"', '"+answer+"')";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Succesfully");
                setVisible(false);
                new Login();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
        
        
        
    }
    
    public static void main(String args[]){
        new signup();
    }
}
