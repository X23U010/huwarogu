<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          <input type="text" id="student_id" name="student_id" value="" autocomplete="new-password">
        </div>

        <div class="field">
          <label for="birth_month">誕生月</label>
          <input type="number" id="birth_month" name="birth_month" value="" autocomplete="new-password">
        </div>

        <div class="field">
          <label for="name">名前</label>
          <input type="text" id="name" name="name" value="" autocomplete="new-password">
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
