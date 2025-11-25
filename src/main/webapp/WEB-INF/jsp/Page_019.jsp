<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>No.019_出席パスワード設定</title>
    <link rel="stylesheet" href="page19.css"> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <div class="main-content-wrapper center-content"> 
        <div class="password-setting-container completion-container">
            <h1 class="setting-title">出席パスワード設定画面</h1>
            
            <form id="password-form" class="setting-form">
                
                <div class="input-group password-input-group">
                    <label for="password">パスワード</label>
                    <div class="password-control-wrapper">
                        <button type="button" id="random-button" class="random-button">
                            ランダム
                        </button>
                        <input type="password" id="password" 
                               placeholder="パスワードを入力または生成" 
                               maxlength="10" 
                               autocomplete="off" 
                               required> 
                        <span class="toggle-password" data-target="password">
                            <i class="fas fa-eye-slash"></i>
                        </span>
                    </div>
                </div>

                <div class="strength-meter-container">
                    <p class="strength-label">厳重度:</p>
                    <div class="strength-meter-bar">
                        <div id="strength-bar" class="strength-bar low"></div>
                    </div>
                    <span id="strength-text" class="strength-text low">低</span>
                </div>

                <div class="input-group password-input-group">
                    <label for="confirm-password">パスワード再入力</label>
                    <div class="password-control-wrapper no-button">
                        <input type="password" id="confirm-password" 
                               placeholder="確認のため再入力" 
                               maxlength="10" 
                               autocomplete="off" 
                               required> 
                        <span class="toggle-password" data-target="confirm-password">
                            <i class="fas fa-eye-slash"></i>
                        </span>
                    </div>
                </div>

                <div id="error-message-area" class="message-area error-area">
                </div>
            
                <button type="submit" id="submit-button" class="confirm-button" disabled>
                    決定する
                </button>
            </form>
        </div>
    </div>
    
    <script src="page19.js"></script> 
</body>
</html>