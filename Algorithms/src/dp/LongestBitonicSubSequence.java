package dp;

public class LongestBitonicSubSequence {

	public static void main(String args[]){
		int arr[] =  {1, 11, 2, 10, 4, 5, 2, 1};
		
		int Lis[] = new int[arr.length];
		int Lds[] = new int [arr.length]; // lds is longest decreasing sub sequence
		
		for(int i=0; i<arr.length ;i++){
			Lis[i] =1;
			Lds[i] =1;
		}
		
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j]  && Lis[i] <Lis[j] +1){
					Lis[i] =Lis[j] +1;
				}
			}
		}
		
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++){
				if(arr[i] < arr[j]  && Lds[i] <Lds[j] +1){
					Lds[i] =Lds[j] +1;
				}
			}
		}
		
		/* OR USE THIS FOR LDS
		 
		  for (i = n-2; i >= 0; i--)
            for (j = n-1; j > i; j--)
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
		 */
		
		int max =Lis[0] + Lds[0]-1;
		for(int i=1;i<arr.length;i++){
			if(max < Lis[i] +Lds[i] -1)
				max = Lis[i] +Lds[i] -1;
		}
		
		System.out.println(max);
		
	}
}
