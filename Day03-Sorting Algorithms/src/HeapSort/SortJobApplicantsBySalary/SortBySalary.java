package HeapSort.SortJobApplicantsBySalary;

class Heap{
    int size;
    int arr[];

    public Heap(int arr[]){
        this.arr = arr;
        this.size = arr.length;
        buildHeap();
    }

    void buildHeap(){
        for(int i = this.size/2-1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void heapify(int rootIndex){
        int largest = rootIndex;
        int leftChild = 2*rootIndex+1;
        int  rightChild = 2*rootIndex + 2;

        if(leftChild < size && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        if(rightChild < size && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }

        if(largest != rootIndex){
            swap(arr, rootIndex, largest);
            heapify(largest);
        }
    }

    public int getSize(){
        return size;
    }

    public void heapSort(){
        for(int i = size-1; i >= 0; i--){
            swap(arr, 0, i);
            size--;
            heapify(0);
        }
    }
    /*
    public int extractRoot(){
        int max = arr[0];
        arr[0] = arr[--size];
        heapify(0);
        return max;
    }
    */
}

public class SortBySalary {

    public static void main(String[] args){

        int[] salary = {1000, 3000, 5000, 2000, 3500, 1500};
        System.out.print("Original Array: ");
        for(int a: salary){
            System.out.print(a + " ");
        }
        Heap h = new Heap(salary);
        h.heapSort();
        System.out.print("\nAfter heap sort: ");
        for(int a: salary){
            System.out.print(a + " ");
        }
    }
}
