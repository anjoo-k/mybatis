package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class khTest
 */
@WebServlet("/insert.me") //1. mapping 오류 : member.join으로 변경필요
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2. 웹브라우저(뷰)에서 값이 올 때 POST 방식으로 서버에 넘어오기 때문에
		//    웹브라우저와 서버의 인코딩 방식이 달라서 인코딩 필요 : request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId"); 
		String userPwd = request.getParameter("userPwd"); 
		String userName = request.getParameter("userName"); 
		String phone = request.getParameter("phone"); 
		String address = request.getParameter("address"); 

		String interest = "";
		if (interestArr != null) {
			interest = String.join(",", interestArr); 
		}

		Member m = new Member(
				userId,
				userPwd,
				userName,
				phone,
				address,
				interest
			);

		int result = new MemberService().insertMember(m);

		if (result > 0) {
			
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 되었습니다.");
			// 3. 회원가입에 성공하면 메인페이지로 가야하니 forward가 아닌 sendRedirect를 사용하며,
			// main 주소를 직접 적기 보다 getContextPath()에 있는 주소를 사용해 주는 것이 좋다.
			// response.sendRedirect(request.getContextPath());
			RequestDispatcher view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);

		} else {
			request.setAttribute("errorMsg", "회원가입 실패했습니다");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}