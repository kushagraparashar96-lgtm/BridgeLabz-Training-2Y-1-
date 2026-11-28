package LinkedList.inventoryManagementSystem;

public class ItemNode {

        String itemName;
        int itemId;
        int quantity;
        double price;
        ItemNode next;

        public ItemNode(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("ID: %-6d | Name: %-18s | Qty: %-5d | Price: ₹%-8.2f | Subtotal: ₹%.2f",
                    itemId, itemName, quantity, price, (quantity * price));
        }
    }

