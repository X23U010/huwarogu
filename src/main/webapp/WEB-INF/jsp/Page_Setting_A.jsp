<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Member"%>
<%@ page import="java.util.ArrayList"%> <%-- 修正1: ArrayListのインポートを追加 --%>
<%
// セッションからMemberオブジェクトを取得
Member member = (Member) session.getAttribute("loginMember");

// Servletから渡された先生リストを取得
ArrayList<Member> teacherList = (ArrayList<Member>) request.getAttribute("teacher_list");
if(teacherList == null) teacherList = new ArrayList<Member>();

String teacher_name = "未設定";
String subteacher_name = "なし";

// 現在のID（空白除去）
String currentMainId = (member != null && member.getMember_teacher_id() != null) 
                       ? member.getMember_teacher_id().trim() : "";
String currentSubId = (member != null && member.getMember_subteacher_id() != null) 
                       ? member.getMember_subteacher_id().trim() : "";

// 担任名の特定
for(Member teacher : teacherList) { 
	if(teacher.getMember_id() != null && teacher.getMember_id().trim().equals(currentMainId)){
		teacher_name = teacher.getMember_name();
		break; // 修正2: セミコロンを追加
	}
}

// 副担任名の特定
for(Member teacher : teacherList) { 
	if(teacher.getMember_id() != null && teacher.getMember_id().trim().equals(currentSubId)){
		subteacher_name = teacher.getMember_name();
		break; // 修正2: セミコロンを追加
	}
}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>基本情報設定画面</title>
    <link rel="stylesheet" href="css/setting.css">
</head>
<body>
    <div class="setting-container">
        <div class="header-info">
            <h1>基本情報設定</h1>
            <p>学籍番号・名前などは変更できません。<br>設定を修正する場合は各ボタンを押してください。</p>
        </div>
        
        <form action="Setting_Servlet" method="post" id="settingForm">
            
            <div class="field">
                <label>学籍番号</label>
                <input type="text" value="<%= (member != null) ? member.getMember_id() : "" %>" readonly>
            </div>

            <div class="field">
                <label>誕生月</label>
                <input type="text" value="<%= (member != null) ? member.getMember_month() + "月" : "" %>" readonly>
            </div>
            
            <div class="field">
                <label>名前</label>
                <input type="text" value="<%= (member != null) ? member.getMember_name() : "" %>" readonly>
            </div>
            
            <div class="field">
                <label>担任</label>
                <input type="text" value="<%= teacher_name %>" readonly>
            </div>
            
            <div class="field">
                <label>副担任</label>
                <input type="text" value="<%= subteacher_name %>" readonly>
            </div>
            
            <div class="button-group">
                <button type="submit" name="action" value="setting_B" id="updateButton">パスワード設定</button>
            </div>
            
            <div class="button-group">
                <button type="submit" name="action" value="setting_C" id="updateButton">担任/副担任設定</button>
            </div>
            
            <div class="button-group">
                <button type="submit" name="action" value="back_top" id="backButton">戻る</button>
            </div>
            
        </form>
    </div>
</body>
</html>