package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Assignment 3.
 *
 * @author Mr. Riscalas
 * @version 1.0
 * @since 2023-05-07
 */
public final class Pow4SumDigits {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Pow4SumDigits() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the sumOfDigits method.
    *
    * @param index // the index
    * @param stringNums // String array of Nums
    * @return sum
    */
    public static int sumOfDigits(final int index, String[] stringNums) {
        // base case
        if (index >= stringNums.length) {
            return 0;
        } else {
            // recursive sum of return statement
            return sumOfDigits(index + 1, stringNums)
                + Integer.parseInt(stringNums[index]);
        }
    }

    /**
    * This is the sumOfDigits method.
    *
    * @param num //base
    * @return sum
    */
    public static int sumOfDigits(final int num) {
        // call the same function but this time with more arguments
        return sumOfDigits(0, String.valueOf(num).split(""));
    }

    /**
    * This is the powerOfFour method.
    *
    * @param num // the number
    * @param multipleOfFour // the different powers of 4
    * @return boolean
    */
    public static boolean powerOfFour(final int num, final int multipleOfFour) {
        // base case
        final int four = 4;
        if (multipleOfFour == num) {
            return true;
        } else if (multipleOfFour > num) {
            return false;
        } else {
            // calculate the next power of 4
            return powerOfFour(num, multipleOfFour * four);
        }
    }

    /**
    * This is the powerOfFour method.
    *
    * @param num //base
    * @return boolean
    */
    public static boolean powerOfFour(final int num) {
        final int four = 4;
        // call the same function but this time with more arguments
        return powerOfFour(num, four);
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
            /* Read each line from the input file and convert to integer then
            * call both the power of four function and the sum of digits one
            */
            while (inputFile.hasNextLine()) {
                try {
                    // strip the string and convert to int
                    final int number = Integer.parseInt(inputFile.nextLine()
                                                    .strip());
                    // calculate the sum of digits
                    final int sum = sumOfDigits(number);
                    // find out if it is a power of four
                    final boolean powerOfFour = powerOfFour(number);
                    // Write the answer to the output file
                    writer.write("All the digits of your num added up is: "
                            + sum + "\n");
                    // if it is a power of four write that otherwise write that
                    // it isn't
                    if (powerOfFour) {
                        writer.write(number + " is a power of 4\n");
                    } else {
                        writer.write(number + " is not a power of 4\n");
                    }
                } catch (NumberFormatException error) {
                    System.err.println("Incorrect input: "
                        + error.getMessage());
                }
            }
        } catch (FileNotFoundException error) {
            System.err.println("File not found: " + error.getMessage());
        } catch (IOException error) {
            System.err.println("Error writing to file: " + error.getMessage());
        }
    }
}
