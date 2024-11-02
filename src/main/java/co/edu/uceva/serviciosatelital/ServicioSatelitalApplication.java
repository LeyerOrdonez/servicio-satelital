package co.edu.uceva.serviciosatelital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileInputStream;
import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class ServicioSatelitalApplication {

    public static void main(String[] args) {
        if (FirebaseApp.getApps().isEmpty()) {
            try (FileInputStream serviceAccount = new FileInputStream("src/main/resources/imagenes-satelital-procesadas-firebase-adminsdk-ym4ri-3cbc49f8a9.json")) {
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setStorageBucket("imagenes-satelital-procesadas.appspot.com")
                        .build();
                FirebaseApp.initializeApp(options);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SpringApplication.run(ServicioSatelitalApplication.class, args);
    }
}

