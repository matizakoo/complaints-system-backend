package pl.engineer.active.substances.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.engineer.active.substances.dto.ComplaintDTO;

import java.io.IOException;
import java.util.List;

@Service
public class EmailService {
    private final OkHttpClient okHttpClient;
    @Value("${email.auth}")
    private String emailAuth;
    @Autowired
    private ComplaintServiceImpl complaintServiceImpl;
    @Value("${email.toSend}")
    private String emailToSend;
    public EmailService() {
        this.okHttpClient = new OkHttpClient().newBuilder().build();
    }

    public void sendSimpleEmail() throws IOException {
        List<ComplaintDTO> list = complaintServiceImpl.complaintsExpiresInTwoDays();
        if(list == null || list.isEmpty())
            return;
        StringBuilder stringBuilder = new StringBuilder();

        for(ComplaintDTO e: list) {
            stringBuilder.append(e.getFactureId() + " ");
        }

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"from\":{\"email\":\"mailtrap@demomailtrap.com\",\"name\":\"Reklamacje tanielazienki\"},\"to\":[{\"email\":\" "+ emailToSend + " \"}],\"subject\":\"Kończy się czas rozpatrywania reklamacji\",\"text\":\"Koniecznie rozpatrz reklamacje o numerze faktur: "+ stringBuilder +"\",\"category\":\"Integration Test\"}");
        Request request = new Request.Builder()
                .url("https://send.api.mailtrap.io/api/send")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + emailAuth)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
    }
}