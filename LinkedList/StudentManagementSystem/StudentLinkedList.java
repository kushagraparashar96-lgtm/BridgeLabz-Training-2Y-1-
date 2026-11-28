package LinkedList.StudentManagementSystem;

public class StudentLinkedList {

        private StudentNode head;


        public void addAtBeginning(int rollNumber, String name, int age, String grade) {
            StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
            newNode.next = head;
            head = newNode;
            System.out.println("Record added at the beginning.");
        }


        public void addAtEnd(int rollNumber, String name, int age, String grade) {
            StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
            if (head == null) {
                head = newNode;
                System.out.println("Record added as the first node.");
                return;
            }
            StudentNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            System.out.println("Record added at the end.");
        }


        public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
            if (position < 1) {
                System.out.println("Invalid position! Position must be >= 1.");
                return;
            }
            if (position == 1) {
                addAtBeginning(rollNumber, name, age, grade);
                return;
            }

            StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
            StudentNode temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }

            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Record added at position " + position + ".");
        }


        public void deleteByRollNumber(int rollNumber) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            if (head.rollNumber == rollNumber) {
                head = head.next;
                System.out.println("Student with Roll Number " + rollNumber + " deleted.");
                return;
            }

            StudentNode temp = head;
            while (temp.next != null && temp.next.rollNumber != rollNumber) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Student with Roll Number " + rollNumber + " not found.");
            } else {
                temp.next = temp.next.next;
                System.out.println("Student with Roll Number " + rollNumber + " deleted.");
            }
        }


        public void searchByRollNumber(int rollNumber) {
            StudentNode temp = head;
            while (temp != null) {
                if (temp.rollNumber == rollNumber) {
                    System.out.println("Record Found -> Roll No: " + temp.rollNumber +
                            ", Name: " + temp.name +
                            ", Age: " + temp.age +
                            ", Grade: " + temp.grade);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }


        public void displayAll() {
            if (head == null) {
                System.out.println("No student records available.");
                return;
            }

            System.out.println("\n--- Student Records ---");
            StudentNode temp = head;
            while (temp != null) {
                System.out.printf("Roll No: %d | Name: %s | Age: %d | Grade: %s%n",
                        temp.rollNumber, temp.name, temp.age, temp.grade);
                temp = temp.next;
            }
            System.out.println("-----------------------\n");
        }


        public void updateGrade(int rollNumber, String newGrade) {
            StudentNode temp = head;
            while (temp != null) {
                if (temp.rollNumber == rollNumber) {
                    temp.grade = newGrade;
                    System.out.println("Grade updated successfully for Roll Number " + rollNumber + ".");
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }




