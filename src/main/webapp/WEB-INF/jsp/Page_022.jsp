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


<%
if (abList.size() != 0) {
%>
<table border="1">
    <tr>
        <th>選択</th>
        <th>申請ID</th>
        <th>申請者</th>
        <th>欠席日</th>
        <th>理由</th>
    </tr>

<%
    for (Absence a : abList) {
%>
    <tr>
        <td>
            <input type="checkbox"
                   name="absenceIds"
                   value="<%= a.getAbsence_id() %>">
        </td>
        <td><%= a.getAbsence_id() %></td>
        <td><%= a.getAbsence_member_id() %></td>
        <td><%= a.getAbsence_date() %></td>
        <td><%= a.getAbsence_txt() %></td>
    </tr>
    </table>

<br>

<input type="submit" name="action" value="承認">
<input type="submit" name="action" value="却下">

</form>
    
<%
    }
}else {
%>
    <tr>
        <td colspan="9">申請はありません</td>
    </tr>
<%
}
%>


<!-- ================= 公欠申請 ================= -->
<h2>公欠申請一覧</h2>

<form action="PubAbApplicationServlet" method="post">


<%
if (PuAbList.size() != 0) {
%>
<table border="1">
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
    for (Public_Absence p : PuAbList) {
%>
    <tr>
        <td>
            <input type="checkbox"
                   name="publicAbsenceIds"
                   value="<%= p.getPublic_absence_id() %>">
        </td>
        <td><%= p.getPublic_absence_id() %></td>
        <td><%= p.getStudent_id() %></td>
        <td><%= p.getActivity_date() %></td>
        <td><%= p.getStart_time() %></td>
        <td><%= p.getEnd_time() %></td>
        <td><%= p.getReason() %></td>
    </tr>
    </table>

<br>

<input type="submit" name="action" value="承認">
<input type="submit" name="action" value="却下">

</form>
    
<%
    }
}else {
%>
    <tr>
        <td colspan="9">申請はありません</td>
    </tr>
<%
}
%>

<!-- ================= レポート申請 ================= -->
<h2>レポート申請一覧</h2>

<form action="ReportApplicationServlet" method="post">



<%
if (reportList.size() != 0) {
%>
<table border="1">
    <tr>
        <th>選択</th>
        <th>レポートID</th>
        <th>申請者</th>
        <th>提出日</th>
        <th>実施日</th>
        <th>開始</th>
        <th>終了</th>
        <th>場所</th>
        <th>内容</th>
    </tr>
<%
    for (Report r : reportList) {
%>

    <tr>
        <td>
            <input type="checkbox"
                   name="reportIds"
                   value="<%= r.getReport_id() %>">
        </td>
        <td><%= r.getReport_id() %></td>
        <td><%= r.getStudent_id() %></td>
        <td><%= r.getApplication_date() %></td>
        <td><%= r.getActivity_date() %></td>
        <td><%= r.getStart_time() %></td>
        <td><%= r.getEnd_time() %></td>
        <td><%= r.getLocation() %></td>
        <td><%= r.getReport_details() %></td>
    </tr>
    </table>
    
    <br>

<input type="submit" name="action" value="承認">
<input type="submit" name="action" value="却下">

</form>
<%
    }
} else {
%>
    <tr>
        <td colspan="9">申請はありません</td>
    </tr>
<%
}
%>

</table>



</body>
</html>





