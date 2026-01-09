document.addEventListener('DOMContentLoaded', () => {
    
    // 💡 HTML要素の取得
    const passwordInput = document.getElementById('password');
    const confirmInput = document.getElementById('confirm-password');
    const updateButton = document.getElementById('updateButton');
    const randomButton = document.getElementById('random-button');
    const errorArea = document.getElementById('error-message-area');
    const settingForm = document.getElementById('settingForm'); 
    
    // 厳重度メーター要素
    const strengthBar = document.getElementById('strength-bar');
    const strengthText = document.getElementById('strength-text');

    /**
     * エラーメッセージ表示を制御するヘルパー関数
     * @param {string} message - 表示するエラーメッセージ。空文字の場合は非表示。
     * @param {HTMLElement[]} inputsToHighlight - エラー表示を赤くする入力フィールドの配列
     */
    const displayError = (message, inputsToHighlight = []) => {
        errorArea.textContent = message;
        errorArea.style.display = message ? 'block' : 'none'; // メッセージがあるときだけ表示

        // エラークラスのクリアと適用
        [passwordInput, confirmInput].forEach(input => {
            input.classList.remove('input-error');
        });
        inputsToHighlight.forEach(input => {
            input.classList.add('input-error');
        });

        // ボタンの制御 (ボタンの見た目を無効化する処理は維持)
        updateButton.disabled = !!message; 
    };
    
    // --- 厳重度チェックロジック (調整) ---
    const checkPasswordStrength = (password) => {
        let strength = 0;
        
        if (password.length === 0) {
            strengthBar.style.width = '0%';
            strengthText.textContent = 'なし';
            strengthBar.className = 'strength-bar';
            strengthText.className = 'strength-text';
            return 0; // 強度0を返す
        }

        // 1. 長さのチェック (最大3点)
        if (password.length >= 8) strength += 1;
        if (password.length >= 10) strength += 1;
        if (password.length >= 12) strength += 1;

        // 2. 文字種類のチェック (最大4点)
        const hasLowercase = /[a-z]/.test(password);
        const hasUppercase = /[A-Z]/.test(password);
        const hasNumber = /[0-9]/.test(password);
        const hasSpecialChar = /[^A-Za-z0-9]/.test(password);

        let charTypeCount = 0;
        if (hasLowercase) charTypeCount++;
        if (hasUppercase) charTypeCount++;
        if (hasNumber) charTypeCount++;
        if (hasSpecialChar) charTypeCount++;

        if (charTypeCount >= 4) strength += 3;
        else if (charTypeCount >= 3) strength += 2;
        else if (charTypeCount >= 2) strength += 1;


        // 3. 減点ロジック (シーケンス、繰り返し)
        const consecutiveChars = /(.)\1\1|012|123|abc|bcd/.test(password.toLowerCase());
        const repeatedPattern = /(.+)\1{2,}/.test(password); // 例: aaa, ababab
        
        if (consecutiveChars) { strength -= 2; }
        if (repeatedPattern) { strength -= 1; }
        if (strength < 0) { strength = 0; }
        
        // 4. 厳重度判定 (最大7点)
        let level = '';
        let width = 0;

        // 判定基準を調整 (0:なし, 1-2:低, 3-4:中, 5-7:高)
        if (strength <= 2) { 
            level = 'low';
            width = (strength / 2) * 33; // 0-33%
            strengthText.textContent = '低';
        } else if (strength <= 4) {
            level = 'medium';
            width = 33 + ((strength - 2) / 2) * 33; // 33-66%
            strengthText.textContent = '中';
        } else {
            level = 'high';
            width = 66 + ((strength - 4) / 3) * 34; // 66-100%
            if (strength >= 7) {
                 level = 'perfect'; // 最高の強度は別の色
                 strengthText.textContent = '最高';
            } else {
                 strengthText.textContent = '高';
            }
        }
        
        strengthBar.style.width = width + '%';
        strengthBar.className = 'strength-bar ' + level;
        strengthText.className = 'strength-text ' + level;
        
        return strength;
    };
    
    // --- 入力/検証ロジック (主要ロジック) ---
    const checkInputs = () => {
        const passwordValue = passwordInput.value;
        const confirmValue = confirmInput.value;
        
        // 1. パスワードの入力チェック
        if (passwordValue.length > 0) {
            // A. パスワードが入力されているが、再入力がない場合
            if (confirmValue.length === 0) {
                 displayError('パスワードを変更する場合は、確認のため再入力してください。', [confirmInput]);
                 return;
            }
            
            // B. パスワードが一致しない場合
            if (passwordValue !== confirmValue) {
                displayError('パスワードが一致しません。', [passwordInput, confirmInput]);
                return;
            }
            
            // C. パスワードの厳重度が低すぎる場合 (最低強度チェック)
            const strength = checkPasswordStrength(passwordValue);
            // 変更する場合、最低でも「中」レベル（強度3以上）を要求
            if (strength < 3) { 
                displayError('パスワードの厳重度が低すぎます。「中」レベル以上になるよう修正してください。', [passwordInput]);
                return;
            }
        }
        
        // 2. パスワードが空の場合 (変更しない場合)
        if (passwordValue.length === 0 && confirmValue.length > 0) {
            // パスワードが空だが、再入力がある場合はエラー
            displayError('パスワードを変更しない場合は、両方の入力欄を空にしてください。', [confirmInput]);
            return;
        }

        // 全てのエラー条件を通過した場合
        checkPasswordStrength(passwordValue); // 強度を最終確定
        displayError(''); // エラー表示をクリア
        // ボタンの disabled は displayError で解除される
    };

    // --- ランダムパスワード生成ロジック (強化) ---
    const generateRandomPassword = () => {
        const lower = 'abcdefghijklmnopqrstuvwxyz';
        const upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
        const numbers = '0123456789';
        const special = '!@#$%^&*()_+-=[]{}|;:,.<>?';
        const allChars = lower + upper + numbers + special;

        let password = '';
        
        password += lower.charAt(Math.floor(Math.random() * lower.length));
        password += upper.charAt(Math.floor(Math.random() * upper.length));
        password += numbers.charAt(Math.floor(Math.random() * numbers.length));
        password += special.charAt(Math.floor(Math.random() * special.length));

        for (let i = 4; i < 12; i++) { 
            password += allChars.charAt(Math.floor(Math.random() * allChars.length));
        }

        password = password.split('').sort(() => 0.5 - Math.random()).join('');
        
        passwordInput.value = password;
        confirmInput.value = password; 
        checkInputs();
    };

    // --- 表示/非表示アイコンのロジック ---
    document.querySelectorAll('.toggle-password').forEach(toggle => {
        toggle.addEventListener('click', () => {
            const targetId = toggle.getAttribute('data-target');
            const targetInput = document.getElementById(targetId);
            const icon = toggle.querySelector('i');

            if (targetInput.type === 'password') {
                targetInput.type = 'text';
                icon.classList.remove('fa-eye-slash');
                icon.classList.add('fa-eye');
            } else {
                targetInput.type = 'password';
                icon.classList.remove('fa-eye');
                icon.classList.add('fa-eye-slash');
            }
        });
    });

    // --- イベントリスナー設定 ---
    passwordInput.addEventListener('input', checkInputs);
    confirmInput.addEventListener('input', checkInputs);
    
    randomButton.addEventListener('click', generateRandomPassword);
    
    // フォーム送信時の追加チェック (★ event.preventDefault() を削除)
    settingForm.addEventListener('submit', (event) => {
        // 最終チェックのみ実行
        checkInputs(); 
        
        // クライアント側でエラーが出ていても、送信自体は許可される
        if (updateButton.disabled) {
            // サーバー側でエラー処理が行われるべきですが、ユーザーには通知する
             if (!errorArea.textContent) {
                displayError('入力内容を確認してください。');
            }
        }
        // event.preventDefault() は実行しないため、フォームは送信される
    });

    // 初期チェック
    checkInputs();
});