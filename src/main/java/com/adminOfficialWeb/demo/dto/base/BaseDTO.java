package com.adminOfficialWeb.demo.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@JsonIgnoreProperties(value = {"createdDate", "updatedDate"}, allowGetters = true)
public class BaseDTO implements Serializable {

    private long id;

}
