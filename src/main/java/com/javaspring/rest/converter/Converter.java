package com.javaspring.rest.converter;

import org.springframework.beans.BeanUtils;

public abstract class Converter<T1, T2> {
	public static<T1, T2> void convertModel(T1 from, T2 to) {
		BeanUtils.copyProperties(from, to);
	}
}