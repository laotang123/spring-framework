package pers.ljf.spring.debug.entity;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;

/**
 * @author: ljf
 * @date: 2021/3/25 15:36
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
@Data
public class PersonDestroy implements DisposableBean {
	private String name;
	private Integer age;

	@Override
	public void destroy() throws Exception {
		System.out.println("释放对象");
		this.name = null;
		this.age = null;
	}
}



