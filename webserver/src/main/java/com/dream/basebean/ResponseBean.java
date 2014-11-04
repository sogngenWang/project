package com.dream.basebean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dream.constants.Constant;
import com.dream.utils.CommonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * POST响应对象
 * 
 * @author 王松根
 * @date 2014年10月28日
 */
@JsonInclude(Include.NON_NULL)
public class ResponseBean {

	public static final Log LOG = LogFactory.getLog(ResponseBean.class);
	// 响应消息对象
	private MsgBean msg = new MsgBean();
	// 响应内容
	private Object content;
	// 响应内容MAC校验值
	private String mac;

	public MsgBean getMsg() {
		return msg;
	}

	public Object getContent() {
		return content;
	}

	@SuppressWarnings("unchecked")
	public void setContent(Object content) {
		//content默认应该是null
		
		//设置过的值，有可能是Map List Object 
		
		//判断content的类型，假如已经被设置过值，并且是list类型的，则第二次进来设置的是分页对象
		if (null != this.content && this.content instanceof List ){
			ArrayList<Object> contentList = (ArrayList<Object>) this.content;
			HashMap<String ,Object> contentTmp = new HashMap<String ,Object>();
			contentTmp.put(Constant.JSON_LIST, contentList);
			contentTmp.put("currentPage",((PageBase)content).getCurrentPage());
			contentTmp.put("totalPage",((PageBase)content).getTotalPage());
			contentTmp.put("recordPerPage",((PageBase)content).getRecordPerPage());
			this.content = contentTmp;
		}else{
			this.content = content;
		}
		
//		this.content = content;
	}

	public void setMsg(MsgBean msg) {
		this.msg = msg;
	}

	public String getMac() {
		return mac;
	}

	/**
	 * 当前只支持content类型分别为 null , ArrayList, Map<String,Object> , Object
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String setMac(String key) {
		
		
		// 把content对象转化成Map类型(原来应该是一个对象)
		if (null == content) {
			//针对content为空的情况
			return null;
		}else if (content instanceof ArrayList) {
			//针对传入的是一个List的情况
			ArrayList<Object> contentList = (ArrayList<Object>) content;
			this.mac = CommonUtils.caculateList(contentList, key);
			content = new HashMap<String,ArrayList<Object>>();
			((HashMap<String,ArrayList<Object>>)content).put(Constant.JSON_LIST, contentList);
		}else {
			//普通对象型
			// 把对象转化成map
			Map<String, Object> map = null;
			try {
				map = CommonUtils.objectToMap(null, content);
			} catch (Exception e) {
				LOG.error("objectToMap error  " + e.getMessage());
			}
			this.mac = CommonUtils.calculateMac(map, key);
		} 
		
		return this.mac;
	}
}
