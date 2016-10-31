import java.io.*;
import java.util.*;

public class SUMFOUR {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
		String arr[][] = new String[n][4];
		for(int r=0;r<n;r++){
			 arr[r]=br.readLine().split(" ");
			
		}
		int extra = n*n;
		int ab[]= new int[extra];
		int cd[]= new int[extra];
		HashMap<Integer,Integer> hm1= new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> hm2= new HashMap<Integer,Integer>();
		
		int tmp1=0, tmp2=0;
		for(int i=0;i<n;i++){
		//	System.out.println(arr[i].length);
			int a=Integer.parseInt(arr[i][0]);
			int c = Integer.parseInt(arr[i][2]);
			for(int j=0;j<n;j++){
				 int x = a+Integer.parseInt(arr[j][1]);
				 int y = -c-Integer.parseInt(arr[j][3]);
				 if(!hm1.containsKey(x)){
					 ab[tmp1]++;
					 hm1.put(x,tmp1++);
					 
				 }
				 else
					 ab[hm1.get(x)]++;
				 
				 if(!hm2.containsKey(y)){
					 cd[tmp2]++;
					 hm2.put(y,tmp2++);
				 }
				 else{
					 cd[hm2.get(y)]++;
				 }
				
				 
			}
		}
		int count=0;
		for(Map.Entry entry: hm1.entrySet()){
			int key =(Integer) entry.getKey();
			if(hm2.containsKey(key)){
				count+=ab[(Integer)entry.getValue()]*cd[hm2.get(key)];
			}
		}
		
	/*	
		Arrays.sort(cd);
		
		int count=0;
		for(int i=0;i<ab.length;i++){
			count+= ab[i+extra]*cd[i+extra];
		}
		
	for(int i=0;i<ab.length;i++){
			int x = Arrays.binarySearch(cd, -ab[i]);
			if(x>=0){
			int y=x;
			count++;
			while(x+1<cd.length && cd[x+1]==cd[x]){
				x++;
				count++;
			}
			while(y>0 && cd[y-1]==cd[y]){
				y--;
				count++;
			}
			}
		}*/
		
		System.out.println(count);
		
	}

}
