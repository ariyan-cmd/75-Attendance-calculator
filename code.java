import java.util.Scanner;

public class code {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of classes held: ");
        int totalClasses = sc.nextInt();

        System.out.print("Enter number of classes you have attended: ");
        int attendedClasses = sc.nextInt();

        System.out.print("Enter total number of classes in the semester (enter 0 if you don't know): ");
        int totalSemesterClasses = sc.nextInt();

        double currentPercentage = (attendedClasses * 100.0) / totalClasses;

        // CHECK IF ALLOWED
        if (currentPercentage >= 75) {
            System.out.println("You are allowed to sit in the exam.");

            // IF TOTAL SEMESTER CLASSES ARE KNOWN
            if (totalSemesterClasses != 0) {

                int skip = 0;

                while ((attendedClasses * 100.0) / (totalSemesterClasses + skip) >= 75) {
                    skip++;
                }

                System.out.println("You can skip " + (skip - 1) +
                        " more classes and still be allowed to sit in the exam.");
            }

            // IF TOTAL SEMESTER CLASSES ARE UNKNOWN
            else {
                int miss = 0;

                while ((attendedClasses * 100.0) / (totalClasses + miss) >= 75) {
                    miss++;
                }

                System.out.println("You cannot miss more than " + (miss - 1) +
                        " consecutive classes or you will be disallowed.");
            }
        }

        // IF NOT ALLOWED
        else {
            System.out.println("You are NOT allowed to sit in the exam.");

            // CALCULATE REQUIRED CLASSES TO REACH 75%
            int need = (int) Math.ceil((0.75 * totalClasses - attendedClasses) / 0.25);

            if (need < 0) need = 0;

            System.out.println("You need to attend at least " + need +
                    " more classes consecutively to reach 75% attendance.");
        }

        sc.close();
    }
}
