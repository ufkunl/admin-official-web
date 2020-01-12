package com.adminOfficialWeb.demo.entity;

import com.adminOfficialWeb.demo.entity.Base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @NonNull
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String name;

    private boolean active;

}
