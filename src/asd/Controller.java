package asd;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
import com.dto.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(request, response);
	}

	protected void doProc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		String brx = request.getParameter("brx");
		
		HttpSession session = request.getSession();

		if (cmd == null) {
			cmd = "board";
		}

		boolean isDis = false;

		System.out.println("Controller : " + cmd);
		System.out.println("brx : " + brx);

		String viewPage = "";
		users_dao dao = new users_dao();
		tDao dao2 = new tDao();
		
		

		
		

		if (cmd.equals("board")) {
			viewPage = "/board.jsp";
			
			Vector<tDto> realhot = dao2.realhot();
			request.setAttribute("realhotre", realhot);
			
			Vector<tDto> hot = dao2.hot();
			request.setAttribute("hotre", hot);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);

			Vector<tDto> free = dao2.free();
			request.setAttribute("freere", free);

			Vector<tDto> humor = dao2.humor();
			request.setAttribute("humorre", humor);
			
			Vector<tDto> unknowns = dao2.unknowns();
			request.setAttribute("unknownsre", unknowns);
			
			Vector<tDto> trade = dao2.trade();
			request.setAttribute("tradere", trade);

			isDis = true;
			
		} 
		else if (cmd.equals("hot")) 
		{
			viewPage = "/hot.jsp";
			
			Vector<tDto> hot = dao2.hotboard();
			request.setAttribute("hotre", hot);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);
			
			
			
			//----------------------------------
			
			String pageNum=request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			RequestDispatcher rd = request.getRequestDispatcher("hot.jsp");
			rd.forward(request, response);
			
			
			//---------------------------------- isdis •ûÁÖ°í

		} 
		else if (cmd.equals("free")) {
			viewPage = "/free.jsp";
			
			Vector<tDto> free = dao2.freeboard();
			request.setAttribute("freere", free);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);

			//----------------------------------
			
			String pageNum=request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			RequestDispatcher rd = request.getRequestDispatcher("free.jsp");
			rd.forward(request, response);
			
			
			//---------------------------------- isdis •ûÁÖ°í
			
		} else if (cmd.equals("humor")) {
			viewPage = "/humor.jsp";
			
			Vector<tDto> humor = dao2.humorboard();
			request.setAttribute("humorre", humor);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);

			//----------------------------------
			
			String pageNum=request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			RequestDispatcher rd = request.getRequestDispatcher("humor.jsp");
			rd.forward(request, response);
			
			
			//---------------------------------- isdis •ûÁÖ°í
			
		} else if (cmd.equals("unknown")) {
			viewPage = "/unknown.jsp";
			
			Vector<tDto> unknowns = dao2.unknownsboard();
			request.setAttribute("unknownsre", unknowns);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);

			//----------------------------------
			
			String pageNum=request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll2(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			RequestDispatcher rd = request.getRequestDispatcher("unknown.jsp");
			rd.forward(request, response);
			
			
			//---------------------------------- isdis •ûÁÖ°í
		} else if (cmd.equals("trade")) {
			viewPage = "/trade.jsp";
			Vector<tDto> trade = dao2.tradeboard();
			request.setAttribute("tradere", trade);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);

			//----------------------------------
			
			String pageNum=request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll2(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			RequestDispatcher rd = request.getRequestDispatcher("trade.jsp");
			rd.forward(request, response);
			
			
			//---------------------------------- isdis •ûÁÖ°í
			
		} else if (cmd.equals("write")) {
			viewPage = "/write/write.jsp";

			isDis = true;
		}
		else if (cmd.equals("unknownswrite")) {
			viewPage = "/write/unknownswrite.jsp";

			isDis = true;
		}
		
		else if (cmd.equals("freepost")) 
		{
			viewPage = "/post/freepost.jsp";
			
			tDto freepostdto = dao2.selectOne_free(brx);
			request.setAttribute("freepostre", freepostdto);
			
			Vector<tDto> free = dao2.freeboard();
			request.setAttribute("freere", free);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);

			//========================================
			
			String pageNum = request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			isDis = true;
			
			//---------------------------------- isdis ³Ö¾îÁÖ°í rd •ûÁà¾ßµÅ
		}
		
		else if(cmd.equals("humorpost")) 
		{
			viewPage = "/post/humorpost.jsp";
			tDto humorpostdto = dao2.selectOne_humor(brx);
			request.setAttribute("humorpostre", humorpostdto);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);
			
			Vector<tDto> humor = dao2.humorboard();
			request.setAttribute("humorre", humor);
			
			//========================================
			
			String pageNum = request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			isDis = true;
			
			//---------------------------------- isdis ³Ö¾îÁÖ°í rd •ûÁà¾ßµÅ
			
		}
		
		else if(cmd.equals("hotpost"))
		{
			viewPage = "/post/hotpost.jsp";
			
			tDto hotpostdto = dao2.selectOne_hot(brx);
			request.setAttribute("hotpostre", hotpostdto);
			
			Vector<tDto> hot = dao2.hotboard();
			request.setAttribute("hotre", hot);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);
			
			
			
			//========================================
			
			String pageNum=request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			isDis = true;
			
			//---------------------------------- isdis ³Ö¾îÁÖ°í rd •ûÁà¾ßµÅ
			
		}
		
		else if(cmd.equals("noticepost")) 
		
		{
			viewPage = "/post/noticepost.jsp";
			tDto noticetdto = dao2.selectOne_notice(brx);
			request.setAttribute("noticepostre", noticetdto);
			
			isDis = true;
		}
		
		else if(cmd.equals("tradepost")) {
			viewPage = "/post/tradepost.jsp";
			tDto tradepostdto = dao2.selectOne_trade(brx);
			request.setAttribute("tradepostre", tradepostdto);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);
			
			Vector<tDto> trade = dao2.tradeboard();
			request.setAttribute("tradere", trade);
			
			//========================================
			
			String pageNum=request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll2(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			isDis = true;
			
			//---------------------------------- isdis ³Ö¾îÁÖ°í rd •ûÁà¾ßµÅ
			
		}
		else if(cmd.equals("unknownspost")) {
			viewPage = "/post/unknownspost.jsp";
			tDto unknownpostdto = dao2.selectOne_unknowns(brx);
			request.setAttribute("unknownspostre", unknownpostdto);
			
			Vector<tDto> notice = dao2.notice();
			request.setAttribute("noticere", notice);
			
			Vector<tDto> unknowns = dao2.unknownsboard();
			request.setAttribute("unknownsre", unknowns);
			
			//========================================
			
			String pageNum=request.getParameter("pageNum");
			String cat = request.getParameter("cat");
			
			if(pageNum==null){
				pageNum="1";
			}
			
			Vector<tDto> v = dao2.selectAll2(pageNum, cat);					
			int totalPage = dao2.getTotalPage(cat);
			
			request.setAttribute("data", v);
			request.setAttribute("totalPage", totalPage);
			
			isDis = true;
			
			//---------------------------------- isdis ³Ö¾îÁÖ°í rd •ûÁà¾ßµÅ
			
		} else if(cmd.equals("login")) {
			viewPage = "/login.jsp";
			
			isDis = true;
		} else if(cmd.equals("loginProc")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			boolean result = dao.loginCheck(id, pw);
			
			if(result) {
				
				session.setAttribute("id", id);
				
				viewPage = "/board.jsp";

				Vector<tDto> realhot = dao2.realhot();
				request.setAttribute("realhotre", realhot);
				
				Vector<tDto> hot = dao2.hot();
				request.setAttribute("hotre", hot);
				
				Vector<tDto> notice = dao2.notice();
				request.setAttribute("noticere", hot);

				Vector<tDto> free = dao2.free();
				request.setAttribute("freere", free);

				Vector<tDto> humor = dao2.humor();
				request.setAttribute("humorre", humor);
				
				Vector<tDto> unknowns = dao2.unknowns();
				request.setAttribute("unknownsre", unknowns);
				
				Vector<tDto> trade = dao2.trade();
				request.setAttribute("tradere", trade);

				isDis = true;
			} else {
				viewPage = "/loginfailed.jsp";
				isDis = true;
			}
		} else if(cmd.equals("join")) {
			viewPage = "/join.jsp";

			isDis = true;
		} else if(cmd.equals("insertproc")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			int result = dao.insertRow(id, pw, name, address, tel);
			
			isDis = false;
		} else if(cmd.equals("board2")) {
			viewPage = "/board.jsp";

			Vector<tDto> hot = dao2.hot();
			request.setAttribute("hotre", hot);

			Vector<tDto> free = dao2.free();
			request.setAttribute("freere", free);

			Vector<tDto> humor = dao2.humor();
			request.setAttribute("humorre", humor);

			isDis = true;
		}
		
		else if(cmd.equals("selectOne_free")) {
			viewPage ="/post/free_update.jsp";
			tDto freeupdatedto = dao2.selectOne_free(brx);
			request.setAttribute("f_update", freeupdatedto);
			
			isDis=true;
		} else if(cmd.equals("selectOne_hot")) {
			viewPage ="/post/hot_update.jsp";
			tDto hotupdatedto = dao2.selectOne_hot(brx);
			request.setAttribute("hot_update", hotupdatedto);
			
			isDis=true;
		} else if(cmd.equals("selectOne_humor")) {
			viewPage ="/post/humor_update.jsp";
			tDto humorupdatedto = dao2.selectOne_humor(brx);
			request.setAttribute("humor_update", humorupdatedto);
			
			isDis=true;
		} else if(cmd.equals("selectOne_trade")) {
			viewPage ="/post/trade_update.jsp";
			tDto tradeupdatedto = dao2.selectOne_trade(brx);
			request.setAttribute("trade_update", tradeupdatedto);
			
			isDis=true;
		} else if(cmd.equals("selectOne_unknowns")) {
			viewPage ="/post/unknowns_update.jsp";
			tDto unknownsupdatedto = dao2.selectOne_unknowns(brx);
			request.setAttribute("unknowns_update", unknownsupdatedto);
			
			isDis=true;
		}
		
		else if(cmd.equals("free_update")) { 
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			String comment = request.getParameter("comment");
			dao2.free_update(brx, title, content, writer, comment);
			isDis=false;
		} 
		
		else if(cmd.equals("hot_update")) { 
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			String comment = request.getParameter("comment");
			dao2.hot_update(brx, title, content, writer, comment);
			isDis=false;
		} 
		
		else if(cmd.equals("humor_update")) { 
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			String comment = request.getParameter("comment");
			dao2.humor_update(brx, title, content, writer, comment);
			isDis=false;
		} 
		
		else if(cmd.equals("trade_update")) { 
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			String comment = request.getParameter("comment");
			dao2.trade_update(brx, title, content, writer, comment);
			isDis=false;
		} 
		
		else if(cmd.equals("unknowns_update")) { 
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			String comment = request.getParameter("comment");
			dao2.unknowns_update(brx, title, content, writer, comment);
			isDis=false;
		} 
		
		else if(cmd.equals("delete")) { 
			String category = request.getParameter("category");
			String brxs = request.getParameter("brx");
			System.out.println(category);
			System.out.println(brxs);
			
			dao2.delhot(brxs, category);
			isDis=false;
		} 
		
		
		else if(cmd.equals("logout")) {
			session.invalidate();
			
			isDis = false;
		}

		

		if (isDis) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}
}