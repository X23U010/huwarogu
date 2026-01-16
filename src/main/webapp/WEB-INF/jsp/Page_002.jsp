<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Member"%>
<%
// セッションから公欠情報を取得
Member member = (Member) session.getAttribute("member");

// 各項目の初期値を空文字で設定
String member_id = "";
String member_name = "";
String member_month = "";
String member_password = "";

// セッションにデータが存在する場合、値を代入
if (member != null) {
    if (member.getMember_id() != null) member_id = member.getMember_id();
    if (member.getMember_name() != null) member_name = member.getMember_name();
    if (member.getMember_month() != null) member_month = member.getMember_month();
    if (member.getMember_password() != null) member_password = member.getMember_password();
}
%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.002_新規会員登録画面</title>
  <link rel="stylesheet" href="css/page2.css">
</head>
<body>
  <div class="container">
    <h1>新規会員登録</h1>

    <form class="new-registration-form" action="New_Registration_Servlet" method="post" autocomplete="off">
      <div class="form-grid">
        <div class="field">
          <label for="student_id">学籍番号</label>
          <input type="text" id="student_id" name="student_id" value="<%=member_id %>" autocomplete="new-password">
        </div>

        <div class="field">
          <label for="birth_month">誕生月</label>
          <input type="number" id="birth_month" name="birth_month" value="<%=member_month %>" autocomplete="new-password">
        </div>

        <div class="field">
          <label for="name">名前</label>
          <input type="text" id="name" name="name" value="<%=member_name %>" autocomplete="new-password">
        </div>

        <div class="field">
          <label for="password">パスワード</label>
          <input type="password" id="password" name="password" value="" autocomplete="new-password">
        </div>
      </div>
      <button type="submit" id="submit_btn" name="action" value="new_registretion_register">登録</button>
    </form>
  </div>
</body>
</html>
