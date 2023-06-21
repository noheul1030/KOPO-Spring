package membership;

import common.JDBConnect;

//DB - CRUD
public class MemberDAO extends JDBConnect{

	// DB의 연결이 완료된 DAO 객체 생성
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv,url,id,pw);
	}
	
	// 아이디 패스워드 일치하는 회원 정보를 반환
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO(); // 회원정보 DTO 객체
		String query = "select * from member where id = ? and pass = ?"; // 쿼리문
		
		try { // 결과 처리 구문
		
			psmt = con.prepareStatement(query);
			psmt.setString(1,uid);
			psmt.setString(2,upass);
			rset = psmt.executeQuery();
			
			if(rset.next()) {
				// 쿼리문 결과 데이터
				dto.setId(rset.getString("id"));
				dto.setPass(rset.getString("pass"));
				dto.setName(rset.getString("name"));
				dto.setRegidate(rset.getString("regidate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto; // DTO 객체 반환
	}
}
