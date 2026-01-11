<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Member"%>
<%@ page import="Model.Divination"%>
<%
// セッションからMemberオブジェクトを取得
Member member = (Member) session.getAttribute("loginMember");

// Servletから渡されたDivinationオブジェクトを取得
Divination d = (Divination) request.getAttribute("divinationResult");

// Servletから渡されたメッセージを取得
String message = (String) request.getAttribute("message");

// Divinationオブジェクトがnullでないかチェック
boolean isDivinationValid = (d != null && d.getDivination_txt() != null);
%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>更新完了</title>
  <link rel="stylesheet" href="css/page15.css">
</head>
<body>
    <div class="main-content-wrapper">
        <div class="complete-container">
            <div class="result-box">
                <h2 class="complete-title">更新完了</h2>
                
                <% if (isDivinationValid) { %>
                <div class="fortune-section">
                    <p class="section-label">今の運勢は…</p>
                    <p id="fortune-message" class="fortune-message"><%=d.getDivination_txt()%></p>
                </div>

                <div class="item-section">
                    <p class="section-label">ラッキーアイテムは</p>
                    <p id="lucky-item" class="lucky-item"><%=d.getDivination_item()%></p>
                </div>
                <% } else { %>
                <div class="fortune-section">
                    <p class="section-label">運勢情報の取得に失敗しました。</p>
                </div>
                <% } %>
                
				<form action="Setting_Servlet" method="post">
                <button id="back-to-top-button" class="back-to-top-button" name="action" value="back_top">
                    TOPへ戻る
                </button>
                </form>
                
            </div>
        </div>

    </div>
    </body>
</html>