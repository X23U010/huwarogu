// confirm.js の内容
/* 全体を覆う背景画像 */

document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById('confirmation-modal');
    const classNameDisplay = document.getElementById('class-name-display');
    const cancelButton = document.getElementById('cancel-button');
    const confirmButton = document.getElementById('confirm-attendance-button');

    // ★★★ 仮のデータ（FC013から渡されることを想定）
    const studentId = 'A123456'; 
    const className = '情報科学基礎'; // IDに対応した授業名
    // ★★★ 

    // 授業名を表示に反映させる関数
    function showConfirmationModal(className) {
        classNameDisplay.innerHTML = `**${className}**の授業に出席しますか？`;
        modal.classList.add('is-active'); // モーダルを表示
    }

    // モーダルを閉じる（FC013へ戻る）
    function hideModal() {
        modal.classList.remove('is-active');
    }

    // 授業名を表示に設定し、モーダルを開く (実際にはFC013の登録ボタン押下時に実行)
    // テストのため、ロード時に実行
    showConfirmationModal(className); 

    // --- イベントリスナー ---

    // キャンセルボタン（FC013へ戻る）
    cancelButton.addEventListener('click', () => {
        hideModal(); 
        // 💡 画面説明通り、FC013への遷移（この場合はモーダルを閉じる）
        console.log('出席登録をキャンセルしました。');
    });

    // 出席ボタン（名簿にチェックし、トップに戻る）
    confirmButton.addEventListener('click', () => {
        // 1. サーバー側での出席登録処理（名簿にチェックが入る処理）をシミュレーション
        console.log(`ID: ${studentId} の ${className} 授業の出席を登録しました。`);
        
        // 2. 登録成功メッセージを表示
        alert(`${className}の出席を登録しました。`);
        
        // 3. トップ画面へ遷移（FC001などを想定）
        // window.location.href = 'top.html'; // 実際の遷移先URLに置き換えてください
        
        // 簡易的にモーダルを閉じる
        hideModal();
    });
});