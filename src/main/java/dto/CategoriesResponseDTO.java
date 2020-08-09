package dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoriesResponseDTO {
    ArrayList < CategoriesObjectDTO > Categories = new ArrayList< CategoriesObjectDTO >();
}
