package com.devsuperior.dscatalog.repositoies;

import com.devsuperior.dscatalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Long> {
}
