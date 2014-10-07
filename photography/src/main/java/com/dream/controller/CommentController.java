package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.bean.Comment;
import com.dream.bean.JsonClazz;
import com.dream.constants.Constant;
import com.dream.service.CommentService;

@Controller
public class CommentController {

	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;
	@Resource(name = "commentService")
	private CommentService commentService;
	
	@RequestMapping(value = "/detailComment", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JsonClazz detailComment(Comment comment) throws Exception {
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,commentService.detailComment(comment));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/listComment", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JsonClazz listComment(Comment comment)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_LIST,commentService.listComment(comment));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/updateComment", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JsonClazz updateComment(Comment comment)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,commentService.updateComment(comment));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/addComment" , method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JsonClazz addComment(Comment comment)throws Exception{
		jsonClazz.getData().clear();
		commentService.addComment(comment);
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	
	@RequestMapping(value = "/deleteComment" , method={RequestMethod.GET,RequestMethod.POST} )
	@ResponseBody
	public JsonClazz deleteComment(Comment comment)throws Exception{
		jsonClazz.getData().clear();
		commentService.deleteComment(comment.getCommentid());
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

}
