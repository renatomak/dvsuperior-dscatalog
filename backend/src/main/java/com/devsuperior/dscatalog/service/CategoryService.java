package com.devsuperior.dscatalog.service;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositoies.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    public List<Category> findAll() {
        return categoryRespository.findAll();
    }
}
