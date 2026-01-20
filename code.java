import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        System.out.print("Enter total number of classes held: ");
        int totalClasses = a.nextInt();
        System.out.print("Enter number of classes attended: ");
        int attendedClasses = b.nextInt();
        System.out.print("Enter total number of classes for the semester(input 0 if you dont know): ");
        int totalSemesterClasses = c.nextInt();
        int extra = 1;
        if(attendedClasses/totalClasses >= 0.75){
            System.out.println("You are allowed to sit in the exams.");
            Scanner d = new Scanner(System.in);
            System.out.println("Do you want to calculate how many classes you can miss without getting debarred? Type(y/n)");
            String response = d.nextLine();
            if(response.equals("y")){
                if(totalSemesterClasses == 0){
                    for(extra = 1; ; extra++){
                        if((attendedClasses)/(totalClasses + extra) < 0.75){
                            break;
                        }
                    }
                    System.out.println("Since you don't Know the total number of classes for the semester, you can skip " + extra + " classes.");
                }
                else{
                    if(totalClasses != attendedClasses && attendedClasses/totalSemesterClasses < 0.75){
                        for(extra = 1; totalClasses + extra <= totalSemesterClasses; extra++){
                            if((attendedClasses)/(totalClasses + extra) < 0.75){
                                break;
                            }
                        }
                        System.out.println("You can skip " + (extra - 1) + " classes without getting debarred.");
                    }
                    else{
                        System.out.println("You can skip all remaining classes without getting debarred.");
                    }
                }
            }
            else{
                System.out.println("Have a nice day!");
            }
        }
        else{
            System.out.println("You are not allowed to sit in the exams.");
            Scanner e = new Scanner(System.in);
            System.out.println("Do you want to calculate how many classes you need to attend to be allowed to sit in the exams? Type(y/n)");
            String response2 = e.nextLine();
            if(response2.equals("y")){
                int needToAttend = 0;
                if(totalSemesterClasses == 0){
                    for (needToAttend = 1; ; needToAttend++) {
                        if ((attendedClasses + needToAttend) / (totalClasses + needToAttend) >= 0.75) {
                            break;
                        }
                    }
                    System.out.println("Since you don't know the total number of classes for the semester, hypothetically you have to attend " + needToAttend + " more classes to get above 75% attendance and be allowed to sit in the exams.");
                }
                else{
                    for (needToAttend = 1; totalClasses + needToAttend <= totalSemesterClasses; needToAttend++) {
                        if ((attendedClasses + needToAttend) / (totalClasses + needToAttend) >= 0.75) {
                            break;
                        }
                    }
                    if(totalClasses + needToAttend > totalSemesterClasses){
                        System.out.println("Even if you attend all remaining classes, you will not be able to reach 75% attendance.");
                    }
                    else{
                        System.out.println("You need to attend " + needToAttend + " more classes to be allowed to sit in the exams.");
                    }
                }
            }
            else{
                System.out.println("Have a nice day!");
            }
        }
    }
}