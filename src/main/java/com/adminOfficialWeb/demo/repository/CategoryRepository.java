package com.adminOfficialWeb.demo.repository;

import com.adminOfficialWeb.demo.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category,Long> {

    Category findByName(String name);

}
