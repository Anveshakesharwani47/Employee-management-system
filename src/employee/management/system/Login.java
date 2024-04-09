package employee.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	JLabel label1;
	JTextField tusername;
	JPasswordField tpassword;
	JButton button1,button2;
	Login(){
		super("Employee management system");
		
		JLabel username=new JLabel("Username");
		username.setBounds(40,20,100,30);
		add(username);
		
		tusername=new JTextField();
		tusername.setBounds(150,20,150,30);
		add(tusername);
		
		JLabel password=new JLabel("Password");
	    password.setBounds(40,70,100,30);
		add( password);
		
		 tpassword=new JPasswordField();
		 tpassword.setBounds(150,70,150,30);
		 add(tpassword);
		
		 button1=new JButton("LOGIN");
	     button1.setFont(new Font("Arial",Font.BOLD,14));
    	 button1.setForeground(Color.RED);
		 button1.setBackground(Color.BLACK);
		 button1.setBounds(150,140,150,30);
		 button1.addActionListener(this);
		 add(button1);
		    
	     button2=new JButton("BACK");
		 button2.setFont(new Font("Arial",Font.BOLD,14));
		 button2.setForeground(Color.RED);
		 button2.setBackground(Color.BLACK);
	     button2.setBounds(150,180,150,30);
	     button2.addActionListener(this);
	     add(button2);
		    
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login1.jpg"));
	     Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
	     ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(350,10,200,200);
		 add(image);
		
		 getContentPane().setBackground(new Color(209,119,109));
		 setSize(600,300);
		 setLocation(450,200);
		 setLayout(null);
		 setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button1)
		{
			try{
				 String username=tusername.getText();
				 String password=tpassword.getText();
				 connect conn=new connect();
				 String query="select * from login where username = '"+ username +"' and password = '"+password+"'";
				 ResultSet resultSet=conn.statement.executeQuery(query);
				 if(resultSet.next())
				 {	setVisible(false);
				 new Home();
				 }
				 else
				 {
				 	JOptionPane.showMessageDialog(null,"Invalid username or password");
				 }
			   }catch(Exception E){
				E.printStackTrace();
		        }
	    }
		else if(e.getSource()==button2)
		{
			System.exit(90);
		}
	}
	public static void main(String[] args)
	{
		new Login();
	}

}
