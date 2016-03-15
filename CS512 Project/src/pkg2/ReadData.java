package pkg2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 


public class ReadData {
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
				Tuple temp = new Tuple(tokens[0], tokens[1]); 
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
	
	public Map<String, Integer> buildUserIndex(List<Tuple> User_List, List<Tuple> User_Item)
	{
		
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		int index = 0; 
		for (int i=0; i<User_List.size(); i++)
		{
			if (!map.containsKey(User_List.get(i).y))
			{
					map.put(User_List.get(i).y, index); 
					index++; 
			} 				
		}
		for (int i=0; i<User_Item.size(); i++)
		{
			if (!map.containsKey(User_Item.get(i).x))
			{
					map.put(User_Item.get(i).x, index); 
					index++; 
			} 				
		}
		return map; 		
	}
	public Map<String, Integer> buildListIndex(List<Tuple> User_List, List<Tuple> List_Item)
	{
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		int index = 0; 
		for (int i=0; i<User_List.size(); i++)
		{
			if (!map.containsKey(User_List.get(i).x))
			{
					map.put(User_List.get(i).x, index); 
					index++; 
			} 				
		}
		for (int i=0; i<List_Item.size(); i++)
		{
			if (!map.containsKey(List_Item.get(i).x))
			{
					map.put(List_Item.get(i).x, index); 
					index++; 
			} 				
		}
		return map; 			
	}
	public Map<String, Integer> buildItemIndex(List<Tuple> User_Item, List<Tuple> List_Item)
	{
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		int index = 0; 
		for (int i=0; i<User_Item.size(); i++)
		{
			if (!map.containsKey(User_Item.get(i).y))
			{
					map.put(User_Item.get(i).y, index); 
					index++; 
			} 				
		}
		for (int i=0; i<List_Item.size(); i++)
		{
			if (!map.containsKey(List_Item.get(i).y))
			{
					map.put(List_Item.get(i).y, index); 
					index++; 
			} 				
		}
		return map; 			
	}
	public double[][] buildML(List<Tuple> User_List, Map<String, Integer> User_Index, Map<String, Integer> List_Index)
	{
		double[][] ML = new double[User_Index.keySet().size()][List_Index.keySet().size()]; 
		for (int i=0; i<User_List.size(); i++)
		{
			String listID = User_List.get(i).x; 
			String userID = User_List.get(i).y; 
			ML[User_Index.get(userID)][List_Index.get(listID)] = 1.0; 		
		}		
		return ML; 		
	}
	public double[][] buildMT(List<Tuple> User_Item, Map<String, Integer> User_Index, Map<String, Integer> Item_Index)
	{
		double[][] MT = new double[User_Index.keySet().size()][Item_Index.keySet().size()]; 
		for (int i=0; i<User_Item.size(); i++)
		{
			String userID = User_Item.get(i).x; 
			String itemID = User_Item.get(i).y; 
			MT[User_Index.get(userID)][Item_Index.get(itemID)] = 1.0; 		
		}		
		return MT; 		
	}
	
	
}
