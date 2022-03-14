package com.devsuperior.dscatalog.repository;

import com.devsuperior.dscatalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Long> {
}
