import com.github.jreddit.entity.Comment;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by hari on 6/2/15.
 */
public class getStuff {
    public void children(Comment c) throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://www.reddit.com/dev/api#GET_api_morechildren");
        List<NameValuePair> params = new ArrayList<NameValuePair>(4);
        //params.add(new BasicNameValuePair("JSON",c.getIdentifier().toString(),c.getFullName(),"NEW"));
        post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        System.out.println(entity);
    }

}
