package LinkedList.StudentManagementSystem;

import java.util.Scanner;

public class StudentRecordManagement {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StudentLinkedList list = new StudentLinkedList();

            while (true) {
                System.out.println("\n1. Add at Beginning");
                System.out.println("2. Add at End");
                System.out.println("3. Add at Specific Position");
                System.out.println("4. Delete by Roll Number");
                System.out.println("5. Search by Roll Number");
                System.out.println("6. Display All Records");
                System.out.println("7. Update Grade");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                if (choice == 8) break;

                int roll, age, pos;
                String name, grade;

                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                        pos = 0;
                        if (choice == 3) {
                            System.out.print("Enter Position (1-based): ");
                            pos = sc.nextInt();
                        }
                        System.out.print("Enter Roll Number: ");
                        roll = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        age = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter Grade: ");
                        grade = sc.nextLine();

                        if (choice == 1) list.addAtBeginning(roll, name, age, grade);
                        else if (choice == 2) list.addAtEnd(roll, name, age, grade);
                        else list.addAtPosition(pos, roll, name, age, grade);
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to delete: ");
                        list.deleteByRollNumber(sc.nextInt());
                        break;

                    case 5:
                        System.out.print("Enter Roll Number to search: ");
                        list.searchByRollNumber(sc.nextInt());
                        break;

                    case 6:
                        list.displayAll();
                        break;

                    case 7:
                        System.out.print("Enter Roll Number to update: ");
                        roll = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter New Grade: ");
                        grade = sc.nextLine();
                        list.updateGrade(roll, grade);
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
            sc.close();
        }
    }







