<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Report"%>
<%
// セッションからデータ取得
Report report = (Report) session.getAttribute("report_info");

String company = (report != null && report.getCompany_name() != null) ? report.getCompany_name() : "";
String location = (report != null && report.getLocation() != null) ? report.getLocation() : "";
String activity_date = (report != null && report.getActivity_date() != null) ? report.getActivity_date() : "";
String start = (report != null && report.getStart_time() != null) ? report.getStart_time() : "";
String end = (report != null && report.getEnd_time() != null) ? report.getEnd_time() : "";
String reason = (report != null && report.getReason() != null) ? report.getReason() : "";
String activity_report = (report != null && report.getReport_details() != null) ? report.getReport_details() : "";
%>
<%!
// 活動内容コードを日本語テキストに変換する関数
public String getReasonDisplay(String reasonCode) {
    switch (reasonCode) {
        case "C01": return "インターン選考";
        case "C02": return "インターン";
        case "C03": return "オープンカンパニー";
        case "C05": return "説明会(選考に進む予定)";
        case "C06": return "説明会(選考に進まない予定)";
        case "C07": return "選考受験";
        case "C08": return "面談・懇親会";
        case "C09": return "内定式";
        case "C10": return "研修";
        default: return "未選択";
    }
}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>No.011_報告書提出（確認）</title>
  <link rel="stylesheet" href="css/page11.css">
</head>
<body>
  <div class="report-check-container">
    <h1 style="text-align: center;">報告書提出確認</h1> 

    <form action="Report_Servlet" method="post" autocomplete="off">
    
        <input type="hidden" name="company_name" value="<%=company%>">
        <input type="hidden" name="activity_location" value="<%=location%>">
        <input type="hidden" name="activity_date" value="<%=activity_date%>">
        <input type="hidden" name="start_time" value="<%=start%>">
        <input type="hidden" name="finish_time" value="<%=end%>">
        <input type="hidden" name="activity_content_code" value="<%=reason%>">
        <input type="hidden" name="activity_report" value="<%=activity_report%>">

        <div class="row-group">
            <div class="field-item">
                <label>企業名</label>
                <div class="card-value-box"><%=company%></div>
            </div>
            <div class="field-item">
                <label>活動場所</label>
                <div class="card-value-box"><%=location%></div>
            </div>
        </div>
        
        <label>活動日</label>
        <div class="card-value-box"><%=activity_date%></div>

        <div class="row-group">
            <div class="field-item">
                <label>活動開始時間</label>
                <div class="card-value-box"><%=start%></div>
            </div>
            <div class="field-item">
                <label>活動終了時間</label>
                <div class="card-value-box"><%=end%></div>
            </div>
        </div>
        
        <label>活動内容</label>
        <div class="card-value-box">
            <%= getReasonDisplay(reason) %>
        </div>
        
        <label>活動レポート</label>
        <div class="report-text-area">
            <%=activity_report%>
        </div>

        <div class="buttons">
            <button type="submit" class="back-btn" name="action" value="back_C">戻る</button>
            <button type="submit" class="confirm-btn" name="action" value="report_register_comit">確認</button>
        </div>
    </form>
  </div>
</body>
</html>