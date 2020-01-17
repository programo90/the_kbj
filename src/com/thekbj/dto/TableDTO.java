package com.thekbj.dto;

public class TableDTO {
	private int bno;
	private int mno;
	private String bctg;
	private String btitle;
	private String bcontent;
	private String bwrdate;
	private int bviewcount;
	private String btag;
	private String bapi;
	private int brecount;
	private int blikecount;
	private String bimg;
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
	public String getBapi() {
		return bapi;
	}
	public void setBapi(String bapi) {
		this.bapi = bapi;
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
	@Override
	public String toString() {
		return "TableDTO [bno=" + bno + ", mno=" + mno + ", bctg=" + bctg + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bwrdate=" + bwrdate + ", bviewcount=" + bviewcount + ", btag=" + btag + ", bapi=" + bapi
				+ ", brecount=" + brecount + ", blikecount=" + blikecount + ", bimg=" + bimg + "]";
	}
	
}