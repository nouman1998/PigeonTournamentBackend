package com.piegon.DTO;

import com.piegon.Models.Category;

public class CategoryDTO {
    Long categoryId;
    String categoryName;
    Integer noOfPigeons ;

    public CategoryDTO() {
    }

    public CategoryDTO(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void populateDTO(Category category){
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
        this.noOfPigeons = category.getNoOfPigeons();
    }

    public Category populateDomainObject()
    {
        Category  category =  new Category();
        if(this.categoryId != null)
        {
            category.setCategoryId(this.categoryId);
        }
        category.setCategoryName(this.categoryName);
        category.setNoOfPigeons(this.noOfPigeons);
        return category;
    }

    public Integer getNoOfPigeons() {
        return noOfPigeons;
    }

    public void setNoOfPigeons(Integer noOfPigeons) {
        this.noOfPigeons = noOfPigeons;
    }
}
