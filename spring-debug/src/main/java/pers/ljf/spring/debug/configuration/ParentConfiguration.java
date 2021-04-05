package pers.ljf.spring.debug.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: ljf
 * @date: 2021/4/4 6:56
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
@Configuration
@Import({ToyotaConfiguration.class, VolkswagenConfiguration.class})
public class ParentConfiguration {
	@Bean(name = "car")
	public Car getCar() {
		return new Car() {
			@Override
			public void print() {
				System.out.println("i am inner subClass");
			}
		};
	}
}
