package IITB;

import java.util.Scanner;
import java.util.Stack;

public class Contest2 {
	
	static int[] operator=new int[4];
	static int rhs, finish;

	public static void main(String args[]){
		
		Scanner s=new Scanner(System.in);
		int n =s.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n-1;i++){
			arr[i]=s.nextInt();
		}
		
		rhs = s.nextInt();
		
		int len=n-1;
		int postFix[] = new int[2*len-1];
		postFix[0]=arr[0];
		postFix[1]=arr[1];
		finish=0;
		allPostFix(postFix, 2,arr ,2,len);
		
	}
	
	static void allPostFix(int postFix[],int p,int arr[],int r,int len){
		if(finish==1){
			return;
		}
		
		if(p>=2*len-1){
			/*for(int x:postFix){
				System.out.print(x+" ");
			}
			System.out.println();*/
							
			if(evaluatePostFix(postFix,len)){
			
				convertPostFixToInfix(postFix,len);
				finish=1;
				return;
			}
			
			return;
		}
		int flag =0;
		
		if(checkForOperator(r,p-r)){
			postFix[p] = -1000;
			allPostFix(postFix, p+1,arr ,r,len);
			
			postFix[p] = -2000;
			allPostFix(postFix, p+1,arr ,r,len);
			
			postFix[p] = -3000;
			allPostFix(postFix, p+1,arr ,r,len);
			
			postFix[p] = -4000;
			allPostFix(postFix, p+1,arr ,r,len);
			flag=1;
		}
		else{
			postFix[p] = arr[r];
			allPostFix(postFix, p+1,arr ,r+1,len);
		}
		
		if(flag==1 && postFix[p]==-4000 && r<len){
			postFix[p] = arr[r];
			allPostFix(postFix, p+1,arr ,r+1,len);
		}
		
	}
	
	static boolean checkForOperator(int noOfOperand, int noOfOperator){
		
		return noOfOperand - noOfOperator > 1 ;
	}
	
	static boolean evaluatePostFix(int postFix[],int len){
		int stack[]=new int[2*len];
		int head=0;
		String ss="";
		for(int i=0;i<2*len-1;i++){
			int x = postFix[i];
			if(x==-1000||x==-2000||x==-3000||x==-4000){
				int y=0;
				if(x==-1000){
					y = stack[head-2]+stack[head-1];
					
				}
				else if(x==-2000){
					y = stack[head-2]-stack[head-1];
					
				}
				else if(x==-3000){
					y = stack[head-2]*stack[head-1];
						
				}
				else{
					if(stack[head-1]==0)
						return false;
					
					y = stack[head-2]/stack[head-1];
					
				}
				stack[head-2]=y;
				head--;
			}
			else{
				stack[head]=postFix[i];
				head++;
				
			}
		}
		
		if(stack[head-1]==rhs){
			return true;
		}
		return false;
	}

	static void convertPostFixToInfix(int postFix[], int len){
		
		char answer[]=new char[150];
		int k=0;
		for(int i=0;i<2*len-1;i++){
			
			int num = postFix[i];
		//	System.out.println(num);
			if(num==-1000||num==-2000||num==-3000||num==-4000){
				k=k-2;
				char rightPart[] =new char[10];
				int r=0;
			//	for(char c: answer)
			//		System.out.print(c);
			//	System.out.println();
				while(k >= 0 && answer[k]!=' '){
					rightPart[r++] = answer[k--];
				}
				k--;
				char leftPart[] =new char[150];
				int l=0;
				while(k>=0 && answer[k]!=' '){
					leftPart[l++] = answer[k--];
				}
				
				l--;r--;
				k++;
				answer[k++]='(';
				while(l>=0){
					answer[k++] = leftPart[l--];
				}
				if(num==-1000)
					answer[k++]='+';
				else if(num==-2000)
					answer[k++]='-';
				else if(num==-3000)
					answer[k++]='*';
				else
					answer[k++]='/';
				
				while(r>=0){
					answer[k++] = rightPart[r--];
				}
				
				answer[k++]=')';
				answer[k++]=' ';
			}
			else{
				char tmp[]= new char[10];
				int j=0;
				while(num>0){
					int d=num%10;
					
					tmp[j++] = (char) (48+d);
					num=num/10;
				}
				
				j--;
				while(j>=0){
					answer[k++] = tmp[j--]; 
				}
				answer[k++]=' ';
				
				
			}
			
		}
		
		for(char c:answer){
			System.out.print(c);
		}
		
	}
}
