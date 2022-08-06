/**
 * The purpose of this class is to create my own custom Array class using a generic class and by adding additional
 * features not available to normal arrays.
 *
 *
 * @author: Bruck Negash
 * @param data          Generic array
 * @param E             Generic type parameter for my elements
 */

import java.util.Arrays;
import java.util.Random;

public class MyArray<E extends Comparable<E>> {

    private E[] data;

    public MyArray(int size) {
        this.data = (E[]) (new Comparable[size]);
    }

    /**
     * This constructor can accept an array or a comma-separated list of values.
     */
    public MyArray(E... elements) {
        this.data = (E[]) (new Comparable[elements.length]);
        //Make a deep copy to prevent shared references.
        System.arraycopy(elements, 0, this.data, 0, elements.length);
    }


    /**
     * This method takes an integer index as a parameter and returns the data array at the given index.
     *<p>
     *     Before state - Here my method will take an integer value as the index
     *     After state -  It will then return whatever value/element from the chosen index
     *     Strategy - return my data/array at a given integer index
     *</p>
     *
     * @return index        integer value of the array's index
     */

    public E get(int index) {
        return data[index];
    }

    /**
     * This method shall take two integer parameters (start and end). Returns a new MyArray object
     * with values between the start and end indices.
     *<p>
     *   Before state - This method will expect to receive two integer indexes (start and end) and create a new
     *   MyArray object.
     *
     *   After state - It will initialize the object with the elements from the chosen range.
     *
     *   Strategy - Create a new array to input the values between the start and end index
     *
     *   How - I first created a new array of the comparable type called temp and casting it to E[]. I found that
     *   to get the range of values in an array I would have to subtract the max value from the min. I then created
     *   a local variable (j) to later be the place value of the new data in my temp array by assigning the old array
     *   to the new. After first it would only proudce the end index's element, followed by null values
     *   until I figured out that I need to increment j otherwise it will not print the all the values just the end
     *   until the loop ends. Then return the new MyArray object with the new values.
     *</p>
     * @return
     */
    public MyArray<E> get(int start, int end){

        /**
         * Create a new array of the Comparable type
         * then casting it to E[].
         */
        E[] temp = (E[]) (new Comparable[end - start]);
        int j = 0;
        for(int i = start; i < end; i++){
            temp[j] = data[i];
            //System.out.println(data[i]);
            /**
             * Increment j to retrieve next element from array
             */
            j++;
        }
        /**
         * Returns a new MyArray object with the values between start and end
         */
        return new MyArray<>(temp);
    }

    /**
     * This method shall take an integer value as the index and a value and places the value at the
     * given index.
     *
     * <p>
     *     Before state - This method is expected to take an integer value as the index and a value to input in
     *     the chosen index.
     *     After state - After the method is called and runs, it will insert/put the value(s) at the chosen index.
     *     Strategy - To assign the value entered to the given index in the array.
     *     How - This is accomplished by assigning the value to the data at the index
     * </p>
     * @param index index of the data array
     * @param value value to be placed in the array
     */
    public void put(int index, E value) {
        data[index] = value;
    }

    /**
     * This method takes 3 parameters: start, end and a comma separated list of values. It will take the
     * values and place them into the array replacing the values between the start and end indices(inclusive).
     * This method does not return any value.
     *
     * <p>
     *     Before state: this method is expected to recieve integer values of the start and end index as well as
     *     accept any number of comma seperated values.
     *
     *     After state: By using a the <code>System.arraycopy()</code> I used the variable
     *     <code>values</code> as the Object source, 0 as the the starting position in my source array,
     *     the generic <code>data</code> array as the objects destination, the <code>start</code> integer
     *     as the starting position in the destination data and the number of elements to be copied
     *     is the <code>values.length</code>.
     *
     *    Strategy: Copy the original array and input the new values into the newly copied array
     *
     * </p>
     *
     * @param start  The starting position/index of the array
     * @param end    The end position/index of destination array
     * @param values is the source variable of the list of values
     * @throws IndexOutOfBoundsException if copying would cause access of data outside array bounds
     * @throws ArrayStoreException       if an element in the source array could not be stored into the destination
     *                                   array because of type mismatch
     * @throws NullPointerException      if the source or destination is null
     */

    public void put(int start, int end, E... values)
            throws IndexOutOfBoundsException, ArrayStoreException, NullPointerException {
        try {
            System.arraycopy(values, 0, this.data, start, values.length);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (ArrayStoreException e) {
            System.out.println("Element in the source array could not be stored into the destination " +
                    "array because of type mismatch.");
        } catch (NullPointerException e) {
            System.out.println("Source or destination is null.");
        }
    }

    /**
     * This takes a single MyArray object as input and returns whether or not this MyArray object is equal to
     * the parameter MyArray object. This method also checks and validates if my objects have equal and same number
     * of elements, all have the same data type, and if in the same exact order without the need to be sorted.
     *
     * <p>
     *     Before state - Is expected to receive a MyArray object as input
     *
     *     After state -  Will then check if the new object data passes the set critrea and will
     *     output a message if found true or not
     *
     *     Strategy - I wanted to use a series checks and validations of the object from the given critrea.
     *     First setting the validations i.e. if the instance matches or if it is empty.
     *
     * </p>
     * @param o          MyArray object
     * @return false     If object does not meet all criteria
     */
    @Override
    public boolean equals(Object o) {
        /**
         * Checks if the current instance is the same as the
         * MyArray object
         */
        if (this == o) {
            return true;
        }
        /**
         * Checks if new object is empty
         */
        if (o == null) {
            return false;
        }

        MyArray<E> myArray = (MyArray<E>) o;
         if(Arrays.equals(data, myArray.data)){
             System.out.println("These objects are equal");
             return true;
         }else {
             System.out.println("These objects are not equal");
             return false;
         }
    }


    /**
     * This method finds and returns the max value using the compareTo() method from the Comparable interface.
     * Using the compare to method allows me to compare to objects of type E to another object of type E.
     *
     * <p>
     *     Before state - This method will be expected to receive the array, when called. And creates a local variable
     *     to assign the first element in the array.
     *
     *     After state - Once the method runs it will return the max value/element in the array
     *
     *     Strategy - Assign the first element to a local variable then loop and compare the element to the other
     *     elements until it finds the max value.
     *
     *     How - Set local variable temp to the first index, wrap an if statement that checks if any value is bigger
     *     than temp in a for loop to continue the process until max value is found. Then once found to return the
     *     max value.
     * </p>
     * @return temp      is the max value
     */
    public E max() {
        E temp = data[0];
        for (int i = 0; i < data.length; i++) {
            /**
             * Checks if any value is bigger than temp
             */
            if (temp.compareTo(data[i]) < 0) {
                /**
                 * Assigns the value(temp) to max
                 */
                temp = data[i];
            }
        }
        return temp;
    }


    /**
     * This method finds and returns the max value using the compareTo() method from the Comparable interface.
     * Using the compare to method allows me to compare to objects of type E to another object of type E.
     *
     * <p>
     *     Before state - This method will be expected to receive the array, when called. And creates a local variable
     *     to assign the first element in the array.
     *
     *     After state - Once the method runs it will return the min value/element in the array
     *
     *     Strategy - Assign the first element to a local variable then loop and compare the element to the other
     *     elements until it finds the min value.
     *
     *     How - Set local variable temp to the first index, wrap an if statement that checks if any value is smaller
     *     than temp in a for loop to continue the process until min value is found. Then once found to return the
     *     min value
     * </p>
     * @return temp     is the min value
     */
    public E min() {
        E temp = data[0];
        for (int i = 0; i < data.length; i++) {
            /**
             * Checks if any value is smaller than temp
             */
            if (temp.compareTo(data[i]) > 0) {
                /**
                 * Assigns the new min value to temp
                 */
                temp = data[i];
            }
        }
        return temp;
    }

    /**
     * This method takes no parameters and reverses the array. This method will
     * iterate over an array and swap elements until it reaches the midpoint.
     *
     * <p>
     *     Before state - Takes no parameters as an arguement but will initialize a local variable.
     *
     *     After state - Will assign the reversed array to the local variable.
     *
     *     Strategy - To split the array in half and swap the first and last elements and the second and fourth
     *     elements with the third element remaining in the same place.
     *
     * </p>
     */
    public void reverse() {
        E temp;

        for (int i = 0; i < data.length / 2; i++) {
            temp = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = temp;
        }
    }

    /**
     * This method uses the Random class to shuffle the elements inside my array.
     *
     * <p>
     *     Before state - Creates a new object of the random class.
     *
     *     After state -  Will return the array elements in a random order
     *
     *     Strategy - The strategy here is to use the random class to return the array list in a random order.
     *
     *     How - First creating a random object to recieve a random element/value (j)
     *     from the array and then later swap the value/element (j) with an i element and
     *     continually do that until the end.
     * </p>
     */
    public void shuffle(){
        /**
         * Creates new object of the Random class
         */
        Random rand = new Random();

        /**
         * Starts from the end of the list
         */
        for(int i = data.length - 1; i >= 1; i--){
            /**
             * gets a random index j
             */
            int j = rand.nextInt(i + 1);

            /**
             * Swaps element at i'th position in the list
             * with the element at the randomly generated index j
             */
            E temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    /**
     * This method shifts the elements in the array to the left n times.
     * It takes an integer value as the number of shifts. Takes the first element in the array
     * and wraps it to the end of the list as the list shifts to the left.
     *
     * <p>
     *     Before state - Initializes three local variables to hold the first element of the index, short hand
     *     variable for "leftShiftDistance" (because im lazy) and variable j to add the first element to the end
     *     of the array.
     *
     *     After state -  The array is shifted 'n' times and the first element of the index will loop to the end.
     *
     *     Strategy - To assign the first index to a local variable, create a loop that shifts the elements to the left,
     *     and to continually place whatever element that is first to go to the end.
     * </p>
     */
    public void leftShift(int leftShiftDistance){
        /**
         * @param n             is the integer value of shifts
         * @param firstNum      variable to store the first element from array
         */
        int n = leftShiftDistance;
        E firstNum;
        int j;

        /**
         * Rotates array elements by n times
         */
        for(int i = 0; i < n; i++){
            /**
             * Stores first element of the array
             */
            firstNum = data[0];
            for(j = 0; j < data.length - 1; j++) {
                /**
                 * Shifts elements of array by one
                 */
                data[j] = data[j + 1];
            }
            /**
             * First element of array will be added to the end
             */
            data[j] = firstNum;
        }

    }


    /**
     * This method shifts the elements in the array to the right n times.
     * It takes an integer value as the number of shifts. Takes the last element in the array
     * and wraps it to the beginning of the list as the list shifts to the right.
     *
     * <p>
     *     Before state - Initializes three local variables to hold the last element of the index, short hand
     *     variable for "rightShiftDistance" (because im lazy) and variable j to add the last element to the beginning
     *      of the array.
     *
     *     After state - The array is shifted 'n' times and the last element of the index will loop to the beginning.
     *
     *     Strategy - To assign the last index to a local variable, create a loop that shifts the elements to the right,
     *      and to continually place whatever element that is last to go to the beginning.
     * </p>
     */
    public void rightShift(int rightShiftDistance){
        /**
         * @param n             is the integer value of shifts
         * @param lastNum      variable to store the last element from array
         */
        int n = rightShiftDistance;
        E lastNum;
        int j;

        /**
         * Rotates array elements by n times
         */
        for(int i = 0; i < n; i++){

            /**
             * Stores last element of the array
             */
            lastNum = data[data.length - 1];

            for(j = data.length - 2; j >= 0; j--) {
                /**
                 * Shifted elements are stored at data index
                 */
                data[j + 1] = data[j];
            }
            /**
             * Last element of array will be added to the beginning
             */
            data[0] = lastNum;
        }

    }

    /**
     * This method returns the size of the array.
     *
     * @return data.length      value for the size of array
     */
    public int size() {
        return data.length;
    }

    /**
     *This method sorts the array of comparable objects
     *
     * <p>
     *     Before state - Takes an unsorted generic array
     *
     *     After state - The smallest element is selected from the unsorted array and swapped with the leftmost
     *     element, and the element becomes a part of the sorted array
     *
     *     Strategy - Set the local variable to the first index, then find the minimum element in the array, swap with
     *     value at the min location and repeat until the list is sorted.
     *
     *     How - First for loop moves the boundary of unsorted array one by one, then finds the min element in unsorted
     *     array using the compareTo. It then swaps the found min element with the first element and repeast until
     *     sorted.
     * </p>
     */
    public void sort() {
        for (int i = 0; i < data.length - 1; i++) {
            E currMin = data[i];
            int currMinIndex = i;

            for (int j = i + 1; j < data.length; j++) {
                if (currMin.compareTo(data[j]) > 0) {
                    currMin = data[j];
                    currMinIndex = j;
                }
            }
            /**
             * Swaps data[i] with the data[currMinIndex]
             */
            if (currMinIndex != i) {
                data[currMinIndex] = data[i];
                data[i] = currMin;
            }
        }
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
