// page16.js の内容

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('absence-form');
    const dateInput = document.getElementById('absence-date');
    const reasonInput = document.getElementById('absence-reason');
    const errorArea = document.getElementById('error-message-area');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // フォームのデフォルト送信を防ぐ

        // エラーをリセット
        errorArea.textContent = '';
        dateInput.classList.remove('input-error');
        reasonInput.classList.remove('input-error');

        // 必須チェック

        // 日付と理由のチェック (両方必須)
        if (!dateInput.value || !reasonInput.value.trim()) {
            hasError = true;
            errorArea.textContent = '日付または理由が入力されていません';
            
            // エラー箇所を視覚的に強調 (FC016_Errorのデザイン)
            if (!dateInput.value) {
                dateInput.classList.add('input-error');
            }
            if (!reasonInput.value.trim()) {
                reasonInput.classList.add('input-error');
            }
        }

      
    });
});