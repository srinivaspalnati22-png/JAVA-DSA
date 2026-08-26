package BASICS_ON_DIGITS;

public class DigitConcepts {

    // 1. Extract last digit
    public static int extractLastDigit(int n) {
        return Math.abs(n % 10);
    }

    // 2. Remove last digit
    public static int removeLastDigit(int n) {
        return n / 10;
    }

    // 3. Extract all digits one by one and print them
    public static void printAllDigits(int n) {
        System.out.print("Digits of " + n + " (from right to left): ");
        int temp = Math.abs(n);
        if (temp == 0) {
            System.out.println(0);
            return;
        }
        while (temp > 0) {
            int digit = temp % 10;
            System.out.print(digit + " ");
            temp /= 10;
        }
        System.out.println();
    }

    // 4. Build / Reverse a number digit by digit
    public static int reverseNumber(int n) {
        int reversed = 0;
        int temp = Math.abs(n);
        while (temp > 0) {
            int digit = temp % 10;
            reversed = (reversed * 10) + digit;
            temp /= 10;
        }
        return n < 0 ? -reversed : reversed;
    }

    // 5. Check if Even / Odd
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // 6. Check if Prime (Has exactly 2 factors: 1 and itself)
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 7. Check if Composite (More than 2 factors)
    public static boolean isComposite(int n) {
        if (n <= 1) return false;
        return !isPrime(n);
    }

    // 8. Greatest Common Divisor (GCD) using Euclidean Algorithm
    public static int getGCD(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    // 9. Remove all factor 'a' from number 'n' (Repeated division)
    public static int removeFactorA(int n, int a) {
        if (a <= 1) return n;
        while (n % a == 0) {
            n /= a;
        }
        return n;
    }

    // 10. Remove all occurrences of digit 'targetDigit' from a number
    public static int removeDigit(int n, int targetDigit) {
        int result = 0;
        int multiplier = 1;
        int temp = Math.abs(n);

        while (temp > 0) {
            int digit = temp % 10;
            if (digit != targetDigit) {
                result = digit * multiplier + result;
                multiplier *= 10;
            }
            temp /= 10;
        }
        return n < 0 ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   BASICS ON DIGITS & MATH CONCEPTS     ");
        System.out.println("========================================");

        int num = 12345;
        System.out.println("Original Number: " + num);
        System.out.println("1. Last Digit: " + extractLastDigit(num));
        System.out.println("2. Number after removing last digit: " + removeLastDigit(num));
        
        System.out.print("3. ");
        printAllDigits(num);

        System.out.println("4. Reversing number digit-by-digit: " + reverseNumber(num));
        System.out.println("5. Is " + num + " Even? " + isEven(num));
        System.out.println("6. Is 29 Prime? " + isPrime(29));
        System.out.println("7. Is 28 Composite? " + isComposite(28));
        System.out.println("8. GCD of (24, 36): " + getGCD(24, 36));
        System.out.println("9. Remove factor 2 from 40: " + removeFactorA(40, 2)); // 40 -> 20 -> 10 -> 5
        System.out.println("10. Remove digit 3 from 13532: " + removeDigit(13532, 3)); // 152
    }
}
