package ChatBot;
/**
 * 
 * 
 * 
 *
 */
import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class ChatBotMain extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_1;
	private JButton btnSend;
	private String main="";
	JTextArea textArea;
	LocalTime time=LocalTime.now();
	LocalDate date=LocalDate.now();
	Random random=new Random();
	private JScrollBar scrollBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatBotMain frame = new ChatBotMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public ChatBotMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 428, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					action();
				}
			}
			
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_1.setBounds(0, 555, 338, 60);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action();
			}
		});
		btnSend.setBounds(341, 555, 75, 59);
		contentPane.add(btnSend);
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 396, 554);
		contentPane.add(textArea);
		
		scrollBar = new JScrollBar();
		scrollBar.setVisible(true); 

		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			   public void adjustmentValueChanged(AdjustmentEvent e) {
			}
		});
		scrollBar.setBounds(395, 0, 21, 554);
		contentPane.add(scrollBar,BorderLayout.EAST);
		
	JScrollBar scrollBar = new JScrollBar();
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
			}
		});
			scrollBar.setBounds(395, 0, 21, 554);
		contentPane.add(scrollBar);
		
		
	}
	
	void action()
	{
		
		String query=textField_1.getText();
		textArea.append(" You: "+query+"\n");
		//query.trim();
		query=query.toLowerCase();
		if(query.contains("clear screen")||query.contains("clr")||query.contains("cls"))
		{
			textArea.setText("");
			textField_1.setText("");
		}
		else if(query.contains("hi")||query.contains("hey")||query.contains("hola")||query.contains("hello"))
		{
			Random rand=new Random();
			int a=rand.nextInt(4);
			if(a==0)
			{
				ai("Hey, I'm here.");
			}
			else if(a==1)
			{
				ai("Hey, what's up?");
			}
			else if(a==2)
			{
				ai("Hey, how are you doing?");
			}
			else if(a==3)
			{
				ai("Hello, how are you?");
			}
			else
			{
				ai("Hello, how are you doing?");
			}
			
		}
		else if(query.contains("fine")||query.contains("I'm fine")||query.contains("am okay")||query.contains("good"))
		{
			Random rand=new Random();
			int a=rand.nextInt(4);
			if(a==0)
			{
				ai("It's good to know that you are fine.");
			}
			else if(a==1)
			{
				ai("It's a pleasure to know that you are fine.");
			}
			else if(a==2)
			{
				ai("Oh, great!");
			}
			else if(a==3)
			{
				ai("Oh, such a great news.");
			}
			else if(a==4)
			{
				ai("Wish, you always remain good.");
			}
		}
		else if(query.contains("wssup")||query.contains("whats up")||query.contains("whatsup")||query.contains("wtsup")
				||query.contains("you doing")||query.contains("u doing"))
		{
				ai("I'm good and what about you");
		}
		else if(query.contains("yes")||query.contains("yeah")||query.contains("ya"))
		{
			Random rand=new Random();
			int a=rand.nextInt(2);
			if(a==0)
			{
				ai("Oh, great!");
			}
			else if(a==1)
			{
				ai("Oh, great news!");
			}
			else if(a==2)
			{
				ai("Nice");
			}
		}
		else if(query.contains("ntnhng")||query.contains("nothing")||query.contains("ntg"))
		{
			Random rand=new Random();
			int a=rand.nextInt(2);
			if(a==0)
			{
				ai("Why?");
			}
			else if(a==1)
			{
				ai("Why, as far as I know, you are a very charming person.");
			}
			else if(a==2)
			{
				ai("Why? Don't waste your time.");
			}
		}
		else if(query.contains("time"))
		{
		    String ctime=new String();
			if(time.getHour()>12)
			{
				int hour=time.getHour()-12;
				ctime=ctime+hour+":"+time.getMinute()+":"+time.getSecond()+" PM";
			}
			
			else
			{
				
				ctime=ctime+time.getHour()+":"+time.getMinute()+":"+time.getSecond()+" AM";
			}
			ai(ctime);	
		}
		else if(query.contains("date")||query.contains("month")||query.contains("year")||query.contains("day"))
		{
		
			String cdate=new String();
			cdate=cdate + date.getDayOfWeek()+","+date.getDayOfMonth()+" "+date.getMonth()+" "+date.getYear();
			ai(cdate);
		}
		else
		{
			try
			{
				try
				{
					URL url=new URL("https://google.co.in");
					URLConnection connection=url.openConnection();
					connection.connect();
					ai("Here some results for you ...");
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.google.com/search?q="+query.replace(" ", "+")+"&btnG=Google+Search"));
			
				}
				catch(Exception ee)
				{
					ai("Connect with internet connection for get better results...");
				}
				
				catch(Exception eee)
		        {
					Random rand=new Random();
					int a=rand.nextInt(4);
					if(a==0)
					{
						ai("Sorry, I can't understand you");
					}
					else if(a==1)
					{
						ai("Please state it correctly.");
					}
					else if(a==2)
					{
						ai("I didn't understand that. Can you please rephrase?");
					}
					else if(a==3)
					{
						ai("???");
					}
			    }
			}
		}
	}
	
	public static void ai(String s)
	{
		textArea.append(" ChatBot: "+s+"\n\n");
		textField_1.setText("");
	}
}
