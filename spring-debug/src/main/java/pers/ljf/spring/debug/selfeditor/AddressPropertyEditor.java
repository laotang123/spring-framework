package pers.ljf.spring.debug.selfeditor;

import java.beans.PropertyEditorSupport;

/**
 * @author: ljf
 * @date: 2021/3/28 12:26
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
public class AddressPropertyEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			String[] split = text.split("-");
			Address address = new Address();
			address.setProvince(split[0]);
			address.setCity(split[1]);
			address.setTown(split[2]);
			this.setValue(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
