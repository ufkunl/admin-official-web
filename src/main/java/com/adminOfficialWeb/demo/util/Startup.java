package com.adminOfficialWeb.demo.util;

import com.adminOfficialWeb.demo.entity.Category;
import com.adminOfficialWeb.demo.entity.Role;
import com.adminOfficialWeb.demo.entity.User;
import com.adminOfficialWeb.demo.repository.CategoryRepository;
import com.adminOfficialWeb.demo.repository.RoleRepository;
import com.adminOfficialWeb.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Startup {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CategoryRepository categoryRepository;

    @Bean("initUser")
    @DependsOn("initRoles")
    public void initializeUsers() {

        Role superAdmin = roleRepository.findByName("SUPERADMIN");

        if (!userRepository.findByEmail("superadmin@gmail.com").isPresent()) {

            User superAdminUser = new User();
            superAdminUser.setEmail("superadmin@gmail.com");
            superAdminUser.setPhoneNumber("1111111111");
            superAdminUser.setPassword(bCryptPasswordEncoder.encode("123456"));
            superAdminUser.setName("ADMIN");
            superAdminUser.setSurname("SUPER");
            superAdminUser.setActive(true);
            superAdminUser.setRole(superAdmin);
            superAdminUser.setUserKey("111111111");
            userRepository.save(superAdminUser);
        }

    }

    @Bean("initRoles")
    public void initializeRoles() {

        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Role roleSuperAdmin = new Role("SUPERADMIN");

        if (roleRepository.findByName("ADMIN") == null)
            roleRepository.save(roleAdmin);

        if (roleRepository.findByName("USER") == null)
            roleRepository.save(roleUser);

        if (roleRepository.findByName("SUPERADMIN") == null)
            roleRepository.save(roleSuperAdmin);
    }

    @Bean("initCategory")
    public void initCategory(){
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()){
            categories = new ArrayList<>();
            categories.add(new Category("Genel",true));
            categories.add(new Category("Teknoloji",true));
            categories.add(new Category("Spor",true));
            categories.add(new Category("Sağlık",true));
            categoryRepository.saveAll(categories);
        }
    }

}
