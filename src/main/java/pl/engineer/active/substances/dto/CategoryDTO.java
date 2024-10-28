package pl.tanielazienki.tanielazienki.dto;

import lombok.*;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Integer id;
    private String category;

    public CategoryDTO(String category) {
        this.category = category;
    }
}
