/**
 *  Task 4 : Result List
 *  GSoC 2016
 * 	vitrivr
 * 
 *  Project - Natural Language Query Interface
 *  
 *  submitted by - Prateek Goel
 */

import java.util.Random;

public class Vitrivr_ResultList {

	private static final int N = 100000;
	private static Tuple tuple[];
	
	/* Each object of Tuple class represents a tuple (x, id) */
	
	private static class Tuple{
		int x;
		int id;
		
		public Tuple(int x, int id){
			this.x=x;
			this.id=id;					
		}
	}
	
	// The method swaps the elements at position i and j in tuple array
	public static void swap(int i ,int j){
		Tuple tmp = tuple[i];
		tuple[i]=tuple[j];
		tuple[j] = tmp;
	}
	
	/**
	 *  Picks a random pivot element between [start, end] 
	 *	Partitions the tuple array about pivot element such that everything to the left of pivot is smaller than pivot
	 *	and to the right of pivot is larger than pivot element
	 *	Comparison among tuples is done on the basis of value of x in a tuple (x, id)
	 */
	
	public static int randomPartition(int start, int end){
		Random rand = new Random();
		int pivot =rand.nextInt(end-start+1) + start;
		
		/* Putting pivot at end and then considering tuple[start ... (end-1)] for comparison with tuple[end]*/
		swap(pivot,end);
		
		Tuple t = tuple[end];
		int i = start;
		
	    for (int j = start; j <= end - 1; j++)
	    {
	        if (tuple[j].x <= t.x)
	        {
	            swap(i, j);
	            i++;
	        }
	    }
	    
	    // placing tuple[end] at correct position i.e. at i'th position
	    swap(i, end);
	    
	    // returns the correct position of pivot element 
	    return i;
		
	}
	
	/**
	 *  kthSmallest method returns k'th smallest element in tuple[start....end] using
	 *  QuickSort based method
	 */
	
	public static int kthSmallest(int start, int end, int k){
		
		// If k is smaller than number of elements in array
	    if (k > 0 && k <= end - start + 1)
	    {
	        /** 
	        *   Partition the array around a random pivot element and
	        *   get position of pivot element in sorted tuple array
	        */
	    	int positionPivot = randomPartition(start, end);
	 
	        // If position is same as k
	        if (positionPivot - start == k-1)
	            return tuple[positionPivot].x;
	       
	        // If position is more, recur for left subarray
	        if (positionPivot - start > k-1)  
	            return kthSmallest(start, positionPivot - 1, k);
	 
	        // Else recur for right subarray
	        return kthSmallest(positionPivot + 1, end, k - positionPivot + start - 1);
	    }
	    
	 // If k is more than number of elements in array
	    return Integer.MAX_VALUE;
	}
	
	
	public static void main (String [] args)throws Exception{
		int k=500;						// given
		tuple = new Tuple[N];
		Random rand = new Random();
		
		/** 
		 *  Randomly generating N tuples where randomX lies between [0,1000]
		 *  id is denoted by i here and is unique 
		 */
		for(int i=1;i<=N;i++){
			int randomX = rand.nextInt(1001);
			tuple[i-1] = new Tuple(randomX,i);
		}
		
		// element represent the value of x of that tuple(x,id) which is present at k'th position in sorted tuple array
		int element =kthSmallest(0,N-1,k);
		
		// printing the id of tuples(x,id) whose x is smallers than or equal to element
		for(int i=0;i<N;i++){
			if(tuple[i].x <=element)
				System.out.println(tuple[i].id);
		}
	}
	
}
