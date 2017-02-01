package com.demo.conf;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Task Model
 * 
 * @author Abhijeet
 *
 */
@JsonInclude(Include.NON_NULL)
public class TaskModel {

    @JsonProperty(value = "name")
    @NotBlank(message = "Name should not be null")
    private String name;

    @JsonProperty(value = "createdOn")
    @NotNull(message = "Creation date should not be null")
    private Date createdOn;

    public TaskModel() {
        super();
    }

    public TaskModel(String name, Date createdOn) {
        super();
        this.name = name;
        this.createdOn = createdOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
