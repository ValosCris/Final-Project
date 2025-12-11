package org.cristian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    private final String assignmentId; //auto increases
    private String assignmentName;
    private double weight;
    private List<Integer> scores;

    private static int nextId = 1; //changes after nextId++ to provide other IDs

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("Assignment%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    public double calcAssignmentAvg() {
        //do
        return 0; //get rid temporarily of error of not having return anything
    }

    public void generateRandomScore() {
        //do
    }
}
