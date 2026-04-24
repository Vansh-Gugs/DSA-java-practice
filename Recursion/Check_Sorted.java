public class Check_Sorted {
    //Strictly increasing(no duplicates)
    public static boolean isSorted(int arr[], int index){
        //base case
        if(index==arr.length-1){ //-1 because we check for arr[index+1] so that it doesnt go index out of bounds
            return true;
        }

        if(arr[index]<arr[index+1]){
            return isSorted(arr, index+1);
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6};
        System.out.println(isSorted(array,0));
    }
}
