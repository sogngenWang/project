package com.dream.weddingexpo.bean;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Others {
	
	private String aboutAssociation;
	
	private String joinAssociation;

	public String getAboutAssociation() {
		return aboutAssociation;
	}

	public void setAboutAssociation(String aboutAssociation) {
		this.aboutAssociation = aboutAssociation;
	}

	public String getJoinAssociation() {
		return joinAssociation;
	}

	public void setJoinAssociation(String joinAssociation) {
		this.joinAssociation = joinAssociation;
	}
	
	
}
