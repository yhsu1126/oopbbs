import java.util.Iterator;
import java.util.LinkedList;

/**
 * the class for managing the article. <br/>Using linked list doesn't know will make it easier to implmemnt or not
 * @author yhsu1126
 *
 */
public class POOBoard {
    private String name;
    private LinkedList <POOArticle> article=new LinkedList<POOArticle>();
    private int[] monitor=new int[1000];
    /**
     * Create the board
     * @param name the name for the  board 
     */
    POOBoard(String name)
    {
	this.name=name;
    }
    /**
     * add an article will check if it exceeds the size
     * @param article the article to add
     * @return 0 symbols success and -1 means something wrong
     */
    public int add(POOArticle article)
    {
	if(this.article.size()<1000)
	{
	    this.article.add(article);
	    monitor[article.showid()]=1;
	    return 0;
	}
	else
    	{
	    return -1;
    	}
    }
    /**
     * delete the article at certain position
     * @param pos precondition: must not exceed limit 1000 or there is an article at that position
     */
    public void del(int pos)
    {
	try
	{
	    monitor[article.get(pos).showid()]=0;
	    this.article.remove(pos);
	}
	catch(Exception ex)
	{
	    System.out.printf("Something wrong happened : %s",ex.getMessage());
	}
    }
    /**
     * get the size of the board
     * @return the size of the board
     */
    public int length()
    {
	return this.article.size();
    }
    /**
     * show all the article name author, evaluation point in the board
     */
    public void show()
    {
	Iterator<POOArticle> ip=this.article.iterator();
	int pos=0;
	while(ip.hasNext())
	{
	    System.out.printf("%d ",pos);
	    ip.next().show();
	    pos++;
	}
    }
    /**
     * more an article from position src to position dest
     * @param src the source
     * @param dest the destination
     */
    public void move(int src,int dest)
    {
	if(src>=1000 || dest>=1000)
	{
	    System.out.printf("Exceed Max\n");
	}
	else
	{
	    POOArticle tmp=this.article.get(src);
	    this.article.remove(src);
	    this.article.add(dest, tmp);
	}
    }
    /**
     * when adding a article, give the article its unique ID
     * @return the unique ID for the article or -1 meaning that the board is full
     */
    public int assignid()
    {
	int i;
	for(i=0;i<1000;i++)
	{
	    if(this.monitor[i]==0)
	    {
		return i;
	    }
	}
	return -1;
    }
    /**
     * show the name of the board;
     */
    public void showname()
    {
	System.out.printf("%s",this.name);
    }
}
