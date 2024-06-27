package pl.tanielazienki.tanielazienki.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "note")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String note;
    private String publisher;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "complaint_id", nullable = false)
    private ComplaintEntity complaintEntity;
}
