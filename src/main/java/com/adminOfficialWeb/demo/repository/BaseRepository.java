package com.adminOfficialWeb.demo.repository;

import com.adminOfficialWeb.demo.entity.Base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity,ID extends Serializable> extends JpaRepository<T,ID> {

    Optional<List<T>> findByActive(boolean active);

}
