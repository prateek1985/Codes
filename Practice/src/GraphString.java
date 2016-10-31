import java.io.*;
import java.util.*;

public class GraphString {
static Graph g[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]= br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		g= new Graph[n+1];
		for(int i=1;i<n+1;i++){
			g[i]= new Graph();
		}
		
		for(int i=0;i<m;i++){
			String e[]= br.readLine().split(" ");
			g[Integer.parseInt(e[0])].al.add(Integer.parseInt(e[1]));
			g[Integer.parseInt(e[1])].al.add(Integer.parseInt(e[0]));
		}
		for(int i=1;i<n+1;i++){
			if(g[i].al.size()==n-1){
				g[i].c = 'b';
			}
		}
		int x=0;
		for(int i=1;i<n+1;i++){
			if(g[i].c!='b'){
				x=i;
				break;
			}
		}
		if(x==0){
			printString();
			return ;
		}
		
		g[x].c='a';
		for(int i=0;i<g[x].al.size();i++){
			int v = g[x].al.get(i);
			if(g[v].c!='b')
				g[v].c = 'a';
		}
		int y=0;
		for(int i=1;i<n+1;i++){
			if(g[i].c=='n')
			{
				y=i;
				break;
			}
		}
		if(y==0){
			printString();
			return;
		}
		boolean flag=true;
		g[y].c='c';
		for(int i=0;i<g[y].al.size();i++){
			int v = g[y].al.get(i);
			if(g[v].c=='a'){
				flag =false;
				break;
			}
			else if(g[v].c != 'b'){
				g[v].c= 'c';
			}
				
		}
		if(flag){
			
			for(int i=1;i<n+1;i++){
				if(g[i].c == 'n'){
					System.out.println("No");
					return;
				}
			}
			
			int a=0,b=0,c=0;
			for(int i=1;i<n+1;i++){
				if(g[i].c=='a')
					a++;
				else if(g[i].c=='b')
					b++;
				else
					c++;
			}
			
			for(int i=1;i<n+1;i++){
				int tmp=g[i].al.size();
				if(g[i].c=='a' && tmp !=a+b-1){
					System.out.println("No");
					return;
				}
				else if(g[i].c=='b' && tmp != a+b+c-1){
					System.out.println("No");
					return;
				}
				else if(g[i].c=='c' && tmp != b+c-1){
					System.out.println("No");
					return;
				}
					
			}
			
			printString();
		}
		else
			System.out.println("No");
		
	}
	private static class Graph{
		ArrayList<Integer>al= new ArrayList<Integer>();
		char c='n';
	}
	private static void printString(){
		System.out.println("Yes");
		for(int i=1;i<g.length;i++){
			System.out.print(g[i].c);
		}
	}
}
