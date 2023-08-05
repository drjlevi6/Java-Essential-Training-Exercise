import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetterCounter {
    /*
     * Count uppercase letters in user-entered strings.
     *
     * This class reads an arbitrary number of user-submitted strings until a
     * blank string is read. The strings are then converted into an array.
     * Each string's length and number of uppercase letters are reported.
     * The method doing the reporting uses varargs.
     */

    public static void main(String[] args) {
        // Get an array of user-entered strings consisting of uppercase and
        // lowercase letters.
        String[] userStrings = getUserStrings();
        printStatistics(userStrings);
        // For each string, print statistics: total and uppercase letters.
    }

    public static String[] getUserStrings(){
        /* Each user string, if validated as consisting of only alphabetic
         * characters, is appended to a single string consisting of all of
         * the user's strings, separated by spaces.
         */
        Pattern pattern = Pattern.compile("^[A-Z]+$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        boolean matchFound;
        String userString;
        String accum = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
            while(!(userString = scanner.nextLine()).isEmpty()) {
                System.out.println("You entered: " + userString);

            matcher = pattern.matcher(userString);
            matchFound = matcher.find();
            if (matchFound){
                accum += ((accum.isEmpty()) ? userString :' ' + userString);
            } else {
                System.out.println(
                        "Invalid string, must be alphabetic chars only");
            }
            System.out.print("Enter next string: ");
        }
          return accum.split(" ");
    }
    public static void printStatistics(String ...userStrings){
        for (int i=0; i < userStrings.length; i++){
            System.out.println("userStrings[" + i + "] = “" +  userStrings[i] +
                "”; has " + userStrings[i].length() + " chars, " +
                userStrings[i].replaceAll("[a-z]",
                "").length() + " uppercase.");
        }
    }
}
