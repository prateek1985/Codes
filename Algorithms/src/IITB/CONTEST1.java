package IITB;
import java.util.*;
import java.io.*;
public class CONTEST1 {

	public static void main(String args[]){
		
		Scanner s=new Scanner(System.in);
		int n =s.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++){
			arr[i]=s.nextInt();
		}
		
		int correctSeq[]=findCorrectSeq(arr);
//=		for(int f:correctSeq){
		///	System.out.println(f);
	//	}
		
		
		int l1=0,r1=1;
		int output[] = new int[2*arr.length];
		Arrays.fill(output, -1);
		int count=0;
		int tmp=0, go=0;
		while(correctSeq[l1]!=-1 && correctSeq[r1]!=-1){
			
			
			int indexL = correctSeq[l1];
			if(indexL>0 && go==0){
				
				int x = arr[indexL-1];
				arr[indexL-1]=arr[indexL+1]-arr[indexL];
				while(indexL>0 && arr[indexL-1]+arr[indexL]==arr[indexL+1]){
					indexL--;
				}
			//	System.out.println(indexL+" "+correctSeq[r1]);
				if(correctSeq[r1]-indexL+1>=5){
					count++;
					output[tmp++]=indexL;
					output[tmp++]=correctSeq[r1];
				}
				
				arr[correctSeq[l1]-1] = x;
				go=1;
			}
			
			int indexR = correctSeq[r1];
		//	System.out.println(indexR+"index");
			if(indexR<arr.length-1){
				
				int y = arr[indexR+1];
				arr[indexR+1]=arr[indexR]+arr[indexR-1];
				
				while(indexR<arr.length-1 && arr[indexR+1]==arr[indexR]+arr[indexR-1]){
					indexR++;
				}
				if(indexR+1 >= correctSeq[r1+1]){
					go=1;
				}
				
				if(indexR-correctSeq[l1]+1>=5){
					count++;
					
					output[tmp++]=correctSeq[l1];
					output[tmp++]=indexR;
				}
				//System.out.println(correctSeq[l1]+" "+indexR);
				arr[correctSeq[r1]+1]=y;
			}
			
			l1+=2;
			r1+=2;
		}
		
		System.out.println(count);
		for(int p=0;p<output.length && output[p]!=-1;p++){
			System.out.print(output[p]+" ");
		}
		
	}
	
	static int[] findCorrectSeq(int arr[]){
		int correctSeq[] = new int[arr.length];
		Arrays.fill(correctSeq, -1);
		
		int l=0,r=0;
		int i=0, flag=0, tmp=0;
		while(i<arr.length-2){
			
			if(arr[i+2]==arr[i+1]+arr[i] && flag==0){
				
					l=i;
					r=i+2;
					flag=1;
				
			}
			else if(arr[i+2]==arr[i+1]+arr[i] ){
				r=i+2;
				
			}
			
			if(arr[i+2]!=arr[i+1]+arr[i] && flag==1){
				
				correctSeq[tmp++]=l;
				correctSeq[tmp++]=r;
				flag=0;
			}
			else if(i==arr.length-3 && flag==1){
				correctSeq[tmp++]=l;
				correctSeq[tmp++]=r;
			}
			i++;
		}
		
		return correctSeq;
	}
}
