import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ComparingTimes {
  static String timeCompare(String timeOne, String timeTwo) {
    String result = "";
    // Simple check on AM vs PM
    if (timeOne.indexOf("AM") != -1 && timeTwo.indexOf("PM") != -1) {
      result = "First";
    } else if (timeOne.indexOf("PM") != -1 && timeTwo.indexOf("AM") != -1) {
      result = "Second";
    } else {
      // Both times are either AM or PM - determination is based on actual time
      // TODO: Possible regex fix to replace ':' and 'AM/PM' with blank spaces to clean string
      String timeOneSplitString = timeOne.substring(0, 2) + timeOne.substring(3, 5);
      String timeTwoSplitString = timeTwo.substring(0, 2) + timeTwo.substring(3, 5);

      result = (Integer.parseInt(timeOneSplitString) > Integer.parseInt(timeTwoSplitString) ? "Second" : "First");
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int q = s.nextInt(); // The number of queries
    int i;

    for (i = 0; i < q; i += 1) {
      String timeOne = s.next();
      String timeTwo = s.next();

      String result = timeCompare(timeOne, timeTwo);
      System.out.println(result);
    }
  }
}