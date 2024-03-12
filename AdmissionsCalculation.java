// TODO: program structure (remove "chaining"), duplicated code, indentation spaces, naming, and testing

import java.util.*;
import java.lang.Math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AdmissionsCalculation {

    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }

    static InputInterface input;
    public static void setInput(InputInterface i) {
        input = i;
    }
    


    public static void main(String[] args) {

        input = new InputImpl(new Scanner(System.in));

        System.out.print("This program compares two applicants to\n"
                + "determine which one seems like the stronger\n"
                + "applicant. For each candidate I will need\n"
                + "either SAT or ACT scores plus a weighted GPA.");

        double score1 = callTestQuestions(1);
        double score2 = callTestQuestions(2);

        compareScores(score1, score2);

    }

    protected static double callTestQuestions(int applicantNumber) {

        int test = printApplicantIntro(applicantNumber);

        double score = 0;
        if (test == 1) {
            score = satScore();
        } else if (test == 2) {
            score = actScore();
        }
        return score;
    }

    protected static void compareScores(double score1, double score2) {

        System.out.print("\n\nFirst applicant overall score = " + round1(score1)
                + "\nSecond applicant overall score = " + round1(score2));
        if (score1 > score2) {
            System.out.print("\nThe first applicant seems to be better");
        } else if (score1 < score2) {
            System.out.print("\nThe second applicant seems to be better");
        } else {
            System.out.print("\nThe two applicants seem to be equal");
        }

    }

    protected static int printApplicantIntro(int applicantNumber) {
        System.out.print("\n\nInformation for applicant #" + applicantNumber + ":");
        int test = input.inputI("\n    do you have 1) SAT scores or 2) ACT scores?");
        return test;
    }

    
    protected static double satScore() {
        int math = input.inputI("SAT math?");
        int reading = input.inputI("SAT critical reading?");
        int writing = input.inputI("SAT writing?");
        double examScore = computeExamScoreSAT(math, reading, writing);
        System.out.print("    exam score = " + round1(examScore) + "\n");
        double gpaScore = calculateGpa();
        System.out.print("    GPA score = " + round1(gpaScore));
        return gpaScore + examScore;
    }

    protected static double actScore() {
        int english = input.inputI("ACT English?");
        int math = input.inputI("ACT math?");
        int reading = input.inputI("ACT reading?");
        int science = input.inputI("ACT science?");
        double examScore = computeExamScoreACT(english, math, reading, science);

        System.out.print("    exam score = " + round1(examScore) + "\n");
        double gpaScore = calculateGpa();
        System.out.print("    GPA score = " + round1(gpaScore));
        return gpaScore + examScore;
    }

    protected static double calculateGpa() {
        double gpa = input.inputD("overall GPA?");
        double maxGpa = input.inputD("max GPA?");
        double multiplier = input.inputD("Transcript Multiplier?");
        double gpaScore = computeGpaScore(gpa, maxGpa, multiplier);
        return gpaScore;
    }

    protected static double computeExamScoreSAT(int math, int reading, int writing) {
        return (2 * math + reading + writing) / 32.0;
    }

    protected static double computeExamScoreACT(int english, int math, int reading, int science) {
        return (2 * math + english + reading + science) / 1.8;
    }

    protected static double computeGpaScore(double gpa, double maxGpa, double multiplier) {
        return (gpa / maxGpa) * 100 * multiplier;
    }

    protected static double round1(double input) {
        return Math.round(input * 10) / 10.0;
    }

}