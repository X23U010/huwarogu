<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Member"%>
<%
// セッションからMemberオブジェクトを取得
Member member = (Member) session.getAttribute("loginMember");
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
                <p>学籍番号は変更できません。<br>他の情報を修正し「保存」してください。</p>
            </div>
            
            <form action="Setting_Servlet" method="post" id="settingForm">
                
                <div class="field" id="student_id_field">
                    <label for="student_id">学籍番号</label>
                    <input type="text" id="student_id" name="student_id" 
                           value="<%=member.getMember_id()%>" readonly>
                </div>

                <div class="field" id="birth_field">
                    <label for="birth_month">誕生月</label>
                    <input type="number" id="birth_month" name="birth_month" 
                           value="<%=member.getMember_month()%>" min="1" max="12" readonly>
                </div>
                
                <div class="field" id="name_field">
                    <label for="name">名前</label>
                    <input type="text" id="name" name="name" 
                           value="<%=member.getMember_name()%>" readonly>
                </div>
                
                
                <div class="button-group">
                    <button type="submit" id="backButton" name="action" value="setting_B">パスワード設定</button>
                </div>
                
                <div class="button-group">
                    <button type="submit" id="backButton" name="action" value="setting_C">担任/副担任設定</button>
                </div>
                
                <div class="button-group">
                    <button type="submit" id="backButton" name="action" value="back_top">戻る</button>
                </div>
                
                
            </form>
        </div>
    <script src="js/setting.js"></script>
</body>
</html>