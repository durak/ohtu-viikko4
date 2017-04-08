package ohtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Submission {

    private String student_number;
    private int week;
    private int hours;
    private boolean a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
            a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21;


    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public Integer getHours() {
        return hours;
    }
    
    public List<Integer> listDoneExercises() {
        List<Integer> dones = new ArrayList<>();
        if (a1) dones.add(1);
        if (a2) dones.add(2);
        if (a3) dones.add(3);
        if (a4) dones.add(4);
        if (a5) dones.add(5);
        if (a6) dones.add(6);
        if (a7) dones.add(7);
        if (a8) dones.add(8);
        if (a9) dones.add(9);
        if (a10) dones.add(10);
        if (a11) dones.add(11);
        if (a12) dones.add(12);
        if (a13) dones.add(13);
        if (a14) dones.add(14);
        if (a15) dones.add(15);
        if (a16) dones.add(16);
        if (a17) dones.add(17);
        if (a18) dones.add(18);
        if (a19) dones.add(19);
        if (a20) dones.add(20);
        if (a21) dones.add(21);
        
        return dones;                
    }

    @Override
    public String toString() {
        List<Integer> dones = listDoneExercises();
        
        StringBuilder sb = new StringBuilder();
//        sb.append(student_number).append("\n\n");
        sb.append(" ").append("viikko ").append(week);
        sb.append(": tehtyjä tehvätiä yhteensä: ").append(dones.size());
        sb.append(", aikaa kului ").append(hours).append(" tuntia, tehdyt tehtävät: ");
        
        for (Integer done : dones) {
            sb.append(done).append(" ");
        }                
                
        return sb.toString();
    }

}
