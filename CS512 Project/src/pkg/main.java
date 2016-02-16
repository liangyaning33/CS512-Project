package pkg; 
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import pkg.ReadData.*;
import java.util.*; 

public class main {	
	
	
	
	public static void main (String[] args)
	{
		ReadData t = new ReadData(); 
		Map<String, ArrayList<String>> user_list = t.buildUserList(); 
		Map<String, ArrayList<String>> user_friend = t.buildUserFriendList(); 
		Map<String, ArrayList<String>> user_item_list = t.buildUserItemList(); 

		ArrayList<User> users = new ArrayList<User>(); 
		Set<String> set = user_list.keySet(); 
		for (String key:set)
		{
			User temp = t.new User(key); //initialize a user
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
		t.writeFile("output.txt", users); 
		
	}
}
