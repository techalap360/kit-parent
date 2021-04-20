package com.kit.model.converter;

import static java.util.Collections.emptyList;

import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Zubayer Ahamed
 * @since Apr 18, 2021
 */
@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

	private static final String SPLIT_CHAR = ";";

	@Override
	public String convertToDatabaseColumn(List<String> stringList) {
		return stringList != null && stringList.size() > 1 ? String.join(SPLIT_CHAR, stringList) : "";
	}

	@Override
	public List<String> convertToEntityAttribute(String string) {
		return StringUtils.isNotBlank(string) ? Arrays.asList(string.split(SPLIT_CHAR)) : emptyList();
	}

}
