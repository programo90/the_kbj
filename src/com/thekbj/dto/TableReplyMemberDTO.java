package com.thekbj.dto;

public class TableReplyMemberDTO {
	private int bno;
	private int mno;
	private String bctg;
	private String btitle;
	private String bcontent;
	private String bwrdate;
	private int bviewcount;
	private String btag;
	private int brecount;
	private int blikecount;
	private String bimg;
	private String bnick;
	private int rno;
	private String rcontent;
	private String rwrdate;
	private String rnick;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getBctg() {
		return bctg;
	}
	public void setBctg(String bctg) {
		this.bctg = bctg;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwrdate() {
		return bwrdate;
	}
	public void setBwrdate(String bwrdate) {
		this.bwrdate = bwrdate;
	}
	public int getBviewcount() {
		return bviewcount;
	}
	public void setBviewcount(int bviewcount) {
		this.bviewcount = bviewcount;
	}
	public String getBtag() {
		return btag;
	}
	public void setBtag(String btag) {
		this.btag = btag;
	}
	public int getBrecount() {
		return brecount;
	}
	public void setBrecount(int brecount) {
		this.brecount = brecount;
	}
	public int getBlikecount() {
		return blikecount;
	}
	public void setBlikecount(int blikecount) {
		this.blikecount = blikecount;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	public String getBnick() {
		return bnick;
	}
	public void setBnick(String bnick) {
		this.bnick = bnick;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
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
	public void setRwrdate(String rwrdate) {
		this.rwrdate = rwrdate;
	}
	public String getRnick() {
		return rnick;
	}
	public void setRnick(String rnick) {
		this.rnick = rnick;
	}
	@Override
	public String toString() {
		return "TableRelpyDTO [bno=" + bno + ", mno=" + mno + ", bctg=" + bctg + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bwrdate=" + bwrdate + ", bviewcount=" + bviewcount + ", btag=" + btag + ", brecount="
				+ brecount + ", blikecount=" + blikecount + ", bimg=" + bimg + ", bnick=" + bnick + ", rno=" + rno
				+ ", rcontent=" + rcontent + ", rwrdate=" + rwrdate + ", rnick=" + rnick + "]";
	}
	
	
}
