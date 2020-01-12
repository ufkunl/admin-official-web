package com.adminOfficialWeb.demo.repository;

import com.adminOfficialWeb.demo.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<Role,Long> {

    Role findByName(String name);

}
