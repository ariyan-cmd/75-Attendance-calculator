import java.util.Scanner;

public class code{
    public static void main(String[] args) {
        // creating 3 scanner objects to take input from user (like total classes, attended classes and total semester classes)
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        System.out.print("Enter total number of classes held: ");
        int totalClasses = a.nextInt(); // total classes held
        System.out.println("Enter number of classes you have attended: ");
        int attendedClasses = b.nextInt(); // classes attended by student
        System.out.print("Enter total number of classes in the semester(enter 0 if you don't know): ");
        int totalSemesterClasses = c.nextInt(); // total classes in the semester
        // this block is if you are allowed to sit in exam
        if(attendedClasses/totalClasses >= 0.75){
            System.out.print("You are allowed to sit in the exam.");
            // this block is to calculate how many classes you can skip
            if(totalSemesterClasses != 0){
                double skip = 1;
                if(attendedClasses/totalSemesterClasses >= 0.75){
                    System.out.println("you can skip all remaining classes.");
                }
                if(attendedClasses/totalSemesterClasses <0.75){
                    while((attendedClasses + skip)/(totalSemesterClasses) < 0.75){
                        skip++;
                    }
                }
                System.out.println("You can skip " + Integer.valueOf((int)(skip-1)) + " classes and still be allowed to sit in the exam.");
            }
            if(totalSemesterClasses == 0){
                double days = 1;
                while((attendedClasses)/(totalClasses + days) < 0.75){
                    days++;
                }
                System.out.println("You cannot skip more than "+ Integer.valueOf((int)(days-1)) + " classes consecutively or you will be disallowed to sit in the exam.");
            }
        }
        if(attendedClasses/totalClasses < 0.75){
            System.out.print("You are not allowed to sit in the exam.");
            if(totalSemesterClasses != 0){
                double per = totalSemesterClasses / 0.75;
                double need = per - totalClasses;
                System.out.println("You need to attend " + Integer.valueOf((int)(need)) + " more classes to be allowed to sit in the exam.");
            }
            if(totalSemesterClasses == 0){
                double skipp = 1;
                while((attendedClasses+ skipp)/(totalClasses + skipp) < 0.75){
                    skipp++;
                }
                System.out.println("You need to attend " + Integer.valueOf((int)(skipp)) + " consecutive classes to be go overr 75% attendance");
            }
        }

    }
}