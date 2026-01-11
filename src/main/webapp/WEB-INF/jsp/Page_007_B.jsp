<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Public_Absence"%>
<%
// セッションから公欠情報を取得
Public_Absence pa = (Public_Absence) session.getAttribute("public_Absence_info");

// 各項目の初期値を空文字で設定
String company = "";
String location = "";
String reason = "";
String screening = "";

// セッションにデータが存在する場合、値を代入
if (pa != null) {
    if (pa.getCompany_name() != null) company = pa.getCompany_name();
    if (pa.getLocation() != null) location = pa.getLocation();
    if (pa.getReason() != null) reason = pa.getReason();
    if (pa.getSelection_details() != null) screening = pa.getSelection_details();
}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.007_公欠申請_B</title>
  <link rel="stylesheet" href="css/page7.css">
</head>
<body>
  <div class="absence-container">
    <h1 class="title">公欠申請 2/2</h1>

    <form action="Public_Absence" method="post" autocomplete="off">
      
      <label for="companyName">企業名</label>
      <input type="text" id="companyName" name="company_name" value="<%=company %>">
      
      <label for="locationSelect">実施場所</label>
      <select id="locationSelect" name="activity_location_code">
        <option value="P001" <% if("P001".equals(location)) out.print("selected"); %>>Web</option>
        <option value="P003" <% if("P003".equals(location)) out.print("selected"); %>>学内</option>
        <option value="P002" <% if("P002".equals(location)) out.print("selected"); %>>現地</option>
      </select>

      <label for="reasonSelect">事由</label>
      <select id="reasonSelect" name="official_leave_reason_code">
        <option value="C01" <% if("C01".equals(reason)) out.print("selected"); %>>インターンシップ</option>
        <option value="C02" <% if("C02".equals(reason)) out.print("selected"); %>>説明会</option>
        <option value="C03" <% if("C03".equals(reason)) out.print("selected"); %>>一次選考</option>
        <option value="C04" <% if("C04".equals(reason)) out.print("selected"); %>>二次選考</option>
        <option value="C05" <% if("C05".equals(reason)) out.print("selected"); %>>三次選考</option>
        <option value="C06" <% if("C06".equals(reason)) out.print("selected"); %>>四次選考</option>
        <option value="C07" <% if("C07".equals(reason)) out.print("selected"); %>>最終選考</option>
        <option value="C08" <% if("C08".equals(reason)) out.print("selected"); %>>面談・懇親会</option>
        <option value="C09" <% if("C09".equals(reason)) out.print("selected"); %>>内定式</option>
        <option value="C10" <% if("C10".equals(reason)) out.print("selected"); %>>研修</option>
      </select>
	  
      <label for="screeningSelect">選考内容</label>
      <select id="screeningSelect" name="screening_method_code">
        <option value="S01" <% if("S01".equals(screening)) out.print("selected"); %>>なし</option>
        <option value="S02" <% if("S02".equals(screening)) out.print("selected"); %>>適性検査（性格、作文等も含む）</option>
        <option value="S03" <% if("S03".equals(screening)) out.print("selected"); %>>面接</option>
        <option value="S04" <% if("S04".equals(screening)) out.print("selected"); %>>グループディスカッション・ワーク</option>
      </select>

      <div class="button-area">
        <%-- 前のページ(Page_007_A)へ戻るボタン。action値を送ってServletで制御する場合はこちら --%>
        <button type="submit" class="back-button" name="action" value="back_A">戻る</button>
        <button type="submit" class="submit-button" name="action" value="official_leave_request_register">確認</button>
      </div>
    </form>
  </div>
</body>
</html>