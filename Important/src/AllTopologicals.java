import java.io.*;
import java.util.*;

public class AllTopologicals {
static Graph g[];
    static int n;
    static Stack <Integer> st;
    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
         n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
         g=new Graph[n+1];
        for(int i=1;i<n+1;i++){
            g[i]=new Graph();
        }
        int indegree[]= new int[n+1];
        for(int i=0;i<m;i++){
            String e[]=br.readLine().split(" ");
            g[Integer.parseInt(e[0])].al.add(Integer.parseInt(e[1]));
            indegree[Integer.parseInt(e[1])]++;
        }
        st = new Stack<Integer>();
        allTopological(indegree);
        
    }
    
    private static void allTopological(int indegree[]){
        
        boolean flag=false;
        for(int i=1;i<n+1;i++){
            if(indegree[i]==0 && !g[i].vis){
                g[i].vis=true;
                for(int j=0;j<g[i].al.size();j++){
                    indegree[g[i].al.get(j)]--;
                }
                st.push(i);
                
                allTopological(indegree);
                
                 g[i].vis=false;
                for(int j=0;j<g[i].al.size();j++){
                    indegree[g[i].al.get(j)]++;
                }
                st.pop();
                flag=true;
            }
            
        }
     
        if(!flag){
            System.out.println(st);
        }
    }
    
    
    private static class Graph{
        ArrayList<Integer>al = new ArrayList<Integer>();
        boolean vis =false;
        
    }
}