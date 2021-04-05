package pers.ljf.spring.debug.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ljf
 * @date: 2021/4/4 7:00
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
@Service
public class BoyService {
	@Autowired
	private Boy boy;

	public Boy getBoy() {
		return this.boy;
	}
}
