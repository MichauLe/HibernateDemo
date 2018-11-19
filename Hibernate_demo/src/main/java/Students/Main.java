package Students;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student st = new Student(null,"Marian","Kowalski","123");
//        st.getImie();
//        System.out.println(st.getImie());

        System.out.println("wpisz imie");
        Scanner scanner = new Scanner(System.in);
        String plec = scanner.nextLine();
        System.out.println("podaj wiek");
        String nazwisko = scanner.nextLine();

        StudentDao std = new StudentDao();

        std.saveStudentInDatabase(st);
        System.out.println(std.getAllStudentsFromDatabase());
    }
}
