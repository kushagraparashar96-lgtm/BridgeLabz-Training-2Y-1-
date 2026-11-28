package LinkedList.movieManagementSystem;

import java.util.Scanner;

public class MovieManagementSystem {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n=== Movie Management System ===");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Display All Movies (Forward)");
            System.out.println("8. Display All Movies (Reverse)");
            System.out.println("9. Update Movie Rating by Title");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    int pos = 0;
                    if (choice == 3) {
                        System.out.print("Enter position (1-based): ");
                        pos = sc.nextInt();
                        sc.nextLine();
                    }
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Release Year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating (0.0 - 10.0): ");
                    double rating = sc.nextDouble();
                    sc.nextLine();

                    if (choice == 1) movieList.addAtBeginning(title, director, year, rating);
                    else if (choice == 2) movieList.addAtEnd(title, director, year, rating);
                    else movieList.addAtPosition(pos, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Enter Movie Title to remove: ");
                    movieList.removeByTitle(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Director name to search: ");
                    movieList.searchByDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Rating to search: ");
                    movieList.searchByRating(sc.nextDouble());
                    sc.nextLine();
                    break;

                case 7:
                    movieList.displayForward();
                    break;

                case 8:
                    movieList.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter Movie Title to update: ");
                    String updateTitle = sc.nextLine();
                    System.out.print("Enter new Rating: ");
                    double newRating = sc.nextDouble();
                    sc.nextLine();
                    movieList.updateRating(updateTitle, newRating);
                    break;

                case 0:
                    System.out.println("Exiting Movie Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
