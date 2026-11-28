package LinkedList.inventoryManagementSystem;

public class InventorySinglyLinkedList {

        private ItemNode head;
        private int size;

        public InventorySinglyLinkedList() {
            this.head = null;
            this.size = 0;
        }

        // 1. Add at Beginning
        public void addAtBeginning(String name, int id, int qty, double price) {
            ItemNode newNode = new ItemNode(name, id, qty, price);
            newNode.next = head;
            head = newNode;
            size++;
            System.out.println("Item added at the beginning.");
        }

        // 1. Add at End
        public void addAtEnd(String name, int id, int qty, double price) {
            ItemNode newNode = new ItemNode(name, id, qty, price);
            if (head == null) {
                head = newNode;
            } else {
                ItemNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
            System.out.println("Item added at the end.");
        }

        // 1. Add at Specific Position (1-based index)
        public void addAtPosition(int position, String name, int id, int qty, double price) {
            if (position < 1 || position > size + 1) {
                System.out.println("Invalid position! Valid range: 1 to " + (size + 1));
                return;
            }
            if (position == 1) {
                addAtBeginning(name, id, qty, price);
                return;
            }

            ItemNode newNode = new ItemNode(name, id, qty, price);
            ItemNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
            System.out.println("Item added at position " + position + ".");
        }

        // 2. Remove an item based on Item ID
        public void removeById(int id) {
            if (head == null) {
                System.out.println("Inventory is empty.");
                return;
            }
            if (head.itemId == id) {
                System.out.println("Removed item: " + head.itemName);
                head = head.next;
                size--;
                return;
            }

            ItemNode current = head;
            while (current.next != null && current.next.itemId != id) {
                current = current.next;
            }

            if (current.next == null) {
                System.out.println("Item with ID " + id + " not found.");
            } else {
                System.out.println("Removed item: " + current.next.itemName);
                current.next = current.next.next;
                size--;
            }
        }

        // 3. Update quantity of an item by Item ID
        public void updateQuantity(int id, int newQty) {
            ItemNode current = head;
            while (current != null) {
                if (current.itemId == id) {
                    current.quantity = newQty;
                    System.out.println("Updated quantity for '" + current.itemName + "' to " + newQty + ".");
                    return;
                }
                current = current.next;
            }
            System.out.println("Item with ID " + id + " not found.");
        }

        // 4a. Search by Item ID
        public void searchById(int id) {
            ItemNode current = head;
            while (current != null) {
                if (current.itemId == id) {
                    System.out.println("\n--- Item Found ---\n" + current);
                    return;
                }
                current = current.next;
            }
            System.out.println("No item found with ID " + id + ".");
        }

        // 4b. Search by Item Name
        public void searchByName(String name) {
            boolean found = false;
            ItemNode current = head;
            System.out.println("\n--- Search Results for: " + name + " ---");
            while (current != null) {
                if (current.itemName.equalsIgnoreCase(name)) {
                    System.out.println(current);
                    found = true;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("No item found with name '" + name + "'.");
            }
        }

        // 5. Calculate and display total value of inventory
        public void calculateTotalValue() {
            if (head == null) {
                System.out.println("Inventory is empty. Total Value: ₹0.00");
                return;
            }
            double totalValue = 0;
            ItemNode current = head;
            while (current != null) {
                totalValue += current.price * current.quantity;
                current = current.next;
            }
            System.out.printf("Total Inventory Value: ₹%.2f%n", totalValue);
        }

        // 6. Sort inventory using Merge Sort
        public void sortInventory(boolean sortByName, boolean ascending) {
            if (head == null || head.next == null) {
                System.out.println("Inventory sorted.");
                return;
            }
            head = mergeSort(head, sortByName, ascending);
            System.out.println("Inventory sorted by " + (sortByName ? "Name" : "Price") +
                    " (" + (ascending ? "Ascending" : "Descending") + ").");
        }

        private ItemNode mergeSort(ItemNode node, boolean sortByName, boolean ascending) {
            if (node == null || node.next == null) {
                return node;
            }

            ItemNode middle = getMiddle(node);
            ItemNode nextOfMiddle = middle.next;
            middle.next = null;

            ItemNode left = mergeSort(node, sortByName, ascending);
            ItemNode right = mergeSort(nextOfMiddle, sortByName, ascending);

            return sortedMerge(left, right, sortByName, ascending);
        }

        private ItemNode sortedMerge(ItemNode a, ItemNode b, boolean sortByName, boolean ascending) {
            if (a == null) return b;
            if (b == null) return a;

            int comparison;
            if (sortByName) {
                comparison = a.itemName.compareToIgnoreCase(b.itemName);
            } else {
                comparison = Double.compare(a.price, b.price);
            }

            boolean pickA = ascending ? (comparison <= 0) : (comparison >= 0);
            ItemNode result;

            if (pickA) {
                result = a;
                result.next = sortedMerge(a.next, b, sortByName, ascending);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next, sortByName, ascending);
            }
            return result;
        }

        private ItemNode getMiddle(ItemNode node) {
            if (node == null) return null;
            ItemNode slow = node, fast = node;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // Display all items
        public void displayInventory() {
            if (head == null) {
                System.out.println("Inventory is empty.");
                return;
            }
            System.out.println("\n--- Current Inventory ---");
            ItemNode current = head;
            int index = 1;
            while (current != null) {
                System.out.println(index++ + ". " + current);
                current = current.next;
            }
        }
    }
