package com.youcode.mypromotionapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "department_administrator")
public class DepartmentAdministrator extends Administrator{

    @OneToMany
    private List<PromotionStatus> promotionsAccepted;

}
