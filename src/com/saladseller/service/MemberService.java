package com.saladseller.service;

import java.util.List;

import com.saladseller.dao.MemberDao;
import com.saladseller.model.Member;

public class MemberService {
	private static MemberService instance;
	// 로직처리를 위해서 DB에 접근해야함...
	// DB접근은 DAO에게 맡깁시다..
	private MemberDao memberDao;

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	private MemberService() {
		memberDao = MemberDao.getInstance();
	}

	public boolean login(String id, String pw) {
		boolean result = false;
		Member member = memberDao.selectOne(id);

		if (member == null) {
			result = false;
		} else {
			String originPw = member.getM_pw();
			if (originPw.equals(pw)) {
				result = true;
			}
		}
		return result;
	}

	public boolean join(String id, String pw, String email, String addr, String phone) {
		// 입력받은 아이디를 member table에 넣기전에
		// 기존에 입력받은 아이디가 있으면.....넣지말고
		// 기존아이디가 없으면 받은정보를 테이블에 삽입

		// 1. 기존아이디 존재 여부 확인 >> selectOne
		// 결과가 있으면 아이디 존재, null이면 아이디 없음

		boolean result = false;

		Member member = memberDao.selectOne(id);
		if (member == null) {
			// 아이디가 존재 하지 않으니.. table에 삽입합시다.
			Member newMember = new Member();

			newMember.setM_id(id);
			newMember.setM_pw(pw);
			newMember.setM_email(email);
			newMember.setM_addr(addr);
			newMember.setM_phone(phone);

			memberDao.insertMember(newMember);

			// 회원가입(table에 데이터 삽입)을 하면 결과를 true로 바꿈
			result = true;
		}
		// 회원가입 결과 리턴
		return result;
	}

	// 회원정보를 가져오기 위한 함수 >>기준이 id값
	public Member findMember(String id) {
		// id를 기준으로 회원정보를 가져다 줌
		return memberDao.selectOne(id);
	}

	// 회원정보를 수정하는 기능이 필요합니다.
	public boolean modifyMember(String id, String pw, String email, String addr, String phone) {

		boolean result = false;

		// 입력받은 정보를 table에 update >>DB에 접근은 Dao 전담!!
		// memberDao.update()가 필요합니다.>>memberDao
		// 기존비밀번호와 입력받은 비밀번호가 맞는지 확인
		// 기존 회원정보 받아오기
		Member originMember = memberDao.selectOne(id);

		if (originMember.getM_pw().equals(pw)) {
			// 기존 비밀번호와 입력받은 비밀번호가 같음!
			// 수정 실행

			Member member = new Member();

			// 파라미터로 받은 정보를 member 객체에 담아서 dao로 전달
			member.setM_id(id);
			member.setM_pw(pw);
			member.setM_email(email);
			member.setM_addr(addr);
			member.setM_phone(phone);

			// 전달 받은 member 객체의 정보를 이용하여 table 수정
			memberDao.updateMember(member);
			result = true;
		}

		return result;
	}

	// 모든 회원정보를 조회
	public List<Member> getAllMember() {

		return memberDao.selectAll();
	}

}
