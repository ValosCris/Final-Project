import org.cristian.Assignment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssignmentTest {

    @Test
    @DisplayName("calcAssignmentAvg: no given scores -> no avg -> 0")
    public void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Array", 20);

        double expected = 0; //no scores to be able to calculate
        double actual = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calcAssignmentAvg: only null score -> no avg -> 0")
    public void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Trigonometry", 25);

        assignment.getScores().add(null);

        double expected = 0; //no scores to be able to calculate
        double actual = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calcAssignmentAvg: null score + other valid-> avg of valid")
    public void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Trigonometry", 25);

        assignment.getScores().add(10);
        assignment.getScores().add(null);
        assignment.getScores().add(5);

        double expected = 7.5; //no scores to be able to calculate
        double actual = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateRandomScore: add 3 null spots in scores -> generateScores -> scores size is 3")
    public void testGenerateRandomScore1() {
        Assignment assignment = new Assignment("Calculus", 30);

        assignment.getScores().add(null);
        assignment.getScores().add(null);
        assignment.getScores().add(null); //to have size of 3 for scores

        assignment.generateRandomScore();

        int sizeExpected = 3;
        int sizeActual = assignment.getScores().size();

        Assertions.assertEquals(sizeExpected, sizeActual);
    }

    @Test
    @DisplayName("generateRandomScore: all scores in [0, 100]? -> true") //want to assertions through all scores then
    public void testGenerateRandomScore2() {
        Assignment assignment = new Assignment("Linear algebra", 35);

        assignment.getScores().add(null);
        assignment.getScores().add(null);
        assignment.getScores().add(null); //to have size of 3 for scores

        assignment.generateRandomScore();

        for (Integer score : assignment.getScores()) {
            boolean rangeRespectedExpected = true;
            boolean rangeRespectedActual = score <= 100 && score >= 0;

            Assertions.assertEquals(rangeRespectedExpected, rangeRespectedActual);
        }
    }
}
