package ra.crud.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_name", columnDefinition = "varchar(100)", nullable = false)
    private String studentName;
    @Column(name = "phone_number", columnDefinition = "varchar(15)")
    private String phoneNumber;
    @Column(name = "birthday", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(name = "address", columnDefinition = "varchar(255)")
    private String address;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "sex")
    private boolean sex;
}
