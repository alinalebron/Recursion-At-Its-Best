/**
 * File : ArrayRecursionTest.java
 *
 *
 * I affirm that this program is entirely my own work
 * and none of it is the work of any other person.
 * Created by @AlinaLebron on 4/21/15.
 */

import java.util.Random;

class ArrayRecursion
{
    // instance var's

    private int[] list;		// array of ints
    private int count = 0;	// number of elements used

    /**
     * Create an ArrayRecursion object. Create an array with between 10 and 15
     * elements, and fill it with random positive 2-digit ints
     */
    public ArrayRecursion()
    {
        Random r = new Random();
        count = r.nextInt(6) + 10;
        list = new int[count];

        for (int i = 0; i < count; i++)
        {
            list[i] = r.nextInt(90) + 10;
        }
    }

    /*
     * Return the list as a string
     * @return a string containing all ints stored in list
     */
    public String toString()
    {
        String out = "";
        for (int i = 0; i < count; i++)
        {
            out += list[i] + "  ";
        }
        return out + "\n";
    }

    /**
     * Reverse the order of the values stored in the list. (called by client to
     * reverse list using first algorithm)
     */
    public void reverse()
    {
        reverseRecurse(list, 0, count);
    }

    // recursive "helper" method to reverse the values stored in the list
    // (called by public method reverse1())
    private void reverseRecurse(int[] list, int start, int count)
    {
        if (start < count) // base case
        {
            int temp = list[start]; // temporarily store the value at start
            list[start] = list[count - 1]; // store the value of count-1 in the start index
            list[count - 1] = temp; // replace the value of count -1 as the value in temp (previously value at start)
            reverseRecurse(list, start + 1, count - 1); // call the method again for the next start and
        }
    }

    /*
     * Returns the index of the largest value in the array.
     * @return the index of the largest value in the array
     */
    public int getIndexOfLargest()
    {
        return recursiveGetIndexOfLargest(list, count);
    }

    // recursive "helper" method to return index of largest value
    // (called by public method getLargest())
    private int recursiveGetIndexOfLargest(int[] list, int count)
    {
        if (count == 1) // if the list size is equivalent to 1, return that index
        {
            return count - 1;
        }

        /*
           Determines the index with the largest value in the smaller portion in the array
         */

        int index = recursiveGetIndexOfLargest(list, count - 1);

        if (list[index] < list[count - 1]) // check if the value of the index is less than count - 1
        {

            return count - 1; // if so, return count - 1
        }
            return index; // return the index
    }

    /*
     * Sort the array in ascending order using the selection sort
     */
    public void sort()
    {
        recursiveSort(list, count);
    }

    // recursive "helper" method to sort the array
    // (called by public method sort())
    private void recursiveSort(int[] list, int count)
    {
        if (count > 1) // base case
        {
            int temp = list[count -1]; // temporarily store the value of the last element of the list

            int index = recursiveGetIndexOfLargest(list, count); // finds the index with the largest value

            /* Swaps the last element with the largest element */

            list[count -1] = list[index];

            list[index] = temp ;

            recursiveSort(list, count - 1);

        }

    }
}

/**
 * A test class for the ArrayRecursion class
 */
public class ArrayRecursionTest
{

    public static void main(String[] args)
    {
        ArrayRecursion list = new ArrayRecursion();

        System.out.println("\nOriginal:  " + list);
        list.reverse();
        System.out.println("\nReversed:    " + list);
        System.out.println("Largest value is at index: "
                + list.getIndexOfLargest());
        list.sort();
        System.out.println("\nSorted:    " + list);
    }
}