<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Model.Report"%>
    
<%
Report report = (Report) session.getAttribute("report_info");

String activity_date = "";
String start = "";
String end = "";

if (report != null) {
	
if(!(report.getActivity_date() == null)){
	activity_date = report.getActivity_date();
}
if(!(report.getStart_time() == null)){
	start = report.getStart_time();
}

if(!(report.getEnd_time() == null)){
	end = report.getEnd_time();
}

}
%>  
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.010_報告書提出</title>
  <link rel="stylesheet" href="css/page10.css">
</head>
<body>
  <div class="report-container">
    <h1 class="title">報告書提出2/3</h1> 
    
    <form action="Report_Servlet" method="post" autocomplete="off">
      
      <label for="activityDate">活動日</label>
      <input type="date" id="activityDate" name="activity_date" value = "<%=activity_date%>"> 
      
      <label for="activityStartTime">活動開始時間</label>
      <input type="text" id="activityStartTime" name="start_time" placeholder="例: 13:30（半角）" value = "<%=start%>"> 
      
      <label for="activityFinishTime">活動終了時間</label>
      <input type="text" id="activityFinishTime" name="finish_time" placeholder="例: 16:00（半角）" value = "<%=end%>">
      
      <div class="button-area"> 
      <button type="submit" class="back-button" name="action" value="back_A">戻る</button> 
      <button type="submit" class="submit-button" name="action" value="next_C">次へ</button> 
      </div>
    </form>
  </div>
</body>
</html>