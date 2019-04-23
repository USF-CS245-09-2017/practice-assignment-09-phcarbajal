// min
import java.util.Arrays;

public class BinaryHeap 
{
	
	private int MAX = 10;
	private int[] arr;
	private int size;
	
    public BinaryHeap() 
    {
		arr = new int[MAX];
		size = 0;
	}
	
    private int parent(int index) 
    {
		return (index - 1) / 2;
	}
	
    private int left_child(int index) 
    {
		return (2 * index + 1);
	}
	
    private int right_child(int index) 
    {
		return (2 * index + 2);
	}
	
    private void swap(int a, int b) 
    {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
        
    // this is to make sure that there is enough space to add
    public void add(int num) 
    {
        if (size == MAX) 
        {
			MAX *= 2;
			arr = Arrays.copyOf(arr, MAX); 
		}
		
		arr[size++] = num;
		int curr = size - 1;
		
        while (arr[curr] < arr[parent(curr)]) 
        {
			swap(curr, parent(curr));
			curr = parent(curr);
		}
	}
	
    public int remove() 
    {
        if (size == 0) 
        {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int min = arr[0];
		arr[0] = arr[--size]; // apparently size-- does not work
		master_swap(0);
		return min;
	}
	
    private void master_swap(int index) 
    {
        if (index < size / 2) 
        {
            if (arr[index] > arr[left_child(index)] || arr[index] > arr[right_child(index)]) 
            {
                if (arr[left_child(index)] < arr[right_child(index)]) 
                {
					swap(index, left_child(index));
					master_swap(left_child(index));
                } 
                else 
                {
					swap(index, right_child(index));
					master_swap(right_child(index));
				}
			}
		}
	}
}