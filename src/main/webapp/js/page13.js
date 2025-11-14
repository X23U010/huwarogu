// script.js の内容

// パスワード入力フィールドとトグルボタン（目のマーク）を取得
const passwordInput = document.getElementById('lesson-password');
const toggleButton = document.querySelector('.password-toggle');

// トグルボタンがクリックされた時の処理
toggleButton.addEventListener('click', function() {
    // 現在の input の type を確認
    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
    
    // typeを切り替える
    passwordInput.setAttribute('type', type);
    
});