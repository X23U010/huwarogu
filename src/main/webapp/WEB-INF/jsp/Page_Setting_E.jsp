<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="Model.Divination"%>
<%@ page import="Dao.Divination_Logic"%>
<%
Divination_Logic dlogic = new Divination_Logic();
Divination d = dlogic.divination_execute();
%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>設定更新完了画面</title>
  <link rel="stylesheet" href="css/page15.css">
</head>
<body>
    <div class="main-content-wrapper">
        <div class="complete-container">
            <div class="result-box">
                <h2 class="complete-title">更新完了</h2>
                
                <div class="fortune-section">
                    <p class="section-label">今の運勢は…</p>
                    <p id="fortune-message" class="fortune-message"><%=d.getDivination_txt()%>
                        </p>
                </div>

                <div class="item-section">
                    <p class="section-label">ラッキーアイテムは</p>
                    <p id="lucky-item" class="lucky-item"><%=d.getDivination_item()%>
                        </p>
                </div>
                
                 <p style="color:red;">${errorMsg}</p>
                 
				<form action="Setting_Servlet" method="post">
                <button id="back-to-top-button" class="back-to-top-button" name="action" value="back_A">
                    設定画面に戻る
                </button>
                </form>
            </div>
        </div>
    </div>
    </body>
</html>
