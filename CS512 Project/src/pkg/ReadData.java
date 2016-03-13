package pkg;
import java.util.*; 
import java.util.List;

import pkg.Objects.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;
import java.lang.Math.*; 

public class ReadData{
	
	public int getIndexUser(List<User> all_users, String ID)
	{
		int index = -1; 
		for (int i=0; i<all_users.size(); i++)
		{
			User temp = all_users.get(i); 
			if (temp.User_ID.equals(ID))
			{
				index = i; 
				break; 
			} 
		}
		return index; 
	}
	public int getIndexList(List<Lists> all_users, String ID)
	{
		if (all_users == null || all_users.size() == 0)
			return -1; 
		int index = -1;		
		for (int i=0; i<all_users.size(); i++)
		{
			Lists temp = all_users.get(i); 
			if (temp.List_ID.equals(ID))
			{
				index = i; 
				break; 
			} 
		}
		return index; 
	}
	public int getIndexItem(List<Item> all_users, String ID)
	{
		if (all_users == null || all_users.size() == 0)
			return -1; 
		int index = -1; 
		for (int i=0; i<all_users.size(); i++)
		{
			Item temp = all_users.get(i); 
			if (temp.Item_ID.equals(ID))
			{
				index = i; 
				break; 
			} 
		}
		return index; 
	}
	
	public List<Tuple> read(String file)
	{
		List<Tuple> result = new ArrayList<Tuple>(); 		
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			String left;  
			while (line != null)
			{
				String delims = "\t";
				String[] tokens = line.split(delims);
				Objects obj = new Objects(); 
				Tuple temp = obj.new Tuple(tokens[0], tokens[1]); 
				result.add(temp); 
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
	public All buildUserList(String file, All comb)
	{
		List<Tuple> input = read(file); 
		List<User> All_Users = comb.All_Users; 
		List<Lists> All_Lists = comb.All_Lists; 
		for (int i=0; i<input.size(); i++)
		{
			String ListID = input.get(i).x; 
			String UserID = input.get(i).y; 
			int ListIndex = getIndexList(All_Lists, ListID); 
			Lists temp; 
			Objects p = new Objects(); 
			if (ListIndex == -1)
			{
				temp = p.new Lists(ListID); 
				All_Lists.add(temp); 
			}
			else 
				temp = All_Lists.get(ListIndex); 
			List<User> Curr_User = temp.List_Users; 
			int UserIndex = getIndexUser(All_Users, UserID); 
			User temp_user; 
			if (UserIndex == -1)
			{
				temp_user = p.new User(UserID); 
				All_Users.add(temp_user); 
			}
			else
				temp_user = All_Users.get(UserIndex); 
			Curr_User.add(temp_user); 
			temp_user.User_Lists.add(temp); 			
		}
		return comb; 			
	}
	public All buildListItem(String file, All comb)
	{
		List<Tuple> input = read(file); 
		List<Lists> All_Lists = comb.All_Lists; 
		List<Item> All_Items = comb.All_Items; 
		for (int i=0; i<input.size(); i++)
		{
			String ListID = input.get(i).x; 
			String ItemID = input.get(i).y; 
			int ListIndex = getIndexList(All_Lists, ListID); 
			Lists temp; 
			Objects p = new Objects(); 
			if (ListIndex == -1)
			{
				temp = p.new Lists(ListID); 
				All_Lists.add(temp); 
			}
			else 
				temp = All_Lists.get(ListIndex); 
			List<Item> Curr_Item = temp.List_Items; 
			int ItemIndex = getIndexItem(All_Items, ItemID); 
			Item temp_item; 
			if (ItemIndex == -1)
			{
				temp_item = p.new Item(ItemID); 
				All_Items.add(temp_item); 
			}
			else
				temp_item = All_Items.get(ItemIndex); 
			Curr_Item.add(temp_item); 
			temp_item.Item_Lists.add(temp); 			
		}
		return comb; 
	}
	public All buildUserItem(String file, All comb)
	{
		List<Tuple> input = read(file); 
		List<User> All_Users = comb.All_Users; 
		List<Item> All_Items = comb.All_Items; 
		for (int i=0; i<input.size(); i++)
		{
			String UserID = input.get(i).x; 
			String ItemID = input.get(i).y; 
			int UserIndex = getIndexUser(All_Users, UserID); 
			User temp; 
			Objects p = new Objects(); 
			if (UserIndex == -1)
			{
				temp = p.new User(UserID); 
				All_Users.add(temp); 
			}
			else 
				temp = All_Users.get(UserIndex); 
			List<Item> Curr_Item = temp.User_Items; 
			int ItemIndex = getIndexItem(All_Items, ItemID); 
			Item temp_item; 
			if (ItemIndex == -1)
			{
				temp_item = p.new Item(ItemID); 
				All_Items.add(temp_item); 
			}
			else
				temp_item = All_Items.get(ItemIndex); 
			Curr_Item.add(temp_item); 
			temp_item.Item_Users.add(temp); 			
		}
		return comb; 
	}
	
	
}