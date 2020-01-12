package com.adminOfficialWeb.demo.repository;

import com.adminOfficialWeb.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User,Long> {

    Optional<User> findByIdAndActive(long id, boolean active);

    Optional<User> findByEmail(String email);
}
