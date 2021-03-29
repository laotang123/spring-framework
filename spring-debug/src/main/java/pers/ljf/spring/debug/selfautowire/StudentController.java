package pers.ljf.spring.debug.selfautowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author: ljf
 * @date: 2021/3/29 6:49
 * @description:
 * @modified By:
 * @version: $ 1.0
 */
@Controller
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService){
		this.studentService = studentService;
	}

	public Student getStudent() {
		return studentService.getStudent();
	}
}
