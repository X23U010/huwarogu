<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>活動申請</title>
    <link rel="stylesheet" href="style.css"> 
</head>
<body>
    <div class="container">
        <h1>活動申請</h1>
        <form action="#" method="post">
            
            <div class="form-group">
                <label for="startDate">活動日</label>
                <input type="date" id="startDate" name="startDate" required>
            </div>

            <div class="form-group">
                <label for="endDate">活動終了日</label>
                <input type="date" id="endDate" name="endDate" required>
            </div>

            <div class="form-group">
                <label for="startTime">開始時間</label>
                <input type="time" id="startTime" name="startTime" required>
            </div>

            <div class="form-group">
                <label for="endTime">終了時間</label>
                <input type="time" id="endTime" name="endTime" required>
            </div>

            <div class="form-group">
                <label for="absentTime">公欠希望時間</label>
                <input type="text" id="absentTime" name="absentTime" placeholder="例: 9:00〜12:00">
            </div>

            <div class="form-group">
                <label for="companyName">企業名</label>
                <input type="text" id="companyName" name="companyName" required>
            </div>

            <div class="form-group">
                <label for="location">実施場所</label>
                <input type="text" id="location" name="location" required>
            </div>

            <div class="form-group">
                <label for="reason">事由</label>
                <textarea id="reason" name="reason" required></textarea>
            </div>

            <div class="form-group">
                <label for="selectionContent">選考内容</label>
                <input type="text" id="selectionContent" name="selectionContent" placeholder="例: 一次面接、会社説明会など">
            </div>

            <button type="submit" class="submit-btn">申請する</button>
        </form>
    </div>
</body>
</html>