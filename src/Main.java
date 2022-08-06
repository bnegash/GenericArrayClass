/**
 * The purpose of this class is to demonstrate the functionality of the MyArray.java class.
 * It outputs all the methods defined in the generic class.
 *
 * @author: Bruck Negash,CIN: 305603706,CS-2013,Sections 03 & 04
 */

public class Main {
    public static void main(String[] args){
        MyArray intArray = new MyArray(105,9,16,51,49);
        MyArray strArray = new MyArray("Science","English","Math","History","Engineering");
        MyArray intArray2 = new MyArray(87,67,21,97);
        MyArray charArray = new MyArray('G','e','n','e','r','i','c','s');

        System.out.println("Here is the integer array: " + intArray);
        System.out.println("Here is the string array: " + strArray);
        System.out.println("Here is the char array: " + charArray);
        System.out.println();

        /**
         * Outputs the equals method
         */
        System.out.println("Checking if 'intArray' is equal to 'testArr'...");
        intArray.equals(intArray2);
        System.out.println();

        /**
         * Outputs the max and min values of the arrays
         */
        System.out.println("Here is the min value of integer array: " + intArray.min());
        System.out.println("Here is the min value of string array: " + strArray.min());
        System.out.println("Here is the min value of char array: " + charArray.min());

        System.out.println();
        System.out.println("Here is the max value of integer array: " + intArray.max());
        System.out.println("Here is the max value of string array: " + strArray.max());
        System.out.println("Here is the max value of char array: " + charArray.max());
        System.out.println();

        /**
         * Outputs the arrays in reverse
         */
        intArray.reverse();
        strArray.reverse();
        charArray.reverse();
        System.out.println("Here is the integer array in reverse: " + intArray);
        System.out.println("Here is the string array in reverse: " + strArray);
        System.out.println("Here is the char array in reverse: " + charArray);
        System.out.println();

        /**
         * Outputs sorted array
         */
        intArray.sort();
        strArray.sort();
        charArray.sort();
        System.out.println("Here is the sorted integer array: " + intArray);
        System.out.println("Here is the sorted string array: " + strArray);
        System.out.println("Here is the sorted char array: " + charArray);
        System.out.println();

        /**
         * Outputs the shuffled array
         */
        intArray.shuffle();
        strArray.shuffle();
        charArray.shuffle();
        System.out.println("Here is the shuffled integer array: " + intArray);
        System.out.println("Here is the shuffled string array: " + strArray);
        System.out.println("Here is the shuffled char array: " + charArray);
        System.out.println();

        /**
         * Outputs for leftShift distance
         */
        intArray.leftShift(2);
        strArray.leftShift(1);
        charArray.leftShift(2);
        System.out.println("Here is the integer array left shifted: " + intArray);
        System.out.println("Here is the string array left shifted: " + strArray);
        System.out.println("Here is the char array left shifted: " + charArray);
        System.out.println();

        /**
         * Outputs for rightShift distance
         */
        intArray.rightShift(1);
        strArray.rightShift(1);
        charArray.rightShift(1);
        System.out.println("Here is the integer array right shifted: " + intArray);
        System.out.println("Here is the string array right shifted: " + strArray);
        System.out.println("Here is the char array right shifted: " + charArray);
        System.out.println();


        /**
         * Output to show the value at given index
         * put(int index, E value)
         */
        intArray.put(2,10);
        System.out.println("Here is the integer array after inputting a value at given index: " + intArray);
        strArray.put(2,"Computer Science");
        System.out.println("Here is the string array after inputting 'Computer Science' at index '2': " + strArray);
        charArray.put(1,'T');
        System.out.println("Here is the char array after inputting 'T' at index '1': " + charArray);
        System.out.println();

        /**
         * Output to place given data/value between given start and end index
         * put(int start, int end, E... values)
         */
        intArray.put(1,3,13,6,89);
        System.out.println("Here is the integer array after inputting values between given" +
                " indices: " + intArray);
        strArray.put(1,3,"Art","Calculus","PolySci");
        System.out.println("Here is the string array after inputting 'Art, Calculus, PolySci' between " +
                "index '1 and 3': " + strArray);
        charArray.put(0,3,'a');
        System.out.println("Here is the char value 'a' at index '0 and 3': " + charArray);
        System.out.println();

        /**
         * Outputs to return the data at given index
         * get(int index)
         */
        System.out.println("Here is the integer at index '3': " + intArray.get(3));
        System.out.println("Here is the string at index '2': " + strArray.get(2));
        System.out.println("Here is the char value at index '4': " + charArray.get(4));
        System.out.println();

        /**
         * Output to show the values between the given indices start and end
         * get(int start, int end)
         */
        System.out.println("Here is the integer values between '0 and 3': " + intArray.get(0,3));
        System.out.println("Here is the string values between '1 and 4': " + strArray.get(1,4));
        System.out.println("Here is the char values between '0 and 4': " + charArray.get(0,4));

    }
}
