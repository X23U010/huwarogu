<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Model.Report"%>
    
<%
Report report = (Report) session.getAttribute("report_info");

String reason = "";
String activity_report = "";

if (report != null) {
    if(report.getReason() != null){
    	reason = report.getReason();
    }

    if(report.getReport_details() != null){
    	activity_report = report.getReport_details();
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
    <h1 class="title">報告書提出3/3</h1>
    
    <form action="Report_Servlet" method="post" autocomplete="off">

	  <label for="activityContentSelect">活動内容</label>
      <select id="activityContentSelect" name="activity_content_code"> 
      <option value="C01" <% if("C01".equals(reason)) out.print("selected"); %>>インターン選考</option>
	  <option value="C02" <% if("C02".equals(reason)) out.print("selected"); %>>インターン</option>
	  <option value="C03" <% if("C03".equals(reason)) out.print("selected"); %>>オープンカンパニー</option>
	  <option value="C05" <% if("C05".equals(reason)) out.print("selected"); %>>説明会(選考に進む予定)</option>
	  <option value="C06" <% if("C06".equals(reason)) out.print("selected"); %>>説明会(選考に進まない予定)</option>
	  <option value="C07" <% if("C07".equals(reason)) out.print("selected"); %>>選考受験</option>
	  <option value="C08" <% if("C08".equals(reason)) out.print("selected"); %>>面談・懇親会</option>
	  <option value="C09" <% if("C09".equals(reason)) out.print("selected"); %>>内定式</option>
	  <option value="C10" <% if("C10".equals(reason)) out.print("selected"); %>>研修</option>
	  </select>
      
      <label for="activityReport">活動レポート</label>
      <textarea id="activityReport" name="activity_report" rows="6"><%=activity_report %></textarea> 
      
      <div class="button-area"> 
      <button type="submit" class="back-button" name="action" value="back_B">戻る</button> 
      <button type="submit" class="submit-button" name="action" value="report_register">確認</button> 
      </div>
    </form>
  </div>
</body>
</html>