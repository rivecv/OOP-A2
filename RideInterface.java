package org.example;

public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);               // Add visitor to queue
    void removeVisitorFromQueue(Visitor visitor);          // Remove visitor from queue
    void printQueue();                                      // Print visitors in queue
    void runOneCycle();                                     // Run the ride for one cycle
    void addVisitorToHistory(Visitor visitor);             // Add visitor to ride history
    boolean checkVisitorFromHistory(Visitor visitor);      // Check if visitor is in ride history
    int numberOfVisitors();                                // Get the number of visitors in history
    void printRideHistory();                               // Print the ride history
}
