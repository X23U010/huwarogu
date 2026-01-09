<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Model.Report"%>
<%
Report report = (Report) session.getAttribute("report_info");

String company = "";
String location = "";

if (report != null) {
    
    if (report.getCompany_name() != null) {
        company = report.getCompany_name();
    }
    
    if (report.getLocation() != null) {
        location = report.getLocation();
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
    <h1 class="title">報告書提出1/3</h1> 
    
    <form action="Report_Servlet" method="post" autocomplete="off">
    
      <label for="companyName">企業名</label>
      <input type="text" id="companyName" name="company_name" value = "<%=company%>">
      
      <label for="activityLocation">活動場所</label>
      <input type="text" id="activityLocation" name="activity_location" value = "<%=location%>">
      
      <div class="button-area"> 
      <button type="submit" class="back-button" name="action" value="back_top">破棄</button> 
      <button type="submit" class="submit-button" name="action" value="next_B">次へ</button> 
      </div>
    </form>
  </div>
</body>
</html>