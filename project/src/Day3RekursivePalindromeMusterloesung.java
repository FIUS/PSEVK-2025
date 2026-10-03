package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static char[] removeElement(char[] array, int index) {
        if (array == null || index < 0 || index >= array.length) {
            return array;
        }
        char[] result = new char[array.length - 1];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, array.length - index - 1);

        return result;
    }
    public static boolean isPalindrome(char[] wortArray) {
        if (wortArray.length < 2) {
            return true;
        } else {
            if (wortArray[0] == wortArray[wortArray.length - 1]) {
                char[] newWort = removeElement(wortArray, wortArray.length - 1);
                newWort = removeElement(newWort, 0);
                return isPalindrome(newWort);
            } else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner derScanner = new Scanner(System.in);
        String wort = derScanner.nextLine();
        char[] wortArray = wort.toCharArray();
        System.out.println(isPalindrome(wortArray));
    }
}