package org.example;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        // Create Ride object
        Employee operator = new Employee("John Doe", 35, "Male", "Ride Operator", 5);
        Ride ride = new Ride("Ferris Wheel", 3, true, operator, 2);

        // Create Visitors
        Visitor visitor1 = new Visitor("Alice", 25, "Female", true, "Gold Member");
        Visitor visitor2 = new Visitor("Bob", 30, "Male", true, "Silver Member");
        Visitor visitor3 = new Visitor("Charlie", 20, "Male", false, "Standard");
        Visitor visitor4 = new Visitor("Diana", 28, "Female", true, "Platinum Member");
        Visitor visitor5 = new Visitor("Eve", 22, "Female", false, "Standard");

        // Add Visitors to the queue
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        // Print the queue
        ride.printQueue();

        // Remove a Visitor from the queue
        ride.removeVisitorFromQueue(visitor3);

        // Print the queue again
        ride.printQueue();
    }


    public void partFourA() {
        // Create Ride object
        Employee operator = new Employee("John Doe", 35, "Male", "Ride Operator", 5);
        Ride ride = new Ride("Roller Coaster", 2, true, operator,2
        );

        // Create Visitors
        Visitor visitor1 = new Visitor("Alice", 25, "Female", true, "Gold Member");
        Visitor visitor2 = new Visitor("Bob", 30, "Male", true, "Silver Member");
        Visitor visitor3 = new Visitor("Charlie", 20, "Male", false, "Standard");
        Visitor visitor4 = new Visitor("Diana", 28, "Female", true, "Platinum Member");
        Visitor visitor5 = new Visitor("Eve", 22, "Female", false, "Standard");

        // Add Visitors to ride history
        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        // Check if a Visitor is in the history
        ride.checkVisitorFromHistory(visitor3);
        ride.checkVisitorFromHistory(new Visitor("Unknown", 0, "Unknown", false, "None"));

        // Print the number of Visitors in history
        ride.numberOfVisitors();

        // Print all Visitors in the history
        ride.printRideHistory();
    }

    public void partFourB() {
        // Create Ride object
        Employee operator = new Employee("John Doe", 35, "Male", "Ride Operator", 5);
        Ride ride = new Ride("Ferris Wheel", 2, true, operator,3);

        // Create Visitors
        Visitor visitor1 = new Visitor("Alice", 25, "Female", true, "Gold Member");
        Visitor visitor2 = new Visitor("Bob", 30, "Male", true, "Silver Member");
        Visitor visitor3 = new Visitor("Charlie", 20, "Male", false, "Standard");
        Visitor visitor4 = new Visitor("Diana", 28, "Female", true, "Platinum Member");
        Visitor visitor5 = new Visitor("Eve", 22, "Female", false, "Standard");

        // Add Visitors to ride history
        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        // Print all Visitors before sorting
        System.out.println("Before sorting:");
        ride.printRideHistory();

        // Sort the collection
        VisitorComparator comparator = new VisitorComparator();
        ride.sortRideHistory(comparator);

        // Print all Visitors after sorting
        System.out.println("After sorting:");
        ride.printRideHistory();
    }


    public void partFive() {
        // Create Ride object
        Employee operator = new Employee("John Doe", 35, "Male", "Ride Operator", 5);
        Ride ride = new Ride("Roller Coaster", 2, true, operator, 3);

        // Create Visitors
        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "Male", true, "Member" + i));
        }

        // Print all visitors in queue
        System.out.println("Before running the ride:");
        ride.printQueue();

        // Run one cycle
        ride.runOneCycle();

        // Print all visitors in queue after one cycle
        System.out.println("After running the ride:");
        ride.printQueue();

        // Print all visitors in the collection
        System.out.println("Visitors in ride history:");
        ride.printRideHistory();
    }

    public void partSix() {
        // Create Ride object
        Ride ride = new Ride("Roller Coaster", 3, true, new Employee("John Doe", 35, "Male", "Operator", 5), 5);

        // Add Visitors to ride history
        ride.addVisitorToHistory(new Visitor("Alice", 25, "Female", true, "Gold Member"));
        ride.addVisitorToHistory(new Visitor("Bob", 30, "Male", true, "Silver Member"));
        ride.addVisitorToHistory(new Visitor("Charlie", 20, "Male", false, "Standard"));
        ride.addVisitorToHistory(new Visitor("Diana", 28, "Female", true, "Platinum Member"));
        ride.addVisitorToHistory(new Visitor("Eve", 22, "Female", false, "Standard"));

        // Print ride history
        System.out.println("Current ride history:");
        ride.printRideHistory();

        // Export ride history to a file
        String filePath = "ride_history.csv";
        ride.exportRideHistory(filePath);
    }


    public void partSeven() {
        // Create Ride object
        Ride ride = new Ride("Roller Coaster", 3, true, new Employee("John", 40, "Male", "Operator", 10), 5);

        // File path from which history will be imported
        String filePath = "ride_history.csv";

        // Import ride history from file
        ride.importRideHistory(filePath);

        // Print the number of visitors in the LinkedList
        System.out.println("Number of visitors in ride history: " + ride.numberOfVisitors());

        // Print all visitors in the LinkedList
        System.out.println("Visitors in ride history:");
        ride.printRideHistory();
    }
}
