import com.github.jreddit.entity.User;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

/**
 * Created by Hari on 5/30/2015.
 */
public class main {
    public static void main(String[] args) {
        RestClient restClient = new HttpRestClient();
        restClient.setUserAgent("bot/toxicshithead");
        User user = new User(restClient,constants.users,constants.password);
        try {
            user.connect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
