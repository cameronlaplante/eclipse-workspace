package sorting;
public class InsertionSort {

    public static Integer[] insertionSort(Integer array[]){

        int l = array.length;
        for (int i = 1; i<l; i++){
            int cur = array[i];
            int j = i-1;

            while (j >= 0 && array[j] > cur){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = cur;
        }
        return array;
    }

    // public static void main(String args[]){
    //     Integer[] array = {4,5,1,7,9,0,1};
    //     System.out.println("Prior to Insertion Sorting");
    //  //   System.out.println(args[0]);
    //     for(int i:array){
    //         System.out.print(i+ " ");
    //     }

    //     insertionSort(array);

    //     System.out.println("Post Insertion Sort");

    //     for (int i:array){
    //         System.out.print(i+" ");
    //     }

    // }

}
