<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Public_Absence"%>
<%
Public_Absence pa = (Public_Absence) session.getAttribute("public_Absence_info");

String company = (pa != null && pa.getCompany_name() != null) ? pa.getCompany_name() : "";
String location = (pa != null && pa.getLocation() != null) ? pa.getLocation() : "";
String start_date = (pa != null && pa.getActivity_date() != null) ? pa.getActivity_date() : "";
String end_date = (pa != null && pa.getActivity_end_date() != null) ? pa.getActivity_end_date() : "";
String start_time = (pa != null && pa.getStart_time() != null) ? pa.getStart_time() : "";
String end_time = (pa != null && pa.getEnd_time() != null) ? pa.getEnd_time() : "";
String reason = (pa != null && pa.getReason() != null) ? pa.getReason() : "";
String screening = (pa != null && pa.getSelection_details() != null) ? pa.getSelection_details() : "";
%>
<%!
public String getLocationDisplay(String code) {
    if ("P001".equals(code)) return "Web";
    if ("P002".equals(code)) return "現地";
    if ("P003".equals(code)) return "学内";
    return "未選択";
}
public String getReasonDisplay(String code) {
    if ("C01".equals(code)) return "インターンシップ";
    if ("C02".equals(code)) return "説明会";
    if ("C03".equals(code)) return "一次選考";
    // ... 必要に応じて追加
    return "選考受験"; 
}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.008_公欠申請確認</title>
  <link rel="stylesheet" href="css/page8.css">
</head>
<body>
  <div class="report-check-container">
    <h1>公欠申請確認</h1> 

    <form action="Public_Absence" method="post" autocomplete="off">
        <%-- DB登録用の隠しデータ --%>
        <input type="hidden" name="company_name" value="<%=company%>">
        <input type="hidden" name="activity_location_code" value="<%=location%>">
        <input type="hidden" name="start_date" value="<%=start_date%>">
        <input type="hidden" name="end_date" value="<%=end_date%>">
        <input type="hidden" name="start_time" value="<%=start_time%>">
        <input type="hidden" name="end_time" value="<%=end_time%>">
        <input type="hidden" name="official_leave_reason_code" value="<%=reason%>">
        <input type="hidden" name="screening_method_code" value="<%=screening%>">

        <div class="row-group">
            <div class="field-item">
                <label>企業名</label>
                <div class="card-value-box"><%=company%></div>
            </div>
            <div class="field-item">
                <label>活動場所</label>
                <div class="card-value-box"><%=getLocationDisplay(location)%></div>
            </div>
        </div>
        
        <div class="row-group">
            <div class="field-item">
                <label>活動開始日</label>
                <div class="card-value-box"><%=start_date%></div>
            </div>
            <div class="field-item">
                <label>活動終了日</label>
                <div class="card-value-box"><%=end_date%></div>
            </div>
        </div>

        <div class="row-group">
            <div class="field-item">
                <label>活動開始時間</label>
                <div class="card-value-box"><%=start_time%></div>
            </div>
            <div class="field-item">
                <label>活動終了時間</label>
                <div class="card-value-box"><%=end_time%></div>
            </div>
        </div>
        
        <label>活動内容（事由）</label>
        <div class="card-value-box"><%=getReasonDisplay(reason)%></div>

        <div class="buttons">
            <button type="button" class="back-btn" onclick="history.back()">戻る</button>
            <button type="submit" class="confirm-btn" name="action" value="official_leave_request_register_comit">提出</button>
        </div>
    </form>
  </div>
</body>
</html>