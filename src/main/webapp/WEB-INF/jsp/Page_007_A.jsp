<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Public_Absence" %>
<%
// セッションから公欠情報を取得
Public_Absence pa = (Public_Absence) session.getAttribute("public_Absence_info");

// 各項目の初期値を空文字で設定
String startdate = "";
String enddate = "";
String starttime = "";
String endtime = "";

// セッションにデータが存在する場合、値を代入
if (pa != null) {
    if (pa.getActivity_date() != null) startdate = pa.getActivity_date();
    if (pa.getActivity_end_date() != null) enddate = pa.getActivity_end_date();
    if (pa.getStart_time() != null) starttime = pa.getStart_time();
    if (pa.getEnd_time() != null) endtime = pa.getEnd_time();
}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.007_公欠申請_A</title>
  <link rel="stylesheet" href="css/page7.css">
</head>
<body>
  <div class="absence-container">
    <h1 class="title">公欠申請1/2</h1>

    <form action="Public_Absence" method="post" autocomplete="off">
    
	  <label for="activityStartDate">活動日</label>
      <input type="date" id="activityStartDate" name="start_date" value="<%=startdate %>">
      
      <label for="activityEndDate">活動終了日</label>
      <input type="date" id="activityEndDate" name="end_date" value="<%=enddate %>">
      
      <label for="startTime">開始時間</label>
      <input type="text" id="startTime" name="start_time" value="<%=starttime %>">
      
      <label for="endTime">終了時間</label>
      <input type="text" id="endTime" name="end_time" value="<%=endtime %>">

      <div class="button-area">
        <button type="button" class="back-button" name="action" value="back_top">破棄</button>
        <button type="submit" class="submit-button" name="action" value="next_B">次へ</button>
      </div>
    </form>
  </div>
</body>
</html>