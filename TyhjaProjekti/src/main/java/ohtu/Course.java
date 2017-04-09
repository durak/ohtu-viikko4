package ohtu;


public class Course {
    
    private String name;
    private String term;
    private int week1, week2, week3, week4, week5, week6;
    
    public int getNumberOfExercises(int week) {
        int numberOfWeeks = 6;
        int[] weeks = new int[numberOfWeeks + 1];
        weeks[1] = week1;
        weeks[2] = week2;
        weeks[3] = week3;
        weeks[4] = week4;
        weeks[5] = week5;
        weeks[6] = week6;
        
        return weeks[week];                        
    }

    
}
