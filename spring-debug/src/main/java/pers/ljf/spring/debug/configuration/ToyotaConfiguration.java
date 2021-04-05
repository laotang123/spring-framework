package pers.ljf.spring.debug.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ljf
 * @date: 2021/4/4 6:49
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
@Configuration
public class ToyotaConfiguration {
	@Bean(name = "toyota")
	public Toyota getToyota() {
		return new Toyota();
	}
}
