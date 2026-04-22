public class SelectionSort {
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
        for(int i=0;i<arr.length-1;i++)
        {
            int smallest = i; //initial index as i
            for(int j=i;j<arr.length;j++) //not till arr.length-1 becasue it needs to go to the last element to compare with smallest element
            {
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            //swapping i th element with the smallest element
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }

        printArray(arr);
    }
}
