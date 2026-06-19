<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Absence"%>
<%@ page import="Model.Public_Absence"%>
<%@ page import="Model.Report"%>
<%@ page import="Dao.Application_Logic"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Absence> abList = (ArrayList<Absence>) session.getAttribute("abList");
ArrayList<Public_Absence> PuAbList = (ArrayList<Public_Absence>) session.getAttribute("PuAbList");
ArrayList<Report> reportList = (ArrayList<Report>) session.getAttribute("reportList");

Application_Logic al = new Application_Logic();

%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>申請の受理・拒否</title>
    <link rel="stylesheet" href="css/page22.css">
</head>

<body>
	
    <div class="admin-container">

		<h1 class="title">申請一覧</h1>
		
		<nav id="global_navi">
			<ul>
				<li class="current"><a href="HuwaLog_Servlet?action=back_top">HOME</a></li>
				<li class="current"><a href="#absence_list">欠席一覧</a></li>
				<li class="current"><a href="#public_absence_list">公欠一覧</a></li>
				<li class="current"><a href="#report_list">報告書一覧</a></li>
			</ul>
		</nav>
        
        <section id="absence_list" class="request-section">
            <h2 class="section-title">
                <i class="fas fa-user-times"></i> 欠席申請一覧
            </h2>
            <% if (abList != null && !abList.isEmpty()) { %>
            <form action="AbApplicationServlet" method="post">
                <div class="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>選択</th>
                                <th>ID</th>
                                <th>申請日</th>
                                <th>申請者</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Absence a : abList) { %>
                            <tr>
                                <td><input type="checkbox" name="absenceIds" value="<%=a.getAbsence_id()%>"></td>
                                <td><a href="AbApplicationServlet?action=Indetail&id=<%=a.getAbsence_id() %>"><%=a.getAbsence_id() %></a></td>
                                <td><%=al.Name_Search(a.getAbsence_member_id())%></td>
                                <td><%=a.getAbsence_application_date() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <div class="button-area">
                    <button type="submit" name="action" value="欠席承認" class="submit-button">承認</button>
                    <button type="submit" name="action" value="欠席却下" class="reject-button">却下</button>
                </div>
            </form>
            <% } else { %>
            <p class="no-data">欠席申請はありません</p>
            <% } %>
        </section>

        <section id="public_absence_list" class="request-section">
            <h2 class="section-title">
                <i class="fas fa-briefcase"></i> 公欠申請一覧
            </h2>
            <% if (PuAbList != null && !PuAbList.isEmpty()) { %>
            <form action="PubAbApplicationServlet" method="post">
                <div class="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>選択</th>
                                <th>ID</th>
                                <th>申請者</th>
                                <th>申請日</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Public_Absence p : PuAbList) { %>
                            <tr>
                                <td><input type="checkbox" name="publicAbsenceIds" value="<%=p.getPublic_absence_id()%>"></td>
                                <td><a href="PubAbApplicationServlet?action=Indetail&id=<%=p.getPublic_absence_id() %>"><%=p.getPublic_absence_id() %></a></td>
                                <td><%=al.Name_Search(p.getStudent_id())%></td>   
                                <td><%=p.getApplication_date() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <div class="button-area">
                    <button type="submit" name="action" value="公欠承認" class="submit-button">承認</button>
                    <button type="submit" name="action" value="公欠却下" class="reject-button">却下</button>
                </div>
            </form>
            <% } else { %>
            <p class="no-data">公欠申請はありません</p>
            <% } %>
        </section>

        <section id="report_list" class="request-section">
            <h2 class="section-title">
                <i class="fas fa-file-alt"></i> レポート申請一覧
            </h2>
            <% if (reportList != null && !reportList.isEmpty()) { %>
            <form action="ReportApplicationServlet" method="post">
                <div class="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>選択</th>
                                <th>ID</th>
                                <th>申請者</th>
                                <th>申請日</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Report r : reportList) { %>
                            <tr>
                                <td><input type="checkbox" name="reportIds" value="<%=r.getReport_id()%>"></td>
                                <td><a href="ReportApplicationServlet?action=Indetail&id=<%=r.getReport_id()%>"><%=r.getReport_id()%></a></td>
                                <td><%=al.Name_Search(r.getStudent_id())%></td>
                                <td><%=r.getApplication_date() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <div class="button-area">
                    <button type="submit" name="action" value="報告書承認" class="submit-button">承認</button>
                    <button type="submit" name="action" value="報告書却下" class="reject-button">却下</button>
                </div>
            </form>
            <% } else { %>
            <p class="no-data">レポート申請はありません</p>
            <% } %>
        </section>


    </div>
</body>
</html>