import java.util.Scanner;

public class HelloTester {

    public static void main(String[] args){

        //1.Initialize
        int StudentTotal;
        int StudentGrade;
        int Max_Total =500;
        int Max_Grade = 200;

        //2.Get Input
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the Total Mark of the Student");
        StudentTotal = input.nextInt();

        System.out.println("Please Enter the Total Grade of the Student");
        StudentGrade = input.nextInt();


        //3. Process
            float MarkPercentage = (float) StudentTotal / Max_Total * 100 ;
            float Gradepercentage = (float) StudentGrade / Max_Grade * 100;


        //4. Print Output

           System.out.println("Student Total Mark = " +StudentTotal);
           System.out.println("Student Total Grade = " +StudentGrade);
           System.out.println("Student Mark Percentage = " +MarkPercentage);
           System.out.println("Student Grade Percentage = " +Gradepercentage);




    }
}
