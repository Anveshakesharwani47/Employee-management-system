package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Attendance extends JFrame implements ActionListener {
	JButton take,view,back;
	Attendance()
	{
		setTitle("ATTENDANCE");
		JLabel label=new JLabel("ATTENDANCE");
		label.setFont(new Font("Tahoma",Font.BOLD,15));
		label.setBounds(175,50,400,100);
		add(label);
		
		take=new JButton("TAKE ATTENDANCE");
		take.setBounds(50,200,175,30);
		take.setBackground(Color.BLACK);
		take.setForeground(Color.RED);
		take.addActionListener(this);
		add(take);
		
		view=new JButton("VIEW ATTENDANCE");
		view.setBounds(250,200,175,30);
		view.setBackground(Color.BLACK);
		view.setForeground(Color.RED);
		view.addActionListener(this);
		add(view);
		
		back=new JButton("BACK");
		back.setBounds(150,300,175,30);
		back.setForeground(Color.RED);
	    back.setBackground(Color.BLACK);
	    back.addActionListener(this);
		add(back);
		
		getContentPane().setBackground(new Color(211,235,212));
		setSize(500,400);
		setLocation(300,150);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==take)
		{
			try{
				
			   setVisible(false);
			   new AttendanceEmp();
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		else if(e.getSource()==view)
		{
			setVisible(false);
			 new ViewAttendance();
		}
		else
		{
			setVisible(false);
			new Home();
		}
	}
		
   public static void main(String[] args)
   {
	   new Attendance();
   }
}


