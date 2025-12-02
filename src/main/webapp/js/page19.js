document.addEventListener('DOMContentLoaded', () => {
    const passwordInput = document.getElementById('password');
    const confirmInput = document.getElementById('confirm-password');
    const submitButton = document.getElementById('submit-button');
    const randomButton = document.getElementById('random-button');
    const errorArea = document.getElementById('error-message-area');
    
    // 厳重度メーター要素
    const strengthBar = document.getElementById('strength-bar');
    const strengthText = document.getElementById('strength-text');
    
    // --- 厳重度チェックロジック ---
    const checkPasswordStrength = (password) => {
        let strength = 0;
        
        // パスワードが空の場合
        if (password.length === 0) {
            strengthBar.style.width = '0%';
            strengthText.textContent = 'なし';
            strengthBar.className = 'strength-bar';
            strengthText.className = 'strength-text';
            return 0;
        }

        // 1. 長さのチェック (最大2点)
        if (password.length >= 6) strength += 1;
        if (password.length >= 8) strength += 1;

        // 2. 文字種類のチェック (最大2点)
        const hasLowercase = /[a-z]/.test(password);
        const hasUppercase = /[A-Z]/.test(password);
        const hasNumber = /[0-9]/.test(password);
        const hasSpecialChar = /[^A-Za-z0-9]/.test(password);

        let charTypeCount = 0;
        if (hasLowercase) charTypeCount++;
        if (hasUppercase) charTypeCount++;
        if (hasNumber) charTypeCount++;
        if (hasSpecialChar) charTypeCount++;

        if (charTypeCount >= 3) strength += 2;
        else if (charTypeCount >= 2) strength += 1;

        // 💡 修正点: 単純なパスワードを減点するロジックの追加 (最低-3点)
        
        // a) 3文字以上の連続した文字（例: aaa, 111, abc, 987）をチェックし、減点
        const consecutiveChars = /(.)\1\1|012|123|234|345|456|567|678|789|987|876|765|654|543|432|321|210|abc|bcd|cde|def|efg|fgh|ghi|hij|ijk|jkl|klm|lmn|mno|nop|opq|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz/.test(password.toLowerCase());
        
        if (consecutiveChars) {
            strength -= 2; // 大きく減点
        }
        
        // b) 文字の繰り返しパターン（例: ababab, 121212）をチェックし、減点
        const repeatedPattern = /(.+)\1{2,}/.test(password);
        
        if (repeatedPattern) {
             strength -= 1; 
        }

        // 最小値は0に制限
        if (strength < 0) {
            strength = 0;
        }
        
        // 3. 厳重度判定 (0-5点)
        let level = '';
        let width = 0;

        if (strength <= 1) { 
            level = 'low';
            width = 33;
            strengthText.textContent = '低';
        } else if (strength <= 3) {
            level = 'medium';
            width = 66;
            strengthText.textContent = '中';
        } else {
            level = 'high';
            width = 100;
            strengthText.textContent = '高';
        }

        // メーター表示を更新
        strengthBar.style.width = width + '%';
        strengthBar.className = 'strength-bar ' + level;
        strengthText.className = 'strength-text ' + level;
        
        return strength;
    };
    
    // --- 入力/検証ロジック ---
    const checkInputs = () => {
        errorArea.textContent = '';
        const passwordValue = passwordInput.value.trim();
        const confirmValue = confirmInput.value.trim();

        const passwordMatch = passwordValue === confirmValue;
        const isNotEmpty = passwordValue.length > 0 && confirmValue.length > 0;
        
        // 決定ボタンの有効/無効
        submitButton.disabled = !(isNotEmpty && passwordMatch);
        submitButton.style.opacity = submitButton.disabled ? '0.6' : '1';

        // エラーメッセージ表示
        if (isNotEmpty && !passwordMatch) {
            errorArea.textContent = 'パスワードが一致しません。';
            passwordInput.classList.add('input-error');
            confirmInput.classList.add('input-error');
        } else {
            passwordInput.classList.remove('input-error');
            confirmInput.classList.remove('input-error');
        }
    };

    // --- ランダムパスワード生成ロジック ---
    const generateRandomPassword = () => {
        const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()';
        let password = '';
        for (let i = 0; i < 10; i++) {
            password += chars.charAt(Math.floor(Math.random() * chars.length));
        }
        passwordInput.value = password;
        confirmInput.value = password; 
        checkInputs();
        checkPasswordStrength(password); 
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
    passwordInput.addEventListener('input', () => {
        checkInputs();
        checkPasswordStrength(passwordInput.value);
    });
    
    confirmInput.addEventListener('input', checkInputs);
    randomButton.addEventListener('click', generateRandomPassword);
    
    // 初期チェック
    checkInputs();
    checkPasswordStrength(passwordInput.value);

});