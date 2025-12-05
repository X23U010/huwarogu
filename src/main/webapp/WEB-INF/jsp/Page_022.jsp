<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>申請の処理拒否画面 (FC022)</title>
    <link rel="stylesheet" href="css/page22.css"> 
</head>
<body>
    <div class="main-content-wrapper center-content"> 
        <div class="application-list-container completion-container">
            <h1 class="list-title">申請一覧</h1>

            <div class="list-controls">
                <button type="button" id="select-button" class="action-button select-button">
                    選択
                </button>
            </div>
            
            <form id="application-form">
                <div class="application-items" id="application-items-container">
                    
                </div>
                
                <div class="process-buttons-group">
                    <button type="button" id="accept-button" class="confirm-button accept-button" disabled>
                        受理
                    </button>
                    <button type="button" type="button" id="reject-button" class="confirm-button reject-button" disabled>
                        拒否
                    </button>
                </div>
            </form>
        </div>
    </div>
    
    <script src="page22.js"></script> 
</body>
</html>