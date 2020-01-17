package com.thekbj.dto;

public class MemberDTO {
	private int mno;
	private String mid;
	private int mpw;
	private String mname;
	private String mbdate;
	private String memail;
	private String mnick;
	private int mscore; 
	private String mjoindate;
	private String mimg;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getMpw() {
		return mpw;
	}
	public void setMpw(int mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbdate() {
		return mbdate;
	}
	public void setMbdate(String mbdate) {
		this.mbdate = mbdate;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMnick() {
		return mnick;
	}
	public void setMnick(String mnick) {
		this.mnick = mnick;
	}
	public int getMscore() {
		return mscore;
	}
	public void setMscore(int mscore) {
		this.mscore = mscore;
	}
	public String getMjoindate() {
		return mjoindate;
	}
	public void setMjoindate(String mjoindate) {
		this.mjoindate = mjoindate;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	@Override
	public String toString() {
		return "MemberDTO [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mbdate=" + mbdate
				+ ", memail=" + memail + ", mnick=" + mnick + ", mscore=" + mscore + ", mjoindate=" + mjoindate
				+ ", mimg=" + mimg + "]";
	}
}