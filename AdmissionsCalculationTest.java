import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AdmissionsCalculationTest {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  @Test
  void addition() {
    assertEquals(2, 1 + 1);
  }

  @Test
  void computeExamScoreSAT() {
    assertEquals(0.5625, AdmissionsCalculation.computeExamScoreSAT(3, 5, 7));
  }

  @Test
  void computeExamScoreACT() {
    assertEquals(1310, AdmissionsCalculation.computeExamScoreACT(512, 303, 790, 450));
  }

  @Test
  void computeGpaScore() {
    assertEquals(76.5, AdmissionsCalculation.computeGpaScore(3.4, 4.0, 0.9));
  }

  @Test
  void round1() {
    assertEquals(3.4, AdmissionsCalculation.round1(3.4449)); // rounding
    assertEquals(3.5, AdmissionsCalculation.round1(3.45));  // rounding with 5, should round up 
    assertEquals(3.0, AdmissionsCalculation.round1(3));  // should add 0 to integers
    assertEquals(4.0, AdmissionsCalculation.round1(3.99));  // round up to 1s place
    assertEquals(3.1, AdmissionsCalculation.round1(3.08));  // round up to 10ths place
    assertEquals(3.0, AdmissionsCalculation.round1(3.03));  // round down to 10ths place
  }

  @Test
  void computeGpa() {
    AdmissionsCalculation.setInput(new InputMock());
    assertEquals(78.375, AdmissionsCalculation.calculateGpa());
  }

//   protected static double calculateGpa() {
//     double gpa = input.inputD("overall GPA?");
//     double maxGpa = input.inputD("max GPA?");
//     double multiplier = input.inputD("Transcript Multiplier?");
//     double gpaScore = computeGpaScore(gpa, maxGpa, multiplier);
//     return gpaScore;
// }

}