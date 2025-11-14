// absence_confirm.js の内容

document.addEventListener('DOMContentLoaded', () => {
    const displayDate = document.getElementById('display-date');
    const displayReason = document.getElementById('display-reason');
    const cancelButton = document.getElementById('cancel-send-button');
    const sendButton = document.getElementById('send-absence-button');
    const modal = document.getElementById('absence-confirm-modal');

    // FC016から渡されたデータ（クエリパラメータなどを想定）を取得
    const urlParams = new URLSearchParams(window.location.search);
    const date = urlParams.get('date') || '2025/9/25'; 
    const reason = urlParams.get('reason') || '39.6度の熱があるため'; 

    // 取得したデータを画面に反映
    displayDate.textContent = date;
    displayReason.textContent = reason;
    
    // --- イベントリスナー ---

    // キャンセルボタン (FC016 欠席届入力画面へ戻る)
    cancelButton.addEventListener('click', () => {
        // window.location.href = 'page16.html'; // 💡 入力画面に戻る
        alert('送信をキャンセルし、入力画面に戻ります。');
    });

    // 送信ボタン (欠席届を送信し、完了画面へ)
    sendButton.addEventListener('click', () => {
        // 1. サーバー側で欠席届の送信処理（担当教師への通知）を実行
        
        // 2. 完了画面（FC015など）へ遷移
        // window.location.href = 'complete.html'; // 💡 完了画面のURL
        
        alert('欠席届を送信しました。完了画面へ遷移します。');
    });
});