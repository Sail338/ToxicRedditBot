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
import com.google.inject.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hari on 6/2/15.
 */
public class MainFunctions {
    User user;
    RestClient restClient;
    int x = 0;
    List<Comment> commentelist;
    List<Submission> subs;
    public void connectuser() {
        inputstuff.setPassword("");
        inputstuff.setUsername("");
        System.out.println(constants.users);
        restClient = new HttpRestClient();
        restClient.setUserAgent("bot/toxicshithead");

        user = new User(restClient,constants.users,constants.password);
        try {
            user.connect();
        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }
    public List<String> subbredditList(){
        List<String> subredditList = new ArrayList<String>();
        return subredditList;

    }
    public void beToxic() {
        connectuser();

        Submissions subs = new Submissions(restClient,user);
        List<Submission> submisionList  = subs.ofSubreddit("harkistestsub", SubmissionSort.NEW, -1, 100, null, null, true);

        for(Submission submission: submisionList)
        {
            Comments comment   = new Comments(restClient);
            //System.out.println(submission.toString());


            List<Comment> commentsList =  comment.ofSubmission(submission,null,10,1,10, CommentSort.NEW);

            for(Comment comment_f: commentsList) {





                String body = comment_f.getBody().toString();
                String badmouth = "python is a shitty langaue, why the fuck would u use that nig shit";
                System.out.println(comment_f.getBody());





                if(body.contains("python") || body.toLowerCase().contains("python")) {
                    //getReplies(comment_f);

                    //System.out.println(commentelist);

                    for(Comment badmouthre: comment_f.getReplies()) {


                        if (badmouthre.getBody().contains(badmouth)) {

                            break;
                        }
                    }
                    SubmitActions submitActions = new SubmitActions(restClient,user);
                    //System.out.println(body);

                    //submitActions.comment(comment_f.getFullName(),badmouth);



                }

            }
            //new Messages(restClient).compose(user,"biotechnologist","THE EPIC PYTON BOT","PYthon is looks like pseudocode","","");




        }
        System.out.print("done");
    }
    public List<Comment> getReplies(Comment comment) {

        x++;

        commentelist = comment.getReplies();
        if(commentelist.isEmpty()) {
            System.out.println(x);
            System.out.println(commentelist);

            return getReplies(comment);
        }


        return commentelist;

    }
    public void setSubmisionsFromSubreddit(String subredit, SubmissionSort commentSort, @Nullable List<String> listofsubreddit) {
        Submissions sabs = new Submissions(restClient,user);
        if(listofsubreddit != null) {
            for(String s : listofsubreddit) {
                subs =  sabs.ofSubreddit(s,commentSort,-1,10,null,null,true);
            }
        } else {
            subs = sabs.ofSubreddit(subredit,commentSort,-1,10,null,null,true);
        }


        //sets list of submissions by subreddit
    }
    public List<Submission> getSubmisionsFromSubreddit() {
        return subs;
    }




}




