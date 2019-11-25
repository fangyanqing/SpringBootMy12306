package com.neuedu.catshop.entity;


public class Product {
	
	private Integer proid;
	private String proname;
	private String gender;
	private String age;
	private String weight;
	private Double yj;
	private Double xj;
	private Integer  kcsl;
	private String color;
	private String ms;
	private String cd;
	private String tp;
	private String sjrq;
	private String state;
	private String tp1;
	private String tp2;
	private String tp3;
	
	private Kind kind;
	
	
	
	public Product() {
		super();
	}
	
	
	public Product(Integer proid) {
		super();
		this.proid = proid;
	}


	public Product(Integer proid, String proname, String gender, String age, String weight, Double yj, Double xj,
			Integer kcsl, String color, String ms, String cd, String tp, String sjrq, String state, String tp1,
			String tp2, String tp3, Kind kind) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.yj = yj;
		this.xj = xj;
		this.kcsl = kcsl;
		this.color = color;
		this.ms = ms;
		this.cd = cd;
		this.tp = tp;
		this.sjrq = sjrq;
		this.state = state;
		this.tp1 = tp1;
		this.tp2 = tp2;
		this.tp3 = tp3;
		this.kind = kind;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Double getYj() {
		return yj;
	}
	public void setYj(Double yj) {
		this.yj = yj;
	}
	public Double getXj() {
		return xj;
	}
	public void setXj(Double xj) {
		this.xj = xj;
	}
	public Integer getKcsl() {
		return kcsl;
	}
	public void setKcsl(Integer kcsl) {
		this.kcsl = kcsl;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getTp() {
		return tp;
	}
	public void setTp(String tp) {
		this.tp = tp;
	}
	public String getSjrq() {
		return sjrq;
	}
	public void setSjrq(String sjrq) {
		this.sjrq = sjrq;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTp1() {
		return tp1;
	}
	public void setTp1(String tp1) {
		this.tp1 = tp1;
	}
	public String getTp2() {
		return tp2;
	}
	public void setTp2(String tp2) {
		this.tp2 = tp2;
	}
	public String getTp3() {
		return tp3;
	}
	public void setTp3(String tp3) {
		this.tp3 = tp3;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	
	
	
	
}
