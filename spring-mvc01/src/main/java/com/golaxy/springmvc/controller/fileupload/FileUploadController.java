package com.golaxy.springmvc.controller.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author: ljf
 * @date: 2021/4/24 14:17
 * @description: 文件上传controller
 * @modified By:
 * @version: $ 1.0
 */
@Controller
public class FileUploadController {
	@PostMapping("/fileupload")
	public String upload(MultipartFile file, HttpServletRequest request, String desc) throws IOException {
		System.out.println(desc);
		if (file.isEmpty()) {
			return "false";
		}
		String path = request.getServletContext().getRealPath("/WEB-INF/file");
		String filename = file.getOriginalFilename();
		//上传文件后的存储路径？
		File filePath = new File(path, filename);
		System.out.println("file path: " + filePath);

		if (!filePath.getParentFile().exists()) {
			filePath.getParentFile().mkdir();
		}

		file.transferTo(filePath);
		return "success";
	}
}
