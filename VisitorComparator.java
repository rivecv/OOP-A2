package org.example;

import java.util.Comparator;

// Comparator for Visitor
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First compare by age (ascending)
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }

        // If ages are the same, compare by membership type (alphabetically)
        return v1.getMembershipType().compareTo(v2.getMembershipType());
    }
}
