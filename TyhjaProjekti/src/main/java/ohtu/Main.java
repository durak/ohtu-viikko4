package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;


public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "01234567";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        
        int totalDone = 0;
        int totalHours = 0;
        
        System.out.println("Opiskelijanumero: " + studentNr + "\n");
        for (Submission submission : subs) {
            totalDone += submission.listDoneExercises().size();
            totalHours += submission.getHours();
            System.out.println(submission);
        }
        
        System.out.println("\nyhteensä: " + totalDone + " tehtävää " + totalHours + " tuntia");

    }
}
