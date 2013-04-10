/**
 * the POOArticle class, use the same design as the homework says
 * @author yhsu1126
 *
 */
public class POOArticle {
    private int id;
    private String title;
    private String author;
    private String content;
    private int count;
    private int evalcount;
    private int[] evaluation=new int[1024];
    private String[] evalmessages=new String[1024];
    /**
     * Create the article~~
     * @param title the title of the article
     * @param author the author of the article
     * @param content the content of the article
     * @param count the unique id for the article
     */
    POOArticle(String title, String author, String content, int count)
    {
	id=count;
	this.title=title;
	this.author=author;
	this.content=content;
	evalcount=0;
	count=0;
    }
    /**
     * give a good comment 
     * @param message the comment
     * @return -1 as failed, others as success
     */
    public int push(String message)
    {
	if(count<=1024)
	{
	    int asize=count;
	    evalcount+=1;
	    evaluation[asize]=1;
	    evalmessages[asize]=new String();
	    evalmessages[asize]=message;
	    count++;
	    return 0;
	}
	else
	{
	    return -1;
	}
    }
    /**
     * give a bad comment 
     * @param message the comment
     * @return -1 as failed, others as success
     */
    public int boo(String message)
    {
	if(count<=1024)
	{
	    int asize=count;
	    evalcount-=1;
	    evaluation[asize]=-1;
	    evalmessages[asize]=new String();
	    evalmessages[asize]=message;
	    count++;
	    return 0;
	}
	else
	{
	    return -1;
	}
    }
    /**
     * give a neutral comment 
     * @param message the comment
     * @return -1 as failed, others as success
     */
    public int arrow(String message)
    {
	if(count<=1024)
	{
	    int asize=count;
	    evaluation[asize]=0;
	    evalmessages[asize]=new String();
	    evalmessages[asize]=message;
	    count++;
	    return 0;
	}
	else
	{
	    return -1;
	}
    }
    /**
     * show the article all its information and comments
     */
    public String show()
    {
	String a="<html><table><tr><td>標題: "+this.showtitle()+"</td><td>作者: "+this.showAuthor()+"</td><td>人氣: "+this.showcount()+"</td></tr>";
	a+="<tr><td colspan=\"3\">----------------------------------------------------------------------------</td></tr>";
	a+="<tr><td colspan=\"3\">"+this.content+"</td></tr>";
	int i;
	for(i=0;i<count;i++)
	{
	    switch(evaluation[i])
	    {
	    	case -1:
	    	    a+="<tr><td>Booo</td>";
	    	    break;
	    	case 0:
	    	    break;
	    	case 1:
	    	    a+="<tr><td>Love</td>";
	    	    break;
	    	default:
	    	a+="<tr><td>>>>></td>";
	    	    break;
	    }
	    a+="<td colspan=\"2\">"+this.evalmessages[i]+"</td></tr>";
	}
	return a;
    }
    /**
     * act as the "banner" of the article, can also used when we need to create a simple article list
     */
    public void list()
    {
	System.out.printf("Article Title: %s  ",this.title);
	System.out.printf("By %s ",this.author);
	System.out.printf("evaluation: %d",this.evalcount);
    }
    public String showtitle()
    {
	return this.title;
    }
    public String showAuthor()
    {
	return this.author;
    }
    public String showcount()
    {
	return Integer.toString(this.evalcount);
    }
    public String showname()
    {
	return this.showtitle();
    }
    public int showid()
    {
	return this.id;
    }
    public static String stringToHTMLString(String string) {
	    StringBuffer sb = new StringBuffer(string.length());
	    // true if last char was blank
	    boolean lastWasBlankChar = false;
	    int len = string.length();
	    char c;

	    for (int i = 0; i < len; i++)
	        {
	        c = string.charAt(i);
	        if (c == ' ') {
	            // blank gets extra work,
	            // this solves the problem you get if you replace all
	            // blanks with &nbsp;, if you do that you loss 
	            // word breaking
	            if (lastWasBlankChar) {
	                lastWasBlankChar = false;
	                sb.append("&nbsp;");
	                }
	            else {
	                lastWasBlankChar = true;
	                sb.append(' ');
	                }
	            }
	        else {
	            lastWasBlankChar = false;
	            //
	            // HTML Special Chars
	            if (c == '"')
	                sb.append("&quot;");
	            else if (c == '&')
	                sb.append("&amp;");
	            else if (c == '<')
	                sb.append("&lt;");
	            else if (c == '>')
	                sb.append("&gt;");
	            else if (c == '\n')
	                // Handle Newline
	                sb.append("&lt;br/&gt;");
	            else {
	                int ci = 0xffff & c;
	                if (ci < 160 )
	                    // nothing special only 7 Bit
	                    sb.append(c);
	                else {
	                    // Not 7 Bit use the unicode system
	                    sb.append("&#");
	                    sb.append(new Integer(ci).toString());
	                    sb.append(';');
	                    }
	                }
	            }
	        }
	    return sb.toString();
	}
}
