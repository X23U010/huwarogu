<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Absence" %>
<%
// セッションから公欠情報を取得
Absence pa = (Absence) session.getAttribute("absence_info");

// 各項目の初期値を空文字で設定
String date = "";
String txt = "";

// セッションにデータが存在する場合、値を代入
if (pa != null) {
    if (pa.getAbsence_date()!= null) date = pa.getAbsence_date();
    if (pa.getAbsence_txt() != null) txt = pa.getAbsence_txt();
}
%>    
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欠席届確認</title>
    <link rel="stylesheet" href="css/page17.css"> 
</head>
<body>
    <div class="main-content-wrapper center-content"> 
        
        <div id="absence-confirm-modal" class="modal-overlay is-active"> 
            <div class="confirmation-box confirm-absence-box">
                <h2 class="modal-title">欠席届</h2>
                
<div class="absence-content-display">
    <div class="display-group">
        <span class="display-label">日付</span>                        
        <input type="date" value="<%=date %>" readonly> 
    </div>
    
    <div class="display-group">
        <span class="display-label">理由</span>  
        <textarea rows="5" readonly><%=txt %></textarea>                    
    </div>
</div>

<div class="confirm-text">
    <p>上記の内容で本当に送信しますか？</p>
    <p class="warning-text">内容は担当の教師に送信されます</p>
</div>

<div class="button-group">
    <button type="button" class="action-button cancel" onclick="history.back()">戻る</button> 
    <form action="Absence_Servlet" method="post" style="flex: 1;">
        <button type="submit" class="action-button confirm" name="action" value="adsence_register_comit" style="width: 100%;">送信</button>
    </form>
</div>
            </div>
        </div>

    </div>
    
</body>
</html>