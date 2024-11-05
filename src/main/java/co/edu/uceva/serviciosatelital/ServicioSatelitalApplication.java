package co.edu.uceva.serviciosatelital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class ServicioSatelitalApplication {

    public static void main(String[] args) {
        if (FirebaseApp.getApps().isEmpty()) {
            try {
                // Get the directory path
                String directoryPath = "src/main/resources";

                // Find the JSON file
                File jsonFile = findJsonFile(directoryPath);

                if (jsonFile == null) {
                    throw new FileNotFoundException("No JSON file found in " + directoryPath);
                }

                // Load the JSON file
                try (FileInputStream serviceAccount = new FileInputStream(jsonFile)) {
                    FirebaseOptions options = new FirebaseOptions.Builder()
                            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                            .setStorageBucket("imagenes-satelital-procesadas.appspot.com")
                            .build();
                    FirebaseApp.initializeApp(options);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SpringApplication.run(ServicioSatelitalApplication.class, args);
    }

    // This method searches for a file with the extension ".json" in the given directory
    private static File findJsonFile(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files == null) {
            return null;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".json")) {
                return file;
            }
        }

        return null;
    }




}

