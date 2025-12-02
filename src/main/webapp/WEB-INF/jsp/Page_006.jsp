<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>お知らせ</title>
  <link rel="stylesheet" href="css/page6.css">
</head>
<body>
  <div class="notice-container">
    <h1 class="notice-title">お知らせ</h1>
    <ul class="notice-list">
      <li>
        <span class="star" onclick="toggleStar(this)">☆</span>
        <input type="checkbox" id="notice1">
        <label for="notice1" class="notice-label">
          お・し・ら・せ
          <span class="date">mm/dd</span>
        </label>
      </li>
      <li>
        <span class="star" onclick="toggleStar(this)">☆</span>
        <input type="checkbox" id="notice2">
        <label for="notice2" class="notice-label">
          お・し・ら・せ
          <span class="date">mm/dd</span>
        </label>
      </li>
      <li>
        <span class="star" onclick="toggleStar(this)">☆</span>
        <input type="checkbox" id="notice3">
        <label for="notice3" class="notice-label">
          お・し・ら・せ
          <span class="date">mm/dd</span>
        </label>
      </li>
      <li>
        <span class="star" onclick="toggleStar(this)">☆</span>
        <input type="checkbox" id="notice4">
        <label for="notice4" class="notice-label">
          お・し・ら・せ
          <span class="date">mm/dd</span>
        </label>
      </li>
    </ul>
<form action="Lesson_Attendance_Servlet" method="post">
                <button id="back-to-top-button" class="back-to-top-button" name="action" value="back_top">
                    TOPへ戻る
                </button>
                </form>
  </div>

  <script>
    // 星マークのトグル
    function toggleStar(el) {
      el.textContent = el.textContent === '☆' ? '★' : '☆';
      el.classList.toggle('active');
    }
  </script>
</body>
</html>
