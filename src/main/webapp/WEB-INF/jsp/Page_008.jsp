<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>公欠申請（確認）</title>
  <link rel="stylesheet" href="008.css">
</head>
<body>
  <div class="confirm-container">
    <h1>公欠申請（確認）</h1>

    <div class="field">
      <label>公欠日</label>
      <p id="date_display">mm/dd</p>
    </div>

    <div class="field">
      <label>公欠理由</label>
      <textarea id="reason_display" readonly></textarea>
    </div>

    <div class="button-area">
      <button type="button" class="back-button">戻る</button>
      <button type="button" class="confirm-button">確認</button>
    </div>
  </div>
</body>
</html>
