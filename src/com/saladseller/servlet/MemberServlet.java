package com.saladseller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saladseller.model.Member;
import com.saladseller.service.MemberService;

public class MemberServlet extends HttpServlet {

	MemberService memberService;

	public MemberServlet() {
		memberService = MemberService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

	public void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 여기서 입력되는 urI를 구분해서 동작할 것들에 대한 정의...
		// loginForm.do 로그인 화면을띄워주는거고..
		// login.do가 오면 파라미터와 함께 로그인 시도...
		// 우리가 아까 정의했던 request목록에 대해서
		// 동작할 것들을 여기다가 정의..합니다!!

		// 현재 넘겨 받은 URI에 대한 정보를 확인!
		// System.out.println("req URI : " + req.getRequestURI());
		// System.out.println("context path : " + req.getContextPath());

		String contextPath = req.getContextPath();
		String reqURI = req.getRequestURI();

		if (reqURI.equals(contextPath + "/loginForm.do")) {
			req.getRequestDispatcher("loginForm.jsp").forward(req, resp);

		} else if (reqURI.equals(contextPath + "/index.do")) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		} else if (reqURI.equals(contextPath + "/login.do")) {
			// 여기서는 로그인 처리 할거에요
			// 로그인 처리라는 로직이 필요함...>>>service에 등록할거에요
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");

			if (memberService.login(id, pw)) {
				req.getSession().setAttribute("id", id);
				req.setAttribute("result", true);
				req.getRequestDispatcher("loginResult.jsp").forward(req, resp);

			} else {
				req.setAttribute("result", false);
				req.getRequestDispatcher("loginResult.jsp").forward(req, resp);
			}

			// loginResult포워딩...
		} else if (reqURI.equals(contextPath + "/joinForm.do")) {
			req.getRequestDispatcher("joinForm.jsp").forward(req, resp);

		} else if (reqURI.equals(contextPath + "/logout.do")) {
			req.getRequestDispatcher("logoutResult.jsp").forward(req, resp);

		} else if (reqURI.equals(contextPath + "/join.do")) {
			// 파라미터로 넘겨받은 정보를 기준으로 회원가입을 진행...
			// 회원가입 로직은 Service 클래스를 이용하여 구현
			// MemberService에 회원가입을 하는 기능을 구현합니다.

			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String email = req.getParameter("email");
			String addr = req.getParameter("addr");
			String phone = req.getParameter("phone");

			boolean result = memberService.join(id, pw, email, addr, phone);
			// 회원가입이 성공하면 result : true, 실패하면 false

			// 회원가입 결과를 전달하기위해 request 속성에 저장
			req.setAttribute("result", result);

			// joinResult로 회원가입 결과 전달..
			req.getRequestDispatcher("joinResult.jsp").forward(req, resp);

			// resp.sendRedirect("loginForm.do");

		} else if (reqURI.equals(contextPath + "/main.do")) {
			// 로그인 결과에 따라서 성공이며>>main.jsp 포워딩
			// 실패면 loginForm.do 리다이렉트
			// 로그인 실패 성공은 session에 아이디가 있는지 없는지로 확인합시다..

			if (req.getSession().getAttribute("id") == null) {
				// 로그인 실패 > 로그인 화면 리다이렉트
				resp.sendRedirect("loginForm.do");
				return;
			} else {
				// 로그인 성공 >>main.jsp 포워딩
				req.getRequestDispatcher("main.jsp").forward(req, resp);

			}
		} else if (reqURI.equals(contextPath + "/memberUpdateForm.do")) {
			// 회원정보를 수정할 수 있는 화면을 요청
			// 기존의 데이터
			// 우리가 알고있는데이터는 id
			// >>id를 기준으로 조회 해야됩니다. DB에서...
			// id??? >>session

			// 파라미터에서 id를 읽어옴
			String id = req.getParameter("id");
			// 읽어온 id를 기준으로 회원정보를 조회
			Member member = memberService.findMember(id);

			// 조회한 회원정보를 request의 속성에 저장
			req.setAttribute("member", member);

			// 회원정보 수정페이지로 전달 및 페이지 변경
			req.getRequestDispatcher("memberUpdateForm.jsp").forward(req, resp);

		} else if (reqURI.equals(contextPath + "/memberUpdate.do")) {
			// 회원정보를 수정합니다.
			// 모든 회원정보
			// 입력받은 회원정보를 테이블에 업데이트 하는것!
			// 로직처리는 서비스 객체에서 작성합니다.

			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String email = req.getParameter("email");
			String addr = req.getParameter("addr");
			String phone = req.getParameter("phone");

			// 회원정보 수정 로직처리
			memberService.modifyMember(id, pw, email, addr, phone);
			resp.sendRedirect("main.do");

		} else if (reqURI.equals(contextPath + "/memberList.do")) {
			// 모든 회원정보를 조회

			req.setAttribute("memberList", memberService.getAllMember());

			req.getRequestDispatcher("memberList.jsp").forward(req, resp);

		} else if (reqURI.equals(contextPath + "/logout.do")) {
			// session에 저장된 id 삭제
			// loginForm.do 로 리다이렉트
			req.getSession().removeAttribute("id");
			resp.sendRedirect("loginForm.do");
		} else if (reqURI.equals(contextPath + "/addForm.do")) {
			req.getRequestDispatcher("addForm.jsp").forward(req, resp);
		}

	}

}
