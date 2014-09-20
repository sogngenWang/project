package com.dream.weddingexpo.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class CommonUtils {
	/**
	 * 根据传入的paramMap去构建critera
	 */
	public static void setCriteria(Map<String, String> paramMap,Criteria criteria) {
		if (null != paramMap && !paramMap.isEmpty()) {
			Set<String> paramKeySet = paramMap.keySet();
			paramKeySet.isEmpty();
			Iterator<String> itrator = paramKeySet.iterator();
			while (itrator.hasNext()) {
				String itratorTempKey = itrator.next();
				String tempValue = paramMap.get(itratorTempKey);
				if (StringUtils.isNotBlank(tempValue)) {
					criteria.add(Restrictions.eq(itratorTempKey, tempValue));
				}
			}
		}

	}
	
}
