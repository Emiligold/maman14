
public class Main {
	
	public static void main(String[] args)
	{
		Integer[] A = {10, 3, 7, 2, 1, 5, 9, 2, 6, 20};
		
		Heap heap = new Heap(A);
		System.out.println(heap.print());
		heap.heapSort();
		System.out.println(heap.print());
		System.out.println(heap.getExchangeCount());
	}
}
