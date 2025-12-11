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

	  <label for="activityContentSelect">活動内容</label>
      <select id="activityContentSelect" name="activity_content_code"> 
      <option value="C01">インターン選考</option>
	  <option value="C02">インターン</option>
	  <option value="C03">オープンカンパニー</option>
	  <option value="C04">説明会</option>
	  <option value="C05">説明会(選考に進む予定)</option>
	  <option value="C06">説明会(選考に進まない予定)</option>
	  <option value="C07">選考受験</option>
	  <option value="C08">面談・懇親会</option>
	  <option value="C09">内定式</option>
	  <option value="C10">研修</option>
	  </select>
      
      <label for="activityReport">活動レポート</label>
      <textarea id="activityReport" name="activity_report" rows="6"></textarea> 
      
      <div class="button-area"> 
      <button type="button" class="back-button" onclick="history.back()">戻る</button> 
      <button type="submit" class="submit-button" name="action" value="report_register">提出</button> 
      </div>
    </form>
  </div>
</body>
</html>