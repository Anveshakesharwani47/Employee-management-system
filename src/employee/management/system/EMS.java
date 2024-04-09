package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
public class EMS extends JFrame{
	JLabel label1;
	EMS()
	{	setTitle("EMPLOYEE MANAGEMENT SYSTEM");
	
		label1=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
		label1.setBounds(200,125,800,50);
		add(label1);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/backgr.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
	    image.setBounds(0,0,1000,650);
	    add(image);
	    
	    setSize(1000,650);
	    setLocation(200,50);
	    setLayout(null);
		setVisible(true);
		
		try{
			Thread.sleep(5000);
			setVisible(false);
			new Login();
		   }catch(Exception e){
			e.printStackTrace();
		}
		
	}
 public static void main(String[] args)
 {
	new EMS();
 }
}
