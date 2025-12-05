<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Menber"%>
<%
Menber member = (Menber) session.getAttribute("loginMenber");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>No.???_設定画面</title>
    <link rel="stylesheet" href="css/page3.css">

    <!-- キャッシュ防止（戻るボタンなどでも再入力されないように） -->
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
</head>
<body>
    <div class="main-content-wrapper">
        <div class="attendance-container">

            <div class="header-info">
                <h1>基本情報設定</h1>
            </div>
            <div class="field" id="student_id_field">
        <label for="student_id">学籍番号</label>
        <input type="text" id="student_id" name="student_id" value="<%=member.getMenber_id()%>">
      </div>

      <div class="field" id="birth_field">
        <label for="birth_month">誕生月</label>
        <input type="number" id="birth_month" name="birth_month" value="<%=member.getMenber_month()%>">
      </div>
      <div class="field" id="name_field">
        <label for="name">名前</label>
        <input type="text" id="name" name="name" value="<%=member.getMenber_name()%>">
      </div>
      <div class="field" id="password_field">
        <label for="password">パスワード</label>
        <input type="password" id="password" name="password" value="<%=member.getMenber_password()%>">
      </div>
   </div>
   </div>
    <script src="js/page3.js"></script>
</body>
</html>
