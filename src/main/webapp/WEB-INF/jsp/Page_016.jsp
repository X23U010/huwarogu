<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欠席届提出</title>
    <link rel="stylesheet" href="page16.css"> 
</head>
<body>
    <div class="main-content-wrapper center-content"> 
        
        <div class="absence-container">
            <h1 class="absence-title">欠席届</h1>
        
            <form id="absence-form" class="absence-form">
            
                <div class="input-group">
                    <label for="absence-date">日付<span class="required-star">*</span></label>
                    <input type="date" id="absence-date" required> 
                </div>
            
                <div class="input-group">
                    <label for="absence-reason">理由<span class="required-star">*</span></label>
                    <textarea id="absence-reason" rows="5" placeholder="欠席理由を入力してください" required></textarea>
                </div>

                <div id="error-message-area" class="message-area error-area">
                </div>
            
                <button type="submit" class="confirm-button">
                    確認
                </button>
            </form>
        </div>
        
    </div>
    
    <script src="page16.js"></script> 
</body>
</html>