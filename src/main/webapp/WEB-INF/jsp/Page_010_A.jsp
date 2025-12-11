<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.010_報告書提出</title>
  <link rel="stylesheet" href="css/page10.css">
</head>
<body>
  <div class="report-container">
    <h1 class="title">報告書提出</h1> 
    
    <form action="Report_Servlet" method="post" autocomplete="off">
    
      <label for="companyName">企業名</label>
      <input type="text" id="companyName" name="company_name">
      
      <label for="activityLocation">活動場所</label>
      <input type="text" id="activityLocation" name="activity_location">
      
      <div class="button-area"> 
      <button type="button" class="back-button" onclick="history.back()">戻る</button> 
      <button type="submit" class="submit-button" name="action" value="next_B">次へ</button> 
      </div>
    </form>
  </div>
</body>
</html>