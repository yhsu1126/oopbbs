import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameExample extends JFrame {
  private String position;
  private int countd,counta,countb;
  public JFrameExample(String title,String pos)
  {
      	setTitle(title);
      	position=pos;
      	countd=1;
      	counta=0;
      	countb=0;
	setSize(960,600);
	setLocationRelativeTo(null);
	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setResizable(false);
	setLayout(new BorderLayout());
	Font dfont=new Font("標楷體",36,24);
	setContentPane(new JLabel(new ImageIcon(getClass().getResource("temp.png"))));
	setLayout(new BorderLayout(10,10));
	JLabel banner=new JLabel("<html><div><font color=\"white\"><b>歡迎~ &nbsp;root!</b>目前位置為："+pos
		+" <br/><font style=\"font-size:80%;\">目前系統已有: "+countd+"個資料夾		"+countb+" 個討論版	"+
		counta+"篇文章</font></font></div></html>");
	JLabel footer=new JLabel("<html><font style=\"font-size:50%\" color=\"white\">Created by <a href=\"mailto:b00902104@ntu.edu.tw\">yhsu1126</font></html>");
	banner.setFont(dfont);
	footer.setFont(dfont);
	this.getContentPane().add(banner,BorderLayout.NORTH);
	this.getContentPane().add(footer,BorderLayout.SOUTH);
	 setSize(959,599);
	 setSize(960,600);
  }
  public static void main(String[] args) {
     JFrameExample main= new JFrameExample("OOPBBS Simple Demo","Home/");
     main.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}