package pkg;
import java.util.*; 

import pkg.Objects.Lists;

public class Objects {
	public class Tuple { 
		  public String x; 
		  public String y; 
		  public Tuple(String x, String y) { 
		    this.x = x; 
		    this.y = y; 
		  } 
		  public String getX()
		  {
			  return x; 
		  }
		  public String getY()
		  {
			  return y; 
		  }		  
		} 
	public class User{
		String User_ID; 
		ArrayList<Item> User_Items; 
		ArrayList<Lists> User_Lists; 
		ArrayList<User> User_Friends; 		
		public User(String User_ID)
		{
			this.User_ID = User_ID; 
			this.User_Items = new ArrayList<Item>(); 
			this.User_Lists = new ArrayList<Lists>(); 
		}		
	}
	public class Item{
		String Item_ID; 
		ArrayList<User> Item_Users; 
		ArrayList<Lists> Item_Lists; 		
		public Item(String Item_ID)
		{
			this.Item_ID = Item_ID; 
			this.Item_Lists = new ArrayList<Lists>(); 
		}
	}	
	public class Lists{
		String List_ID; 
		ArrayList<Item> List_Items; 
		ArrayList<User> List_Users; 		
		public Lists(String List_ID)
		{
			this.List_ID = List_ID; 
			this.List_Users = new ArrayList<User>(); 
			this.List_Items = new ArrayList<Item>(); 
		}
	}
	public class All{
		ArrayList<User> All_Users; 
		ArrayList<Item> All_Items; 
		ArrayList<Lists> All_Lists; 
	}
	
	
	
}
