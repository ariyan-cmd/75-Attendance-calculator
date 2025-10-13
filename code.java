import java.util.Scanner;

public class code {
    public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    while (true) { 
        double extra = 1;
        double more = 1;
        System.out.print("Enter total number of classes held: ");
        double held = Double.valueOf(read.nextLine());
        System.out.print("Enter the total number of classes attended by you: ");
        double attended = Double.valueOf(read.nextLine());
        if((attended/held)<0.75){
            System.out.println("You are debarred");
            while(true){
                if((attended+more)/(held+more)>=0.75){
                    System.out.println("You will need to attend "+more+" days to sit in examination.");
                    break;
                }
                else{
                    more = more + 1;
                    
                }
            }
        }
        else if((attended/held)>=0.75){
            while(true){
                if(attended/(held+extra)<=0.75){

                    System.out.println("You cannot be absent for "+extra+" days, or you will get debarred");
                    break;
                }
                else{
                    extra = extra+1;
                    
                }
            }
        }
    }
    }
}
    
