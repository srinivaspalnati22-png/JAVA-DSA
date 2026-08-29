/**
 * 08. Type Casting in Java - Runnable Demonstration
 */
public class TypeCastingDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. Widening (Implicit) Casting ===");
        int myInt = 9;
        double myDouble = myInt; // Automatic casting
        System.out.println("int value:    " + myInt);
        System.out.println("double value: " + myDouble);

        System.out.println("\n=== 2. Narrowing (Explicit) Casting ===");
        double fractionalVal = 9.78;
        int truncatedVal = (int) fractionalVal; // Explicit casting
        System.out.println("double value: " + fractionalVal);
        System.out.println("truncated int: " + truncatedVal);

        System.out.println("\n=== 3. Type Promotion in Expressions ===");
        byte b1 = 40;
        byte b2 = 50;
        int sumInt = b1 + b2; // Promoted to int
        byte sumByte = (byte) (b1 + b2);
        System.out.println("b1 + b2 as int:  " + sumInt);
        System.out.println("b1 + b2 as byte: " + sumByte);

        System.out.println("\n=== 4. Character & ASCII Casting ===");
        char ch = 'A';
        int asciiVal = ch; // Implicit char to int
        System.out.println("Character '" + ch + "' has ASCII code: " + asciiVal);

        int code = 97;
        char letter = (char) code; // Explicit int to char
        System.out.println("ASCII code " + code + " corresponds to char: '" + letter + "'");

        System.out.println("\n=== 5. Byte Overflow Wrapping ===");
        int overflowVal = 130;
        byte overflowByte = (byte) overflowVal;
        System.out.println("130 cast to byte wraps around to: " + overflowByte);
    }
}
