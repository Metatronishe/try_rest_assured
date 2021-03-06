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

    @Test
    @Description("Try to duplicate update status")
    public void CheckDuplicateUpdateStatus() {
        HashMap<String, String> json = new HashMap<>();
        json.put("status", "My status");

        Requests.StatusUpdateTest(json)
                .statusCode(200);

        Requests.StatusUpdateTest(json)
                .statusCode(403);
    }

    @Test
    @Description("Try to update status to empty text")
    public void TryToUpdateEmptyStatus() {
        HashMap<String, String> json = new HashMap<>();
        json.put("status", "");

        Requests.StatusUpdateTest(json)
                .statusCode(200);
    }

    @Test
    @Description("Try to update status without required request body param 'status'K")
    public void TryToUpdateStatusWithoutStatusValueInTheRequestBody() {
        HashMap<String, String> json = new HashMap<>();
        json.put("attachment_url", "https://www.youtube.com/watch?v=eQgCak_CBpk");

        Requests.StatusUpdateTest(json)
                .statusCode(403);
    }

}
