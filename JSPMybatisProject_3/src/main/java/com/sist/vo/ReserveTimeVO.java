package com.sist.vo;
/*
 *  TNO                                       NOT NULL NUMBER
 TIME                                      NOT NULL VARCHAR2(10)
 */
public class ReserveTimeVO {
        private int tno;
        private String time;
		public int getTno() {
			return tno;
		}
		public void setTno(int tno) {
			this.tno = tno;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		  
}
