package com.neuedu.catshop.entity;

public class Kind {
	private Integer kindId;
	private String kindName;
	private String kindImage;
	
	
	public Kind() {
		super();
	}
	
	
	public Kind(Integer kindId) {
		super();
		this.kindId = kindId;
	}


	public Kind(String kindName) {
		super();
		this.kindName = kindName;
	}


	public Kind(Integer kindId, String kindName, String kindImage) {
		super();
		this.kindId = kindId;
		this.kindName = kindName;
		this.kindImage = kindImage;
	}
	public Integer getKindId() {
		return kindId;
	}
	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getKindImage() {
		return kindImage;
	}
	public void setKindImage(String kindImage) {
		this.kindImage = kindImage;
	}
	
	
}
