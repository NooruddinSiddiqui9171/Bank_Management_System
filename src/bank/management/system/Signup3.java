package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
@SuppressWarnings("serial")
public class Signup3 extends JFrame implements ActionListener 
{
	JLabel l1,type,cardnum,number,pin,pnumber,services;
	JRadioButton saving,current,fixed,recurring;
	JCheckBox atmcard,intebank,mobbank,emailsms,chequebook,estatement,agree;
	ButtonGroup accounttype;
	JButton submit,cancel;
	String formno;
	Random random=new Random();
	public Signup3(String formno)
	{
	  this.formno=formno;	
	  setLayout(null);	
	  l1=new JLabel("Page :3 Account Details");
	  l1.setFont(new Font("Raleway",Font.BOLD,22));
	  l1.setBounds(280,40,400,40);
	  add(l1);
	  
	  type=new JLabel("Account Type");
	  type.setFont(new Font("Raleway",Font.BOLD,22));
	  type.setBounds(100,130,200,30);
	  add(type);
	  
	  saving=new JRadioButton("Saving Account");
	  saving.setFont(new Font("Raleway",Font.BOLD,16));
	  saving.setBackground(Color.WHITE);
	  saving.setBounds(100,180,150,20);
	  add(saving);
	  
	  current=new JRadioButton("Current Account");
	  current.setFont(new Font("Raleway",Font.BOLD,16));
	  current.setBackground(Color.WHITE);
	  current.setBounds(100,220,150,20);
	  add(current);
	  
	  fixed=new JRadioButton("Fixed Deposit Account");
	  fixed.setFont(new Font("Raleway",Font.BOLD,16));
	  fixed.setBackground(Color.WHITE);
	  fixed.setBounds(330,180,200,20);
	  add(fixed);
	  
	  recurring=new JRadioButton("Recurring Deposit Account");
	  recurring.setFont(new Font("Raleway",Font.BOLD,16));
	  recurring.setBackground(Color.WHITE);
	  recurring.setBounds(330,220,250,20);
	  add(recurring);
	  
	  accounttype = new ButtonGroup();
	  accounttype.add(saving);
	  accounttype.add(current);
	  accounttype.add(recurring);
	  accounttype.add(fixed);
	  
	  
	  cardnum=new JLabel("Card Number");
	  cardnum.setFont(new Font("Raleway",Font.BOLD,22));
	  cardnum.setBounds(100,300,200,30);
	  add(cardnum);
	  
	  number=new JLabel("Your 16-Digit Card Number");
	  number.setFont(new Font("Raleway",Font.ITALIC,12));
	  number.setBounds(320,320,350,30);
	  add(number);
	  
	  number=new JLabel("XXXX-XXXX-XXXX-4562");
	  number.setFont(new Font("Raleway",Font.BOLD,22));
	  number.setBounds(320,300,350,30);
	  add(number);
	  
	  pin=new JLabel("PIN");
	  pin.setFont(new Font("Raleway",Font.BOLD,22));
	  pin.setBounds(100,370,200,30);
	  add(pin);
	  
	  number=new JLabel("Your 4-Digit Pin Number");
	  number.setFont(new Font("Raleway",Font.ITALIC,12));
	  number.setBounds(320,390,350,30);
	  add(number);
	  
	  pnumber=new JLabel("XXXX");
	  pnumber.setFont(new Font("Raleway",Font.BOLD,22));
	  pnumber.setBounds(320,370,350,30);
	  add(pnumber);
	  
	  services=new JLabel("Services Required:");
	  services.setFont(new Font("Raleway",Font.BOLD,22));
	  services.setBounds(100,450,350,30);
	  add(services);
	  
	  atmcard = new JCheckBox("ATM Card");
	  atmcard.setFont(new Font("Raleway",Font.BOLD,16));
	  atmcard.setBackground(Color.WHITE);
	  atmcard.setBounds(100,500,200,30);
	  add(atmcard);
	  
	  intebank = new JCheckBox("Internet Banking");
	  intebank.setFont(new Font("Raleway",Font.BOLD,16));
	  intebank.setBackground(Color.WHITE);
	  intebank.setBounds(100,540,200,30);
	  add(intebank);
	  
	  mobbank = new JCheckBox("Mobile Banking");
	  mobbank.setFont(new Font("Raleway",Font.BOLD,16));
	  mobbank.setBackground(Color.WHITE);
	  mobbank.setBounds(100,580,200,30);
	  add(mobbank);
	  
	  emailsms = new JCheckBox("Email & Sms Alert");
	  emailsms.setFont(new Font("Raleway",Font.BOLD,16));
	  emailsms.setBackground(Color.WHITE);
	  emailsms.setBounds(310,500,200,30);
	  add(emailsms);
	  
	  chequebook = new JCheckBox("Cheque Book");
	  chequebook.setFont(new Font("Raleway",Font.BOLD,16));
	  chequebook.setBackground(Color.WHITE);
	  chequebook.setBounds(310,540,200,30);
	  add(chequebook);
	  
	  estatement = new JCheckBox("E-Statement");
	  estatement.setFont(new Font("Raleway",Font.BOLD,16));
	  estatement.setBackground(Color.WHITE);
	  estatement.setBounds(310,580,200,30);
	  add(estatement);
	  
	  agree = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
	  agree.setFont(new Font("Raleway",Font.BOLD,16));
	  agree.setBackground(Color.WHITE);
	  agree.setBounds(100,655,700,30);
	  add(agree);
	  
	  submit=new JButton("Submit");
	  submit.setBackground(Color.BLACK);
	  submit.setForeground(Color.WHITE);
	  submit.setFont(new Font("Raleway",Font.BOLD,14));
	  submit.setBounds(250,720,100,30);
	  submit.addActionListener(this);
	  add(submit);
	  
	  cancel=new JButton("Cancel");
	  cancel.setBackground(Color.BLACK);
	  cancel.setForeground(Color.WHITE);
	  cancel.setFont(new Font("Raleway",Font.BOLD,14));
	  cancel.setBounds(420,720,100,30);
	  cancel.addActionListener(this);
	  add(cancel);

	  setSize(850,820);
	  setLocation(350,0);
	  getContentPane().setBackground(Color.WHITE);
	  setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		String acctype="";
		if(saving.isSelected())
			acctype="Saving Account";
		else if(current.isSelected())
			acctype="Current Account";
		else if(fixed.isSelected())
			acctype="Fixed Account";
		else
			acctype="Recurring Account";
		
		String card="";
				if(atmcard.isSelected())
					card="Yes";
				else
					card="No";
	    String Intbanking="";
				if(intebank.isSelected())
					Intbanking="Yes";
				else
					Intbanking="No";
		String mobbanking="";
		        if(mobbank.isSelected())
		        	mobbanking="Yes";
		        else
		        	mobbanking="No";
		String smsalert="";
		        if(emailsms.isSelected())
		        	smsalert="Yes";
		        else
		        	smsalert="No";
	    String cheqbook="";
		        if(chequebook.isSelected())
		        	cheqbook="Yes";
		        else
		        	cheqbook="No";  
	    String estm="";
		        if(estatement.isSelected())
		        	estm="Yes";
		        else
		        	estm="No"; 
		String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5854569000000000L);
		int randomNumber = random.nextInt(9999 - 1000 + 1) + 1000;
        String pinnumber = String.format("%04d", randomNumber);
		try
		{		
		if(e.getSource()==cancel)
		{
			setVisible(false);
			new Login().setVisible(true);
		}
		else if(agree.isSelected()==false)
		{
			JOptionPane.showMessageDialog(null,"Please Select Terms and Condition");
		}	
		else if(accounttype.getSelection()==null)
		{
			JOptionPane.showMessageDialog(null,"Please Select Account Type");
		}
		else
		{
			Connect con=new Connect();
			String query="INSERT INTO SIGNUP3 VALUES('"+formno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+card+"','"+Intbanking+"','"+mobbanking+"','"+smsalert+"','"+cheqbook+"','"+estm+"')";
			String loginquery="INSERT INTO LOGIN VALUES('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
			con.stm.executeUpdate(query);
			con.stm.execute(loginquery);
			JOptionPane.showMessageDialog(null,"Your card Number "+cardnumber+"\n Your pin "+pinnumber);
		
			setVisible(false);
			new Deposit(cardnumber).setVisible(true);
			
		}
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		
	}
	public static void main(String arg[])
	{
	 	new Signup3("");
	}
}
