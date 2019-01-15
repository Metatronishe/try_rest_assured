package twitterApiTest;

import com.twitter.api.test.Requests;
import com.twitter.api.test.RandomInt;
import io.qameta.allure.Description;
import org.junit.Test;

public class RetweetUpdateTest {

    @Test
    @Description("Retweet the present real tweet")
    public void RetweetThePresentTweet() {
        Requests.StatusRetweetUpdateTest(5)
                .statusCode(200);
    }

    @Test
    @Description("Retweet the non-present tweet")
    public void RetweetNonPresentTweet() {
        Requests.StatusRetweetUpdateTest(RandomInt.getRandomIntegerBetweenRange(10, 50))
                .statusCode(403);
    }

}
