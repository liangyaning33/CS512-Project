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

	public class User{
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
	public class Item{
		
		
		String item_id; 	
		public Item(String i)
		{
			this.item_id = i; 
		}
	}
	public class ItemList{
		public String list_id; 
		public ArrayList<Item> list_items; 
		public ItemList(String x, ArrayList<Item> y)
		{
			this.list_id = x; 
			this.list_items = y; 
		}
	}
	
	public class Tuple { 
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
	public Map<String, ArrayList<Item>> buildList()
	{
		Map<String, ArrayList<Item>> lists = new HashMap<String, ArrayList<Item>>(); 
		ArrayList<Tuple> input = read("Foursquare\\l_i.txt"); 
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
	public Map<String, ArrayList<String>> buildGeneralList(String file)
	{
		//Map<String, ArrayList<Item>> lists = buildList(); 
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>(); 
		ArrayList<Tuple> input = read(file); 
		
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
	public Map<String, ArrayList<String>> buildUserList()
	{
		//Map<String, ArrayList<Item>> lists = buildList(); 
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>(); 
		ArrayList<Tuple> input = read("Foursquare\\l_u_train.txt"); 
		
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
	public Map<String, ArrayList<String>> buildUserFriendList()
	{
		//Map<String, ArrayList<Item>> lists = buildList(); 
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>(); 
		ArrayList<Tuple> input = read("Foursquare\\u_f.txt"); 
		
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
	public Map<String, ArrayList<String>> buildUserItemList()
	{
		Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>(); 
		ArrayList<Tuple> input = read("Foursquare\\u_i_train.txt"); 
		
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
	
	public ArrayList<Tuple> read(String file)
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
	public void writeFile(String file, ArrayList<User> users)
	{
		try
		{
		    FileWriter writer = new FileWriter(file);
			
		    writer.write("User ID");
		    writer.write("\t\t");
		    writer.write("Items");
		    writer.write("\t\t");
		    writer.write("Lists");
		    writer.write("\t\t");
		    writer.write("Friends"); 
		    writer.write('\n'); 
		    
		     
		    for (int i=0; i<users.size(); i++)
		    {
		    	writer.write(users.get(i).user_id); 
		    	writer.write("\t\t"); 
		    	writer.write(Integer.toString(users.get(i).user_item.size())); 
		    	writer.write("\t\t");
		    	writer.write(Integer.toString(users.get(i).user_list.size())); 
		    	writer.write("\t\t"); 
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
	

	
	
}

