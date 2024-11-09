package ra.crud.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class StudentDTO {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String studentName;
    private String phoneNumber;
    private Date birthday;
    private String address;
    private MultipartFile imageUrl;
    private boolean sex;
}
