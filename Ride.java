package org.example;

import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String name;
    private int capacity;
    private boolean isOpen;
    private Employee operator;

    private Queue<Visitor> queue;        // Queue to hold waiting Visitors
    private LinkedList<Visitor> rideHistory;  // History of Visitors who took the ride

    private int maxRider;     // Max visitors per cycle
    private int numOfCycles;  // Number of cycles the ride has run

    public Ride() {
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 5; // Default max riders per cycle
        this.numOfCycles = 0; // Default cycle count
    }

    public Ride(String name, int capacity, boolean isOpen, Employee operator, int maxRider) {
        this.name = name;
        this.capacity = capacity;
        this.isOpen = isOpen;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    // Implementing RideInterface methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.contains(visitor)) {
            queue.remove(visitor);
            System.out.println("Visitor " + visitor.getName() + " removed from the queue.");
        } else {
            System.out.println("Visitor " + visitor.getName() + " is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Visitors currently in queue:");
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            for (Visitor visitor : queue) {
                System.out.println("- " + visitor.getName() + ", Age: " + visitor.getAge() + ", Membership: " + visitor.getMembershipType());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("The ride cannot be run as there is no operator assigned.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("The ride cannot be run as there are no visitors in the queue.");
            return;
        }

        System.out.println("Running one ride cycle...");
        int currentCycleRiders = 0;
        while (currentCycleRiders < maxRider && !queue.isEmpty()) {
            Visitor visitor = queue.poll(); // Remove from queue
            addVisitorToHistory(visitor);  // Add to ride history
            currentCycleRiders++;
        }

        numOfCycles++; // Increment the cycle count
        System.out.println("Cycle completed. Number of cycles run: " + numOfCycles);
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        if (found) {
            System.out.println("Visitor " + visitor.getName() + " is in the ride history.");
        } else {
            System.out.println("Visitor " + visitor.getName() + " is NOT in the ride history.");
        }
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in ride history: " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history (Visitors who took the ride):");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println("- " + visitor.getName() + ", Age: " + visitor.getAge() + ", Membership: " + visitor.getMembershipType());
        }
    }

    // Export ride history to a file
    public void exportRideHistory(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + "," +
                        visitor.getMembershipType() + "," + visitor.isHasMembership());
                writer.newLine();
            }
            System.out.println("Ride history successfully exported to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error exporting ride history to file: " + e.getMessage());
        }
    }

    // Import ride history from a file
    public void importRideHistory(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String name = parts[0];
                        int age = Integer.parseInt(parts[1]);
                        String gender = parts[2];
                        String membershipType = parts[3];
                        boolean hasMembership = Boolean.parseBoolean(parts[4]);
                        Visitor visitor = new Visitor(name, age, gender, hasMembership, membershipType);
                        rideHistory.add(visitor);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing visitor data: " + e.getMessage());
                    }
                } else {
                    System.err.println("Invalid data format in file: " + line);
                }
            }
            System.out.println("Ride history successfully imported from file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error importing ride history from file: " + e.getMessage());
        }
    }
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted.");
    }
}
