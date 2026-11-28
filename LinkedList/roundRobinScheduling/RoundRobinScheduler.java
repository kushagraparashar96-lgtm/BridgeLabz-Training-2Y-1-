package LinkedList.roundRobinScheduling;

import java.util.Scanner;

public class RoundRobinScheduler {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            RoundRobinCircularList scheduler = new RoundRobinCircularList();
            int choice;

            do {
                System.out.println("\n=== Round Robin CPU Scheduling System ===");
                System.out.println("1. Add New Process at End");
                System.out.println("2. Remove Process by Process ID");
                System.out.println("3. Display Current Process Queue");
                System.out.println("4. Simulate Round Robin Scheduling");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Process ID: ");
                        int pid = sc.nextInt();
                        System.out.print("Enter Burst Time: ");
                        int burst = sc.nextInt();
                        System.out.print("Enter Priority: ");
                        int priority = sc.nextInt();
                        scheduler.addProcessAtEnd(pid, burst, priority);
                        break;

                    case 2:
                        System.out.print("Enter Process ID to remove: ");
                        scheduler.removeProcessById(sc.nextInt());
                        break;

                    case 3:
                        System.out.println("\n--- Current Circular Queue ---");
                        scheduler.displayProcesses();
                        break;

                    case 4:
                        System.out.print("Enter Fixed Time Quantum: ");
                        int quantum = sc.nextInt();
                        scheduler.simulateRoundRobin(quantum);
                        break;

                    case 0:
                        System.out.println("Exiting Scheduler...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 0);

            sc.close();
        }
    }
