import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindTheBug {
  static int[] findTheBug(String[] args) {
    int[] bugCoordinates = {-1, -1}; // Row and column coordinates for the bug (default of (-1, -1))
    String current; // Current string to analyze
    int i, l = args.length;

    for (i = 0; i < l; i += 1) {
      current = args[i];
      if (current.indexOf("X") != -1) {
        bugCoordinates[0] = i;
        bugCoordinates[1] = current.indexOf("X");
        break;
      }
    }
    return bugCoordinates;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt(); // Construction of an n x n grid (second n is a string)
    String[] grid= new String[n];
    int grid_index;

    for (grid_index = 0; grid_index < n; grid_index += 1) {
      grid[grid_index] = s.next(); // Get the string data of the row
    }

    // Return an array containing [r, c] based on where the bug is
    int[] result = findTheBug(grid);
    int i;

    for (i = 0; i < result.length; i += 1) {
      System.out.print(result[i] + (i != result.length - 1 ? ", " : ""));
    }
    System.out.println("");
  }
}