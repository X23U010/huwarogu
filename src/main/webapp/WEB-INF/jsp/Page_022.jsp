<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Absence"%> 
<%@ page import="Model.Public_Absence"%> 
<%@ page import="Model.Report"%> 
<%@ page import ="java.util.ArrayList" %>

<%
ArrayList<Absence> abList = (ArrayList<Absence>) session.getAttribute("abList");
ArrayList<Public_Absence> PuAbList = (ArrayList<Public_Absence>) session.getAttribute("PuAbList");
ArrayList<Report> reportList = (ArrayList<Report>) session.getAttribute("reportList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No.022_申請の受理・拒否画面</title>

</head>

<body>

<h1>申請一覧</h1>

<section>
    <h2>欠席申請一覧</h2>
    <% if (abList != null && !abList.isEmpty()) { %>
        <form action="AbApplicationServlet" method="post">
            <table border="1">
                <tr>
                    <th>選択</th>
                    <th>申請ID</th>
                    <th>申請者</th>
                    <th>欠席日</th>
                    <th>理由</th>
                </tr>
                <% for (Absence a : abList) { %>
                <tr>
                    <td><input type="checkbox" name="absenceIds" value="<%= a.getAbsence_id() %>"></td>
                    <td><%= a.getAbsence_id() %></td>
                    <td><%= a.getAbsence_member_id() %></td>
                    <td><%= a.getAbsence_date() %></td>
                    <td><%= a.getAbsence_txt() %></td>
                </tr>
                <% } %>
            </table>
            <input type="submit" name="action" value="欠席承認">
            <input type="submit" name="action" value="欠席却下">
        </form>
    <% } else { %>
        <p class="no-data">欠席申請はありません</p>
    <% } %>
</section>

<hr>

<section>
    <h2>公欠申請一覧</h2>
    <% if (PuAbList != null && !PuAbList.isEmpty()) { %>
        <form action="PubAbApplicationServlet" method="post">
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
                <% for (Public_Absence p : PuAbList) { %>
                <tr>
                    <td><input type="checkbox" name="publicAbsenceIds" value="<%= p.getPublic_absence_id() %>"></td>
                    <td><%= p.getPublic_absence_id() %></td>
                    <td><%= p.getStudent_id() %></td>
                    <td><%= p.getActivity_date() %></td>
                    <td><%= p.getStart_time() %></td>
                    <td><%= p.getEnd_time() %></td>
                    <td><%= p.getReason() %></td>
                </tr>
                <% } %>
            </table>
            <input type="submit" name="action" value="公欠承認">
            <input type="submit" name="action" value="公欠却下">
        </form>
    <% } else { %>
        <p class="no-data">公欠申請はありません</p>
    <% } %>
</section>

<hr>

<section>
    <h2>レポート申請一覧</h2>
    <% if (reportList != null && !reportList.isEmpty()) { %>
        <form action="ReportApplicationServlet" method="post">
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
                <% for (Report r : reportList) { %>
                <tr>
                    <td><input type="checkbox" name="reportIds" value="<%= r.getReport_id() %>"></td>
                    <td><%= r.getReport_id() %></td>
                    <td><%= r.getStudent_id() %></td>
                    <td><%= r.getApplication_date() %></td>
                    <td><%= r.getActivity_date() %></td>
                    <td><%= r.getStart_time() %></td>
                    <td><%= r.getEnd_time() %></td>
                    <td><%= r.getLocation() %></td>
                    <td><%= r.getReport_details() %></td>
                </tr>
                <% } %>
            </table>
            <input type="submit" name="action" value="報告書承認">
            <input type="submit" name="action" value="報告書却下">
        </form>
    <% } else { %>
        <p class="no-data">レポート申請はありません</p>
    <% } %>
</section>

</body>
</html>