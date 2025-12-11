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
      
      <label for="activityDate">活動日</label>
      <input type="date" id="activityDate" name="activity_date"> 
      
      <label for="activityStartTime">活動開始時間</label>
      <input type="text" id="activityStartTime" name="start_time" placeholder="例: 13:30"> 
      
      <label for="activityFinishTime">活動終了時間</label>
      <input type="text" id="activityFinishTime" name="finish_time" placeholder="例: 16:00">
      
      <div class="button-area"> 
      <button type="button" class="back-button" onclick="history.back()">戻る</button> 
      <button type="submit" class="submit-button" name="action" value="next_C">次へ</button> 
      </div>
    </form>
  </div>
</body>
</html>