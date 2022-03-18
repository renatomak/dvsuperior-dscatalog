package com.devsuperior.dscatalog.service;

import com.devsuperior.dscatalog.dto.CategoryDto;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositoies.CategoryRespository;
import com.devsuperior.dscatalog.service.exceptions.DataBasesException;
import com.devsuperior.dscatalog.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        Optional<Category> optionalCategory = categoryRespository.findById(id);
        Category entity = optionalCategory.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new CategoryDto(entity);
    }

    @Transactional
    public CategoryDto create(CategoryDto categoryDto) {
        Category entity = new Category(categoryDto);
        return new CategoryDto(categoryRespository.save(entity));
    }

    @Transactional
    public CategoryDto update(Long id, CategoryDto dto) {
//        Category entity = categoryRespository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
//        entity.setName(dto.getName());
//        return new CategoryDto(categoryRespository.saveAndFlush(entity));
        try {
            Category entity = categoryRespository.getById(id);
            entity.setName(dto.getName());
            entity = categoryRespository.save(entity);
            return new CategoryDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        }
    }

    public void delete(Long id) {
        try {
            categoryRespository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBasesException("Integrity violation");
        }
    }
}
