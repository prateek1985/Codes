import java.io.*;
public class LASTDIG2{
public static void main(String args[])throws NumberFormatException,IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(br.readLine());
for(int r=0;r<t;r++){String arr[]= br.readLine().split(" ");
long test[]=new long [11];
test[0]=1;int tmp = 0;
long arr0=Long.parseLong(arr[0].substring(arr[0].length()-1,arr[0].length()))%10;
for(int i=1;i<=10;i++){
test[i]=(test[i-1]*arr0)%10;}
for(int i=2;i<=10;i++){
if(arr0==test[i]){tmp=i-1;break;}}test[0]=test[tmp];
if(Long.parseLong(arr[1])==0||arr0==1){System.out.println(1);}
else{System.out.println(test[(int)(Long.parseLong(arr[1])%tmp)]);}}}}