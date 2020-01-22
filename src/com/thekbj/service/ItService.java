package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.it.dao.BoardDAO;

public class ItService {
	private static ItService service = new ItService();
	public static ItService getInstance() {
		return service;
	}
	public List<TableDTO> boardList(String bctg,String btag,int startRow, int endRow, String searchType, String searchtxt) {
		// TODO Auto-generated method stub
		List<TableDTO> list = null;
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		
		try {
			conn = db.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			
			list = dao.boardListData(conn,bctg,btag,startRow,endRow,searchType,searchtxt);
			
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		return list;
	}//end boardlist
	
	
	public int getTotalCount() {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		int totalCount = 0;
		try {
			conn = db.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			
			totalCount = dao.getTotalCountData(conn);
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		return totalCount;
	}
	
	public TableDTO boardDetail(int bno) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		TableDTO dto = null;
		try {
			 conn = db.getConnection();
			 conn.setAutoCommit(false);
			 
			BoardDAO dao = BoardDAO.getInstance();
			
			dao.updateViewcountData(conn, bno);
			dto = dao.boardDetailData(conn,bno);
			
			conn.commit();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		return dto;
	}//end boardDetail
	
	public List<ReplyDTO> repList(int bno) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		List<ReplyDTO> list = null;
		try {
			conn=db.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			
			list = dao.repListData(conn, bno);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		return list;
	}//end repList
	public void repInsert(ReplyDTO dto) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getInstance();
			dao.boardRecountIncrease(conn, dto);
			dao.repInsertData(conn, dto);
			dao.increaseMscore(conn, dto.getMno());
			
			conn.commit();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
	}
	public void repRemove(int rno,int bno) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getInstance();
			dao.boardRecountDecrease(conn,bno);
			dao.repRemoveData(conn, rno);
			
			conn.commit();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
	}
	
	public void boardInsertResult(TableDTO dto) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getInstance();
			dao.boardInsertData(conn,dto);
			dao.increaseMscore(conn, dto.getMno());;
			
			
			conn.commit();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
	}
	public void boardRemove(int bno) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getInstance();
			dao.boardRemoveData(conn,bno);
			
			conn.commit();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
	}
	public TableDTO boardModify(int bno) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		TableDTO dto = null;
		try {
			 conn = db.getConnection();
			 
			BoardDAO dao = BoardDAO.getInstance();
			
			dto = dao.boardModifyData(conn,bno);
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		return dto;
	}
	public void boardModifyResult(TableDTO dto) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		try {
			 conn = db.getConnection();
			 conn.setAutoCommit(false);
			 
			BoardDAO dao = BoardDAO.getInstance();
			dao.boardModifyResultData(conn,dto);

			conn.commit();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
	}
	public int boardLike(int bno, int mno) {
		// TODO Auto-generated method stub
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		int blikecount = 0;
		try {
			 conn = db.getConnection();
			 conn.setAutoCommit(false);
			 
			BoardDAO dao = BoardDAO.getInstance();
			boolean tf = dao.searchLike(conn,bno,mno);
			if(tf) {
				dao.likeInsertData(conn,bno,mno);
				dao.increseLikecount(conn,bno);
				blikecount = dao.getLikecount(conn,bno);
			}
			

			conn.commit();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		
		return blikecount;
	}
	public List<TableDTO> allList() {
		// TODO Auto-generated method stub
		List<TableDTO> list = null;
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		
		try {
			conn = db.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			
			list = dao.allListData(conn);
			
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		return list;
	}
}
