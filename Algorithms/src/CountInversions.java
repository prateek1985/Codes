import java.io.*;
import java.util.*;

public class CountInversions {

	static long inversion=0;
	
	public static void main(String args[]) throws IOException{
		File f = new File("F:\\IntegerArray.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		String l;
		while(( l = br.readLine()) !=null){
			al.add(Integer.parseInt(l));
		}
		
		ArrayList<Integer> a =divide(al);
		//System.out.println(a);
		System.out.println(inversion);
	}
	
	public static ArrayList<Integer> divide(ArrayList<Integer> al){
		if(al.size()==1){
			return al;
		}
		else{
		int n = al.size()/2;
		
		ArrayList<Integer> a1 =new ArrayList<Integer>();
		ArrayList<Integer> a2 =new ArrayList<Integer>();
		
		//Collections.copy(al.subList(0,n),a1);
		//Collections.copy(al.subList(n,al.size()),a2);
		for(int i=0;i<n;i++){
			a1.add(al.get(i));
		}
		for(int i=0;i<al.size()-n;i++){
			a2.add(al.get(i+n));         // if n is not added first element is printed only
		}
		
		
		
		ArrayList<Integer> left = divide(a1);
		ArrayList<Integer> right = divide(a2);
		
		return merge(left,right);
		}
	}
		public static ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){
			ArrayList <Integer> m = new ArrayList <Integer>();
			int n1=0,n2=0;
			while(n1+n2 <left.size()+right.size()){
				
				if(left.get(n1) <= right.get(n2)){
					m.add(left.get(n1));
					n1++;
				}
				else {
					m.add(right.get(n2));
					n2++;
					inversion += left.size()-n1;
				}
				if(n1==left.size()){
					while(n2<right.size()){
						m.add(right.get(n2));
						n2++;
					}
			    }
				else if(n2==right.size()){
					while(n1<left.size()){
						m.add(left.get(n1));
						n1++;
				}
				
			}
				
		}
		return m;
	}
}
