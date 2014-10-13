package com.dream.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dream.bean.JsonClazz;
import com.dream.constants.Constant;
import com.dream.utils.JsonUtil;

@Controller
public class UploadController {

	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;

	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	@ResponseBody
	public String uploadFile(HttpServletResponse response,HttpServletRequest request,@RequestParam(value="file", required=false) MultipartFile file) throws IOException{
        //临时目录在项目跟目录下会生成一个.tmp文件，上传完成之后会自动清理该文件
		
		byte[] bytes = file.getBytes();
		String uploadDir = request.getServletContext().getRealPath("/")+ Constant.FILE_PATH_PRE;
        File dirPath = new File(uploadDir);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        String sep = System.getProperty("file.separator");
        File uploadedFile = new File(uploadDir + sep + System.currentTimeMillis() +  file.getOriginalFilename());
        FileCopyUtils.copy(bytes, uploadedFile);
        String msg = "./"+Constant.FILE_PATH_PRE+"/"+uploadedFile.getName();
        
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,msg);
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		
		return JsonUtil.bean2json(jsonClazz);
	}
	
}
