// top.js の内容

document.addEventListener('DOMContentLoaded', () => {
    const teacherMenu = document.getElementById('teacher-menu');
    const studentMenu = document.getElementById('student-menu');
    const userNameElement = document.getElementById('user-name');
    
    // ★★★ 権限（ロール）判定の模擬実装 ★★★
    
    const urlParams = new URLSearchParams(window.location.search);
    let userRole = urlParams.get('role') || 'student'; // デフォルトは生徒
    let userName = urlParams.get('name') || (userRole === 'teacher' ? '田中太郎 先生' : '佐藤花子');
    
    userNameElement.textContent = userName;

    // ロールに基づいて表示するメニューを振り分ける
    if (userRole === 'teacher') {
        teacherMenu.classList.remove('hidden');
        studentMenu.classList.add('hidden');
        console.log(`ログインユーザー: ${userName} (教師)`);
    } else if (userRole === 'student') {
        studentMenu.classList.remove('hidden');
        teacherMenu.classList.add('hidden');
        console.log(`ログインユーザー: ${userName} (生徒)`);
    } else {
        alert('ログインが必要です。');
    }

    // 設定ボタンのアクション (例)
    document.querySelector('.settings-button').addEventListener('click', () => {
        alert('設定画面に遷移します。');
    });
});