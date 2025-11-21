<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>No.001_TOP画面</title>
<link rel="stylesheet" href="css/page1.css">
<script src="js/jquery-3.7.1.min.js"></script>
</head>
<body>
    <main>
        <div id="top">
            <h1>ふわろぐ</h1>
            <div id="buttons">
                <form action=Top_Servlet" method="post">
                    <button type="submit" name="action" value="new">新規会員登録</button>
                    <button type="submit" name="action" value="login">ログイン</button>
                </form>
            </div>
        </div>
    </main>
    
	<footer>
		<small>&copy;copyright ふわろぐ</small>
	</footer>
	
</body>
</html>