package pers.ljf.spring.debug.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author: ljf
 * @date: 2021/4/4 7:02
 * @description:
 * @modified By：
 * @version: $ 1.0
 */
@Controller
public class BoyController {
	private final BoyService boyService;

	public BoyController(BoyService boyService) {
		this.boyService = boyService;
	}


	public void showBoy() {
		System.out.println(boyService.getBoy());
	}
}
