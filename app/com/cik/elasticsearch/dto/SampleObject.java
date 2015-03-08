package com.cik.elasticsearch.dto;

import java.util.Arrays;

import io.searchbox.annotations.JestId;

public class SampleObject {
	@JestId
	private String id;
	private String name;
	private String source;
	private String url;
	private String recipeYeild;
	private String[] ingredients;
	private String prepTime;
	private String cookTime;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRecipeYeild() {
		return recipeYeild;
	}

	public void setRecipeYeild(String recipeYeild) {
		this.recipeYeild = recipeYeild;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "SampleObject [id=" + id + ", name=" + name + ", source="
				+ source + ", url=" + url + ", recipeYeild=" + recipeYeild
				+ ", ingredients=" + Arrays.toString(ingredients)
				+ ", prepTime=" + prepTime + ", cookTime=" + cookTime
				+ ", description=" + description + "]";
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
