package com.dream.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dream.bean.FileUpload;
import com.dream.bean.JsonClazz;
import com.dream.constants.Constant;

@Controller
public class UploadController {

	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;
	@Resource(name = "fileUpload")
	private FileUpload fileUpload;

	@RequestMapping(value = "/upload", method = RequestMethod.POST )
	@ResponseBody
	public JsonClazz upload(HttpServletRequest request) throws Exception {
		
		// 转型为MultipartHttpRequest(重点的所在)
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		
		// 获得第1张图片（根据前台的name名称得到上传的文件）
		MultipartFile imgFile = multipartRequest.getFile(Constant.UPLOAD_PARAM_NAME);
		if(null == imgFile || null == imgFile.getOriginalFilename() || imgFile.getOriginalFilename().isEmpty() ){
			jsonClazz.setState(Constant.FAILED);
			jsonClazz.setCode(Constant.FAILED_CODE);
			return jsonClazz;
		}
		
		// 保存图片
		String fileName = imgFile.getOriginalFilename();
		// 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		// 对扩展名进行小写转换
		ext = ext.toLowerCase();
		
				
		//构建新文件，以及文件保存路径
		String savePath = Constant.UPLOAD_FILE_UPLOAD_PATH+System.currentTimeMillis() ;
		
		File file = new File(savePath);
		
		
		// 如果扩展名属于允许上传的类型，则创建文件
		if (Constant.UPLOAD_IMG_TYPE.contains(ext)) { 
			// 保存上传的文件
			imgFile.transferTo(file); 
		}else{
			jsonClazz.setState(Constant.FAILED);
			jsonClazz.setCode(Constant.FAILED_CODE);
			return jsonClazz;
		}
		
		fileUpload.setFileNewName(savePath);
		fileUpload.setFilePath(savePath);
		jsonClazz.getData().put(Constant.JSON_IMG_PATH, fileUpload);
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		
		return jsonClazz;
	}

}
