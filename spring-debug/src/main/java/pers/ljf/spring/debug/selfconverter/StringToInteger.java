package pers.ljf.spring.debug.selfconverter;

import org.springframework.core.convert.converter.Converter;

/**
 * @author: ljf
 * @date: 2021/4/2 13:24
 * @description: 自定义转换器
 * @modified By：
 * @version: $ 1.0
 */
public class StringToInteger implements Converter<String, Integer> {
	@Override
	public Integer convert(String source) {
		return Integer.valueOf(source);
	}
}
