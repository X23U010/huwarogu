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
    <title>基本情報設定画面_C</title>
    <link rel="stylesheet" href="css/setting.css">

</head>
<body>
        <div class="setting-container">
            
            <div class="header-info">
                <h1>担任設定</h1>
            </div>
            
            <form action="Setting_Servlet" method="post" id="settingForm">
                
                
                
                <div class="button-group">
                    <button type="submit" id="backButton" name="action" value="back_top">戻る</button>
                    <button type="submit" id="updateButton" name="action" value="setting_E_teacher_id">更新</button>
                </div>
            </form>
        </div>
    <script src="js/setting.js"></script>
</body>
</html>