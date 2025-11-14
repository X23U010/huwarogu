<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欠席届確認 (FC017)</title>
    <link rel="stylesheet" href="css/page17.css"> 
</head>
<body>
    <div class="main-content-wrapper center-content"> 
        
        <div id="absence-confirm-modal" class="modal-overlay is-active"> 
            <div class="confirmation-box confirm-absence-box">
                <h2 class="modal-title">欠席届</h2>
                
                <div class="absence-content-display">
                    <div class="display-group">
                        <span class="display-label">日付</span>
                        <p id="display-date" class="display-value">2025/9/25</p>
                    </div>
                    
                    <div class="display-group">
                        <span class="display-label">理由</span>
                        <p id="display-reason" class="display-value reason-text">39.6度の熱があるため</p>
                    </div>
                </div>
                
                <div class="confirm-text">
                    <p>上記の内容で本当に送信しますか？</p>
                    <p class="warning-text">内容は担当の教師に<br>送信されます</p>
                </div>
                
                <div class="button-group">
                    <button id="cancel-send-button" class="action-button cancel" onclick="history.back()">キャンセル</button> 
                     <form action="HuwaLog_Servlet" method="post">
                    <button id="send-absence-button" class="action-button confirm" name="action" value="adsence_register_comit">送信</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
    
    <script src="page17.js"></script> 
</body>
</html>