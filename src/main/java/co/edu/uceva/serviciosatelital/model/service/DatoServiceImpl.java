package co.edu.uceva.serviciosatelital.model.service;

import co.edu.uceva.serviciosatelital.model.dao.IDatoDao;
import co.edu.uceva.serviciosatelital.model.entities.Dato;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class DatoServiceImpl implements IDatoService{

    IDatoDao datoDao;
    private final Storage storage;
    private final String bucketName = "imagenes-satelital-procesadas.appspot.com";


    @Autowired
    public DatoServiceImpl(IDatoDao datoDao) {
        this.datoDao = datoDao;
        FileInputStream serviceAccount = null;

        try {
            serviceAccount = new FileInputStream("src/main/resources/imagenes-satelital-procesadas-firebase-adminsdk-ym4ri-3cbc49f8a9.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            this.storage = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build()
                    .getService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Dato saveDato(Dato dato, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        String contentType1 = file1.getContentType();
        String contentType2 = file2.getContentType();
        String contentType3 = file3.getContentType();

        // Subir la imagen 1 a Firebase
        BlobInfo blobInfo1 = BlobInfo.newBuilder(bucketName, file1.getOriginalFilename())
                .setContentType(contentType1)
                .build();
        storage.create(blobInfo1, file1.getInputStream());
        String imageUrl1 = "https://firebasestorage.googleapis.com/v0/b/" + bucketName + "/o/" + file1.getOriginalFilename() + "?alt=media";
        dato.setNdti_link(imageUrl1);

        // Subir la imagen 2 a Firebase
        BlobInfo blobInfo2 = BlobInfo.newBuilder(bucketName, file2.getOriginalFilename())
                .setContentType(contentType2)
                .build();
        storage.create(blobInfo2, file2.getInputStream());
        String imageUrl2 = "https://firebasestorage.googleapis.com/v0/b/" + bucketName + "/o/" + file2.getOriginalFilename() + "?alt=media";
        dato.setNdwi_link(imageUrl2);

        BlobInfo blobInfo3 = BlobInfo.newBuilder(bucketName, file3.getOriginalFilename())
                .setContentType(contentType3)
                .build();
        storage.create(blobInfo3, file3.getInputStream());
        String imageUrl3 = "https://firebasestorage.googleapis.com/v0/b/" + bucketName + "/o/" + file2.getOriginalFilename() + "?alt=media";
        dato.setColored_image(imageUrl3);

        return datoDao.save(dato);
    }

    @Override
    public List<Dato> list() {return (List<Dato>) datoDao.findAll(); }

    @Override
    public Dato updateData(Dato dato) {
        return datoDao.save(dato);
    }

    @Override
    public void deleteData(Dato dato) {
        datoDao.delete(dato);
    }

    @Override
    public Dato findById(Long id) {
        return datoDao.findById(id).orElseThrow(() -> new DatoServiceImpl.ResourceNotFoundException("info no encontrada con id " + id));
    }

    public List<Dato> findByName(String nombre) {
        // Para una búsqueda parcial, insensible a mayúsculas y minúsculas:
        return datoDao.findByNombreContainingIgnoreCaseWithJPQL(nombre);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException { public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
