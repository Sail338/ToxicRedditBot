import com.github.jreddit.action.SubmitActions;
import com.github.jreddit.entity.Comment;
import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.User;
import com.github.jreddit.retrieval.Comments;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.CommentSort;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;
import com.github.jreddit.message.Messages;
import gui.gui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hari on 5/30/2015.
 */
public class main {

    public static void main(String[] args) {
        gui gui = new gui();
        MainFunctions functions = new MainFunctions();
        System.out.println("One subreddit or many?");

        Scanner scanner = new Scanner(System.in);
        String scanner_input = scanner.nextLine();
        if(scanner_input.equals("one") || scanner.toString().toLowerCase().equals("one")) {
            System.out.println("Input your subreddt");

            Scanner scanner1 = new Scanner(System.in);
            functions.setSubmisionsFromSubreddit(scanner1.nextLine().toString(), SubmissionSort.NEW, null);




        } else {
            Scanner scanner2 = new Scanner(System.in);
            String x= scanner2.nextLine();
            List<String> subreddits = Arrays.asList(x.split(","));
            functions.setSubmisionsFromSubreddit("",SubmissionSort.NEW,subreddits);
        }





        functions.beToxic();

    }

}

