package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PinChange extends JFrame implements ActionListener
{
	String cardnumber;
	JLabel image,text,pintext,repintext;
	JPasswordField pinTextField,repinTextField;
	JButton submit,back;
	public PinChange(String cardnumber)
	{
		this.cardnumber=cardnumber;
	    setLayout(null);
	
	    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	    Image i2=i1.getImage().getScaledInstance(750, 850, Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    image=new JLabel(i3);
	    image.setBounds(0, 0, 750, 800);
	    add(image);
	    
	    text=new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(200,235,300,40);
		image.add(text);
		
		pintext=new JLabel("New Pin: ");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(130,275,150,40);
		image.add(pintext);
		
		pinTextField =new JPasswordField();
		pinTextField.setFont(new Font("System",Font.BOLD,16));
		pinTextField.setBounds(280,275,150,30);
		image.add(pinTextField);
		
		repintext=new JLabel("Re-Enter New Pin: ");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(130,315,150,40);
		image.add(repintext);
		
		repinTextField =new JPasswordField();
		repinTextField.setFont(new Font("System",Font.BOLD,16));
		repinTextField.setBounds(280,315,150,30);
		image.add(repinTextField);
		
		submit=new JButton("Submit");
		submit.setFont(new Font("Times New Roman",Font.BOLD,15));
		submit.setBounds(280,432,150,30);
		submit.addActionListener(this);
		image.add(submit);
		
		back=new JButton("Back");
		back.setFont(new Font("Times New Roman",Font.BOLD,15));
		back.setBounds(280,464,150,30);
		back.addActionListener(this);
		image.add(back);
		
	    setSize(750,800);
		setLocation(400,0);
		setVisible(true);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==submit)
		{
			try
			{
				String npin=pinTextField.getText();
				String rpin=repinTextField.getText();
				if(npin.equals("") || rpin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Pin");
					return;
				}
				else if(!npin.equals(rpin))
				{
					JOptionPane.showMessageDialog(null,"Entered Pin Does Not Match");
					return;
				}
				else if(!npin.matches("[0-9]{4}"))
				{
					JOptionPane.showMessageDialog(null,"Please Enter 4-Digit only");
					return;
				}
				else if(!rpin.matches("[0-9]{4}"))
				{
					JOptionPane.showMessageDialog(null,"Please Enter 4-Digit only");
					return;
				}
				Connect con=new Connect();
				String querySignup3="UPDATE SIGNUP3 SET pin_number ='"+npin+"' WHERE card_number ='"+cardnumber+"'";
				String queryLogin="UPDATE LOGIN SET pin_number ='"+npin+"' WHERE card_number ='"+cardnumber+"'";
				con.stm.executeUpdate(querySignup3);
				con.stm.executeUpdate(queryLogin);
				JOptionPane.showMessageDialog(null,"Pin Changed Sucessfully");
				
				setVisible(false);
				new Transactions(cardnumber).setVisible(true);
				
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		else
		{
			setVisible(false);
			new Transactions(cardnumber).setVisible(true);
		}
	}
  public static void main(String arg[])
  {
	  new PinChange("");
  }
}
