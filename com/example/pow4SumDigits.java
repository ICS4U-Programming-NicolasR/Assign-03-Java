package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary search function.
 *
 * @author Mr. Riscalas
 * @version 1.0
 * @since 2023-04-24
 */
public final class pow4SumDigits {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private pow4SumDigits() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the recBinSearch method.
    *
    * @param index // the index
    * @param stringNums // String array of Nums
    * @return sum
    */
    public static int sumOfDigits(final int index, String[] stringNums) {
        if (index >= stringNums.length) {
            return 0;
        } else {
            return sumOfDigits(index + 1, stringNums) + Integer.parseInt(stringNums[index]);
        }
    }

    /**
    * This is the recBinSearch method.
    *
    * @param num //base
    * @return sum
    */
    public static int sumOfDigits(final int num) {
        // call the same function but this time with more arguments
        return sumOfDigits(0, String.valueOf(num).split(""));
    }

    /**
    * This is the recBinSearch method.
    *
    * @param index // the index
    * @param stringNums // String array of Nums
    * @return sum
    */
    public static boolean powerOfFour(final int num, final int multipleOfFour) {
        if (multipleOfFour == num) {
            return true;
        } else if (multipleOfFour > num) {
            return false;
        } else {
            return powerOfFour(num, multipleOfFour * 4)
        }
    }

    /**
    * This is the recBinSearch method.
    *
    * @param num //base
    * @return index
    */
    public static boolean powerOfFour(final int num) {
        // call the same function but this time with more arguments
        return powerOfFour(num, 4);
    }

    /**
    * This is the main method.
    *
    * @param args //unused
    */
    public static void main(final String[] args) {
        // Set the input and output file paths
        final String inputFilePath = "input.txt";
        final String outputFilePath = "output.txt";
        // Read input from file using Scanner
        try (Scanner inputFile = new Scanner(new File(inputFilePath));
            FileWriter writer = new FileWriter(outputFilePath)) {
            /* Read each line from the input file and find using a binary search
            * the index of the random numbers using recursions
            */
            while (inputFile.hasNextLine()) {
                try {
                    final int number = Integer.parseInt(inputFile.nextLine().strip());
                    // find the index by calling the recBinSearch
                    final int sum = sumOfDigits(number);
                    final boolean powerOfFour = powerOfFour(number);
                    // Write the answer to the output file
                    writer.write("All the digits of your num added up is: "
                            + sum);
                } catch (NumberFormatException error){
                    System.err.println("Incorrect input: " + error.getMessage());
                }
            }
        } catch (FileNotFoundException error) {
            System.err.println("File not found: " + error.getMessage());
        } catch (IOException error) {
            System.err.println("Error writing to file: " + error.getMessage());
        }
    }
}
