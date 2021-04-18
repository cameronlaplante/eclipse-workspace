package sorting;

import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestInsertionSort{

    // /**----------------------------------------------------
    // isSorted - return true if anArray is sorted. 
    // -------------------------------------------------------*/
    private static boolean isSorted(Integer[] anArray){

        for (int i=0; i< anArray.length-1; i++){
            if(anArray[i] > anArray[i+1]){
                return false;
            }
        }
        return true;
    }


    // /**----------------------------------------------------
    // sameElements - 
    // -------------------------------------------------------*/
    private static boolean sameElements(Integer[] array1, Integer[] array2){

        //sort both arrays (call insertion sort)
        Integer array1Sorted[] = InsertionSort.insertionSort(array1);
        //
        if (array1.equals(array2)){
            return true;
        }
        return false;
    }


    // /**----------------------------------------------------
    // testFromConsole - 
    // -------------------------------------------------------*/
    // private static void testFromConsole{

    // }


    /**----------------------------------------------------
    shuffleTest - 
    -------------------------------------------------------*/
    private static void shuffleTest(int N){

        // 1) Generate array of length N - elements 0-N
        Integer[] preShuffle = new Integer[N];
        
        for (int i = 0; i < N; i++){
            preShuffle[i] = i;
        }

        // //FOR TESTING PURPOSES. VERIFY OUTPUT: 
        // System.out.println("preShuffle List: ");
        // System.out.println(Arrays.toString(preShuffle));
        // System.out.println(" ");
        // //^^^^^^^^

        // 2) Randomly shuffle array! (postShuffle)
        Integer[] postShuffle = new Integer[N];
        List<Integer> shuffleList = Arrays.asList(preShuffle);
        Collections.shuffle(shuffleList);
        shuffleList.toArray(postShuffle);

        // //FOR TESTING PURPOSES. VERIFY OUTPUT:
        // System.out.println("postShuffle List: ");
        // System.out.println(Arrays.toString(postShuffle));
        // System.out.println(" ");
        // //^^^^^^^^

        // 3) use insertionSort to sort shuffled array. 

        

        Integer[] postSorting = InsertionSort.insertionSort(postShuffle);


        //postSorting = InsertionSort1.InsertionSort(postSorting);
        // postSorting = new InsertionSort(postSorting);
        // postSorting = I(postShuffle);

        // 4&5) Compare postSorting to preShuffle
        if (postSorting.equals(preShuffle)){
            System.out.println("Passed Test.");
            System.out.println(" ");
        }else{
            System.out.println("Failed Test");
            System.out.println(" ");
        }

    }


    /**----------------------------------------------------
    Main method - Based on presense of args, invoke methods
    -------------------------------------------------------*/
    public static void main(String args[]){
        // no command line args => run testFromConsole
        if (args.length == 0){
          //  testFromConsole();
            
        }else{
            for (String i:args){
                //parse args to int values
                int N = Integer.parseInt(i);

                //for testing
                //System.out.println(N);

                //invoke shuffleTest for each arg
                shuffleTest(N);

            }
        }
    }

}