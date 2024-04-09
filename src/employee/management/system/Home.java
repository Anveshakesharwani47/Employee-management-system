package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class Home extends JFrame{
	JLabel labelhead;
	Home()
	{
		setTitle("EMPLOYEE MANAGEMENT SYSTEM");
		
		labelhead=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		labelhead.setForeground(Color.BLACK);
		labelhead.setFont(new Font("Raleway",Font.BOLD,50));
		labelhead.setBounds(150,155,1000,40);
		add(labelhead);
		
		
		JButton addbutton=new JButton("Add Employee");
	    addbutton.setFont(new Font("Arial",Font.BOLD,14));
		addbutton.setForeground(Color.WHITE);
		addbutton.setBackground(Color.BLACK);
		addbutton.setBounds(335,270,200,40);
	    add(addbutton);
		addbutton.addActionListener(new ActionListener()
		{
        	 @Override
        	 public void actionPerformed(ActionEvent e){
        			setVisible(false);
		    		new AddEmployee();
		    	}
	    });
  
		 JButton delbutton=new JButton("Delete Employee");
		 delbutton.setFont(new Font("Arial",Font.BOLD,14));
		 delbutton.setForeground(Color.RED);
		 delbutton.setBackground(Color.BLACK);
		 delbutton.setBounds(565,270,200,40);
		 add(delbutton);
		 delbutton.addActionListener(new ActionListener(){
		 @Override
		 public void actionPerformed(ActionEvent e){
			 setVisible(false);
		     new DeleteEmployee();	
		  }
		  });
		    
		 JButton shbutton=new JButton("Show Employee");
		 shbutton.setFont(new Font("Arial",Font.BOLD,14));
		 shbutton.setForeground(Color.GREEN);
		 shbutton.setBackground(Color.BLACK);
	     shbutton.setBounds(335,370,200,40);
		 add(shbutton);
		 shbutton.addActionListener(new ActionListener(){
	     @Override
		 public void actionPerformed(ActionEvent e){
	    	         setVisible(false);
		         	new ShowEmployee();  		
		 }
	    });
		    
        JButton attbutton=new JButton("Attendance of Employee");
        attbutton.setFont(new Font("Arial",Font.BOLD,13));
		attbutton.setForeground(Color.CYAN);
		attbutton.setBackground(Color.BLACK);
		attbutton.setBounds(565,370,200,40);
		add(attbutton);
		attbutton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			        setVisible(false);
		    		new Attendance();	
			}
	    });  
		
	    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
	    Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    JLabel image=new JLabel(i3);
		image.setBounds(0,0,1120,630);
		add(image);    
	  
		setSize(1120,630);
		setLocation(250,100);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new Home();	
	}
}
