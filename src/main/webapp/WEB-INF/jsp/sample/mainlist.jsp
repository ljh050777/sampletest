<!--Test Main 화면-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
</head>
<body>
<h2>사용자 목록</h2>
<table style="border:1px solid #ccc">
    <colgroup>
        <col width="25%"/>
        <col width="25%"/>
        <col width="25%"/>
        <col width="25%"/>
    </colgroup>
    <thead>
        <tr>
        	<th scope="col">등록번호</th>
            <th scope="col">이름</th>
            <th scope="col">이메일</th>
            <th scope="col">메세지</th>            
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <tr>                        
                        <td class="title">
                                <a href="#this" name="title">${row.pid }</a>
                                <input type="hidden" id="PID" value="${row.pid }">
                        </td>
                        <td>${row.name }</td>
                        <td>${row.email }</td>
                        <td>${row.message }</td>                        
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
         
    </tbody>
</table>

<br/>
    <a href="#this" class="btn" id="write">입력</a>
       
    <%@ include file="/WEB-INF/include/include-body.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#write").on("click", function(e){ //글쓰기 버튼
                e.preventDefault();
                fn_openListWrite();
            }); 
             
            $("a[name='title']").on("click", function(e){ //제목 
                e.preventDefault();
                fn_openListDetail($(this));
            });
        });
         
         
        //입력화면 호출
        function fn_openListWrite(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/sample/listwrite.do' />");
            comSubmit.submit();
        }
        
        //상세화면 호출
        function fn_openListDetail(obj){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/sample/openListDetail.do' />");
            comSubmit.addParam("PID", obj.parent().find("#PID").val());
            comSubmit.submit();
        }
    </script> 
</body>
</html>