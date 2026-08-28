package STRINGS;

/**
 * StringConcepts.java
 * Comprehensive runnable demonstration of Java String fundamentals:
 * 1. Creation: Literal syntax vs new keyword & String Constant Pool (SCP)
 * 2. Immutability demonstration
 * 3. Comparing Strings: == vs equals() vs equalsIgnoreCase() vs compareTo()
 * 4. Common built-in String methods (length, charAt, case conversion, substrings, replacement, trim)
 * 5. String vs StringBuilder vs StringBuffer
 */
public class StringConcepts {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            JAVA STRINGS DEMONSTRATION            ");
        System.out.println("==================================================");

        // --- 1. Literal Syntax vs 'new' Keyword & String Pool ---
        System.out.println("\n[1] STRING CREATION & MEMORY ALLOCATION:");
        String s1 = "Hello";               // Placed in String Constant Pool
        String s2 = "Hello";               // Reuses same object from Pool
        String s3 = new String("Hello");   // Creates new object in Heap

        System.out.println("s1 = \"Hello\" (Literal)");
        System.out.println("s2 = \"Hello\" (Literal)");
        System.out.println("s3 = new String(\"Hello\")");
        System.out.println("s1 == s2 (Same Pool reference?): " + (s1 == s2)); // true
        System.out.println("s1 == s3 (Same Heap reference?): " + (s1 == s3)); // false
        System.out.println("s1.equals(s3) (Same content?): " + s1.equals(s3)); // true

        // --- 2. String Immutability ---
        System.out.println("\n[2] STRING IMMUTABILITY:");
        String lang = "Java";
        System.out.println("Original string: " + lang);
        lang.concat(" DSA"); // Attempt modification without reassigning
        System.out.println("After lang.concat(\" DSA\"): " + lang + " (Unchanged due to immutability!)");
        lang = lang.concat(" DSA"); // Reassigned to a newly created String object
        System.out.println("After lang = lang.concat(\" DSA\"): " + lang + " (Points to new object)");

        // --- 3. Comparing Strings The Right Way ---
        System.out.println("\n[3] STRING COMPARISON:");
        String a = "Java";
        String b = new String("Java");
        String c = "JAVA";

        System.out.println("Using == (Reference comparison): " + (a == b));                  // false
        System.out.println("Using equals() (Content comparison): " + a.equals(b));             // true
        System.out.println("Using equalsIgnoreCase(): " + a.equalsIgnoreCase(c));            // true
        System.out.println("Using compareTo(): " + a.compareTo("Java"));                     // 0

        // --- 4. Built-in String Methods ---
        System.out.println("\n[4] COMMON STRING METHODS:");
        String sample = "  Java DSA Masterclass  ";
        System.out.println("Original sample: \"" + sample + "\"");
        System.out.println("length(): " + sample.length());
        System.out.println("trim(): \"" + sample.trim() + "\"");
        System.out.println("charAt(4): '" + sample.charAt(4) + "'");
        System.out.println("toUpperCase(): \"" + sample.trim().toUpperCase() + "\"");
        System.out.println("toLowerCase(): \"" + sample.trim().toLowerCase() + "\"");
        System.out.println("contains(\"DSA\"): " + sample.contains("DSA"));
        System.out.println("replace(\"Java\", \"Python\"): \"" + sample.trim().replace("Java", "Python") + "\"");
        System.out.println("substring(2, 6): \"" + sample.substring(2, 6) + "\"");
        System.out.println("startsWith(\"  Java\"): " + sample.startsWith("  Java"));
        System.out.println("endsWith(\"class  \"): " + sample.endsWith("class  "));

        // --- 5. StringBuilder & StringBuffer (Mutable Alternatives) ---
        System.out.println("\n[5] STRINGBUILDER (FAST & MUTABLE):");
        StringBuilder sb = new StringBuilder();
        sb.append("Java");
        sb.append(" DSA");
        System.out.println("StringBuilder append: " + sb);

        sb.insert(4, " &");
        System.out.println("StringBuilder insert: " + sb);

        sb.reverse();
        System.out.println("StringBuilder reverse: " + sb);
        sb.reverse(); // reverse back

        sb.delete(4, 6);
        System.out.println("StringBuilder delete: " + sb);

        // Convert back to String
        String finalStr = sb.toString();
        System.out.println("Converted to String: " + finalStr);
    }
}
