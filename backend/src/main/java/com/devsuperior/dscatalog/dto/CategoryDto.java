package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;

    public CategoryDto(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
