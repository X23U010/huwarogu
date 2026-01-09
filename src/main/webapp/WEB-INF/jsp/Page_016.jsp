<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欠席届提出</title>
    <link rel="stylesheet" href="css/page16.css"> 
</head>
<body>
    <div class="main-content-wrapper center-content"> 
        
        <div class="absence-container">
            <h1 class="absence-title">欠席届</h1>
        
            <form id="absence-form" action="Absence_Servlet" method="post" class="absence-form">
            
                <div class="input-group">
                    <label for="absence-date">日付</label>
                    <input type="date" id="absence-date" name="absence-date" value=""> 
                </div>
            
                <div class="input-group">
                    <label for="absence-reason">理由</label>
                    <textarea id="absence-reason" name="absence-reason" rows="5" value=""></textarea>
                </div>

                <div id="error-message-area" class="message-area error-area">
                </div>
            
                <div class="button-area">
    <button type="submit" class="confirm-button" name="action" value="back_top">破棄</button>
    <button type="submit" class="confirm-button" name="action" value="adsence_register">確認</button>
</div>
            </form>
        </div>
        
    </div>
    
</body>
</html>