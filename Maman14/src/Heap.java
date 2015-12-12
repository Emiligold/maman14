
public class Heap
{
	private int heapSize;
	private Integer[] A;
	private int exchangeCount = 0;
	
	public Heap(Integer[] pA)
	{
		this.A = pA;
		heapSize = A.length;
	}
	
	public void buildMaxHeap()
	{
		heapSize = A.length;
		
		for (int i = ((A.length - 1) / 2); i >= 0; i--)
		{
			maxHeapify(A, i);
		}
	}
	
	public void maxHeapify(Integer[] curr, int i)
	{
		Integer left = leftSon(curr, i);
		Integer right =  rightSon(curr, i);
		Integer largest;
		
		if (left != null && left < heapSize && (curr[left] > curr[i]))
		{
			largest = left;
		}
		else
		{
			largest = i;
		}
		
		if (right != null && right < heapSize && curr[right] > curr[largest])
		{
			largest = right;
		}
		
		if (largest != i)
		{
			exchange(curr, i, largest);
			maxHeapify(curr, largest);
		}
	}
	
	private Integer leftSon(Integer[] A, int i)
	{
		if (2 * (i + 1) > A.length)
		{
			return null;
		}
		
		return 2 * (i + 1) - 1;
	}
	
	private Integer rightSon(Integer[] A, int i)
	{
		if ((2 * (i + 1) + 1) > A.length)
		{
			return null;
		}
		
		return 2 * (i + 1);
	}
	
	public void exchange(Integer[] A, int i, int j)
	{
		exchangeCount++;
		Integer temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public void heapSort()
	{
		buildMaxHeap();
		
		for (int i = A.length - 1; i >= 0; i--)
		{
			exchange(A, 0, i);
			heapSize--;
			maxHeapify(A, 0);
		}
	}
	
	public String print()
	{
		String print = "";
		
		for (int i = 0; i < A.length; i++)
		{
			print += A[i] + " ";
		}
		
		return print;
	}
	
	public int getExchangeCount()
	{
		return exchangeCount;
	}
	
	public void resetExchangeCount()
	{
		exchangeCount = 0;
	}
}
