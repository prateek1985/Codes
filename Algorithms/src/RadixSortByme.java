
import java.util.ArrayList;
import java.util.Queue;


public class RadixSortByme {
    
    public static void main(String args[]){
         int arr[]={54,67,13,24,76,37,97,10,67,24,6,28,5,19,63,1,71,83,9222,1, 33};
        sort(arr);
        /** Print sorted Array **/
        
        for (int i = 0; i <arr.length; i++)
            System.out.print(arr[i]+" ");            
            System.out.println();                     
    }
    static void sort(int []arr){
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<10;i++){
            bucket.add(new ArrayList<Integer>());
        }
        int max=Integer.MIN_VALUE;
        for(int x: arr){
            if(x>max){
                max=x;
            }
        }
        String str=""+max;
        int digitMax=str.length();
        int exp=1;
        
        for(int j=0;j<digitMax;j++){
             
        for(int i=0;i<arr.length;i++){
          
            bucket.get((arr[i]/exp)%10).add(arr[i]);
        }
        int tmp=0;
        for(int i=0;i<10;i++){
           
            while(!bucket.get(i).isEmpty()){
                
              arr[tmp++]=  bucket.get(i).remove(0);
            }
        }
        exp *=10;
    }
   }
}