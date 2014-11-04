package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Checkcode;
import com.dream.constants.Constant;
import com.dream.dao.CheckcodeMapper;
import com.dream.service.CheckcodeService;
import com.dream.utils.CommonUtils;

@Repository(value = "checkcodeService")
public class CheckcodeServiceImpl implements CheckcodeService {

	@Autowired
	private CheckcodeMapper checkcodeDao;

	@Override
	public List<Checkcode> listCheckcode(Checkcode checkcode) {

		return checkcodeDao.listCheckcode(checkcode);
	}

	@Override
	public Checkcode detailCheckcode(Checkcode checkcode) {

		return checkcodeDao.detailCheckcode(checkcode);
	}

	@Override
	public int updateCheckcode(Checkcode checkcode) {

		return checkcodeDao.updateByPrimaryKeySelective(checkcode);
	}

	@Override
	public int deleteCheckcode(int uid) {

		return checkcodeDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addCheckcode(Checkcode checkcode) {

		return checkcodeDao.insert(checkcode);

	}

	@Override
	public int countCheckcode(Checkcode checkcode) {

		return checkcodeDao.countCheckcode(checkcode);
	}

	@Override
	public String addCheckcodeAndSendMobile(String telephone) {
		//生成校验码，然后插入数据库
		Checkcode checkcode = new Checkcode();
		String checkcodeString = CommonUtils.createCheckCode(Constant.CHECKCODE_LENGTH);
		checkcode.setCheckcode(checkcodeString);
		checkcode.setTelephone(telephone);
		checkcode.setCreatetime(CommonUtils.getSYSDate());
		checkcodeDao.insert(checkcode);
		// 发送校验码到手机上
		CommonUtils.sendCheckCode(telephone, checkcodeString);
		return checkcodeString;
	}

}
