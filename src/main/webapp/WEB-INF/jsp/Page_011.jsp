<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.011_報告書提出（確認）</title>
  <link rel="stylesheet" href="css/page11.css">
</head>
<body>
  <div class="report-check-container">
    <h1>No.011_報告書提出（確認）</h1>

    <form action=Report_Servlet method="post" autocomplete="off">
      <label for="activity-date">活動日</label>
      <input type="date" id="activity-date" name="activity-date" value="2025-11-07" readonly>

      <label for="activity-content">活動内容</label>
      <textarea id="activity-content" name="activity-content" rows="4" readonly></textarea>

      <label for="activity-report">活動レポート</label>
      <textarea id="activity-report" name="activity-report" rows="6" readonly></textarea>

      <div class="buttons">
        <button type="button" class="back-btn" onclick="history.back()">戻る</button>
        <button type="submit" class="confirm-btn" name="action" value="report_register_comit">確認</button>
      </div>
    </form>
  </div>
</body>
</html>
