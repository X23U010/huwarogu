<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.003_新規会員登録確認画面</title>
  <link rel="stylesheet" href="css/page3.css">
</head>
<body>
  <div class="container">
    <h1>新規会員登録確認</h1>

    <form>
      <div class="field" id="student_id_field">
        <label for="student_id">学籍番号</label>
        <input type="text" id="student_id" name="student_id" value="" autocomplete="new-password">
      </div>

      <div class="field" id="birth_field">
        <label for="birth_month">誕生月</label>
        <input type="month" id="birth_month" name="birth_month" value="" autocomplete="new-password">
      </div>
      <div class="field" id="name_field">
        <label for="name">名前</label>
        <input type="text" id="name" name="name" value="" autocomplete="new-password">
      </div>


      <div class="field" id="password_field">
        <label for="password">パスワード</label>
        <input type="password" id="password" name="password" value="" autocomplete="new-password">
      </div>

      <!-- ✅ 下部に配置 -->
      <div id="confirm_section">
        <p>以下の内容で間違いありませんか？</p>
        <div class="confirm_buttons">
          <button type="button" id="ok_btn">OK</button>
          <button type="button" id="cancel_btn">キャンセル</button>
        </div>
      </div>
    </form>
  </div>
</body>
</html>
