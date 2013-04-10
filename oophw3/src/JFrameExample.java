import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JFrameExample extends JFrame implements KeyListener{
  Stack<Object> pages= new Stack<Object>();  
  Object current;
  private String position;
  private int countd,counta,countb,showing,cmdvisible;
  private CommandField cmfield;
  private JTextArea contentfield;
  private Showboard show;
  private BBSPanel middle=new BBSPanel();
  private BBSPanel bottom= new BBSPanel();
  private POODirectory home= new POODirectory("Home");
  private Showboard instruction=new Showboard("");
  private int command;
  private JLabel banner;
  public JFrameExample(String title,String pos)
  {
      	setTitle(title);
      	position=pos;
      	countd=1;
      	counta=0;
      	countb=0;
      	cmdvisible=0;
      	showing=0;// 0: directory 1: board 2: Article
      	pages.push(home);
      	current=pages.pop();
	setSize(960,600);
	setLocationRelativeTo(null);
	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
	this.setFocusable(true);
	setLayout(new BorderLayout());
	Font dfont=new Font("�з���",36,24);
	setContentPane(new JLabel(new ImageIcon(getClass().getResource("temp.png"))));
	setLayout(new BorderLayout(10,10));
	banner=new JLabel("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
		
		+"</html>");
	banner.setForeground(Color.WHITE);
	JLabel footer=new JLabel("<html><font style=\"font-size:50%\" color=\"white\">Created by <a href=\"mailto:b00902104@ntu.edu.tw\">yhsu1126</a></font></html>");
	instruction.setFont(dfont);
	instruction.setForeground(Color.WHITE);
	show=new Showboard("�ثe�L���~~");
	show.setForeground(Color.WHITE);
	show.setFont(dfont);
	contentfield=new JTextArea(5,20);
	contentfield.setBackground(new Color(107, 106, 104));
	contentfield.setMaximumSize(new Dimension(960,400));
	contentfield.setBorder(BorderFactory.createEmptyBorder());
	contentfield.setForeground(Color.WHITE);
	contentfield.setFont(dfont);
	cmfield = new CommandField(1);
	cmfield.setVisible(false);
	contentfield.setVisible(false);
	cmfield.addKeyListener(new KeyListener(){
	    public void keyReleased(KeyEvent event) {
		      //show.setText(Integer.toString(event.getKeyCode()));
		      if(event.getKeyCode()==10)
		      {
			  if(cmfield.isVisible()==true)
			  {
			      if(command==-1)
			      {
				  if(cmfield.getText().equals("N") || cmfield.getText().equals("n"))
				      {
				      	;
				      }
				  else
				  {
				      System.exit(0);
				  }
			      }
			      if(command==0)
			      {
				  int a=-1;
				  try
				  {
				      a=Integer.parseInt(cmfield.getText());
				  }
				  catch(Exception e)
				  {
				      ;
				  }
				  finally
				  {
				      if(a>=0)
				      {
					  if(current instanceof POODirectory)
					  {
					      Object tmp=((POODirectory) current).getstuff(a);
					      if(tmp instanceof Boolean || tmp instanceof String)
					      {
						  show.addfirst(current, "���n�ê���!!(�j��)�ڥ�����i�h");
						  banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
								
								+"</html>");
					      }
					      else
					      {
						  pages.push(current);
						  current=tmp;
						  show.showcontent(current);
						  try
						  {
						      position=position+"/"+((POOBoard) current).showname();
						  }
						  catch (Exception e)
						  {
						      position=position+"/"+((POODirectory) current).showname();;
						  }
						  finally
						  {
						      ;
						  }
						  banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
								
								+"</html>");
						  instruction.showinstsruction(current);
					      }
					  }
					  if(current instanceof POOBoard)
					  {
					      Object tmp=((POOBoard) current).getstuff(a);
					      if(tmp instanceof Boolean)
					      {
						  show.addfirst(current, "���n�ê���!!(�j��)�ڥ�����i�h");
						  banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
								
								+"</html>");
					      }
					      else
					      {
						  pages.push(current);
						  current=tmp;
						  show.showcontent(current);
						  position=position+"/"+((POOArticle) current).showname();
						  banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
								
								+"</html>");
						  instruction.showinstsruction(current);
					      }
					  }
				      }
				      else
				      {
					  banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
							
							+"</html>");
				      }
				  }
			      }
			      if(current instanceof POOArticle)
			      {
				  if(cmfield.getText().length()>0 && command==1)
				  {
				      
				      if(((POOArticle) current).push(cmfield.getText())<0)
				      {
					  show.addfirst(current, "�^��Ƥw�F�W��~~<br/>");
				      }
				      else
				      {
					  show.addfirst(current, "�P�±z�����~~(�x��)<br/>");
				      }
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
				  if(cmfield.getText().length()>0 && command==2)
				  {
				      
				      if(((POOArticle) current).boo(cmfield.getText())<0)
				      {
					  show.addfirst(current, "�^��Ƥw�F�W��~~<br/>");
				      }
				      else
				      {
					  show.addfirst(current, "�n�a~~ �@�̳Q��F XDD<br/>");
				      }
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
				  if(cmfield.getText().length()>0 && command==3)
				  {
				      
				      if(((POOArticle) current).arrow(cmfield.getText())<0)
				      {
					  show.addfirst(current, "�^��Ƥw�F�W��~~<br/>");
				      }
				      else
				      {
					  show.addfirst(current, "�P�±z���^��~~:D<br/>");
				      }
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
			      }
			      if(current instanceof POOBoard)
			      {
				  if(command==1)
				  {
				      if(contentfield.getText().length()<=0)
				      {
					  contentfield.requestFocus();
					  banner.setText("�мg���e");
				      }
				      else
				      {
					  POOArticle tmp;
					  String delims = "[ ]+";
					  String[] tokens=cmfield.getText().split(delims);
					  try
					  {
					      tmp= new POOArticle(tokens[0],tokens[1],contentfield.getText(),0);
					  }
					  catch(Exception e)
					  {
					      tmp=null;
					  }
					  if(tmp!=null)
					  {
					      //contentfield.setText(tmp.showtitle()+" "+tmp.showAuthor()+" "+tmp.showcount());
					      ((POOBoard) current).add(tmp);
					      contentfield.setText("");
					      cmfield.setText("");
					      cmfield.setVisible(false);
					      contentfield.setVisible(false);
					      show.setVisible(true);
					      instruction.setVisible(true);
					      show.addfirst(current, "�s�W���\~~ <br/>");
					  }
					  else
					  {
					      contentfield.setText("");
					      cmfield.setText("");
					      cmfield.setVisible(false);
					      contentfield.setVisible(false);
					      show.setVisible(true);
					      instruction.setVisible(true);
					      show.addfirst(current, "�s�W���� QAQ �Ч�کީ�~~ <br/>");
					  }
				      }
				  }
				  else if(command==2)
				  {
				      int a=-1;
				      try
				      {
					  a=Integer.parseInt(cmfield.getText());
				      }
				      catch(Exception e)
				      {
					  ;
				      }
				      finally
				      {
					  if(a>=0)
					  {
					      int r=((POOBoard) current).del(a);
					      if(r<0)
					      {
						  show.addfirst(current, "���ಾ���Ӥ�~(��) ���n�ê���!<br/>");
					      }
					      else
					      {
						  show.addfirst(current, "�R�����\<br/>");
					      }
					  }
					  else
					  {
					      show.showcontent(current);
					  }
				      }
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
				  else if(command==3)
				  {
				      int a=-1,b=-1;
				      try
				      {
					  String delims = "[ ]+";
					  String[] tokens = cmfield.getText().split(delims);
					  a=Integer.parseInt(tokens[0]);
					  b=Integer.parseInt(tokens[1]);
				      }
				      catch(Exception e)
				      {
					  ;
				      }
				      finally
				      {
					  if(a>=0 && b>=0)
					  {
					      int r=((POOBoard) current).move(a,b);
					      if(r<0)
					      {
						  show.addfirst(current, "���ಾ�ʸӶ�~(��) ���n�ê���!<br/>");
					      }
					      else
					      {
						  show.addfirst(current, "���ʦ��\<br/>");
					      }
					  }
					  else
					  {
					      show.showcontent(current);
					  }
				      }
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
				  else if(command==4)
				  {
				      int a=-1,b=-1;
				      try
				      {
					  String delims = "[ ]+";
					  String[] tokens = cmfield.getText().split(delims);
					  a=Integer.parseInt(tokens[0]);
					  b=Integer.parseInt(tokens[1]);
				      }
				      catch(Exception e)
				      {
					  ;
				      }
				      finally
				      {
					  if(a>=0 && b>=0)
					  {
					      int r=((POOBoard) current).move(a,b);
					      if(r<0)
					      {
						  show.addfirst(current, "���ಾ�ʸӶ�~(��) ���n�ê���!<br/>");
					      }
					      else
					      {
						  show.addfirst(current, "���ʦ��\<br/>");
					      }
					  }
					  else
					  {
					      show.showcontent(current);
					  }
				      }
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
			      }
			      if(current instanceof POODirectory)
			      {
				  if(cmfield.getText().length()>0 && command==1)
				  {
				      POODirectory tmp=new POODirectory(cmfield.getText());
				      ((POODirectory) current).add(tmp);
				      show.showcontent(current);
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
				  else if(cmfield.getText().length()>0 && command==2)
				  {
				      POOBoard tmp=new POOBoard(cmfield.getText());
				      ((POODirectory) current).add(tmp);
				      show.showcontent(current);
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
				  else if(command==3)
				  {
				      if(cmfield.getText().equals("Y") || cmfield.getText().equals("y"))
				      {
				      ((POODirectory) current).add_split();
				      }
				      show.showcontent(current);
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
				  else if(command==4)
				  {
				      int a=-1;
				      try
				      {
					  a=Integer.parseInt(cmfield.getText());
				      }
				      catch(Exception e)
				      {
					  ;
				      }
				      finally
				      {
					  if(a>=0)
					  {
					      int r=((POODirectory) current).del(a);
					      if(r<0)
					      {
						  show.addfirst(current, "���ಾ���Ӷ�~(��) ���n�ê���!<br/>");
					      }
					      else
					      {
						  show.addfirst(current, "�R�����\<br/>");
					      }
					  }
					  else
					  {
					      show.showcontent(current);
					  }
				      }
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
				  else if(command==5)
				  {
				      int a=-1,b=-1;
				      try
				      {
					  String delims = "[ ]+";
					  String[] tokens = cmfield.getText().split(delims);
					  a=Integer.parseInt(tokens[0]);
					  b=Integer.parseInt(tokens[1]);
				      }
				      catch(Exception e)
				      {
					  ;
				      }
				      finally
				      {
					  if(a>=0 && b>=0)
					  {
					      int r=((POODirectory) current).move(a,b);
					      if(r<0)
					      {
						  show.addfirst(current, "���ಾ�ʸӶ�~(��) ���n�ê���!<br/>");
					      }
					      else
					      {
						  show.addfirst(current, "���ʦ��\<br/>");
					      }
					  }
					  else
					  {
					      show.showcontent(current);
					  }
				      }
				      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
						
						+"</html>");
				  }
			      }
			      cmfield.setText("");
			      cmfield.setVisible(false);
			      instruction.setVisible(true);
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
	show.setAutoscrolls(true);
	middle.add(show);
	middle.add(contentfield);
	contentfield.setAlignmentX(CENTER_ALIGNMENT);
	bottom.add(instruction);
	bottom.add(cmfield);
	bottom.add(footer);
	instruction.setAlignmentX(CENTER_ALIGNMENT);
	footer.setAlignmentX(CENTER_ALIGNMENT);
	addKeyListener(this);
	this.requestFocus();
	cmfield.setAlignmentX(CENTER_ALIGNMENT);
	this.getContentPane().add(banner,BorderLayout.NORTH);
	this.getContentPane().add(bottom,BorderLayout.SOUTH);
	this.getContentPane().add(middle,BorderLayout.CENTER);
	instruction.showinstsruction(current);
	show.showcontent(current);
	 setSize(959,599);
	 setSize(960,600);
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
	      
	      if(current instanceof POODirectory)
	      {
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=1;
	      }
	      if(current instanceof POOBoard)
	      {
	      banner.setText("�ݪO�Q�p�T���G�@�̳]�p����~~ �Цb�W�襴���e�A�U�襴�W���D�Χ@��(�H�ťդ��})");
	      instruction.setVisible(false);
	      show.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      contentfield.setVisible(true);
	      contentfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=1;
	      }
	  }
      }
      if(event.getKeyCode()==78)
      {  
	  if(cmfield.isVisible()==false)
	  {
	      
	      if(current instanceof POODirectory)
	      {
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=2;
	      }
	  }
      }
      if(event.getKeyCode()==83)
      {  
	  if(cmfield.isVisible()==false)
	  {
	      
	      if(current instanceof POODirectory)
	      {
	      banner.setText("�ݪO�Q�p�T���G�нT�w�z�n�[���j�u? [Y/N] �w�] N");
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=3;
	      }
	  }
      }
      if(event.getKeyCode()==68)
      {
	  if(cmfield.isVisible()==false)
	  {
	      
	      if(current instanceof POODirectory)
	      {
	      banner.setText("�ݪO�Q�p�T���G�п�J�z���R�������اǸ�~");
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=4;
	      }
	      if(current instanceof POOBoard)
	      {
	      banner.setText("�ݪO�Q�p�T���G�п�J�z���R�����峹�Ǹ�~");
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=2;
	      }
	  }
      }
      if(event.getKeyCode()==88)
      {
	  if(cmfield.isVisible()==false)
	  {
	      
	      if(current instanceof POODirectory)
	      {
	      banner.setText("�ݪO�Q�p�T���G�п�J�z�����ʪ����ػP�ت��a(�����Ϊťչj�})~");
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=5;
	      }
	      if(current instanceof POOBoard)
	      {
		  banner.setText("�ݪO�Q�p�T���G�п�J�z�����ʪ����ػP�ت��a(�����Ϊťչj�})~");
		      instruction.setVisible(false);
		      cmfield.setVisible(true);
		      cmfield.requestFocus();
		      this.invalidate();this.validate();;
		      command=4;
	      }
	  }
      }
      if(event.getKeyCode()==81)
      {
	  if(cmfield.isVisible()==false)
	  {
	      
	      banner.setText("�ݪO�Q�p�T���G�n���ں�ı�F�� ?? �ڷ|�ѥ��@���� QAQ [Y/N] �w�] Y");
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=-1;
	  }
      }
      if(event.getKeyCode()==37)
      {
	  if(pages.empty()==true)
	  {
	      show.addfirst(current, "�w�g�b�̤W�h�F");
	  }
	  else
	  {
	      current=pages.pop();
	      show.showcontent(current);
	      int lastsplit=position.lastIndexOf("/");
	      position=position.substring(0,lastsplit);
	      banner.setText("<html><b>�w��~ &nbsp;root!</b>�ثe��m���G"+position
			
			+"</html>");
	      instruction.showinstsruction(current);
	  }
      }
      if(event.getKeyCode()==65)
      {
	  if(cmfield.isVisible()==false)
	  {
	      
	      banner.setText("�п�ܱ��i�J������~");
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=0;
	  }
      }
      if(event.getKeyCode()==80)
      {
	  if(cmfield.isVisible()==false)
	  {
	      
	      if(current instanceof POOArticle)
	      {
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=1;
	      }
	  }
      }
      if(event.getKeyCode()==66)
      {
	  if(cmfield.isVisible()==false)
	  {
	      
	      if(current instanceof POOArticle)
	      {
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();this.validate();;
	      command=2;
	      }
	  }
      }
      if(event.getKeyCode()==82)
      {
	  if(cmfield.isVisible()==false)
	  {
	      
	      if(current instanceof POOArticle)
	      {
	      instruction.setVisible(false);
	      cmfield.setVisible(true);
	      cmfield.requestFocus();
	      this.invalidate();
	      this.validate();
	      command=3;
	      }
	  }
      }
  }
  public static void main(String[] args) {
     JFrameExample main= new JFrameExample("OOPBBS Simple Demo","Home");
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
	setFont(new Font("�з���",36,24));
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

class Showboard extends JLabel
{
    Showboard(String s)
    {
	super(s);
    }
    public void showcontent(Object current)
	  {
	      if(current instanceof POODirectory)
	      {
		  this.setText(((POODirectory) current).show());
	      }
	      else if(current instanceof POOBoard)
	      {
		  this.setText(((POOBoard) current).show());
	      }
	      else
	      {
		  this.setText(((POOArticle) current).show());
	      }
	  }
    public void addfirst(Object current,String s)
    {
	if(current instanceof POODirectory)
	      {
		  this.setText("<html>"+s+((POODirectory) current).show());
	      }
	else if(current instanceof POOBoard)
	      {
		  this.setText("<html>"+s+((POOBoard) current).show());
	      }
	else
	{
	    this.setText("<html>"+s+((POOArticle) current).show());
	}
    }
    public void showinstsruction(Object current)
    {
        if(current instanceof POODirectory)
        {
  	  this.setText("<html>&lt;x&gt;���� &lt;a&gt;�i�J &lt;q&gt;���} &lt;m&gt;�s�W��Ƨ� &lt;n&gt;�s�W�Q�ת� &lt;s&gt;�s�W���j�u <br/>&lt;d&gt;�R���@�� &lt; &lt;-&gt;�W�@��&gt;</html>");
        }
        else if(current instanceof POOBoard)
        {
  	  this.setText("<html>&lt;x&gt;����&lt;a&gt;�[�� &lt;q&gt;���} &lt;m&gt;�s�W�峹 &lt;d&gt;�R���峹&lt; &lt;-&gt;�W�@��&gt;</html>");
        }
        else
        {
            this.setText("<html>&lt;p&gt;����  &lt;b&gt;���  &lt;r&gt;�^��&lt; &lt;-&gt;�W�@��&gt;</html>");
        }
    }
}