package bank.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class MiniStatement extends JFrame 
{
	JLabel text,bankname,card,bln;
	String cardnumber;
	public MiniStatement(String cardnumber)
	{
		super("Mini Statement");
		this.cardnumber=cardnumber;
		setLayout(null);
		
		text=new JLabel("");
		text.setFont(new Font("Raleway",Font.BOLD,12));
		text.setBounds(20,140,400,200);
		add(text);
		
		bankname=new JLabel("Indian Bank");
		bankname.setFont(new Font("Raleway",Font.BOLD,16));
		bankname.setBounds(150,20,100,20);
		add(bankname);
		
		String cardnum=cardnumber;
		cardnumber=cardnumber.substring(0,4)+"XXXXXXXX"+cardnumber.substring(12);
		card=new JLabel("Your Card Number "+cardnumber);
		card.setFont(new Font("Raleway",Font.BOLD,16));
		card.setBounds(20,80,300,20);
		add(card);
		
		bln = new JLabel();
		bln.setFont(new Font("Raleway",Font.BOLD,16));
		bln.setBounds(20, 400, 300, 20);
        add(bln);
        
        try {
            Connect con = new Connect();
            int balance=0;
            String query="SELECT * FROM bank Where AccountNumber = '"+cardnum+"'";
            ResultSet rs = con.stm.executeQuery(query);
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                text.setText(text.getText() + "<html>" + date + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + type +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + amount + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            bln.setText("Your total Balance is Rs "+balance);
        } catch (Exception e) {
            e.printStackTrace();
        }	
		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new MiniStatement("");
	}

}
