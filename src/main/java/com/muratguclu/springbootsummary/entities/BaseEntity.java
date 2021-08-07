package com.muratguclu.springbootsummary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_at")
    private Date updatedAt;
}
