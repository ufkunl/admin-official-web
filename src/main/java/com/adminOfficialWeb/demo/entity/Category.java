package com.adminOfficialWeb.demo.entity;

import com.adminOfficialWeb.demo.entity.Base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Category extends BaseEntity {

    private String name;

    private boolean active;
}
