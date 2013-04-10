import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrameExample extends JFrame implements KeyListener{
  private String position;
  private int countd,counta,countb,showing,cmdvisible;
  private CommandField cmfield;
  private JLabel show;
  private BBSPanel middle=new BBSPanel();
  private BBSPanel bottom= new BBSPanel();
  private String Fhead=new String("<html><font color=\"white\">");
  private String Ftail=new String("</font></html>");
  private POODirectory home= new POODirectory("Home");
  public JFrameExample(String title,String pos)
  {
      	setTitle(title);
      	position=pos;
      	countd=1;
      	counta=0;
      	countb=0;
      	cmdvisible=0;
      	showing=0;// 0: directory 1: board 2: Article
	setSize(960,600);
	setLocationRelativeTo(null);
	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
	this.setFocusable(true);
	setLayout(new BorderLayout());
	Font dfont=new Font("標楷體",36,24);
	setContentPane(new JLabel(new ImageIcon(getClass().getResource("temp.png"))));
	setLayout(new BorderLayout(10,10));
	JLabel banner=new JLabel("<html><div><font color=\"white\"><b>歡迎~ &nbsp;root!</b>目前位置為："+pos
		+" <br/><font style=\"font-size:80%;\">目前系統已有: "+countd+"個資料夾		"+countb+" 個討論版	"+
		counta+"篇文章</font></font></div></html>");
	JLabel footer=new JLabel("<html><font style=\"font-size:50%\" color=\"white\">Created by <a href=\"mailto:b00902104@ntu.edu.tw\">yhsu1126</a></font></html>");
	show=new JLabel(Fhead+"目前無資料~~"+Ftail);
	show.setFont(dfont);
	cmfield = new CommandField(1);
	cmfield.setVisible(false);
	cmfield.addKeyListener(new KeyListener(){
	    public void keyReleased(KeyEvent event) {
		      //show.setText(Fhead+Integer.toString(event.getKeyCode())+Ftail);
		      if(event.getKeyCode()==10)
		      {
			  if(cmfield.isVisible()==true)
			  {
			      show.setText(Fhead+cmfield.getText()+Ftail);
			      cmfield.setText("");
			      cmfield.setVisible(false);
			  }
		      }
		  }
	    @Override
	    public void keyPressed(KeyEvent event) {
	        ;
	    }
	    @Override
	    public void keyTyped(KeyEvent event) { 
	        ;
	    }
	});
	banner.setFont(dfont);
	footer.setFont(dfont);
	show.setAlignmentX(CENTER_ALIGNMENT);
	middle.add(show);
	bottom.add(cmfield);
	bottom.add(footer);
	footer.setAlignmentX(CENTER_ALIGNMENT);
	addKeyListener(this);
	this.requestFocus();
	cmfield.setAlignmentX(CENTER_ALIGNMENT);
	this.getContentPane().add(banner,BorderLayout.NORTH);
	this.getContentPane().add(bottom,BorderLayout.SOUTH);
	this.getContentPane().add(middle,BorderLayout.CENTER);
	 setSize(959,599);
	 setSize(960,600);
  }
  public void showdirectory(POODirectory dir)
  {
      ;
  }
  @Override
  public void keyPressed(KeyEvent event) {
      ;
  }
  @Override
  public void keyTyped(KeyEvent event) { 
      ;
  }
  @Override
  public void keyReleased(KeyEvent event) {
      if(event.getKeyCode()==77)
      {  
	  if(cmfield.isVisible()==false)
	  {
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.revalidate();
	  }
      }
  }
  public static void main(String[] args) {
     JFrameExample main= new JFrameExample("OOPBBS Simple Demo","Home/");
     main.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}

class CommandField extends JTextField
{
    public CommandField(int col)
    {
	super(col);
	setBackground(new Color(107, 106, 104));
	setMaximumSize(new Dimension(960,20));
	setFont(new Font("標楷體",36,24));
	setForeground(Color.WHITE);
	setBorder(BorderFactory.createEmptyBorder());
    }
}

class BBSPanel extends JPanel
{
    BBSPanel()
    {
	super();
	setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
	setOpaque(false);
    }
}