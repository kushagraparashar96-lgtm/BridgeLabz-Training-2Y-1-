package LinkedList.movieManagementSystem;

public class MovieDoublyLinkedList {

        private MovieNode head;
        private MovieNode tail;
        private int size;

        public MovieDoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void addAtBeginning(String title, String director, int year, double rating) {
            MovieNode newNode = new MovieNode(title, director, year, rating);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
            System.out.println("Movie added at the beginning.");
        }

        public void addAtEnd(String title, String director, int year, double rating) {
            MovieNode newNode = new MovieNode(title, director, year, rating);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
            System.out.println("Movie added at the end.");
        }

        public void addAtPosition(int position, String title, String director, int year, double rating) {
            if (position < 1 || position > size + 1) {
                System.out.println("Invalid position! Valid range: 1 to " + (size + 1));
                return;
            }
            if (position == 1) {
                addAtBeginning(title, director, year, rating);
                return;
            }
            if (position == size + 1) {
                addAtEnd(title, director, year, rating);
                return;
            }

            MovieNode newNode = new MovieNode(title, director, year, rating);
            MovieNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
            System.out.println("Movie added at position " + position + ".");
        }

        public void removeByTitle(String title) {
            if (head == null) {
                System.out.println("List is empty. Nothing to remove.");
                return;
            }

            MovieNode current = head;
            while (current != null) {
                if (current.title.equalsIgnoreCase(title)) {
                    if (current == head && current == tail) {
                        head = tail = null;
                    } else if (current == head) {
                        head = head.next;
                        head.prev = null;
                    } else if (current == tail) {
                        tail = tail.prev;
                        tail.next = null;
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    size--;
                    System.out.println("Removed movie: " + current.title);
                    return;
                }
                current = current.next;
            }
            System.out.println("Movie with title '" + title + "' not found.");
        }

        public void searchByDirector(String director) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            boolean found = false;
            MovieNode current = head;
            System.out.println("\n--- Search Results for Director: " + director + " ---");
            while (current != null) {
                if (current.director.equalsIgnoreCase(director)) {
                    System.out.println(current);
                    found = true;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("No movies found directed by '" + director + "'.");
            }
        }

        public void searchByRating(double rating) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            boolean found = false;
            MovieNode current = head;
            System.out.println("\n--- Search Results for Rating: " + rating + " ---");
            while (current != null) {
                if (Double.compare(current.rating, rating) == 0) {
                    System.out.println(current);
                    found = true;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("No movies found with rating " + rating + ".");
            }
        }

        public void displayForward() {
            if (head == null) {
                System.out.println("No movie records available.");
                return;
            }
            System.out.println("\n--- Movies (Forward Order: Head -> Tail) ---");
            MovieNode current = head;
            int index = 1;
            while (current != null) {
                System.out.println(index++ + ". " + current);
                current = current.next;
            }
        }

        public void displayReverse() {
            if (tail == null) {
                System.out.println("No movie records available.");
                return;
            }
            System.out.println("\n--- Movies (Reverse Order: Tail -> Head) ---");
            MovieNode current = tail;
            int index = size;
            while (current != null) {
                System.out.println(index-- + ". " + current);
                current = current.prev;
            }
        }

        public void updateRating(String title, double newRating) {
            MovieNode current = head;
            while (current != null) {
                if (current.title.equalsIgnoreCase(title)) {
                    current.rating = newRating;
                    System.out.println("Updated rating for '" + current.title + "' to " + newRating + "/10.");
                    return;
                }
                current = current.next;
            }
            System.out.println("Movie '" + title + "' not found.");
        }
    }

