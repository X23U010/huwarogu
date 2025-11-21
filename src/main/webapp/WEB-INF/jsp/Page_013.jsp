<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>No.013_授業出席画面</title>
    <link rel="stylesheet" href="css/page13.css">

    <!-- キャッシュ防止（戻るボタンなどでも再入力されないように） -->
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
</head>
<body>
    <div class="main-content-wrapper">
        <div class="attendance-container">

            <div class="header-info">
                <h1>授業出席登録</h1>
            </div>

            <!-- autocomplete="off" でもChromeは無視することがあるため hidden ダミーを先頭に配置 -->
            <form class="login-form" action="Lesson_Attendance_Servlet" method="post" autocomplete="off">
                <!-- ダミーの非表示フィールド（Chromeのオートフィル対策） -->
                <input type="text" name="fakeusernameremembered" style="display:none">
                <input type="password" name="fakepasswordremembered" style="display:none">

                <div class="input-group">
                    <label for="lesson-id">授業ID</label>
                    <input type="text" id="lesson-id" name="lesson-id" 
                           placeholder="授業IDを入力してください" 
                           value="" autocomplete="off" required>
                </div>
                
                <div class="input-group">
                    <label for="lesson-password">パスワード</label>
                    <input type="password" id="lesson-password" name="lesson-password" 
                           placeholder="パスワードを入力してください" 
                           value="" autocomplete="new-password" required>
                    <span class="password-toggle">👁️</span> 
                </div>
                
                <button type="submit" class="register-button" name="action" value="register">
                    出席を登録する
                </button>
            </form>

            <div class="message-area">
                <p>ここに登録成功/失敗メッセージが表示されます</p>
            </div>
        </div>
    </div>
    <script src="js/page13.js"></script>
</body>
</html>
