package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class khTest2
 */
@WebServlet("/rlist.bo") // 1. mapping 오류 수정
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	/**
     	* @see HttpServlet#HttpServlet()
     	*/
    	public ItemController() {
        		super();
        		// TODO Auto-generated constructor stub
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 상품정보를 조회하기위해서는 조회기준 필요 : 예를 들어 상품번호와 같은 키값을 가져와야 한다.
		// int productNo = Integer.parseInt(request.getParameter("pno"));
		// ArrayList<Item> list = new ProductService().selectItemList(productNo);
				
		ArrayList<Item> list = new ProductService().selectItemList();
		
		// 2. JSON 형식을 이용하기 위해서는 resposne 객체의 setContentType() 메서드로
		//    클라이언트에게 보내줘야 이용이 가능하다.
		//    response.setContentType("application/json; charset=UTF-8");
		// list를 꺼낼 땐 반복문을 거쳐 하나씩 꺼내게 되는데
		// Gson을 이용해 반복문을 대신하는 코드를 만들고, toJson 메서드를 호출해 list를 response.getWriter()로 클라이언트에 보내준다.
		// new Gson().toJson(list, response.getWriter());
		if (list.size() > 0) {
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/product/itemListView.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "상품목록 조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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