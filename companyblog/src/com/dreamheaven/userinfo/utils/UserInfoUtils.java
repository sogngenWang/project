package com.dreamheaven.userinfo.utils;

import com.dreamheaven.userinfo.domain.UserInfo;

public class UserInfoUtils {
	//按顺序赋值
	public static void copyPropertiesUserInfo(UserInfo userInfo,Object[] objArrayTemp)
	{
		
		userInfo.setUid(objArrayTemp[0]==null ? null : objArrayTemp[0].toString());
		userInfo.setNickName(objArrayTemp[1]==null ?null :  objArrayTemp[1].toString());
		userInfo.setAge(objArrayTemp[2]==null ? null : objArrayTemp[2].toString());
		userInfo.setSex(objArrayTemp[3]==null ? null : objArrayTemp[3].toString());
		userInfo.setBirthday(objArrayTemp[4]==null ? null : objArrayTemp[4].toString());
		userInfo.setHoby(objArrayTemp[5]==null ? null : objArrayTemp[5].toString());
		userInfo.setCompanyId(objArrayTemp[6]==null ? null : objArrayTemp[6].toString());
		userInfo.setHeadImgPath(objArrayTemp[7]==null ? null : objArrayTemp[7].toString());
		
	}
}
