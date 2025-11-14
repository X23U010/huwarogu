<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>新規会員登録</title>
  <link rel="stylesheet" href="002.css">
</head>
<body>
  <div class="container">
    <h1>新規会員登録</h1>

    <form>
      <div class="form-grid">
        <div class="field">
          <label for="student_id">学籍番号</label>
          <input type="text" id="student_id" name="student_id">
        </div>

        <div class="field">
          <label for="birth_month">誕生月</label>
          <input type="month" id="birth_month" name="birth_month">
        </div>

        <div class="field">
          <label for="name">名前</label>
          <input type="text" id="name" name="name">
        </div>

        <div class="field">
          <label for="password">パスワード</label>
          <input type="password" id="password" name="password">
        </div>
      </div>

      <button type="submit" id="submit_btn">登録</button>
    </form>
  </div>
</body>
</html>
