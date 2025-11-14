<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>No.014_授業出席_確認画面</title>
    <link rel="stylesheet" href="css/page14.css"> 
</head>
<body>
    <div class="main-content-wrapper">
        <div id="confirmation-modal" class="modal-overlay">
            <div class="confirmation-box">
                <h2 class="modal-title">確認</h2>
                <div class="modal-content">
                    <p id="class-name-display">OOOOO<br>授業に出席しますか？</p> 
                    
                </div>
                
                <div class="button-group">
                
                    <button id="cancel-button" class="action-button cancel" onclick="history.back()">キャンセル</button> 
                    
                    <form action="HuwaLog_Servlet" method="post">
    					<button id="comit-button" type="submit" class="action-button confirm" name="action" value="register_comit">
                    		出席
                       </button>
					</form>
                </div>
            </div>
        </div>
    </div>
    
    <script src="js/page14.js"></script> 
</body>
</html>