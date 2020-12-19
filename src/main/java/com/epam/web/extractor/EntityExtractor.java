package com.epam.web.extractor;

import com.epam.web.entity.Entity;

import java.util.Map;

public interface EntityExtractor<T> {
   Map<String, Object> parse (T entity);
}
