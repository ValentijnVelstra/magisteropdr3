package nl.valentijn;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

class Mentor {
    String name;
    int age;
    String phonenr;
    String email;
    String adress;
    String city;
    int employeenr;

    public Mentor(String name, int age, String phonenr, String email, String adress, String city, int employeenr) {
        this.name = name;
        this.age = age;
        this.phonenr = phonenr;
        this.email = email;
        this.adress = adress;
        this.city = city;
        this.employeenr = employeenr;
    }
}
class Student {
    String Studentname;
    int Studentage;
    String Studentphonenr;
    String Studentemail;
    String Studentadress;
    String Studentcity;
    int studentnr;

    public Student(String Studentname, int Studentage, String Studentphonenr, String Studentemail, String Studentadress, String Studentcity, int studentnr) {
        this.Studentname = Studentname;
        this.Studentage = Studentage;
        this.Studentphonenr = Studentphonenr;
        this.Studentemail = Studentemail;
        this.Studentadress = Studentadress;
        this.Studentcity = Studentcity;
        this.studentnr = studentnr;
    }
}
class addclassroom {
    String nameclass;
    Mentor mentor;
    Student Student;

    public addclassroom(String nameclass, Mentor mentor) {
        this.nameclass = nameclass;
        this.mentor = mentor;
        this.Student = Student;
    }

}


public class Main {
    static List<Mentor> mentors = new ArrayList<>();
    static List<Student> Students = new ArrayList<>();
    static List<addclassroom> classRooms = new ArrayList<>();

    static public void addClassroom(String name, Mentor mentor, Student studentfound1){
        addclassroom addclassroom1 = new addclassroom(name, mentor);
        classRooms.add(addclassroom1);
    }

    public static void main(String[] args) {
        while (true) {
            Scanner optie = new Scanner(System.in);  // Create a Scanner object
            System.out.println(""" 
                    Choose: 1. Add a Mentor 
                            2. Remove a Mentor 
                            3. Mentor list 
                            4. Add a class
                            5. Remove a class 
                            6. Add a student 
                            7. Remove a student
                    """);
            Integer choice = optie.nextInt();  // input lezen welke keuze in het menu word gemaakt.
            Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
            Pattern names = Pattern.compile("[a-zA-Z]{1,}");
            Pattern ages = Pattern.compile("[0-9]{2,}");
            Pattern phones = Pattern.compile("[0-9-+]+[-]{1,}+[0-9]{8,}");
            Pattern adresspattern = Pattern.compile("[a-zA-Z]+[\\s]+[0-9␣]+[\\s]+[0-9]{4,}+[a-zA-Z]{2,}");

            switch (choice) { //de switch kijkt welke menu keuze is gamaakt
                case 1:  // case kijkt naar de waarde 1
                    Scanner addMentor = new Scanner(System.in);

                    System.out.println("Naam: ");
                    while(!addMentor.hasNext(names)) {
                        System.out.println("Please enter a valid name: ");
                        addMentor.next();
                    }
                    String name = addMentor.next(); // hier worden de inputs strings enz aangemaakt die later in de mentor array list worden gezet

                    System.out.println("Leeftijd: ");
                    while(!addMentor.hasNext(ages)) {
                        System.out.println("Please enter a valid age: ");
                        addMentor.next();
                    }
                    int age = addMentor.nextInt();

                    System.out.println("Phone : ");
                    while(!addMentor.hasNext(phones)) {
                        System.out.println("Please enter a valid phone number (xx-xxxxxxxx): ");
                        addMentor.next();
                    }
                    String phonenr = addMentor.next();

                    System.out.println("Email: ");
                    while(!addMentor.hasNext(emailPattern)) {
                        System.out.println("Please enter a valid email address: ");
                        addMentor.nextLine();
                    }
                    String email = addMentor.next(emailPattern);

                    System.out.println("Adress: ");
                    while(!addMentor.hasNext()) {
                        System.out.println("Please enter a valid adress: ");
                        addMentor.nextLine();
                    }
                    String adress = addMentor.next();

                    System.out.println("City: ");
                    while(!addMentor.hasNext(names)) {
                        System.out.println("Please enter a valid city: ");
                        addMentor.next();
                    }
                    String city = addMentor.next();

                    System.out.println("Employee Number: ");
                    while(!addMentor.hasNext(ages)) {
                        System.out.println("Please enter a valid employee number: ");
                        addMentor.next();
                    }
                    int employeenr = addMentor.nextInt();

                    Mentor mentor1 = new Mentor(name, age, phonenr, email, adress, city, employeenr);
                    mentors.add(mentor1); // voegt de lijst toe aan de array mentors door een nieuwe mentor aan te maken met de bestaande gegevens

                    break; // voorkomt dat de andere cases af gaan.
                case 2:
                    Scanner remover = new Scanner(System.in);  // scanner kijkt naar de naam om het te verweideren
                    System.out.println("Name: ");
                    String Remove_name = remover.next();
                    Mentor mentorfound = null; // null geeft het een waarde

                    for (Mentor mentor : mentors) {  //for loop om door de bestaande mentoren te kijken
                        if (mentor.name.equals(Remove_name)) {
                            mentorfound = mentor; // dit maakt een extra mentor aan die we kunnen zoeken buiten de for loop
                            break;
                        }
                    }
                    mentors.remove(mentorfound); // staat buiten de for loop, loop moet eerst zoeken en daarna word mentor found gebruikt om de juiste te verweideren

                    for (addclassroom classRoom : classRooms) {  //for loop om door de bestaande mentoren te kijken
                        if (classRoom.mentor.equals(mentorfound)) {
                            classRoom.mentor = null; // dit maakt een extra mentor aan die we kunnen zoeken buiten de for loop
                            break;
                        }
                    }

                    break;
                case 3:
                    for (Mentor mentor : mentors) {  // for loop die ons door alle mentoren in de arraylist laat gaan
                        System.out.println("Name:      " + mentor.name);
                        System.out.println("Age:        " + mentor.age);
                        System.out.println("Phone:       " + mentor.phonenr);
                        System.out.println("Email:        " + mentor.email);
                        System.out.println("Adress:        " + mentor.adress);
                        System.out.println("City:           " + mentor.city);
                        System.out.println("Employee Number: " + mentor.employeenr);
                        System.out.println("================");
                    }

                    break;
                case 4:
                    Scanner addClass = new Scanner(System.in);

                    Mentor mentorfound1 = null;

                    System.out.println("Class name: ");
                    String nameclass = addClass.next(); // hier worden de inputs strings enz aangemaakt die later in de mentor array list worden gezet

                    System.out.println("Mentor name: ");
                    String checkmentor = addClass.next();
                    while(Objects.isNull(mentorfound1)) {
                        for (Mentor mentor : mentors) {  //for loop om door de bestaande mentoren te kijken
                            if (mentor.name.equals(checkmentor)) {
                                mentorfound1 = mentor; // dit maakt een extra mentor aan die we kunnen zoeken buiten de for loop
                                break;
                            }
                        }
                        if (Objects.isNull(mentorfound1)) {
                            System.out.println("Mentor name not found");
                            checkmentor = addClass.next();
                        }
                    }
                    Student studentfound1 = null;

                    System.out.println("Student name: ");
                    String checkstudent = addClass.next();
                    while(Objects.isNull(studentfound1)) {
                        for (Student student : Students) {  //for loop om door de bestaande mentoren te kijken
                            if (student.Studentname.equals(checkstudent)) {
                                studentfound1 = student; // dit maakt een extra mentor aan die we kunnen zoeken buiten de for loop
                                break;
                            }
                        }
                        if (Objects.isNull(studentfound1)) {
                            System.out.println("Student name not found");
                            checkstudent = addClass.next();
                        }
                    }
                    addClassroom(nameclass, mentorfound1, studentfound1);
                    break;
                case 5:
                    for (addclassroom classroom : classRooms) {  // for loop die ons door alle mentoren in de arraylist laat gaan
                        System.out.println("Class name:      " + classroom.nameclass); //classroom word hier gebruikt als variabele binnen de loop
                        System.out.println("Mentor name:      " + classroom.mentor.name);
                        System.out.println("Student name:      " + classroom.Student.Studentname);
                    }
                    break;
                case 6:
                    Scanner addstudent = new Scanner(System.in);

                    System.out.println("Naam: ");
                    while(!addstudent.hasNext(names)) {
                        System.out.println("Please enter a valid name: ");
                        addstudent.next();
                    }
                    String Studentname = addstudent.next(); // hier worden de inputs strings enz aangemaakt die later in de mentor array list worden gezet

                    System.out.println("Leeftijd: ");
                    while(!addstudent.hasNext(ages)) {
                        System.out.println("Please enter a valid age: ");
                        addstudent.next();
                    }
                    int Studentage = addstudent.nextInt();

                    System.out.println("Phone : ");
                    while(!addstudent.hasNext(phones)) {
                        System.out.println("Please enter a valid phone number (xx-xxxxxxxx): ");
                        addstudent.next();
                    }
                    String Studentphonenr = addstudent.next();

                    System.out.println("Email: ");
                    while(!addstudent.hasNext(emailPattern)) {
                        System.out.println("Please enter a valid email address: ");
                        addstudent.nextLine();
                    }
                    String Studentemail = addstudent.next(emailPattern);

                    System.out.println("Adress: ");
                    while(!addstudent.hasNext()) {
                        System.out.println("Please enter a valid adress: ");
                        addstudent.nextLine();
                    }
                    String Studentadress = addstudent.next();

                    System.out.println("City: ");
                    while(!addstudent.hasNext(names)) {
                        System.out.println("Please enter a valid city: ");
                        addstudent.next();
                    }
                    String Studentcity = addstudent.next();

                    System.out.println("Student Number: ");
                    while(!addstudent.hasNext(ages)) {
                        System.out.println("Please enter a valid student number: ");
                        addstudent.next();
                    }
                    int Studentnr = addstudent.nextInt();

                    Student Student1 = new Student(Studentname, Studentage, Studentphonenr, Studentemail, Studentadress, Studentcity, Studentnr);
                    Students.add(Student1);

                    break;
                case 7:

                    break;
            }
        }
    }
}