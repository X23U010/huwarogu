<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欠席届送信完了 (FC018)</title>
    <link rel="stylesheet" href="page18.css"> 
</head>
<body>
    <div class="main-content-wrapper center-content"> 
        <div class="completion-container">
            <h1 class="completion-title">送信が完了しました</h1>
            
            <p class="completion-message">
                欠席届は担任の教師に通知されました。
            </p>

            <form action="HuwaLog_Servlet" method="post">
                <button id="back-to-top-button" class="back-to-top-button" name="action" value="back_top">
                    TOPへ戻る
                </button>
            </form>
        </div>
    </div>
</body>
</html>