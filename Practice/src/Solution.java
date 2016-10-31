import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int r=0;r<t;r++){
            String a = br.readLine();
            String b = br.readLine();
            
            boolean flag=false;
            for(int i=0;i<b.length();i++)
            {
                if(b.charAt(i) >='a')
                    {
                    flag=true;break;
                }
            }
            
            if(flag){
                if(a.length()!=b.length())
                    System.out.println("NO");
                else{
                    for(int i=0;i<a.length();i++){
                        if(a.charAt(i) != b.charAt(i) && a.charAt(i) != b.charAt(i)+32){
                            System.out.println("NO");
                            flag=false;
                            break;
                        }
                            
                    }
                    if(flag)
                        System.out.println("YES");
                }
            }
            else{
                int i=0,j=0;
                while(j<b.length() && i<a.length()){
                    if(a.charAt(i)==b.charAt(j)  || a.charAt(i)==b.charAt(j)+32){
                        i++;j++;
                    }
                
                    else{
                        i++;
                    }
                }
                
               
                    if(j!=b.length()) System.out.println("NO");
                    else  System.out.println("YES");
                
            }
            
        }
    }
}