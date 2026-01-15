<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Absence"%> 
<%@ page import="Model.Public_Absence"%> 
<%@ page import ="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No.025_休み一覧画面</title>
</head>
<%ArrayList<Absence> abList = (ArrayList<Absence>) session.getAttribute("ablist");
ArrayList<Public_Absence> PuAbList =(ArrayList<Public_Absence>)session.getAttribute("PuAbList"); 
%>
<body>

<h1>お休み一覧</h1>

<section>
    <h2>欠席申請一覧</h2>
    <p>今後の欠席者を表示しています。</p>
    <% if (abList != null && !abList.isEmpty()) { %>
            <table border="1">
                <tr>
                    <th>申請ID</th>
                    <th>申請者</th>
                    <th>欠席日</th>
                    <th>理由</th>
                </tr>
                <% for (Absence a : abList) { %>
                <tr>
                    <td><%= a.getAbsence_id() %></td>
                    <td><%= a.getAbsence_member_id() %></td>
                    <td><%= a.getAbsence_date() %></td>
                    <td><%= a.getAbsence_txt() %></td>
                </tr>
                <% } %>
            </table>
    <% } else { %>
        <p class="no-data">今後の欠席予定者はいません</p>
    <% } %>
</section>

<hr>

<section>
    <h2>公欠一覧</h2>
    <p>今後の公欠者を表示しています。</p>
    <% if (PuAbList != null && !PuAbList.isEmpty()) { %>
            <table border="1">
                <tr>
                    <th>申請ID</th>
                    <th>申請者</th>
                    <th>実施日</th>
                    <th>開始</th>
                    <th>終了</th>
                    <th>内容</th>
                </tr>
                <% for (Public_Absence p : PuAbList) { %>
                <tr>
                    <td><%= p.getPublic_absence_id() %></td>
                    <td><%= p.getStudent_id() %></td>
                    <td><%= p.getActivity_date() %></td>
                    <td><%= p.getStart_time() %></td>
                    <td><%= p.getEnd_time() %></td>
                    <td><%= p.getReason() %></td>
                </tr>
                <% } %>
            </table>
    <% } else { %>
        <p class="no-data">今後の公欠予定者はいません</p>
    <% } %>
</section>
</html>
 