package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;


public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        String courseUrl = "https://ohtustats2017.herokuapp.com/courses/1.json";
        String courseText = Request.Get(courseUrl).execute().returnContent().asString();
        
        Course ohtu = mapper.fromJson(courseText, Course.class);
        
        
        int totalDone = 0;
        int totalHours = 0;
        
        System.out.println("Opiskelijanumero: " + studentNr + "\n");
        for (Submission submission : subs) {
            totalDone += submission.listDoneExercises().size();
            totalHours += submission.getHours();
            
            String s = submission.toString();
            System.out.println(s.substring(0, s.indexOf(",")) + " (maksimi " + 
                    ohtu.getNumberOfExercises(submission.getWeek()) + ")" + 
                    s.substring(s.indexOf(",")));
        }
        
        System.out.println("\nyhteensä: " + totalDone + " tehtävää " + totalHours + " tuntia");

    }
}
