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
    <h1>報告書提出</h1>

    <form action=Report_Servlet method="post" autocomplete="off">
      <label for="activity-date">活動日</label>
      <input type="date" id="activity-date" name="activity-date">

      <label for="activity-content">活動内容</label>
      <select name="activity-content">
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
      
      <label for="activity-location">活動場所</label>
      <textarea id="activity-location" name="activity-location" rows="4"></textarea>
      
      <label for="activity-starttime">活動開始時間</label>
      <textarea id="activity-starttime" name="activity-starttime" rows="4"></textarea>
      
      
      <label for="activity-finishtime">活動終了時間</label>
      <textarea id="activity-finishtime" name="activity-finishtime" rows="4"></textarea>
      

      <label for="activity-report">活動レポート</label>
      <textarea id="activity-report" name="activity-report" rows="6"></textarea>

      <div class="buttons">
        <button type="button" class="back-btn" name="action" value="back_top">トップへ戻る</button>
        <button type="submit" class="submit-btn" name="action" value="report_register">提出</button>
      </div>
    </form>
  </div>
</body>
</html>
