package com.adminOfficialWeb.demo.service;

import com.adminOfficialWeb.demo.dto.UserCategoryDTO;
import com.adminOfficialWeb.demo.entity.Category;
import com.adminOfficialWeb.demo.entity.User;
import com.adminOfficialWeb.demo.entity.UserCategory;
import com.adminOfficialWeb.demo.mapper.UserCategoryMapper;
import com.adminOfficialWeb.demo.repository.UserCategoryRepository;
import com.adminOfficialWeb.demo.service.base.UserCategoryService;
import com.adminOfficialWeb.demo.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserCategoryServiceImpl implements UserCategoryService<UserCategoryDTO,Long> {

    @Autowired
    private UserCategoryMapper userCategoryMapper;

    @Autowired
    private UserCategoryRepository userCategoryRepository;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private UserUtil userUtil;

    @Override
    public UserCategoryDTO create(UserCategoryDTO dto) {
        User user = userUtil.getAuthenticatedUser();
        UserCategory userCategory = userCategoryMapper.toEntity(dto);
        Category categoryFromDb = categoryService.findByName(userCategory.getCategory().getName());
        if(categoryFromDb == null){
            userCategory.getCategory().setActive(true);
            categoryFromDb = categoryService.create(userCategory.getCategory());
        }
        userCategory.setCategory(categoryFromDb);
        userCategory.setUser(user);
        userCategory = userCategoryRepository.save(userCategory);

        return userCategoryMapper.toDTO(userCategory);
    }

    // only update UserCategory if category exist
    // first add category then update UserCategory if category not exist
    @Override
    public UserCategoryDTO update(UserCategoryDTO dto) {
        User user = userUtil.getAuthenticatedUser();
        UserCategory userCategory = userCategoryMapper.toEntity(dto);
        Category category = categoryService.findByName(userCategory.getCategory().getName());
        if(category == null){
            category = categoryService.create(new Category(userCategory.getCategory().getName(),true));
        }
        userCategory.setCategory(category);
        userCategory.setUser(user);
        userCategoryRepository.save(userCategory);
        return userCategoryMapper.toDTO(userCategory);
    }

    @Override
    public UserCategoryDTO findById(Long id) {
        return userCategoryMapper.toDTO(userCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id + " numaralı category bulunamadı !")));
    }

    @Override
    public List<UserCategoryDTO> getByActive() {
        User user = userUtil.getAuthenticatedUser();
        List<UserCategory> userCategories = userCategoryRepository.findByUserAndActive(user,true);
        return userCategoryMapper.toDTOList(userCategories);
    }

    @Override
    public boolean deleteById(Long id) {
        UserCategory userCategory = userCategoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Kategori bulunamadı."));
        userCategory.setActive(false);
        userCategoryRepository.save(userCategory);
        /** passive article when passive category !!! add category by user **/
        return true;
    }

    @Override
    public List<UserCategoryDTO> findAll() {
        User user = userUtil.getAuthenticatedUser();
        List<UserCategory> userCategories = userCategoryRepository.findByUser(user);
        return userCategoryMapper.toDTOList(userCategories);
    }

}
