package com.adminOfficialWeb.demo.entity;

import com.adminOfficialWeb.demo.entity.Base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_categories", uniqueConstraints = {
        @UniqueConstraint(name = "uq_user_category_user_category", columnNames = {"user_id", "category_id"})
})
public class UserCategory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private boolean active;

}
