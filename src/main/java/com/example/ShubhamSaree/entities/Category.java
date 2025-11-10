package com.example.ShubhamSaree.entities;

import com.example.ShubhamSaree.enums.CategoryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity(name = "category")
public class Category extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private CategoryType categoryName;

    // todo to be entered more if necessary

    // relationships todo

}
