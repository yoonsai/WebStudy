package com.sist.vo;
/*
 * NO NUMBER,
id VARCHAR2(20),
fno NUMBER,
DAY VARCHAR2(100) CONSTRAINT res_day_nn NOT NULL,
time VARCHAR2(100) CONSTRAINT res_time_nn NOT NULL,
inwon VARCHAR2(20) CONSTRAINT res_inwon_nn NOT NULL,
regdate DATE DEFAULT SYSDATE,
ok NUMBER DEFAULT 0,
CONSTRAINT res_no_pk PRIMARY KEY(no),
CONSTRAINT res_id_fk FOREIGN KEY(id)
REFERENCES project_member(id),
CONSTRAINT res_fno_fk FOREIGN KEY(fno)
REFERENCES food_menu_house(fno)
 * 
 * 
 */
import java.util.*;
public class ReserveInfoVO {
	private int no,fno,ok;
	private String id,day,time,inwon,dbday;
	private Date regdate;
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
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
