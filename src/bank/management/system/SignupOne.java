package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import java.util.Random;
import com.toedter.calendar.JDateChooser;//jcalender jar file
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SignupOne extends JFrame implements ActionListener
{
	long random;
	JLabel formnoLabel,personalDetail,name,fname,dob,gender,email,marital,address,city,state,pincode;
	JTextField nameTextField,fnameTextField,emailTextField,addTextField,cityTextField,stateTextField,pinTextField;
	JDateChooser date;
	JRadioButton male,female,other,maried,unmaried;
	ButtonGroup gendergroup,maritalgroup;
	JButton next;
	public SignupOne()
	{
		setLayout(null);
		
		Random ran=new Random();
		random=Math.abs(ran.nextLong() % 9000L) + 1000L;
		
		formnoLabel=new JLabel("APPLICATION FORM NO. "+ random);
		formnoLabel.setFont(new Font("Ralway",Font.BOLD,38));
		formnoLabel.setBounds(140,20,600,40);
		add(formnoLabel);
		
		personalDetail=new JLabel("Page 1: Personal Details");
		personalDetail.setFont(new Font("Ralway",Font.BOLD,22));
		personalDetail.setBounds(290,80,280,30);
		add(personalDetail);
		
		name=new JLabel("Name:");
		name.setFont(new Font("Ralway",Font.BOLD,22));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Ralway",Font.BOLD,14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		fname=new JLabel("Father's Name:");
		fname.setFont(new Font("Ralway",Font.BOLD,22));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Ralway",Font.BOLD,14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		dob=new JLabel("Date Of Birth:");
		dob.setFont(new Font("Ralway",Font.BOLD,22));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		date=new JDateChooser();
		date.setFont(new Font("Ralway",Font.BOLD,15));
		date.setForeground(new Color(105,105,105));
		date.setBounds( 300, 240, 400, 30);
		add(date);
		
		gender=new JLabel("Gender:");
		gender.setFont(new Font("Ralway",Font.BOLD,22));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300,290,100,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(450,290,100,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		other=new JRadioButton("Other");
		other.setBounds(600,290,100,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);
		
		email=new JLabel("Email Address:");
		email.setFont(new Font("Ralway",Font.BOLD,22));
		email.setBounds(100,340,200,30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Ralway",Font.BOLD,14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		marital=new JLabel("Marital Status:");
		marital.setFont(new Font("Ralway",Font.BOLD,22));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		maried=new JRadioButton("Maried");
		maried.setBounds(300,390,100,30);
		maried.setBackground(Color.WHITE);
		add(maried);
		
		unmaried=new JRadioButton("Unmaried");
		unmaried.setBounds(450,390,150,30);
		unmaried.setBackground(Color.WHITE);
		add(unmaried);
		
		maritalgroup=new ButtonGroup();
	    maritalgroup.add(maried);
		maritalgroup.add(unmaried);
		
		address=new JLabel("Address:");
		address.setFont(new Font("Ralway",Font.BOLD,22));
		address.setBounds(100,440,200,30);
		add(address);
		
		addTextField = new JTextField();
		addTextField.setFont(new Font("Ralway",Font.BOLD,14));
		addTextField.setBounds(300, 440, 400, 30);
		add(addTextField);
		
		city=new JLabel("City:");
		city.setFont(new Font("Ralway",Font.BOLD,22));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Ralway",Font.BOLD,14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		state=new JLabel("State:");
		state.setFont(new Font("Ralway",Font.BOLD,22));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Ralway",Font.BOLD,14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		pincode=new JLabel("Pincode:");
		pincode.setFont(new Font("Ralway",Font.BOLD,22));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Ralway",Font.BOLD,14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);
		
		next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.white);
		next.setFont(new Font("Ralway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350,10);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String formno = "" + random;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
		String mail= emailTextField.getText();
		String address=addTextField.getText();
		String city=cityTextField.getText();
		String state=stateTextField.getText();
		String pin=pinTextField.getText();
		
		String gender="";
		if(male.isSelected())
			gender="Male";
		else if(female.isSelected())
			gender="Female";
		else
			gender="Other";
		
		String marital="";
		if(maried.isSelected())
			marital="Maried";
		else if(unmaried.isSelected())
			marital="Unmaried";
		
		try 
		{
			if(name.equals(""))
				JOptionPane.showMessageDialog(null,"Name is Required");
			else if(fname.equals(""))
				JOptionPane.showMessageDialog(null,"Father Name is Required");
			else if(dob.equals(""))
				JOptionPane.showMessageDialog(null,"Date of birth is Required");
			else if(marital.equals(""))
				JOptionPane.showMessageDialog(null,"Marital is Required");
			else if(gender.equals(""))
				JOptionPane.showMessageDialog(null,"Gender is Required");
			else if(mail.equals(""))
				JOptionPane.showMessageDialog(null,"Mail is Required");
			else if(state.equals(""))
				JOptionPane.showMessageDialog(null,"State is Required");
			else if(pin.equals(""))
				JOptionPane.showMessageDialog(null,"Pincode is Required");
			else if(address.equals(""))
				JOptionPane.showMessageDialog(null,"Address is Required");
			else if(city.equals(""))
				JOptionPane.showMessageDialog(null,"City is Required");
			else
			{
				Connect con=new Connect();
				String query="INSERT INTO SIGNUP VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+mail+"','"+marital+"','"+address+"','"+city+"','"+pin+"', '"+state+"')";
				con.stm.executeUpdate(query);
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}
		}catch(Exception ae)
		{
			System.out.println(ae);
		}	
	}	
  public static void main(String arg[])
  {
	new SignupOne();  
  }

}
