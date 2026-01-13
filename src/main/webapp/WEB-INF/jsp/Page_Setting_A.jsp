<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Member"%>
<%
//セッションからMemberオブジェクトを取得
Member member = (Member) session.getAttribute("loginMember");

//Servletから渡された先生リストを取得
ArrayList<Member> teacherList = (ArrayList<Member>) request.getAttribute("teacher_list");
if(teacherList == null) teacherList = new ArrayList<Member>();

//表示用の変数
String teacher_name = "未設定";
String subteacher_name = "なし";

//--- 修正ポイント：比較時にtrim()を使用して空白を除去する ---
if (member != null && teacherList != null) {
 // ログイン中のユーザーが持っている担任・副担任ID（空白除去）
 String myTeacherId = (member.getMember_teacher_id() != null) ? member.getMember_teacher_id().trim() : "";
 String mySubTeacherId = (member.getMember_subteacher_id() != null) ? member.getMember_subteacher_id().trim() : "";

 for(Member t : teacherList){
     // リストの中の先生自身のID（空白除去）
     String tId = (t.getMember_id() != null) ? t.getMember_id().trim() : "";
     
     // 担任の名前を特定
     if(tId.equals(myTeacherId)){
         teacher_name = t.getMember_name();
     }
     
     // 副担任の名前を特定
     if(tId.equals(mySubTeacherId)){
         subteacher_name = t.getMember_name();
     }
 }
}

%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>基本情報設定画面</title>
    <link rel="stylesheet" href="css/setting.css">

</head>
<body>
        <div class="setting-container">
            
            <div class="header-info">
                <h1>基本情報設定</h1>
                <p>学籍番号は変更できません。<br>他の情報を修正し「保存」してください。</p>
            </div>
            
            <form action="Setting_Servlet" method="post" id="settingForm">
                
                <div class="field" id="student_id_field">
                    <label for="student_id">学籍番号</label>
                    <input type="text" id="student_id" name="student_id" 
                           value="<%=member.getMember_id()%>" readonly>
                </div>

                <div class="field" id="birth_field">
                    <label for="birth_month">誕生月</label>
                    <input type="number" id="birth_month" name="birth_month" 
                           value="<%=member.getMember_month()%>" min="1" max="12" readonly>
                </div>
                
                <div class="field" id="name_field">
                    <label for="name">名前</label>
                    <input type="text" id="name" name="name" 
                           value="<%=member.getMember_name()%>" readonly>
                </div>
                
                <div class="field" id="teacher_field">
                    <label for="teacher_name">担任</label>
                    <input type="text" id="teacher_name" name="teacher_name" 
                           value="<%=teacher_name%>" readonly>
                </div>
                
                <div class="field" id="subteacher_field">
                    <label for="subteacher_name">副担任</label>
                    <input type="text" id="subteacher_name" name="subteacher_name" 
                           value="<%=subteacher_name%>" readonly>
                </div>
                
                
                <div class="button-group">
                    <button type="submit" id="backButton" name="action" value="setting_B">パスワード設定</button>
                </div>
                
                <div class="button-group">
                    <button type="submit" id="backButton" name="action" value="setting_C">担任/副担任設定</button>
                </div>
                
                <div class="button-group">
                    <button type="submit" id="backButton" name="action" value="back_top">戻る</button>
                </div>
                
                
            </form>
        </div>
    <script src="js/setting.js"></script>
</body>
</html>