package pkg; 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;


public class ReadData {

	public static class User{
		ArrayList<String> user_list;
		ArrayList<String> user_item; 
		ArrayList<String> user_friend; 
		String user_id; 		
		public User(String x)
		{
			this.user_id = x; 
			this.user_list = new ArrayList<String>(); 
			this.user_item = new ArrayList<String>(); 
			this.user_friend = new ArrayList<String>(); 
		}
		
	}
	public static class Item{
		
		
		String item_id; 	
		public Item(String i)
		{
			this.item_id = i; 
		}
	}
	public static class ItemList{
		public String list_id; 
		public ArrayList<Item> list_items; 
		public ItemList(String x, ArrayList<Item> y)
		{
			this.list_id = x; 
			this.list_items = y; 
		}
	}
	
	public static class Tuple { 
		  public final String x; 
		  public final String y; 
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
	public static Map<String, ArrayList<Item>> buildList()
	{
		Map<String, ArrayList<Item>> lists = new HashMap<String, ArrayList<Item>>(); 
		ArrayList<Tuple> input = read("l_i.txt"); 
		for (int i=0; i<input.size(); i++)
		{
			String listID = input.get(i).x; 
			String itemID = input.get(i).y;
			Item item = new Item(itemID); 
			
			if (lists.containsKey(listID))
			{
				lists.get(listID).add(item); 
			}
			else
			{
				ArrayList<Item> entry = new ArrayList<Item>(); 
				entry.add(item); 
				lists.put(listID, entry); 			
			}	
		}
		/* 
		Set<String> set = lists.keySet(); 
		for (String key:set)
		{
			ArrayList<Item> temp = lists.get(key); 
			for (int i=0; i<temp.size(); i++)
				System.out.println(temp.get(i).item_id); 
			System.out.println(lists.get(key).size()); 
		}
		*/
		return lists; 		
	}
	public static Map<String, ArrayList<String>> buildUserList()
	{
		//Map<String, ArrayList<Item>> lists = buildList(); 
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>(); 
		ArrayList<Tuple> input = read("l_u_train.txt"); 
		
		for (int i=0; i<input.size(); i++)
		{
			String listID = input.get(i).x; 
			String userID = input.get(i).y;
			//Item item = new Item(itemID); 
			//ItemList list = new ItemList(listID, lists.get(listID)); 
			if (result.containsKey(userID))
			{
				result.get(userID).add(listID); 
			}
			else
			{
				ArrayList<String> entry = new ArrayList<String>(); 
				entry.add(listID); 
				result.put(userID, entry); 			
			}	
		}
		/* 
		Set<String> set = result.keySet(); 
		for (String key:set)
		{
			ArrayList<String> temp = result.get(key); 
			for (int i=0; i<temp.size(); i++)
				System.out.println(temp.get(i)); 
			System.out.println(result.get(key).size()); 
		}
		*/
		return result; 		
	}
	public static Map<String, ArrayList<String>> buildUserFriendList()
	{
		//Map<String, ArrayList<Item>> lists = buildList(); 
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>(); 
		ArrayList<Tuple> input = read("u_f.txt"); 
		
		for (int i=0; i<input.size(); i++)
		{
			String userID = input.get(i).x; 
			String friendID = input.get(i).y;
			//Item item = new Item(itemID); 
			//ItemList list = new ItemList(listID, lists.get(listID)); 
			if (result.containsKey(userID))
			{
				result.get(userID).add(friendID); 
			}
			else
			{
				ArrayList<String> entry = new ArrayList<String>(); 
				entry.add(friendID); 
				result.put(userID, entry); 			
			}	
		}
		/* 
		Set<String> set = result.keySet(); 
		for (String key:set)
		{
			ArrayList<String> temp = result.get(key); 
			for (int i=0; i<temp.size(); i++)
				System.out.println(temp.get(i)); 
			System.out.println(result.get(key).size()); 
		}
		*/
		return result; 		
	}
	public static Map<String, ArrayList<String>> buildUserItemList()
	{
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>(); 
		ArrayList<Tuple> input = read("u_i_train.txt"); 
		
		for (int i=0; i<input.size(); i++)
		{
			String userID = input.get(i).x; 
			String itemID = input.get(i).y;
			//Item item = new Item(itemID); 
			//ItemList list = new ItemList(listID, lists.get(listID)); 
			if (result.containsKey(userID))
			{
				result.get(userID).add(itemID); 
			}
			else
			{
				ArrayList<String> entry = new ArrayList<String>(); 
				entry.add(itemID); 
				result.put(userID, entry); 			
			}	
		}
		/* 
		Set<String> set = result.keySet(); 
		for (String key:set)
		{
			ArrayList<String> temp = result.get(key); 
			for (int i=0; i<temp.size(); i++)
				System.out.println(temp.get(i)); 
			System.out.println(result.get(key).size()); 
		}
		*/
		return result; 		
	}
	
	public static ArrayList<Tuple> read(String file)
	{
		ArrayList<Tuple> result = new ArrayList<Tuple>(); 		
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			String left;  
			while (line != null)
			{
				String delims = "\t";
				String[] tokens = line.split(delims);
				Tuple temp = new Tuple(tokens[0], tokens[1]); 
				result.add(temp); 
				//System.out.println(tokens[0]+" "+tokens[1]); 
				line=br.readLine();
			}
			
		} catch (FileNotFoundException e){
			e.printStackTrace();		
		} catch (IOException e){
			e.printStackTrace();
			
		}catch (NullPointerException e)
		{e.printStackTrace();
			
		}		
		return result;
		
	}
	public static void writeFile(String file, ArrayList<User> users)
	{
		try
		{
		    FileWriter writer = new FileWriter(file);
			
		    writer.write("User ID");
		    writer.write('\t');
		    writer.write("Items");
		    writer.write('\t');
		    writer.write("Lists");
		    writer.write('\t');
		    writer.write("Friends"); 
		    writer.write('\n'); 
		    
		     
		    for (int i=0; i<users.size(); i++)
		    {
		    	writer.write(users.get(i).user_id); 
		    	writer.write('\t'); 
		    	writer.write(Integer.toString(users.get(i).user_item.size())); 
		    	writer.write('\t');
		    	writer.write(Integer.toString(users.get(i).user_list.size())); 
		    	writer.write('\t'); 
		    	writer.write(Integer.toString(users.get(i).user_friend.size())); 
		    	writer.write('\n'); 
		    }		    
		    writer.flush();
		    writer.close();
	
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 	
		
	}
	
	public static void main (String[] args)
	{
		//test.buildList(); 
		Map<String, ArrayList<String>> user_list = buildUserList(); 
		Map<String, ArrayList<String>> user_friend = buildUserFriendList(); 
		Map<String, ArrayList<String>> user_item_list = buildUserItemList(); 

		
		ArrayList<User> users = new ArrayList<User>(); 
		Set<String> set = user_list.keySet(); 
		for (String key:set)
		{
			User temp = new User(key);
			temp.user_list = user_list.get(key); //user - lists
			//temp.user_friend = user_friend.get(key); 
			users.add(temp); 				
		}
		for (int i=0; i<users.size(); i++)
		{
			String key = users.get(i).user_id; 
			if (user_friend.containsKey(key))
				users.get(i).user_friend = user_friend.get(key); 
			if (user_item_list.containsKey(key))
				users.get(i).user_item = user_item_list.get(key); 
			System.out.println("User ID is " + users.get(i).user_id); 
			/*
			for (int j=0; j<users.get(i).user_list.size(); j++)
				System.out.println(users.get(i).user_list.get(j)); 
			
			for (int k=0; k<users.get(i).user_friend.size(); k++)
				System.out.println(users.get(i).user_friend.get(k)); 
			for (int l=0; l<users.get(i).user_item.size(); l++)
				System.out.println(users.get(i).user_item.get(l));
				*/
			System.out.println("List size is "+ users.get(i).user_list.size());
			System.out.println("Friend size is "+ users.get(i).user_friend.size());
			System.out.println("Item size is "+ users.get(i).user_item.size());
		}
		writeFile("output.txt", users); 
		
	}
	
	
	
}

