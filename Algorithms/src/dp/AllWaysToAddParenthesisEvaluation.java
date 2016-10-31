package dp;
import java.util.*;
public class AllWaysToAddParenthesisEvaluation {
static HashMap<String,ArrayList<Integer>> hm ;
	public static void main(String args[]) throws Exception{
		String input = "5*4-3*2";
		hm=new HashMap<String,ArrayList<Integer>>();
		System.out.println(compute(input));
	}
	
	static ArrayList<Integer> compute(String input){
		
		if(hm.containsKey(input))
			return hm.get(input);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int k=0;k<input.length();k++){
			if(input.charAt(k)=='*' || input.charAt(k)=='-' || input.charAt(k)=='+'){
				
				ArrayList<Integer> al1 = compute(input.substring(0,k));
				ArrayList<Integer> al2 = compute(input.substring(k+1));
				
				for(int i=0;i<al1.size();i++){
					for(int j=0;j<al2.size();j++){
						if(input.charAt(k) == '*')
							al.add(al1.get(i) * al2.get(j));
						else if(input.charAt(k) == '+')
							al.add(al1.get(i) + al2.get(j));
						else if(input.charAt(k) == '-')
							al.add(al1.get(i) - al2.get(j));
					}
				}
				
			}
		}
		
		if(al.size()==0){
			al.add(Integer.parseInt(input));
		}
		
		hm.put(input, al);
		
		return al;
	}
	
}
