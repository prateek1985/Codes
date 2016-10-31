package dp;
import java.util.*;
import java.io.*;
public class Candies {
									// DON'T KNOW WHY IT IS CORRECT !!!!!!!!!!!!!!

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int arr[] = new int[t];
		
		for(int y=0;y<t;y++){
			arr[y] = Integer.parseInt(br.readLine());
		}
		
		int candy[]=new int[t];
		candy[0]=1;
		
		for(int i=1;i<t;i++){
			if(arr[i]>arr[i-1]){
				candy[i] = candy[i-1] + 1;
			}
			else if (arr[i]==arr[i-1]){
				candy[i] = 1;
				
			}
			else{
				if(candy[i-1]==1){
					candy[i-1]=2;
					candy[i] = 1;
				}
				else
					candy[i] =1;
			}
				
		}
		int sum=0;
		while(true){
			int flag=0;
		for(int i=1;i<candy.length;i++){
			if(arr[i-1]>arr[i]  && candy[i-1]==candy[i]){
				candy[i-1]++;
				flag=1;
			}
			
		}
		if(flag==0)
			break;
		}
		/*
		for(int i=1;i<candy.length;i++){
			if(arr[i-1]>arr[i]  && candy[i-1]==candy[i]){
				candy[i-1]++;
			}
		}for(int i=1;i<candy.length;i++){
			if(arr[i-1]>arr[i]  && candy[i-1]==candy[i]){
				candy[i-1]++;
			}
		}for(int i=1;i<candy.length;i++){
			if(arr[i-1]>arr[i]  && candy[i-1]==candy[i]){
				candy[i-1]++;
			}
		}for(int i=1;i<candy.length;i++){
			if(arr[i-1]>arr[i]  && candy[i-1]==candy[i]){
				candy[i-1]++;
			}
		}for(int i=1;i<candy.length;i++){
			if(arr[i-1]>arr[i]  && candy[i-1]==candy[i]){
				candy[i-1]++;
			}
		}for(int i=1;i<candy.length;i++){
			if(arr[i-1]>arr[i]  && candy[i-1]==candy[i]){
				candy[i-1]++;
			}
		}
		*/
		
		for(int i=0;i<candy.length;i++){
			sum+=candy[i];
		}
		
		System.out.println(sum);
	}

}
