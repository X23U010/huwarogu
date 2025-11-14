<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザーTOP画面 (FC005)</title>
    <link rel="stylesheet" href="css/page05.css"> 
</head>
<body>
    <div class="main-content-wrapper"> 
        
        <header class="top-header">
            <h1 class="system-name">ふわろぐ</h1>
            <div class="user-info">
                <span id="user-name">ユーザー名</span>
                <a href="settings.html" class="settings-link">
                    <button class="settings-button">
                        <img src="images/gear.svg" alt="設定">
                    </button>
                </a>
            </div>
            <a href="#" class="notification-link">お知らせ</a>
        </header>

        <div id="teacher-menu" class="user-menu-area teacher-area hidden">
            <h2 class="area-title">教師用メニュー</h2>
            <div class="menu-grid">
                <a href="" class="menu-item menu-purple">
                    <span class="menu-icon">📅</span>
                    <span class="menu-label">出欠設定</span>
                </a>
                <a href="" class="menu-item menu-purple">
                    <span class="menu-icon">📃</span>
                    <span class="menu-label">公欠・欠席一覧</span>
                </a>
                <a href="" class="menu-item menu-blue">
                    <span class="menu-icon">📝</span>
                    <span class="menu-label">公欠申請一覧</span>
                </a>
                <a href="" class="menu-item menu-blue">
                    <span class="menu-icon">📊</span>
                    <span class="menu-label">各授業出席率</span>
                </a>
            </div>
        </div>
        
        <div id="student-menu" class="user-menu-area student-area hidden">
            <h2 class="area-title">生徒用メニュー</h2>
            <div class="menu-grid">
                <a href="" class="menu-item menu-blue">
                    <span class="menu-icon">📄</span>
                    <span class="menu-label">公欠申請</span>
                </a>
                <a href="" class="menu-item menu-blue">
                    <span class="menu-icon">📁</span>
                    <span class="menu-label">報告書提出</span>
                </a>
                <a href="HuwaLog_Servlet?action=013" class="menu-item menu-purple">
                    <span class="menu-icon">🔔</span>
                    <span class="menu-label">授業出席</span>
                </a>
                <a href="HuwaLog_Servlet?action=016" class="menu-item menu-purple"> 
                    <span class="menu-icon">🤒</span>
                    <span class="menu-label">欠席届提出</span>
                </a>
            </div>
        </div>

    </div>
    
    <script src="js/page05.js"></script> 
</body>
</html>