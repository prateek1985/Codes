package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxContiguousSubArray {     // not dp but recursion

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static int sum;
	static String arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){							
			sum=0;
			String s=br.readLine();
			arr=br.readLine().split(" ");
			int nonContigousSum=0;
			int tmp=0,max=Integer.MIN_VALUE;
			for(String x: arr){
				int p=Integer.parseInt(x);
				if(p>0)
					nonContigousSum+=p;
				else{
					tmp++;
					if(max<p){
						max=p;
					}
				}
					
			}
			if(tmp!=arr.length)
				System.out.println(maxSubSequence(0,0)+" "+nonContigousSum);
			else
				System.out.println(max+" "+max);
		}
	}
	
	static int maxSubSequence(int i,int j){				// main thing is here
		if(j==arr.length){
			return sum;
		}
	else{
		int tmp=0;
		for(int r=i;r<=j;r++){
			tmp+=Integer.parseInt(arr[r]);
		}
		if(sum<tmp)
			sum=tmp;
		if(tmp<=0)
			return maxSubSequence(j+1,j+1);
		else
			return maxSubSequence(i,j+1);
	}
	}

}
