import java.io.*;
import java.util.*;

public class hackerrank2 {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s[]= br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int d=Integer.parseInt(s[1]);
        String p[]=br.readLine().split(" " );
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(p[i]);
        }
        int count=0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=1;i<=n;i++){
            int c=0;
            if(i>d){
                int med=0;
                int sz=pq.size();
                 int x=0;
                if(sz%2==0){
                   
                    for(int y:pq){
                        x++;
                        if(x==sz/2)
                            med+=y;
                        else if(x==sz/2+1){
                            med+=y;
                            break;
                        }
                    }
                    med =med/2;
                }
                else{
                    for(int y:pq){
                        x++;
                        if(x==(sz/2)+1){
                            med=y;
                            break;
                        }
                    }
            }
                
               System.out.println(med + " "+ i+" ");
            
            if(arr[i-1]>=med*2){
                count++;
            }
        }
            pq.add(arr[i-1]);
             System.out.println(pq);
    }
   System.out.println(count);
}
}