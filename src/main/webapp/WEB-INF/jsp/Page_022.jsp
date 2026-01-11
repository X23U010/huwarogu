<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="Model.Absence"%> 
<%@ page import="Model.Public_Absence"%> 
<%@ page import="Model.Report"%> 
<%@ page import ="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No.023_申請の受理・拒否画面</title>
</head>

<body>
<%ArrayList<Absence> abList = (ArrayList<Absence>) session.getAttribute("abList");
ArrayList<Public_Absence> PuAbList = (ArrayList<Public_Absence>) session.getAttribute("PuAbList");
ArrayList<Report> reportList = (ArrayList<Report>) session.getAttribute("reportList");

%>
<h1>申請一覧</h1>

<!-- ================= 欠席申請 ================= -->
<h2>欠席申請一覧</h2>

<form action="AbApplicationServlet" method="post">

<table>
    <tr>
        <th>選択</th>
        <th>申請ID</th>
        <th>申請者</th>
        <th>欠席日</th>
        <th>理由</th>
    </tr>

<%
if (abList != null) {
    for (Absence a : abList) {
%>
    <tr>
        <td>
            <input type="checkbox"
                   name="absenceIds"
                   value="<%= a.getAbsenceId() %>">
        </td>
        <td><%= a.getAbsenceId() %></td>
        <td><%= a.getMemberId() %></td>
        <td><%= a.getAbsenceDay() %></td>
        <td><%= a.getAbsenceTxt() %></td>
    </tr>
<%
    }
}
%>
</table>

<br>

<input type="submit" name="action" value="承認">
<input type="submit" name="action" value="却下">

</form>


<!-- ================= 公欠申請 ================= -->
<h2>公欠申請一覧</h2>

<form action="PubAbApplicationServlet" method="post">

<table>
    <tr>
        <th>選択</th>
        <th>申請ID</th>
        <th>申請者</th>
        <th>実施日</th>
        <th>開始</th>
        <th>終了</th>
        <th>内容</th>
    </tr>

<%
if (PuAbList != null) {
    for (Public_Absence p : PuAbList) {
%>
    <tr>
        <td>
            <input type="checkbox"
                   name="publicAbsenceIds"
                   value="<%= p.getOfficilAbsenceId() %>">
        </td>
        <td><%= p.getOfficilAbsenceId() %></td>
        <td><%= p.getMemberId() %></td>
        <td><%= p.getImplement() %></td>
        <td><%= p.getStartTime() %></td>
        <td><%= p.getFinishTime() %></td>
        <td><%= p.getTxt() %></td>
    </tr>
<%
    }
}
%>
</table>

<br>

<input type="submit" name="action" value="承認">
<input type="submit" name="action" value="却下">

</form>

<!-- ================= レポート申請 ================= -->
<h2>レポート申請一覧</h2>

<form action="ReportApplicationServlet" method="post">

<table border="1">
    <tr>
        <th>選択</th>
        <th>レポートID</th>
        <th>申請者</th>
        <th>提出期日</th>
        <th>実施日</th>
        <th>開始</th>
        <th>終了</th>
        <th>場所</th>
        <th>内容</th>
    </tr>

<%
if (reportList != null) {
    for (Report r : reportList) {
%>
    <tr>
        <td>
            <input type="checkbox"
                   name="reportIds"
                   value="<%= r.getReportId() %>">
        </td>
        <td><%= r.getReportId() %></td>
        <td><%= r.getReportMemberId() %></td>
        <td><%= r.getReportDeadline() %></td>
        <td><%= r.getReportImplement() %></td>
        <td><%= r.getReportStartTime() %></td>
        <td><%= r.getReportFinishTime() %></td>
        <td><%= r.getReportLocation() %></td>
        <td><%= r.getReportTxt() %></td>
    </tr>
<%
    }
} else {
%>
    <tr>
        <td colspan="9">レポート申請はありません</td>
    </tr>
<%
}
%>

</table>

<br>

<input type="submit" name="action" value="承認">
<input type="submit" name="action" value="却下">

</form>

</body>
</html>





