<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Member"%>
<%
// セッションからMemberオブジェクトを取得
Member member = (Member) session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>基本情報設定画面_B</title>
    <link rel="stylesheet" href="css/setting.css">

</head>
<body>
        <div class="setting-container">
            
            <div class="header-info">
                <h1>パスワード設定</h1>
            </div>
            
            <form action="Setting_Servlet" method="post" id="settingForm">
                
                 <div class="field password-input-group">
                    <label for="password">パスワード (変更する場合のみ)</label>
                    <div class="password-control-wrapper">
                        <button type="button" id="random-button" class="random-button">
                            ランダム生成
                        </button>
                        <input type="password" id="password" name="password" 
                               placeholder="入力または生成（８文字以上）" 
                               autocomplete="new-password" 
                               > <span class="toggle-password" data-target="password">
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

                <div class="field password-input-group">
                    <label for="confirm-password">パスワード再入力</label>
                    <div class="password-control-wrapper no-button">
                        <input type="password" id="confirm-password" 
                               placeholder="手動入力の場合は手動で入力" 
                               autocomplete="new-password"> 
                        <span class="toggle-password" data-target="confirm-password">
                            <i class="fas fa-eye-slash"></i>
                        </span>
                    </div>
                </div>

                <div id="error-message-area" class="message-area error-area">
                </div>
                
                <div class="button-group">
                    <button type="submit" id="backButton" name="action" value="back_A">戻る</button>
                    <button type="submit" id="updateButton" name="action" value="setting_E_password">更新</button>
                </div>
            </form>
        </div>
    <script src="js/setting.js"></script>
</body>
</html>