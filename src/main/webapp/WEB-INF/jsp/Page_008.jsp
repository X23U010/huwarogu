<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>公欠申請確認</title>
  <link rel="stylesheet" href="css/page8.css">
</head>
<body>
  <div class="confirm-container">
     <form action="Official_Leave_Request_Servlet" method="post" autocomplete="off">
    
	  <label for="activityStartDate">活動日</label>
      <input type="text" id="activityStartDate" name="start_date" value="">
      
      <label for="activityEndDate">活動終了日</label>
      <input type="text" id="activityEndDate" name="end_date" value="">
      
      <label for="startTime">開始時間</label>
      <input type="text" id="startTime" name="start_time" value="">
      
      <label for="endTime">終了時間</label>
      <input type="text" id="endTime" name="end_time" value="">

 	  <label for="companyName">企業名</label>
      <input type="text" id="companyName" name="company_name" value="">
      
      <label for="locationSelect">実施場所</label>
      <input type="text" id="locationSelect" name="activity_location_code" value="">
      
      <label for="reasonSelect">事由</label>
      <input type="text" id="reasonSelect" name="official_leave_reason_code" value="">
      
	  <label for="screeningSelect">選考内容</label>
	  <input type="text" id="screeningSelect" name="screening_method_code" value="">
     
      <div class="button-area">
        <button type="button" class="back-button" onclick="history.back()">戻る</button>
        <button type="submit" class="submit-button" name="action" value="official_leave_request_register_comit">提出</button>
      </div>
    </form>
    </div>
  </div>
</body>
</html>
