package Grade_Management_System;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class gradeSystem {
    private static String studentID;
    private static String name,Gradelv,Grade;
    private static int age;
    private static String[] studentIDs;
    static Scanner scan = new Scanner(System.in);

    gradeSystem(int arraySize, double loadFact) {
        studentIDs = new String[arraySize];
    }

    public enum GradeLevel {
        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR
    }

    static String filename = "student.txt";

    ArrayList<Integer> marks = new ArrayList<>();
    ArrayList<String> subject = new ArrayList<>();

    public static void systemProfile() {
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student Marks");
        System.out.println("5. Delete Student");
        System.out.println("6. Generate Grade Report");
        System.out.println("7. Calculate Class Statistics");
        System.out.println("8. Export Data to CSV");
        System.out.println("9. Exit");

    }

    public static void addStudent() throws IOException {

        // user inputs
        // ================================================================================================

        System.out.println("enter Your Student ID : ");
        studentID = scan.nextLine();
        scan.next();

        System.out.println("enter Your name : ");
        name = scan.nextLine();
        scan.next();

        System.out.println("enter Your age : ");
        age = scan.nextInt();

        System.out.print("enter Your grade fallowing category : ");
        System.out.print("[ ");
        for(int x=0; x<GradeLevel.values().length;x++){
            System.out.print(" ," + GradeLevel.values()[x]);
        }
        System.out.println(" ] :");
        Gradelv = scan.nextLine();
        scan.next();


        System.out.println("/t=============== ENTER SUBJECT MARKS ================");

        System.out.println("Enter Your maths mark : ");
        int mathMark = scan.nextInt();

        System.out.println("Enter Your maths mark : ");
        int scienceMark = scan.nextInt();

        System.out.println("Enter Your maths mark : ");
        int BioMark = scan.nextInt();
        scan.next();

        
        // validation
        // =================================================================================================

        double average = (mathMark + scienceMark + BioMark) / 3;

        for (int x = 0; x < studentID.length(); x++) {
            if (studentID.equals(studentIDs[x])) {
                System.out.println("That studentId already have taken...! please enter the new Student ID..!");
                break;
            } else if (x == studentID.length() - 1) {
                studentIDs[x] = studentID;
            }
        }

        if (age >= 5 || age <= 25) {
            System.out.println("You are the eligible student !");
        } else {
            System.out.println("You are a not eligibal student. please try again !");
        }

        if(average >= 75){
            Grade = "A";
        }else if (average >= 60) {
            Grade = "B";
        }else if (average >= 45) {
            Grade = "C";
        }else if (average >= 35) {
            Grade = "S";
        }else{
            Grade = "F";
        }

        // ====================================== DOCUMENET WRITE
        // ===================================

        FileWriter write = new FileWriter(filename);
        BufferedWriter buffer = new BufferedWriter(write);

        buffer.write(studentID + " |");
        buffer.write(name + " |");
        buffer.write(age + " |");
        buffer.write(mathMark + " |");
        buffer.write(BioMark + " |");
        buffer.write(scienceMark + " |");
        buffer.write(average + " |");
        buffer.write(Gradelv + " |");
        buffer.write(Grade + " |");
        buffer.write("-------------------------------------------------------------------------------------------------");

        System.out.println("Student Registration is Successfully..!");

    }

    public static void main(String[] args) throws IOException {

        gradeSystem g1 = new gradeSystem(50, 0.25);

        String fileName = "student.txt";

        FileReader read = new FileReader(fileName);
        BufferedReader buffer = new BufferedReader(read);

        String line;
        System.out.println("All contnet Line By line");
        while ((line = buffer.readLine()) != null) {
            System.out.println(line);
        }

        systemProfile();

        System.out.println("Enter Your Chooise : ");
        int chooiseValue = scan.nextInt();

        switch (chooiseValue) {
            case 1:
                addStudent();
                break;

            default:
                break;
        }
    }
}
