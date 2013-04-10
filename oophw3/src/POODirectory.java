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
    public int del(int pos)
    {
	int result;
	try
	{
	    if(space.get(pos) instanceof POODirectory)
	    {
		result=1;
	    }
	    else if(space.get(pos) instanceof POOBoard)
	    {
		result=2;
	    }
	    else
	    {
		result=0;
	    }
	    space.remove(pos);
	}
	catch(Exception ex)
	{
	    return -1;
	}
	return result;
    }
    public int move(int src, int dest)
    {
	if(src>=1024 || dest>=1024)
	{
	    return -1;
	}
	else
	{
	    try
	    {
	    Object tmp=this.space.get(src);
	    this.space.remove(src);
	    this.space.add(dest, tmp);
	    }
	    catch(Exception e)
	    {
		return -1;
	    }
	}
	return 0;
    }
    public int length()
    {
	return this.space.size();
    }
    public String showname()
    {
	return this.name;
    }
    public String show()
    {
	if(space.size()>0)
	{
	String a="<html><table>";
	a+="<tr><td>項目</td><td>類型</td><td>名稱</td><td>大小</td></tr>";
	Iterator<Object> index=this.space.iterator();
	int pos=0;
	while(index.hasNext())
	{
	    Object tmp=index.next();
	    //System.out.printf("%d\t",pos);
	    a+="<tr><td>"+Integer.toString(pos)+"</td>";
	    pos++;
	    if(tmp instanceof POOBoard)
	    {
		a+="<td>Board</td>";
		a+="<td>"+((POOBoard) tmp).showname()+"</td>";
		a+="<td>"+Integer.toString(((POOBoard) tmp).length())+"</td></tr>";
	    }
	    else if(tmp instanceof POODirectory)
	    {
		a+="<td>Directory</td>";
		a+="<td>"+((POODirectory) tmp).showname()+"</td>";
		a+="<td>"+Integer.toString(((POODirectory) tmp).length())+"</td></tr>";
	    }
	    else
	    {
		a+="<td>-----</td><td>---------------------</td><td>--</td></tr>";
		a+="<tr><td>項目</td><td>類型</td><td>名稱</td><td>大小</td></tr>";
	    }
	}
	a+="</table></html>";
	return a;
	}
	else
	{
	    return "目前無資料~";
	}
    }
    public Object getstuff(int a)
    {
	try
	{
	    return this.space.get(a);
	}
	catch(Exception e)
	{
	    return new Boolean(false);
	}
    }
}
