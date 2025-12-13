package org.cristian;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /**
     * calculates the average score for the assignment
     *
     * @return the value of the average score for the assignment
     */
    public double calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()) {
            return 0; //handle weird case
        }

        int sum = 0;
        int counter = 0;

        for (Integer score : scores) { //enhanced for loop since it only goes through scores
            if (score != null) { //cannot add a null
                sum += score;
                counter++;
            }
        }

        if (counter == 0) {
            return 0;
        } else {
            return (double) sum / counter;
        }
    }

    /**
     * generates random scores for all students in an assignment
     * Note: scores are generated according to this rule:
     * First generate a random number in range [0, 10], then
     * if the number is `0`, then generate a random score in range `[0, 60)` for the student;
     * if the number is `1`, `2`, then generate a random score in range `[60, 70)` for the student;
     * if the number is `3`, `4`, then generate a random score in range `[70, 80)` for the student;
     * if the number is `5`, `6`, `7`, `8`, then generate a random score in range `[80, 90)` for the student;
     * if the number is `9`, `10`, then generate a random score in range `[90, 100]` for the student;
     */
    public void generateRandomScore() {
        Random random = new Random();
        List<Integer> randomizedScores = new ArrayList<>();

        for (int i = 0; i < scores.size(); i++) {
            int randomNum = random.nextInt(11); //11 excluded so from [0, 10]
            int score;

            score = switch (randomNum) {
                case 0 -> random.nextInt(60);               // from [0, 60), 60 excluded
                case 1, 2 -> 60 + random.nextInt(10);       // from [60, 70), 70 excluded
                case 3, 4 -> 70 + random.nextInt(10);       // from [70, 80), 80 excluded
                case 5, 6, 7, 8 -> 80 + random.nextInt(10); // from [80, 90), 90 excluded
                default -> 90 + random.nextInt(11);         // from [90, 100]
            };

            randomizedScores.add(score);
        }

        this.scores = randomizedScores; //to pass on the randomly generated scores
    }
}
