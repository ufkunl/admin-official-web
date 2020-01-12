package com.adminOfficialWeb.demo.entity;

import com.adminOfficialWeb.demo.entity.Base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @NotBlank(message = "name cannot be empty")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "surname cannot be empty")
    @Column(nullable = false)
    private String surname;

    @NotBlank(message = "email cannot be empty")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "password cannot be empty")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "userKey cannot be empty")
    @Column(nullable = false)
    private String userKey;

    private boolean active;

    private String phoneNumber;

    @Lob
    private String cvContent;

    private String cvUrl;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<UserCategory> myCategories;


}
