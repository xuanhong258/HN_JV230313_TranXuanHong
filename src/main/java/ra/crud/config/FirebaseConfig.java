package ra.crud.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {
    private final String serviceAccountKeyPath = "D:\\Exam_MD03\\Exam_Java_Webapp\\src\\main\\webapp\\resources\\firebase.json";

    @Bean
    public Storage storage() throws IOException {
        try (InputStream serviceAccount = new FileInputStream(serviceAccountKeyPath)) {
            return StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build()
                    .getService();
        }
    }
}
