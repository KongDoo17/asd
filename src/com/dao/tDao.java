package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dto.tDto;



public class tDao {
   Connection conn = null;
   PreparedStatement pstmt = null;
   int result = 0;
   ResultSet rs = null;
   int pageSize=5;

   public Connection getConnection() {
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      String url = "jdbc:mysql://58.235.52.224:3306/asd?useUnicode=true&characterEncoding=utf8";
      String dbid = "asd";
      String dbpw = "1234";
      try {
         conn = DriverManager.getConnection(url, dbid, dbpw);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return conn;
   }

   public void freeConnection(Connection c, PreparedStatement ps, ResultSet r) {

      try {
         if (c != null) {
            c.close();
         }
         if (ps != null) {
            ps.close();
         }
         if (r != null) {
            r.close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public void freeConnection(Connection c, PreparedStatement ps) {

      try {
         if (c != null) {
            c.close();
         }
         if (ps != null) {
            ps.close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }
   
   
   
   public int freelike(String brx ,String good) {

		PreparedStatement pstmt = null;
			if(Integer.parseInt(good)==5){
				String category = "free";
				inshot(brx, category);
				delhot(brx, category);
			}

	        try {
	        conn = getConnection();
			String sql = "UPDATE free SET good = good + 1 WHERE brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brx);
			return pstmt.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return -1;
	}
   
   public int humorlike(String brx ,String good) {

		PreparedStatement pstmt = null;
			if(Integer.parseInt(good)==5){
				String category = "humor";
				inshot(brx, category);
				delhot(brx, category);
			}

	        try {
	        conn = getConnection();
			String sql = "UPDATE humor SET good = good + 1 WHERE brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brx);
			return pstmt.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return -1;
	}
   
   public int hotlike(String brx ,String good) {

		PreparedStatement pstmt = null;
	        try {
	        conn = getConnection();
			String sql = "UPDATE hot SET good = good + 1 WHERE brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brx);
			return pstmt.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return -1;
	}
   
   public int inshot(String brx , String category) {
	   
	   PreparedStatement pstmt = null;
	      try {
	         conn = getConnection();
	         String sql = "insert into hot (title,contents,writer,rdate,rtime,good,comments) (select title,contents,writer,rdate,rtime,good + 1,comments from "+category+" where brx="+brx+")";
	         pstmt = conn.prepareStatement(sql);
	         return pstmt.executeUpdate();

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt);
	      }
	      return result;
	   }
   
   
   public int delhot(String brx , String category) {
	   PreparedStatement pstmt = null;
	      try {
	         conn = getConnection();
	         String sql = "delete from "+category+" where brx="+brx;
	         pstmt = conn.prepareStatement(sql);
	         return pstmt.executeUpdate();

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt);
	      }
	      return result;
	   }
   
   
   public Vector<tDto> hot() {
      Vector<tDto> v = new Vector<>();
      try {
         conn = getConnection();
         String sql = "select * from hot order by brx DESC Limit 15";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while (rs.next()) {
           tDto dto = new tDto();
            dto.setBrx(rs.getInt(1));
            dto.setTitle(rs.getString(2));
            dto.setContent(rs.getString(3));
            v.add(dto);
         }
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         freeConnection(conn, pstmt, rs);
      }
      return v;
   }
   
   public Vector<tDto> hotboard() {
	      Vector<tDto> v = new Vector<>();
	      try {
	         conn = getConnection();
	         String sql = "select * from hot order by brx DESC";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	           tDto dto = new tDto();
	            dto.setBrx(rs.getInt(1));
	            dto.setTitle(rs.getString(2));
	            dto.setContent(rs.getString(3));
	            dto.setWriter(rs.getString(4));
	            dto.setDate(rs.getString(5));
	            dto.setTime(rs.getString(6));
	            dto.setGood(rs.getInt(7));
	            dto.setComment(rs.getInt(8));
	            v.add(dto);
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt, rs);
	      }
	      return v;
	   }
   
   public Vector<tDto> freeboard() {
	      Vector<tDto> v = new Vector<>();
	      try {
	         conn = getConnection();
	         String sql = "select * from free order by brx DESC";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	           tDto dto = new tDto();
	            dto.setBrx(rs.getInt(1));
	            dto.setTitle(rs.getString(2));
	            dto.setContent(rs.getString(3));
	            dto.setWriter(rs.getString(4));
	            dto.setDate(rs.getString(5));
	            dto.setTime(rs.getString(6));
	            dto.setGood(rs.getInt(7));
	            dto.setComment(rs.getInt(8));
	            v.add(dto);
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt, rs);
	      }
	      return v;
	   }
   
   public Vector<tDto> humorboard() {
	      Vector<tDto> v = new Vector<>();
	      try {
	         conn = getConnection();
	         String sql = "select * from humor order by brx DESC";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	           tDto dto = new tDto();
	            dto.setBrx(rs.getInt(1));
	            dto.setTitle(rs.getString(2));
	            dto.setContent(rs.getString(3));
	            dto.setWriter(rs.getString(4));
	            dto.setDate(rs.getString(5));
	            dto.setTime(rs.getString(6));
	            dto.setGood(rs.getInt(7));
	            dto.setComment(rs.getInt(8));
	            v.add(dto);
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt, rs);
	      }
	      return v;
	   }
   
   
   public Vector<tDto> tradeboard() {
	      Vector<tDto> v = new Vector<>();
	      try {
	         conn = getConnection();
	         String sql = "select * from trade order by brx DESC";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	           tDto dto = new tDto();
	            dto.setBrx(rs.getInt(1));
	            dto.setTitle(rs.getString(2));
	            dto.setContent(rs.getString(3));
	            dto.setWriter(rs.getString(4));
	            dto.setDate(rs.getString(5));
	            dto.setTime(rs.getString(6));	       
	            dto.setComment(rs.getInt(7));
	            v.add(dto);
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt, rs);
	      }
	      return v;
	   }
   
   public Vector<tDto> unknownsboard() {
	      Vector<tDto> v = new Vector<>();
	      try {
	         conn = getConnection();
	         String sql = "select * from unknowns order by brx DESC";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	           tDto dto = new tDto();
	            dto.setBrx(rs.getInt(1));
	            dto.setTitle(rs.getString(2));
	            dto.setContent(rs.getString(3));
	            dto.setWriter(rs.getString(4));
	            dto.setDate(rs.getString(5));
	            dto.setTime(rs.getString(6));	       
	            dto.setComment(rs.getInt(7));
	            v.add(dto);
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt, rs);
	      }
	      return v;
	   }
   
   public Vector<tDto> notice() {
	      Vector<tDto> v = new Vector<>();
	      try {
	         conn = getConnection();
	         String sql = "select * from notice";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	           tDto dto = new tDto();
	            dto.setBrx(rs.getInt(1));
	            dto.setTitle(rs.getString(2));
	            dto.setContent(rs.getString(3));
	            dto.setWriter(rs.getString(4));
	            dto.setDate(rs.getString(5));
	            dto.setTime(rs.getString(6));
	            dto.setGood(rs.getInt(7));
	            dto.setComment(rs.getInt(8));
	            v.add(dto);
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt, rs);
	      }
	      return v;
	   }
   
   public Vector<tDto> realhot() {
	      Vector<tDto> v = new Vector<>();
	      try {
	         conn = getConnection();
	         String sql = "select * from hot order by good DESC Limit 10";
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	           tDto dto = new tDto();
	            dto.setBrx(rs.getInt(1));
	            dto.setTitle(rs.getString(2));
	            v.add(dto);
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         freeConnection(conn, pstmt, rs);
	      }
	      return v;
	   }
   
   public Vector<tDto> free() {
         Vector<tDto> v = new Vector<>();
         try {
            conn = getConnection();
            String sql = "select * from free order by brx DESC Limit 5";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
              tDto dto = new tDto();
               dto.setBrx(rs.getInt(1));
               dto.setTitle(rs.getString(2));
               dto.setContent(rs.getString(3));
               v.add(dto);
            }
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            freeConnection(conn, pstmt, rs);
         }
         return v;
      }
   
   public Vector<tDto> humor() {
         Vector<tDto> v = new Vector<>();
         try {
            conn = getConnection();
            String sql = "select * from humor order by brx DESC Limit 5";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
              tDto dto = new tDto();
               dto.setBrx(rs.getInt(1));
               dto.setTitle(rs.getString(2));
               dto.setContent(rs.getString(3));
               v.add(dto);
            }
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            freeConnection(conn, pstmt, rs);
         }
         return v;
      }
   
   public Vector<tDto> trade() {
         Vector<tDto> v = new Vector<>();
         try {
            conn = getConnection();
            String sql = "select * from trade order by brx DESC Limit 5";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
              tDto dto = new tDto();
               dto.setBrx(rs.getInt(1));
               dto.setTitle(rs.getString(2));
               dto.setContent(rs.getString(3));
               v.add(dto);
            }
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            freeConnection(conn, pstmt, rs);
         }
         return v;
      }
   
   public Vector<tDto> unknowns() {
         Vector<tDto> v = new Vector<>();
         try {
            conn = getConnection();
            String sql = "select * from unknowns order by brx DESC LIMIT 5;";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
              tDto dto = new tDto();
               dto.setBrx(rs.getInt(1));
               dto.setTitle(rs.getString(2));
               dto.setContent(rs.getString(3));
               v.add(dto);
            }
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            freeConnection(conn, pstmt, rs);
         }
         return v;
      }
   
   public tDto selectOne_free(String brx) {
		tDto dto = new tDto();

		try {
			conn = getConnection();
			String sql = "select * from free where brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(brx));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBrx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setDate(rs.getString(5));
				dto.setTime(rs.getString(6));
				dto.setGood(rs.getInt(7));
				dto.setComment(rs.getInt(8));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}

		return dto;
	}
   
   public tDto selectOne_humor(String brx) {
		tDto dto = new tDto();

		try {
			conn = getConnection();
			String sql = "select * from humor where brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(brx));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBrx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setDate(rs.getString(5));
				dto.setTime(rs.getString(6));
				dto.setGood(rs.getInt(7));
				dto.setComment(rs.getInt(8));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}

		return dto;
	}
   
   public tDto selectOne_hot(String brx) {
		tDto dto = new tDto();

		try {
			conn = getConnection();
			String sql = "select * from hot where brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(brx));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBrx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setDate(rs.getString(5));
				dto.setTime(rs.getString(6));
				dto.setGood(rs.getInt(7));
				dto.setComment(rs.getInt(8));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}

		return dto;
	}
   
   public tDto selectOne_notice(String brx) {
		tDto dto = new tDto();

		try {
			conn = getConnection();
			String sql = "select * from notice where brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(brx));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBrx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setDate(rs.getString(5));
				dto.setTime(rs.getString(6));
				dto.setGood(rs.getInt(7));
				dto.setComment(rs.getInt(8));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}

		return dto;
	}
   
   public tDto selectOne_trade(String brx) {
		tDto dto = new tDto();

		try {
			conn = getConnection();
			String sql = "select * from trade where brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(brx));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBrx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setDate(rs.getString(5));
				dto.setTime(rs.getString(6));
				dto.setComment(rs.getInt(7));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}

		return dto;
	}
   
   public tDto selectOne_unknowns(String brx) {
		tDto dto = new tDto();

		try {
			conn = getConnection();
			String sql = "select * from unknowns where brx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(brx));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBrx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setDate(rs.getString(5));
				dto.setTime(rs.getString(6));
				dto.setComment(rs.getInt(7));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}

		return dto;
	}
   
   public tDto free_update(String brx, String title, String content, String writer, String comment) {
	   tDto dto = new tDto();
		try {
			conn=getConnection();//dbï¿½ï¿½ï¿½ï¿½
		    String sql = "update free set title=?, contents=?, writer=?, rdate=curdate(), rtime=curtime(), comments=? where brx=?"; //sqlï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Û¼ï¿½
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setString(3,writer);
			pstmt.setString(4,comment);
			pstmt.setString(5,brx);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //pstmtï¿½ï¿½ sqlï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		   
		   return dto;
   }
   
   public tDto hot_update(String brx, String title, String content, String writer, String comment) {
	   tDto dto = new tDto();
		try {
			conn=getConnection();//dbï¿½ï¿½ï¿½ï¿½
		    String sql = "update hot set title=?, contents=?, writer=?, rdate=curdate(), rtime=curtime(), comments=? where brx=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setString(3,writer);
			pstmt.setString(4,comment);
			pstmt.setString(5,brx);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //pstmtï¿½ï¿½ sqlï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		   
		   return dto;	
   }
   
   public tDto humor_update(String brx, String title, String content, String writer, String comment) {
	   tDto dto = new tDto();
		try {
			conn=getConnection();//dbï¿½ï¿½ï¿½ï¿½
		    String sql = "update humor set title=?, contents=?, writer=?, rdate=curdate(), rtime=curtime(), comments=? where brx=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setString(3,writer);
			pstmt.setString(4,comment);
			pstmt.setString(5,brx);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //pstmtï¿½ï¿½ sqlï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		   
		   return dto;
   }
   
   public tDto trade_update(String brx, String title, String content, String writer, String comment) {
	   tDto dto = new tDto();
		try {
			conn=getConnection();//dbï¿½ï¿½ï¿½ï¿½
		    String sql = "update trade set title=?, contents=?, writer=?, rdate=curdate(), rtime=curtime(), comments=? where brx=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setString(3,writer);
			pstmt.setString(4,comment);
			pstmt.setString(5,brx);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //pstmtï¿½ï¿½ sqlï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		   
		   return dto;
   }
   
   public tDto unknowns_update(String brx, String title, String content, String writer, String comment) {
	   tDto dto = new tDto();
		try {
			conn=getConnection();//dbï¿½ï¿½ï¿½ï¿½
		    String sql = "update unknowns set title=?, contents=?, writer=?, rdate=curdate(), rtime=curtime(), comments=? where brx=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setString(2,content);
			pstmt.setString(3,writer);
			pstmt.setString(4,comment);
			pstmt.setString(5,brx);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //pstmtï¿½ï¿½ sqlï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
		   
		   return dto;
   }
   
   public Vector<tDto> selectAll(String pageNum, String cat){
		Vector<tDto> v = new Vector<>();
		int curPage = (Integer.parseInt(pageNum)-1)*pageSize;
		
		// ÇöÀç ÆäÀÌÁö °ª 1ÀÌ ³Ñ¾î¿À¸é limit 0, 10 <= ³ªÁß¿¡  dao¿¡¼­
					// 2 => limit 10, 10
					// 3 => limit 20, 10	
		try {
			conn = getConnection();
			String sql = "select * from " + cat + " order by brx DESC limit ?,?";
			// limit ½ÃÀÛ¹øÈ£, °³¼ö
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, curPage);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				tDto dto = new tDto();
				dto.setBrx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setWriter(rs.getString(4));
				dto.setComment(rs.getInt(8));
				dto.setDate(rs.getString(5));
				v.add(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			freeConnection(conn, pstmt, rs);
		}
		
		
		
		return v;	
	}
   
   public Vector<tDto> selectAll2(String pageNum, String cat){
		Vector<tDto> v = new Vector<>();
		int curPage = (Integer.parseInt(pageNum)-1)*pageSize;
		
		// ÇöÀç ÆäÀÌÁö °ª 1ÀÌ ³Ñ¾î¿À¸é limit 0, 10 <= ³ªÁß¿¡  dao¿¡¼­
					// 2 => limit 10, 10
					// 3 => limit 20, 10	
		try {
			conn = getConnection();
			String sql = "select * from " + cat + " order by brx DESC limit ?,?";
			// limit ½ÃÀÛ¹øÈ£, °³¼ö
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, curPage);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				tDto dto = new tDto();
				dto.setBrx(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setWriter(rs.getString(4));
				dto.setComment(rs.getInt(7));
				dto.setDate(rs.getString(5));
				v.add(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			freeConnection(conn, pstmt, rs);
		}
		
		
		
		return v;	
	}
   
   public int getTotalPage(String cat){
		try {
			conn = getConnection();
			String sql = "select count(*) from "+cat;
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result=rs.getInt(1);
			}
			// result¿¡´Â ÀüÃ¼ °³¼ö ´ã±è
			
			// ÅäÅ»ÆäÀÌÁö ·Î °è»êÇÏ±â
			
			//result¸¦ pageSize·Î ³ª´²¼­ ³ª¸ÓÁö°¡ ÀÖÀ¸¸é +1
			// ¾øÀ¸¸é 0
			result = (int) Math.ceil(((double)result/(double)pageSize));
			// result¿¡´Â ÃÑ ÆäÀÌÁö°¡ ³ª¿È
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}
		
		
		
		
		return result;
	}
   
   
   
}