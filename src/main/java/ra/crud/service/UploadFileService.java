package ra.crud.service;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

    String uploadFileToLocal(MultipartFile multipartFile);

    String uploadFileToFireBase(String localFilePath);
}
