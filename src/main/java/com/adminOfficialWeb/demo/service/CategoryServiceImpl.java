package com.adminOfficialWeb.demo.service;

import com.adminOfficialWeb.demo.entity.Category;
import com.adminOfficialWeb.demo.repository.CategoryRepository;
import com.adminOfficialWeb.demo.service.base.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService<Category,Long> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        category.setActive(true);
        category = categoryRepository.save(category);
        return category;
    }

    public Category update(Category entity) {
        return categoryRepository.save(entity);
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id + " numaralı category bulunamadı !"));
    }

    public List<Category> getByActive() {
        return categoryRepository.findByActive(true)
                .orElseThrow(()->new EntityNotFoundException("Kategori Bulunamadı."));
    }

    public boolean deleteById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Kategori bulunamadı."));
        category.setActive(false);
        categoryRepository.save(category);
        /** passive article when passive category !!! add category by user **/
        return true;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }
}
