<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.007_公欠申請_B</title>
  <link rel="stylesheet" href="css/page7.css">
</head>
<body>
  <div class="absence-container">
    <h1 class="title">公欠申請_B</h1>

    <form action="Official_Leave_Request_Servlet" method="post" autocomplete="off">
      
      <label for="companyName">企業名</label>
      <input type="text" id="companyName" name="company_name">
      
      <label for="locationSelect">実施場所</label>
      <select id="locationSelect" name="activity_location_code">
	  <option value="C01">Web</option>
	  <option value="C02">現地</option>
	  <option value="C03">学内</option>
	  </select>

      <label for="reasonSelect">事由</label>
      <select id="reasonSelect" name="official_leave_reason_code">
	  <option value="C01">インターンシップ</option>
	  <option value="C02">説明会</option>
	  <option value="C03">一次選考</option>
	  <option value="C04">二次選考</option>
	  <option value="C05">三次選考</option>
	  <option value="C06">四次選考</option>
	  <option value="C07">最終選考</option>
	  <option value="C08">面談・懇親会</option>
	  <option value="C09">内定式</option>
	  <option value="C10">研修</option>
	  </select>
	  
	  <label for="screeningSelect">選考内容</label>
      <select id="screeningSelect" name="screening_method_code">
	  <option value="C01">なし</option>
	  <option value="C02">適性検査（性格、作文等も含む）</option>
	  <option value="C03">面接</option>
	  <option value="C04">グループディスカッション・ワーク</option>
	  </select>

      <div class="button-area">
        <button type="button" class="back-button" onclick="history.back()">戻る</button>
        <button type="submit" class="submit-button" name="action" value="official_leave_request_register">提出</button>
      </div>
    </form>
  </div>
</body>
</html>