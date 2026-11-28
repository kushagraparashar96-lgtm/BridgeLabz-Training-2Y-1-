package LinkedList.roundRobinScheduling;

public class RoundRobinCircularList {

        private ProcessNode head;
        private ProcessNode tail;
        private int count;

        public RoundRobinCircularList() {
            this.head = null;
            this.tail = null;
            this.count = 0;
        }

        // 1. Add a new process at the end of the circular list
        public void addProcessAtEnd(int pid, int burstTime, int priority) {
            ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
            if (head == null) {
                head = tail = newNode;
                newNode.next = head;
            } else {
                tail.next = newNode;
                newNode.next = head;
                tail = newNode;
            }
            count++;
            System.out.println("Process P" + pid + " added to the circular queue.");
        }

        // 2. Remove a process by Process ID
        public void removeProcessById(int pid) {
            if (head == null) {
                System.out.println("Queue is empty. No process to remove.");
                return;
            }

            ProcessNode current = head;
            ProcessNode prev = tail;

            for (int i = 0; i < count; i++) {
                if (current.processId == pid) {
                    if (count == 1) {
                        head = tail = null;
                    } else {
                        prev.next = current.next;
                        if (current == head) head = current.next;
                        if (current == tail) tail = prev;
                    }
                    count--;
                    System.out.println("Process P" + pid + " removed from queue.");
                    return;
                }
                prev = current;
                current = current.next;
            }
            System.out.println("Process P" + pid + " not found.");
        }

        // 4. Display all processes currently in the circular queue
        public void displayProcesses() {
            if (head == null) {
                System.out.println("Circular Queue is empty.");
                return;
            }
            ProcessNode current = head;
            for (int i = 0; i < count; i++) {
                System.out.println("  -> " + current);
                current = current.next;
            }
        }

        // 3 & 5. Simulate Round-Robin Scheduling & Calculate Average Times
        public void simulateRoundRobin(int timeQuantum) {
            if (head == null) {
                System.out.println("No processes in the queue to schedule.");
                return;
            }
            if (timeQuantum <= 0) {
                System.out.println("Time quantum must be greater than 0.");
                return;
            }

            int totalProcesses = count;
            int currentTime = 0;
            double totalWaitingTime = 0;
            double totalTurnAroundTime = 0;
            int round = 1;

            System.out.println("\n=== Starting Round Robin Simulation (Time Quantum = " + timeQuantum + ") ===");

            while (count > 0) {
                System.out.println("\n--- Round " + round + " ---");
                int processesInThisRound = count;
                ProcessNode current = head;

                for (int i = 0; i < processesInThisRound; i++) {
                    ProcessNode nextNode = current.next;

                    int execTime = Math.min(current.remainingTime, timeQuantum);
                    current.remainingTime -= execTime;
                    currentTime += execTime;

                    System.out.println("Executed Process P" + current.processId + " for " + execTime +
                            " units (Current Time: " + currentTime + ")");

                    if (current.remainingTime == 0) {
                        int turnAroundTime = currentTime; // Assuming arrival time = 0 for all processes
                        int waitingTime = turnAroundTime - current.burstTime;

                        totalTurnAroundTime += turnAroundTime;
                        totalWaitingTime += waitingTime;

                        System.out.println("  [Completed] P" + current.processId +
                                " | Turn-Around Time: " + turnAroundTime +
                                " | Waiting Time: " + waitingTime);

                        removeProcessById(current.processId);
                    }

                    if (count == 0) break;
                    current = nextNode;
                }

                System.out.println("Queue state after Round " + round + ":");
                displayProcesses();
                round++;
            }

            // 5. Display Average Waiting Time and Turn-Around Time
            System.out.println("\n=== Scheduling Summary ===");
            System.out.printf("Average Waiting Time     : %.2f units%n", (totalWaitingTime / totalProcesses));
            System.out.printf("Average Turn-Around Time : %.2f units%n", (totalTurnAroundTime / totalProcesses));
        }
    }
