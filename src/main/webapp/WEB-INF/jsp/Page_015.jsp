<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>出席完了</title>
    <link rel="stylesheet" href="css/page15.css"> 
    
    </head>
<body>
    <div class="main-content-wrapper">
        <div class="complete-container">
            <div class="result-box">
                <h2 class="complete-title">授業出席完了</h2>
                
                <div class="fortune-section">
                    <p class="section-label">授業の運勢は…</p>
                    <p id="fortune-message" class="fortune-message">
                        </p>
                </div>

                <div class="item-section">
                    <p class="section-label">ラッキーアイテムは</p>
                    <p id="lucky-item" class="lucky-item">
                        </p>
                </div>
                
				<form action="Lesson_Attendance_Servlet" method="post">
                <button id="back-to-top-button" class="back-to-top-button" name="action" value="back_top">
                    TOPへ戻る
                </button>
                </form>
                
            </div>
        </div>

    </div>
    
    <script src="js/page15.js"> </script> 
</body>
</html>