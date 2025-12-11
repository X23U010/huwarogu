<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.007_公欠申請_A</title>
  <link rel="stylesheet" href="css/page7.css">
</head>
<body>
  <div class="absence-container">
    <h1 class="title">公欠申請_A</h1>

    <form action="Official_Leave_Request_Servlet" method="post" autocomplete="off">
    
	  <label for="activityStartDate">活動日</label>
      <input type="date" id="activityStartDate" name="start_date" value="">
      
      <label for="activityEndDate">活動終了日</label>
      <input type="date" id="activityEndDate" name="end_date" value="">
      
      <label for="startTime">開始時間</label>
      <input type="text" id="startTime" name="start_time">
      
      <label for="endTime">終了時間</label>
      <input type="text" id="endTime" name="end_time">

      <div class="button-area">
        <button type="button" class="back-button" onclick="history.back()">戻る</button>
        <button type="submit" class="submit-button" name="action" value="next_B">次へ</button>
      </div>
    </form>
  </div>
</body>
</html>