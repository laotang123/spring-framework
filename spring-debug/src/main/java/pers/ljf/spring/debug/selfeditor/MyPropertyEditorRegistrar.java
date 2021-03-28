package pers.ljf.spring.debug.selfeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author: ljf
 * @date: 2021/3/28 12:29
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Address.class, new AddressPropertyEditor());
	}
}
