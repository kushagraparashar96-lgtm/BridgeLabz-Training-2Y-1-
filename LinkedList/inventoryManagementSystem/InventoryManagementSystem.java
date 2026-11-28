package LinkedList.inventoryManagementSystem;

import java.util.Scanner;

public class InventoryManagementSystem {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            InventorySinglyLinkedList inventory = new InventorySinglyLinkedList();
            int choice;

            do {
                System.out.println("\n=== Inventory Management System ===");
                System.out.println("1. Add Item at Beginning");
                System.out.println("2. Add Item at End");
                System.out.println("3. Add Item at Specific Position");
                System.out.println("4. Remove Item by ID");
                System.out.println("5. Update Item Quantity by ID");
                System.out.println("6. Search Item by ID");
                System.out.println("7. Search Item by Name");
                System.out.println("8. Calculate Total Inventory Value");
                System.out.println("9. Sort Inventory (Name / Price)");
                System.out.println("10. Display All Items");
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
                        System.out.print("Enter Item Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Item ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        if (choice == 1) inventory.addAtBeginning(name, id, qty, price);
                        else if (choice == 2) inventory.addAtEnd(name, id, qty, price);
                        else inventory.addAtPosition(pos, name, id, qty, price);
                        break;

                    case 4:
                        System.out.print("Enter Item ID to remove: ");
                        inventory.removeById(sc.nextInt());
                        sc.nextLine();
                        break;

                    case 5:
                        System.out.print("Enter Item ID to update: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new Quantity: ");
                        int newQty = sc.nextInt();
                        sc.nextLine();
                        inventory.updateQuantity(updateId, newQty);
                        break;

                    case 6:
                        System.out.print("Enter Item ID to search: ");
                        inventory.searchById(sc.nextInt());
                        sc.nextLine();
                        break;

                    case 7:
                        System.out.print("Enter Item Name to search: ");
                        inventory.searchByName(sc.nextLine());
                        break;

                    case 8:
                        inventory.calculateTotalValue();
                        break;

                    case 9:
                        System.out.print("Sort by (1 for Item Name, 2 for Price): ");
                        int criteria = sc.nextInt();
                        System.out.print("Order (1 for Ascending, 2 for Descending): ");
                        int order = sc.nextInt();
                        sc.nextLine();
                        inventory.sortInventory(criteria == 1, order == 1);
                        inventory.displayInventory();
                        break;

                    case 10:
                        inventory.displayInventory();
                        break;

                    case 0:
                        System.out.println("Exiting Inventory Management System...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 0);

            sc.close();
        }
    }

