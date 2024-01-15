package com.sist.vo;
/*
 *   NO                                        NOT NULL NUMBER
 ID                                                 VARCHAR2(20)
 FNO                                                NUMBER
 DAY                                       NOT NULL VARCHAR2(100)
 TIME                                      NOT NULL VARCHAR2(100)
 INWON                                     NOT NULL VARCHAR2(50)
 REGDATE                                            DATE
 OK                                                 NUMBER
 */
import java.util.*;
public class ReserveInfoVO {
    private int no,fno,ok;
    private String id,day,time,inwon;
    private String poster,name,address;
    private Date regdate;
    private FoodVO fvo=new FoodVO();
    
    
	public FoodVO getFvo() {
		return fvo;
	}
	public void setFvo(FoodVO fvo) {
		this.fvo = fvo;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getOk() {
		return ok;
	}
	public void setOk(int ok) {
		this.ok = ok;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInwon() {
		return inwon;
	}
	public void setInwon(String inwon) {
		this.inwon = inwon;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fno+" "+day+" "+time+" "+inwon+" "+id;
	}
	
	   
}
