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
    }
    /**
     * give a good comment 
     * @param message the comment
     * @return -1 as failed, others as success
     */
    public int push(String message)
    {
	if(evalmessages.length<=1024)
	{
	    int asize=evalmessages.length;
	    evalcount+=1;
	    evaluation[asize]=1;
	    evalmessages[asize]=new String();
	    evalmessages[asize]=message;
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
	if(evalmessages.length<=1024)
	{
	    int asize=evalmessages.length;
	    evalcount-=1;
	    evaluation[asize]=-1;
	    evalmessages[asize]=new String();
	    evalmessages[asize]=message;
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
	if(evalmessages.length<=1024)
	{
	    int asize=evalmessages.length;
	    evaluation[asize]=0;
	    evalmessages[asize]=new String();
	    evalmessages[asize]=message;
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
    public void show()
    {
	this.list();
	System.out.printf("-----------------------------------------------------\n");
	System.out.printf("%s",this.content);
	int i;
	for(i=0;i<evalmessages.length;i++)
	{
	    switch(evaluation[i])
	    {
	    	case 1:
	    	    System.out.printf("Booo ");
	    	    break;
	    	case 0:
	    	    break;
	    	case -1:
	    	System.out.printf("Love ");
	    	    break;
	    	default:
	    	System.out.printf(">>>> ");
	    	    break;
	    }
	    System.out.printf("%s\n",this.evalmessages[i]);
	}
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
    public int showid()
    {
	return this.id;
    }
}
