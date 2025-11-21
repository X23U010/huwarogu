<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.004_ログイン画面</title>
  <link rel="stylesheet" href="css/page4.css">
</head>
<body>
  <div class="login-container">
    <h1>ログイン</h1>

    <form class="login-form" action="Login_Servlet" method="post" autocomplete="off">
      <div class="field">
        <label for="student_id">学籍番号</label>
        <input type="text" id="student_id" name="student_id" placeholder="学籍番号を入力" value="" autocomplete="new-password">
      </div>

      <div class="field">
        <label for="password">パスワード</label>
        <input type="password" id="password" name="password" placeholder="パスワードを入力" value="" autocomplete="new-password">
      </div>

      <div class="login-buttons">
        <button type="submit" id="login_btn">ログイン</button>
      </div>
    </form>
  </div>
</body>
</html>
