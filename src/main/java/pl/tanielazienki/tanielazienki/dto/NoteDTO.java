package pl.tanielazienki.tanielazienki.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    private Integer id;
    private ComplaintDTO complaintDTO;
    private String note;
    private String publisher;
    private LocalDateTime dateTime;
}
