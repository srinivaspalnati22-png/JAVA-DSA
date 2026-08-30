import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 11. Inputs and Outputs in Java - Runnable Demonstration
 */
public class InputOutputDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("=== 1. Standard Output: print, println, and printf ===");
        
        // System.out.print (no automatic newline)
        System.out.print("Part 1 - ");
        System.out.print("Part 2\n");

        // System.out.println (automatic newline)
        System.out.println("Line 1 with println");
        System.out.println("Line 2 with println");

        // System.out.printf (formatted output)
        String studentName = "Srinivas";
        int rank = 1;
        double score = 98.756;
        char section = 'A';
        boolean isPassed = true;

        System.out.printf("Student: %-10s | Rank: %03d | Score: %.2f | Sec: %c | Passed: %b%n",
                studentName, rank, score, section, isPassed);

        System.out.println("\n=== 2. Escape Sequences ===");
        System.out.println("Tab separation:\tItem1\tItem2\tItem3");
        System.out.println("Quotes & Slash:\t\"Java Programming\" \\ Directory: C:\\DSA");

        System.out.println("\n=== 3. Scanner Parsing Demonstration ===");
        // Simulating standard input stream using a String
        String simulatedInput = "42 3.14159 true Algorithms\nLine with spaces\n";
        Scanner sc = new Scanner(simulatedInput);

        int sampleInt = sc.nextInt();
        double sampleDouble = sc.nextDouble();
        boolean sampleBool = sc.nextBoolean();
        String sampleWord = sc.next();
        
        // Consuming the leftover newline before nextLine()
        sc.nextLine();
        String sampleLine = sc.nextLine();

        System.out.println("Parsed Integer : " + sampleInt);
        System.out.println("Parsed Double  : " + sampleDouble);
        System.out.println("Parsed Boolean : " + sampleBool);
        System.out.println("Parsed Word    : " + sampleWord);
        System.out.println("Parsed Line    : " + sampleLine);
        sc.close();

        System.out.println("\n=== 4. Fast I/O Demonstration (BufferedReader & StringTokenizer) ===");
        String simulatedFastInput = "100 200 300\nJava DSA Fast Input Line\n";
        BufferedReader br = new BufferedReader(new StringReader(simulatedFastInput));

        // Read space-separated numbers on a single line
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        int sum = num1 + num2 + num3;

        // Read whole line
        String textLine = br.readLine();

        System.out.println("Parsed Numbers Sum : " + sum);
        System.out.println("BufferedReader Line: " + textLine);
        br.close();

        System.out.println("\n=== 5. Standard Error Stream (System.err) ===");
        System.err.println("Notice: System.err prints diagnostic/error messages.");
    }
}
