<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="Model.Member"%>
<%
Member men = (Member) session.getAttribute("loginMember");
String role = (String) session.getAttribute("userRole");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>No.005_ユーザーTOP画面</title>
<link rel="stylesheet" href="css/page5.css">
</head>
<body>
	<div class="main-content-wrapper">

		 <header class="top-header">
            <h1 class="system-name">ふわろぐ</h1>
            <div class="user-info settings-dropdown">
                <span id="user-name"><%=men.getMember_name()%></span>

                <!-- 設定ボタン -->
                <button class="settings-button" id="settings-btn">
                    <img src="images/gear.svg" alt="設定">
                </button>
                
 				<ul class="dropdown-menu">
        			<li><a href="Logout_Servlet?action=logout">ログアウト</a></li>
        			<li><a href="HuwaLog_Servlet?action=Setting">基本情報設定</a></li>
  				</ul>
               
            </div>

            <a href="HuwaLog_Servlet?action=006" class="notification-link">お知らせ</a>
        </header>

		<div id="teacher-menu" class="user-menu-area teacher-area hidden">
			<h2 class="area-title">教師用メニュー</h2>
			<div class="menu-grid">
				 <a href="HuwaLog_Servlet?action=022" class="menu-item menu-purple"> <span
					class="menu-icon">📃</span> <span class="menu-label">公欠・欠席一覧</span>
				</a> <a href="HuwaLog_Servlet?action=025" class="menu-item menu-blue"> <span class="menu-icon">📝</span>
					<span class="menu-label">公欠申請一覧</span>
				</a> 
			</div>
		</div>

		<div id="student-menu" class="user-menu-area student-area hidden">
			<h2 class="area-title">生徒用メニュー</h2>
			<div class="menu-grid">
				<a href="HuwaLog_Servlet?action=007_A" class="menu-item menu-blue"> <span class="menu-icon">📄</span>
					<span class="menu-label">公欠申請</span>
					
				</a> <a href="HuwaLog_Servlet?action=010_A" class="menu-item menu-blue"> <span class="menu-icon">📁</span>
					<span class="menu-label">報告書提出</span>
					
				</a> <a href="HuwaLog_Servlet?action=016" class="menu-item menu-purple">
					<span class="menu-icon">🤒</span> <span class="menu-label">欠席届提出</span>
				</a>
			</div>
		</div>

	</div>

	<script>const USER_ROLE = '<%=role%>';</script>

	<script src="js/page05.js"></script>
</body>
</html>