<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model1.BoardDTO,model1.BoardDAO" %>

<%
request.setCharacterEncoding("utf-8");
String num = request.getParameter("num");  // �Ϸù�ȣ �ޱ� 

BoardDAO dao = new BoardDAO(application);  // DAO ���� 
dao.updateVisitCount(num);                 // ��ȸ�� ���� 
BoardDTO dto = dao.selectView(num);        // �Խù� �������� 
dao.close();                               // DB ���� ����
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
<style>
   	.fourth{
	  background: gold;
	  border-color: white;
	  color: black;
	  font-weight : bold;
	  background-image: linear-gradient(45deg, yellow 50%, transparent 50%);
	  background-position: 100%;
	  background-size: 400%;
	  transition: background 300ms ease-in-out;
	  border-radius: 5px;
	  height : 35px;
	}
	
	.fourth:hover {
	  background-position: 0;
	}
</style>
<script type="text/javascript">
function validateForm(form) {  // �� ���� ����
    if (form.title.value == "") {
        alert("������ �Է��ϼ���.");
        form.title.focus();
        return false;
    }
    if (form.content.value == "") {
        alert("������ �Է��ϼ���.");
        form.content.focus();
        return false;
    }
}
</script>
</head>
<body>
<jsp:include page="../Common/Link.jsp" />
<h2>ȸ���� �Խ��� - ���� �ϱ�(Update)</h2>
<form name="writeFrm"  method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="num" value="<%= num %>" />  <!-- ���� ��ũ -->

    <table border="1" width="90%">
        <tr>
            <td>��ȣ</td>
            <td><input type="hidden" name="num" value="<%= dto.getNum() %>"readonly><%= dto.getNum() %></td>
            <td>�ۼ���</td>
            <td><%= dto.getName() %></td>
        </tr>
        <tr>
            <td>�ۼ���</td>
            <td><%= dto.getPostdate() %></td>
            <td>��ȸ��</td>
            <td><%= dto.getVisitcount() %></td>
        </tr>
        <tr>
            <td>����</td>
            <td  colspan="3">
                <input type="text" name="title" value="<%= dto.getTitle() %>" style="width: 90%;" required/>
            </td>        
        </tr>
        <tr>
            <td>����</td>
            <td  colspan="3" height="100">
                <textarea name="content" style="width: 90%; height: 100px;"><%= dto.getContent().replace("\r\n", "<br/>") %></textarea>
            </td>           
        </tr>
        <tr>
            <td colspan="4" align="center">
            <%
            if (session.getAttribute("UserId") != null
                && session.getAttribute("UserId").toString().equals(dto.getId())) {
            %>
                <button class="fourth" type="submit" formaction="EditProcess.jsp">�����ϱ�</button>
                <button class="fourth" type="button" onclick="location.href='View.jsp?num=<%= dto.getNum() %>';">�������</button> 
            <%
            }
            %>
                <button class="fourth" type="button" onclick="location.href='List.jsp';">
                    ��� ����
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>