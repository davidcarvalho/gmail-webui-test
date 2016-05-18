package com.appframework.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by David.Carvalho on 18-05-2016.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({Critical.class})
public interface Critical {
}
