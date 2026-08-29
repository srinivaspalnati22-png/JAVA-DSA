/**
 * 09. Conditionals in Java - Runnable Demonstration
 */
public class ConditionalsDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. Simple if & if-else ===");
        int age = 20;
        if (age >= 18) {
            System.out.println("Age " + age + ": Eligible to Vote");
        } else {
            System.out.println("Age " + age + ": Not Eligible to Vote");
        }

        System.out.println("\n=== 2. else-if Ladder ===");
        int marks = 82;
        if (marks >= 90) {
            System.out.println("Marks " + marks + " -> Grade A");
        } else if (marks >= 75) {
            System.out.println("Marks " + marks + " -> Grade B");
        } else if (marks >= 50) {
            System.out.println("Marks " + marks + " -> Grade C");
        } else {
            System.out.println("Marks " + marks + " -> Fail");
        }

        System.out.println("\n=== 3. Ternary Operator (?:) ===");
        int a = 15, b = 25;
        int max = (a > b) ? a : b;
        System.out.println("Max of " + a + " and " + b + " is: " + max);

        System.out.println("\n=== 4. Switch Statement ===");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Day 1: Monday");
                break;
            case 2:
                System.out.println("Day 2: Tuesday");
                break;
            case 3:
                System.out.println("Day 3: Wednesday");
                break;
            default:
                System.out.println("Day " + day + ": Other Day");
        }
    }
}
