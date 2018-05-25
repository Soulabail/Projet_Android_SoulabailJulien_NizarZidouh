package com.easycocktail.smarteaz;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    private String name;
    private String category;
    private String mainRecipe;
    private List<String> ingredients;
    private String imageLink;
    private String lastTimeModified;
    private String glassType;
    private String alcoholic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;


    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMainRecipe() {
        return mainRecipe;
    }

    public void setMainRecipe(String mainRecipe) {
        this.mainRecipe = mainRecipe;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getLastTimeModified() {
        return lastTimeModified;
    }

    public void setLastTimeModified(String lastTimeModified) {
        this.lastTimeModified = lastTimeModified;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
