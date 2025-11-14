<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>公欠申請</title>
  <link rel="stylesheet" href="007.css">
</head>
<body>
  <div class="absence-container">
    <h1 class="title">公欠申請</h1>

    <form>
      <div class="field">
        <label for="date">申請日</label>
        <input type="date" id="date" name="date">
      </div>

      <div class="field">
        <label for="reason">公欠理由</label>
        <textarea id="reason" name="reason" placeholder="理由を入力してください..."></textarea>
      </div>

      <div class="button-area">
        <button type="button" class="back-button" onclick="location.href='index.html'">トップへ戻る</button>
        <button type="submit" class="submit-button">提出</button>
      </div>
    </form>
  </div>
</body>
</html>
