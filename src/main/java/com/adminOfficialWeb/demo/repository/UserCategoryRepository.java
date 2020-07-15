package com.adminOfficialWeb.demo.repository;

import com.adminOfficialWeb.demo.entity.User;
import com.adminOfficialWeb.demo.entity.UserCategory;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface UserCategoryRepository extends BaseRepository<UserCategory,Long> {
    List<UserCategory> findByUser(User user);
    List<UserCategory> findByUserAndActive(User user, boolean active);
    List<UserCategory> findByUser_UserKeyAndActive(String user_userKey, boolean active);
}
