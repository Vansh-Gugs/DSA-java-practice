public class InsertionSort {
    public static void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};

        //Selection Sort
        //O(n^2) time complexity
        for(int i=1;i<arr.length;i++) //i=1 becasue 0th index is considered sorted part of the array
        {
            int current = arr[i]; //the element that needs to be placed in correct place in sorted part
            int j= i-1; //to tack sorted part
            while(j>=0 && current < arr[j])
            {
                //making space for the next element to come inside the sorted part
                arr[j+1] = arr[j];
                j--; 
            }
            //placement
            arr[j+1] = current;
        }

        printArray(arr);
    }
}
