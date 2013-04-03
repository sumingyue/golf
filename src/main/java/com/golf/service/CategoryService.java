package com.golf.service;

import java.util.List;

import com.golf.entity.Category;
import com.golf.entity.SmallCategory;

public interface CategoryService {

	public int deleteCategory(int categoryId);
	
	public int deleteSmallCategory(int smallCategoryId);
	
	public Category findCategory(int categoryId);

	public SmallCategory findSmallCategory(int smallCategoryId);

	public int insertCategory(Category category);

	public int insertSmallCategory(SmallCategory smallCategory);

	public List<Category> queryAllCategories();

	public List<Category> queryAllCategories(int type);

	public List<SmallCategory> queryAllSmallCategory();

	public List<SmallCategory> queryAllSmallCategoryByTypeCategoryId(int type,int categoryId);

	public int updateCategory(Category category);

	public int updateSmallCategory(SmallCategory smallCategory);

}
