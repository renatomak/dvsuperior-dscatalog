package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 7193684038002132400L;

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    
    private List<CategoryDto> categoryDtos = new ArrayList<>();

    public ProductDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.imgUrl = entity.getImgUrl();
    }

    public ProductDto(Product entity, Set<Category> categories) {
        this(entity);
        categories.forEach(cat -> this.categoryDtos.add(new CategoryDto(cat)));
    }
}
