package pers.ljf.spring.debug.selfautowire;

import org.springframework.stereotype.Service;

/**
 * @author: ljf
 * @date: 2021/3/29 6:48
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Override
	public Student getStudent() {
		return new Student();
	}
}
