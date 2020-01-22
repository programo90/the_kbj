package com.thekbj.enter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;

public class BoardDAO {
   
   private static BoardDAO dao=new BoardDAO();
   private BoardDAO() {}
   public static BoardDAO getBoardDAO() {
      return dao;
   }
   public List<TableDTO> boardListData(Connection conn, int startrow, int pagepercount, String search, String txtsearch, String bview) throws SQLException{
      StringBuilder sql=new StringBuilder();
      /*sql.append(" select bno, bctg ,btitle, bcontent   ");
      sql.append("  , bviewcount ,btag ,brecount, blikecount, bimg ");
      sql.append(" from ent_board");*/
      
//      sql.append(" select @rownum:=@rownum+1 as rnum, b.*         ");
//      sql.append(" from (                                 ");
      sql.append("    select bno, bctg, btitle, bcontent, bviewcount,btag, brecount, blikecount, bimg, mnick, bwrdate      ");
      sql.append("   from ent_board                     ");
      
      if(!search.equals("") && !txtsearch.equals("")) {
         if(search.equals("title")) {
            sql.append(" where btitle like ? ");
         }else if(search.equals("content")) {
            sql.append(" where bcontent like ? ");
         }else if(search.equals("tag")) {
            sql.append(" where btag like ? ");
         }
      }
      
      System.out.println("boardListData bview: "+bview);
      
      if("".equals(bview)) {
         sql.append("   order by bwrdate desc   ");
      }
      else if(bview.equals("reply")) {
            sql.append("  order   by   brecount desc    ");
         }else if(bview.equals("view")) {
            sql.append("  order   by   bviewcount    desc ");   
         }else if(bview.equals("like")) {
            sql.append("  order   by   blikecount    desc ");
         }else if(bview.equals("date")){
           sql.append("       order by bwrdate desc      ");
         }else if(bview.equals("")) {
            sql.append("       order by bwrdate desc      ");
         }
      
      /*sql.append("       order by bwrdate desc               ");*/
//      sql.append(" )b                                    ");
//      sql.append(" where @rownum:=?                        ");
      sql.append(" limit ?,?                              ");
      
      List<TableDTO> list = new ArrayList<>();
      ResultSet rs=null;
      try (PreparedStatement psmt=conn.prepareStatement(sql.toString())
         ){
            if(!search.equals("") && !txtsearch.equals("")) {
               psmt.setString(1, "%"+txtsearch+"%");
//               psmt.setInt(2, pagepercount);
               psmt.setInt(2, startrow);
               psmt.setInt(3, pagepercount);
            }else {
//               psmt.setInt(1, pagepercount);
               psmt.setInt(1, startrow);
               psmt.setInt(2, pagepercount);
            }

            rs=psmt.executeQuery();
            while(rs.next()) {
               TableDTO dto=new TableDTO();
               dto.setBno(rs.getInt("bno"));
               dto.setBctg(rs.getString("bctg"));
               dto.setBtitle(rs.getString("btitle"));
               dto.setBcontent(rs.getString("bcontent"));
               dto.setBviewcount(rs.getInt("bviewcount"));
               dto.setBtag(rs.getString("btag"));
               dto.setBrecount(rs.getInt("brecount"));
               dto.setBlikecount(rs.getInt("blikecount"));
               dto.setBimg(rs.getString("bimg"));
               dto.setMnick(rs.getString("mnick"));
               dto.setBwrdate(rs.getString("bwrdate"));
               list.add(dto);
            }
      }catch(Exception e) {
         System.out.println(e);
      }finally {
         if(rs!=null) try {rs.close();} catch(SQLException e) {}
      }
      
      return list;
   }
   public void boardInsertData(Connection conn, TableDTO dto) throws SQLException {
      StringBuilder sql=new StringBuilder();
      sql.append(" insert into ent_board(   ");
      sql.append(" bctg, btitle, bcontent, bwrdate, bviewcount, btag, brecount, blikecount, bimg, mno, mnick) ");
      sql.append(" values( ?, ?, ?, sysdate(), 0, ?, 0, 0, ?, ?,?)       ");
      System.out.println("sql=" + sql.toString());
      try (
            PreparedStatement psmt=conn.prepareStatement(sql.toString());
         ){
         psmt.setString(1, dto.getBctg());
         psmt.setString(2, dto.getBtitle());
         psmt.setString(3, dto.getBcontent());
         psmt.setString(4, dto.getBtag());
         psmt.setString(5, dto.getBimg());
         psmt.setInt(6, dto.getMno());
         psmt.setString(7, dto.getMnick());
         
         System.out.println("dto =" +dto);
         
         psmt.executeUpdate();

      }catch (Exception e) {
         System.out.println(e);
      }
   }
   public TableDTO boardDetailData(Connection conn, int boardnum) throws SQLException {
      StringBuilder sql=new StringBuilder();
      sql.append(" select bno, bctg, btitle, bcontent, bwrdate, bviewcount, mnick, btag, brecount,bimg   ");
      sql.append(" from ent_board                  ");
      sql.append(" where bno=?                  ");
      
      ResultSet rs=null;
      TableDTO dto=new TableDTO();
   
      try(PreparedStatement psmt=conn.prepareStatement(sql.toString());){
         psmt.setInt(1, boardnum);
         rs=psmt.executeQuery();
         if(rs.next()) {
            dto.setBno(rs.getInt("bno"));
            dto.setBctg(rs.getString("bctg"));
            dto.setBtitle(rs.getString("btitle"));
            dto.setBcontent(rs.getString("bcontent"));
            dto.setBwrdate(rs.getString("bwrdate"));
            dto.setBviewcount(rs.getInt("bviewcount"));
            dto.setMnick(rs.getString("mnick"));
            dto.setBtag(rs.getString("btag"));
            dto.setBrecount(rs.getInt("brecount"));
            dto.setBimg(rs.getString("bimg"));
         }
         
      }finally {
         if(rs!=null) try {rs.close();} catch(SQLException e) {}
      }
      return dto;
   }
   public int boardModifyResultData(Connection conn, TableDTO dto) throws SQLException{
      // TODO Auto-generated method stub
      StringBuilder sql=new StringBuilder();
      sql.append(" update ent_board                ");
      sql.append(" set bctg=?, btitle=?,    bcontent=?, btag=? , bimg=?   ");
      sql.append(" where bno=?                  ");
      
      int modifyresult=0;
      try(PreparedStatement psmt=conn.prepareStatement(sql.toString());){
         psmt.setString(1, dto.getBctg());
         psmt.setString(2, dto.getBtitle());
         psmt.setString(3, dto.getBcontent());
         psmt.setString(4, dto.getBtag());
         psmt.setString(5, dto.getBimg());
         psmt.setInt(6, dto.getBno());
         modifyresult=psmt.executeUpdate();
      }
      return modifyresult;
   }
   public int boardRemoveData(Connection conn, int bno) throws SQLException{
      // TODO Auto-generated method stub
      StringBuilder sql=new StringBuilder();
      sql.append(" delete from ent_board   ");
      sql.append(" where bno=?         ");
      int result=0;
      
      try (
            PreparedStatement psmt=conn.prepareStatement(sql.toString());
         ){
         psmt.setInt(1, bno);
         result=psmt.executeUpdate();
      }
      return result;
   }
   public int getTotalCountData(Connection conn, String search, String txtsearch)throws SQLException {
      // TODO Auto-generated method stub
      StringBuilder sql= new StringBuilder();
      sql.append(" select count(*)   ");
      sql.append(" from ent_board      ");
      if(!search.equals("") && !txtsearch.equals("")) {
         if(search.equals("btitle")) {
            sql.append(" where btitle like ?      ");
         }else if(search.equals("bcontent")) {
            sql.append(" where bcontent like ?   ");
         }else if(search.equals("tag")) {
            sql.append(" where btag like ? ");
         }
      }
      ResultSet rs=null;
      int count=0;
      
      try (
            PreparedStatement psmt=conn.prepareStatement(sql.toString());
         ){
            if(!search.equals("") && !txtsearch.equals("")) {
               psmt.setString(1, "%"+txtsearch+"%");
            }
            rs=psmt.executeQuery();
            if(rs.next()) {
               count=rs.getInt(1);
         }
      }finally {
         if(rs!=null) try {rs.close();} catch(SQLException e) {}
      }
      return count;
   }
   public void recount(Connection conn, int boardnum) throws SQLException {
      // TODO Auto-generated method stub
      StringBuilder sql=new StringBuilder();
      sql.append(" update ent_board               ");
      sql.append(" set bviewcount=IFNULL(bviewcount,0)+1   ");
      sql.append(" where bno=?                  ");
      
      try (
            PreparedStatement psmt=conn.prepareStatement(sql.toString());
         ){
            psmt.setInt(1, boardnum);
            psmt.executeUpdate();
      }catch(Exception e) {
         System.out.println(e);
      }
   }
   public void repInsertData(Connection conn, ReplyDTO dto) throws SQLException{
      StringBuilder sql = new StringBuilder();
      sql.append(" insert into ent_reply       ");
      sql.append(" (rno, bno, rcontent, rwrdate, mno)    ");
      sql.append(" values( null,?,?,sysdate(),? )   ");
      try(
            PreparedStatement psmt=conn.prepareStatement(sql.toString());
         ){
            psmt.setInt(1, dto.getBno());
            psmt.setString(2, dto.getRcontent());
            psmt.setInt(3, dto.getMno());
            psmt.executeUpdate();
      }
   }
   public List<ReplyDTO> repListData(Connection conn, int bno) throws SQLException{
      StringBuilder sql=new StringBuilder();
      sql.append(" select rno, ent_reply.bno, rcontent, rwrdate, member.mnick, member.mno ");
      sql.append(" from ent_reply join member                  ");
      sql.append(" on ent_reply.mno=member.mno               ");
      sql.append(" where bno=?                            ");
      sql.append(" order by rwrdate desc                     ");
      
      ArrayList<ReplyDTO> arr=new ArrayList<>();
      ResultSet rs=null;
      try (
            PreparedStatement psmt=conn.prepareStatement(sql.toString());
         ){
         psmt.setInt(1, bno);
         rs=psmt.executeQuery();
         while(rs.next()) {
            ReplyDTO repdto=new ReplyDTO();
            repdto.setBno(rs.getInt("bno"));
            repdto.setRno(rs.getInt("rno"));
            repdto.setRcontent(rs.getString("rcontent"));
            repdto.setRwrdate(rs.getString("rwrdate"));
            repdto.setMnick(rs.getString("mnick"));
            repdto.setMno(rs.getInt("mno"));
            arr.add(repdto);
         }
      }finally {
         if(rs!=null) try{rs.close();} catch(SQLException e) {}
      }
      return arr;
   }
   public void repRemoveData(Connection conn, int rno, int mno)throws SQLException {
      // TODO Auto-generated method stub
      StringBuilder sql=new StringBuilder();
      sql.append(" delete from ent_reply   ");
      sql.append(" where rno=?          ");
      
      try(
            PreparedStatement psmt=conn.prepareStatement(sql.toString());
         ){
            psmt.setInt(1, rno);
            psmt.executeUpdate();
      }
   }
   public void replyTotalcount(Connection conn, int boardnum) throws SQLException {
      // TODO Auto-generated method stub
      StringBuilder sql=new StringBuilder();
      sql.append(" select count(*) from ent_reply   ");
      sql.append(" where bno=?               ");
      
      try (PreparedStatement psmt=conn.prepareStatement(sql.toString())
         ){
            psmt.setInt(1, boardnum);
            psmt.executeQuery();
      }
      
   }

}