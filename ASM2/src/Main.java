//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("\n" + "0: View \n" + "1: Add Student \n" + "2: Remove Student \n"
                    + "3: Sort by Grade \n" + "4: Search Student\n" + "5: Search Grade \n" + "6: Exit \n");
            System.out.print("\nEnter: ");
            int input = scanner.nextInt();
            if (input == 0) {
                printStudent();
            } else if (input == 1) {
                System.out.println("\nSo hoc sinh ");
                int num = scanner.nextInt();
                for (int i = 0; i < num; i++) {
                    addStudent();
                }
                System.out.println("\n" + "Add " + num + " Da them thanh cong!");
            } else if (input == 2) {
                System.out.println("Number of student: ");
                int num = scanner.nextInt();
                if (num <= Student.count) {
                    for (int i = 0; i < num; i++) {
                        removeStudent();
                    }
                }
                else{
                    System.out.println("Vui long nhan so nho hon!");
                }
            } else if (input == 3) {
                sortByGrade();
            } else if (input == 4) {
                searchStudent();
            } else if (input == 5) {
                searchGrade();
            } else if (input == 6) {
                System.out.println("Thoat chuong trinh.");
                break;
            }
        }
    }

    public static void addStudent() {
        scanner.nextLine();
        System.out.print("\n" + "Nhap ma hoc sinh: ");
        String code = scanner.nextLine();
        System.out.print("Nhap ten hoc sinh: ");
        String name = scanner.nextLine();
        System.out.print("Nhap tuoi: ");
        int age = scanner.nextInt();
        System.out.print("Nhap gioi tinh(1 neu ban la nam/2 neu ban la nu: ");
        int genderValue = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap dia chi nha: ");
        String address = scanner.nextLine();
        System.out.print("Nhap so lop cua ban: ");
        Double grade = scanner.nextDouble();

        Student student = new Student(code, name, age, genderValue, address, grade);
        Student.count += 1;
        studentList.add(student);

    }

    public static void removeStudent() {
        scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        System.out.print("\nNhap ma hoc sinh ban muon xoa: ");
        String code = scanner.nextLine();
        boolean removed = false;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCode().equals(code)) {
                iterator.remove();
                Student.count -= 1;
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("\nStudent with code " + code + " Ma hoc sinh da duoc xoa.");
        } else {
            System.out.println("\nKhong co ma hoc sinh nao duoc tim thay " + code);
        }

    }

    public static void sortByGrade() {
        Comparator<Student> compare = (s1, s2) -> s2.getGrade().compareTo(s1.getGrade());
        Collections.sort(studentList, compare);
        printStudent();
    }

    public static void searchStudent() {
        scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        List<Student> foundStudent = new ArrayList<>();
        System.out.print("\nNhap ma sinh vien hoac ten hoc sinh de tim: ");
        String search = scanner.nextLine();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals((search))){
                foundStudent.add(student);
            }
            if (student.getCode().equals(search)) {
                foundStudent.add(student);
            }
        }
        if (foundStudent.isEmpty()) {
            System.out.println("\nKhong hoc sinh duoc tim thay!");
        }
        else {
            for (Student s : foundStudent) {
                System.out.println(s.StudentToString());
            }
        }
    }
    public static void searchGrade() {
        scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        List<Student> foundStudent = new ArrayList<>();
        System.out.print("\nNhap lop de tim hoc sinh: ");
        Double search = scanner.nextDouble();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getGrade().equals(search)) {
                foundStudent.add(student);
            } else if (student.getGrade() > search) {
                foundStudent.add(student);
            }
        }
        if (foundStudent.isEmpty()) {
            System.out.println("\nKhong hoc sinh dc tim thay!");
        }
        else {
            for (Student s : foundStudent) {
                System.out.println(s.StudentToString());
            }
        }
    }

    public static void printStudent() {
        for (Student s : studentList) {
            System.out.println(s.StudentToString());
        }
    }
}