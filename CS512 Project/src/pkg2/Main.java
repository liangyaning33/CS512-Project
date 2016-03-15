package pkg2;
import java.util.*; 

import pkg2.ReadData.Tuple;

public class Main {
	
	
	public static void main(String args[])
	{
		ReadData t = new ReadData(); 
		List<Tuple> User_List = t.read("Foursquare\\l_u_train.txt"); 
		List<Tuple> User_Item = t.read("Foursquare\\u_i_train.txt"); 
		List<Tuple> List_Item = t.read("Foursquare\\l_i.txt"); 
		Map<String, Integer> User_Index = t.buildUserIndex(User_List, User_Item); 
		System.out.println("all users" + User_Index.keySet().size()); 
		Map<String, Integer> List_Index = t.buildListIndex(User_List, List_Item); 
		System.out.println("all lists" + List_Index.keySet().size()); 
		Map<String, Integer> Item_Index = t.buildItemIndex(User_Item, List_Item); 
		System.out.println("all items" + Item_Index.keySet().size()); 
		double [][] ML = t.buildML(User_List, User_Index, List_Index); 
		//for (int i=0; i<ML.length; i++)
			//System.out.println(Arrays.toString(ML[i])); 
		double [][] MT = t.buildMT(User_Item, User_Index, Item_Index); 
		for (int i=0; i<MT.length; i++)
			System.out.println(Arrays.toString(MT[i])); 
	}

}
