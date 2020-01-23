package com.thekbj.dto;

public class ReplyDTO {
	private int rno;
	private int bno;
	private String rcontent;
	private String rwrdate;
	private String mnick;
	private int mno;
	private String rimg;
	
	
	public String getRimg() {
		return rimg;
	}
	public void setRimg(String rimg) {
		this.rimg = rimg;
	}
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
	public String getRwrdate() {
		return rwrdate;
	}
	public void setRwrdate(String rwdate) {
		this.rwrdate = rwdate;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", bno=" + bno + ", rcontent=" + rcontent + ", rwrdate=" + rwrdate + ", mnick="
				+ mnick + ", mno=" + mno + ", rimg=" + rimg + "]";
	}
	
}
