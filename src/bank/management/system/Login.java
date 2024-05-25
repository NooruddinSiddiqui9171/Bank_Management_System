package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener
{
	JButton login, clear, signup;
	JLabel text, cardno, pin;
	JTextField cardTextField;
	JPasswordField pinTextField;
	public Login()
	{
		super("Automated Teller Machine");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));// It will get the image from given location
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);// it will scale the given image accourding to our given width and hight
		ImageIcon i3=new ImageIcon(i2);// we can not directly pass Image object in JLabel we have to convert it first into ImageIcon object		
		JLabel label=new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Times New Roman",Font.BOLD,38));
		text.setBounds( 200, 40, 400, 40);
		add(text);
		
		cardno=new JLabel("Card No:");
		cardno.setFont(new Font("Ralway",Font.BOLD,28));
		cardno.setBounds( 120, 150, 150, 30);
		add(cardno);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Times New Roman",Font.BOLD,13));
		add(cardTextField);
		
		pin=new JLabel("PIN:");
		pin.setFont(new Font("Ralway",Font.BOLD,28));
		pin.setBounds( 120, 220, 150, 30);
		add(pin);
		
		pinTextField=new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Times New Roman",Font.BOLD,13));
		add(pinTextField);
		
		login=new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear=new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup=new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);// It will set the initial location of main Frame
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == clear)
		{
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(e.getSource() == login)
		{
			Connect con=new Connect();
			String cardnumber=cardTextField.getText();
			@SuppressWarnings("deprecation")
			String pinnumber=pinTextField.getText();
			String query="SELECT * FROM LOGIN WHERE card_number = '"+cardnumber+"' AND pin_number = '"+pinnumber+"'";
			try
			{
				ResultSet rs=con.stm.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
				    new Transactions(cardnumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		else if(e.getSource() == signup)
		{
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}
	public static void main(String arg[])
	{
		new Login();
	}
}
