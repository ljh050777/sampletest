<!--Update 화면-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
</head>
<body>
    <form id="frm">
        <table class="board_view">
            <colgroup>
                <col width="15%"/>
                <col width="35%"/>
                <col width="15%"/>
                <col width="35%"/>
            </colgroup>
            <caption>사용자 상세</caption>
            <tbody>
            <tr>
                <th scope="row">등록번호</th>
                <td>
                	${map.pid }
                	<input type="hidden" id="PID" name="PID" class="wdp_90" value="${map.pid }"/>
                </td>
            </tr>
            <tr>
                <th scope="row">이름</th>
                <td>
                	<input type="text" id="HNGNM" name="HNGNM" class="wdp_90" value="${map.hngnm }"/>
                </td>
            </tr>
            <tr>
                <th scope="row">성별</th>
                <td>
                	<input type="text" id="MF" name="MF" class="wdp_90" value="${map.mf }"/>
                </td>
            </tr>
            <tr>
                <th scope="row">생년월일</th>
                <td>
                	<input type="text" id="BRTHDD" name="BRTHDD" class="wdp_90" value="${map.brthdd }"/>
                </td>
            </tr>
            <tr>
                <th scope="row">주소</th>
                <td>
                	<input type="text" id="ZIPCDADDR" name="ZIPCDADDR" class="wdp_90" value="${map.zipcdaddr }"/>
                </td>
            </tr>
            <tr>
                <th scope="row">메세지</th>
                <td>
                	<input type="text" id="MESSAGE" name="MESSAGE" class="wdp_90" value="${map.message }"/>
                </td>
            </tr>
            
        </tbody>
        </table>
    </form>
     
    <a href="#this" class="btn" id="list">목록</a>
    <a href="#this" class="btn" id="update">저장</a>
    <a href="#this" class="btn" id="delete">삭제</a>
     
    <%@ include file="/WEB-INF/include/include-body.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#list").on("click", function(e){ //목록
                e.preventDefault();
                fn_openMainList();
            });
             
            $("#update").on("click", function(e){ //저장
                e.preventDefault();
                fn_updateList();
            });
             
            $("#delete").on("click", function(e){ //삭제
                e.preventDefault();
                fn_deleteList();
            });
        });
         
        function fn_openMainList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/sample/mainlist.do' />");
            comSubmit.submit();
        }
         
        function fn_updateList(){  
            var comSubmit = new ComSubmit("frm");
            comSubmit.setUrl("<c:url value='/sample/updateList.do' />");
            comSubmit.submit();
        }
         
        function fn_deleteList(){
			if(confirm("삭제하시겠습니까?") == true){		//삭제 확인
				var comSubmit = new ComSubmit();
	            comSubmit.setUrl("<c:url value='/sample/deleteList.do' />");
	            comSubmit.addParam("PID", $("#PID").val());
	            comSubmit.submit();
        	}else{
        		return;
        	} 
        }
    </script>
</body>
</html>