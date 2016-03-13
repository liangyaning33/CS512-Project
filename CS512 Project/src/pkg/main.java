package pkg; 
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.*; 
import java.lang.Math; 
import pkg.Objects.*;

public class main {
	
	
	public static void main(String args[])
	{
		ReadData p = new ReadData(); 
		Objects q = new Objects(); 
		All comb = q.new All(); 
		comb.All_Items = new ArrayList<Item>(); 
		comb.All_Lists = new ArrayList<Lists>(); 
		comb.All_Users = new ArrayList<User>(); 
		comb = p.buildUserList("Foursquare\\l_u_train.txt", comb); 
		comb = p.buildListItem("Foursquare\\l_i.txt", comb); 
		comb = p.buildUserItem("Foursquare\\u_i_train.txt", comb); 
		List<User> All_Users= comb.All_Users; 
		List<Lists> All_Lists= comb.All_Lists; 
		/*
		for  (int i=0; i<All_Users.size(); i++)
		{
			System.out.println("USer ID" +All_Users.get(i).User_ID); 
			System.out.println("# of  lists" + All_Users.get(i).User_Lists.size());
			for (int j=0; j<All_Users.get(i).User_Lists.size(); j++)
				System.out.println("List ID"+All_Users.get(i).User_Lists.get(j).List_ID);
		} */
		for (int i=0; i<All_Lists.size(); i++)
		{
			System.out.println("List ID " +All_Lists.get(i).List_ID); 
			System.out.println("# of  users" + All_Lists.get(i).List_Users.size());
			System.out.println("# of Items"+All_Lists.get(i).List_Items.size()); 
			for (int j=0; j<All_Lists.get(i).List_Users.size(); j++)
				System.out.println("User ID"+All_Lists.get(i).List_Users.get(j).User_ID);	
			for (int j=0; j<All_Lists.get(i).List_Items.size(); j++)
				System.out.println("Item ID"+All_Lists.get(i).List_Items.get(j).Item_ID);	
		}
		
	}
	
	
	
}