<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Member" %>
<%
    // ログインユーザー情報を取得（現在の設定値を確認するため）
    Member member = (Member) session.getAttribute("loginMember");
    
    // Servletから渡された先生リストを取得
    ArrayList<Member> teacherList = (ArrayList<Member>) request.getAttribute("teacher_list");
    if(teacherList == null) teacherList = new ArrayList<Member>();

    // 現在設定されているIDを取得（null安全のために三項演算子などを使うと安心です）
    String currentMainId = (member != null) ? member.getMember_teacher_id() : "";
    String currentSubId = (member != null) ? member.getMember_subteacher_id() : "";
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>基本情報設定画面_C</title>
    <link rel="stylesheet" href="css/setting.css">
</head>
<body>
    <div class="setting-container">
        <div class="header-info">
            <h1>担任/副担任設定</h1>
        </div>
        
        <form action="Setting_Servlet" method="post" id="settingForm">
            <div class="field">
                <label for="mainTeacher">担任</label>
                <select id="mainTeacher" name="main_teacher_id">
                    <option value="">選択してください</option>
                    <% for(Member teacher : teacherList) { %>
                        <option value="<%= teacher.getMember_id() %>" 
                            <%= teacher.getMember_id().equals(currentMainId) ? "selected" : "" %>>
                            <%= teacher.getMember_name() %>
                        </option>
                    <% } %>
                </select>
            </div>

            <div class="field">
                <label for="subTeacher">副担任</label>
                <select id="subTeacher" name="sub_teacher_id">
                    <option value="">なし</option>
                    <% for(Member teacher : teacherList) { %>
                        <option value="<%= teacher.getMember_id() %>"
                            <%= teacher.getMember_id().equals(currentSubId) ? "selected" : "" %>>
                            <%= teacher.getMember_name() %>
                        </option>
                    <% } %>
                </select>
            </div>
            
            <div class="button-group">
                <button type="submit" id="backButton" name="action" value="back_A">戻る</button>
                <button type="submit" id="updateButton" name="action" value="setting_E_teacher">更新</button>
            </div>
        </form>
    </div>
    <script src="js/setting.js"></script>
</body>
</html>