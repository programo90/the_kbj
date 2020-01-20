package com.thekbj.dto;

public class ReplyDTO {
	private int rno;
	private int bno;
	private String rcontent;
	private String rwdate;
	private int mno;
	private String mnick;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMnick() {
		return mnick;
	}
	public void setMnick(String mnick) {
		this.mnick = mnick;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRwdate() {
		return rwdate;
	}
	public void setRwdate(String rwdate) {
		this.rwdate = rwdate;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", bno=" + bno + ", rcontent=" + rcontent + ", rwdate=" + rwdate + ", mno="
				+ mno + ", mnick=" + mnick + "]";
	}
	
	
}
