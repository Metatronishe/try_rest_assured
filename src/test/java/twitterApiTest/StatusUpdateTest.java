package twitterApiTest;

import com.twitter.api.test.Requests;
import io.qameta.allure.Description;
import org.junit.Test;

import java.util.HashMap;

public class StatusUpdateTest {

    @Test
    @Description("Update status successfully")
    public void UpdateStatusSuccessfully() {
        HashMap<String, String> json = new HashMap<>();
        json.put("status", "test");

        Requests.StatusUpdateTest(json)
                .statusCode(200);
    }

    @Test
    @Description("Try to update status with attachment non-Tweeter Url")
    public void UpdateStatusWithAttachNonTweeterUrl() {
        HashMap<String, String> json = new HashMap<>();
        json.put("status", "All my live in one video");
        json.put("attachment_url", "https://www.youtube.com/watch?v=eQgCak_CBpk");

        Requests.StatusUpdateTest(json)
                .statusCode(403);
    }

}
