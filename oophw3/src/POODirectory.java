import java.util.Iterator;
import java.util.LinkedList;


public class POODirectory {
    private String name;
    private LinkedList <Object> space=new LinkedList<Object>();
    POODirectory(String name)
    {
	this.name=name;
    }
    public void add(POOBoard board)
    {
	space.add(board);
    }
    public void add(POODirectory directory)
    {
	space.add(directory);
    }
    public void add_split()
    {
	space.add("------");
    }
    public void del(int pos)
    {
	try
	{
	    space.remove(pos);
	}
	catch(Exception ex)
	{
	    System.out.printf("An error has occured : %s",ex.getMessage());
	}
    }
    public void move(int src, int dest)
    {
	if(src>=1024 || dest>=1024)
	{
	    System.out.printf("Exceed Max\n");
	}
	else
	{
	    Object tmp=this.space.get(src);
	    this.space.remove(src);
	    this.space.add(dest, tmp);
	}
    }
    public int length()
    {
	return this.space.size();
    }
    public void showname()
    {
	System.out.printf("%s\n", this.name);
    }
    public void show()
    {
	Iterator<Object> index=this.space.iterator();
	int pos=0;
	while(index.hasNext())
	{
	    Object tmp=index.next();
	    System.out.printf("%d\t",pos);
	    pos++;
	    if(tmp instanceof POOBoard)
	    {
		System.out.printf("Board\t");
		((POOBoard) tmp).showname();
		System.out.println();
	    }
	    else if(tmp instanceof POODirectory)
	    {
		System.out.printf("Directory\t");
		((POODirectory) tmp).showname();
		System.out.println();
	    }
	    else
	    {
		System.out.printf("-----\t-----------------------\n");
	    }
	}
    }
}
