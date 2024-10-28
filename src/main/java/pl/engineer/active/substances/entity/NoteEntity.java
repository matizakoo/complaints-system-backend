package pl.engineer.active.substances.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "note")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String note;
    private String publisher;
    private LocalDateTime dateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "complaint_id", nullable = false)
    private ComplaintEntity complaintEntity;
}
