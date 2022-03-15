package com.devsuperior.dscatalog.service;

import com.devsuperior.dscatalog.dto.CategoryDto;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositoies.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRespository.findAll();
        return categories.stream().map(CategoryDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        return new CategoryDto(categoryRespository.findById(id).get());
    }
}
