document.addEventListener('DOMContentLoaded', () => {
    
    // ==========================================
    // 1. パスワード設定画面用のロジック
    // ==========================================
    const passwordInput = document.getElementById('password');
    const confirmInput = document.getElementById('confirm-password');
    const updateButton = document.getElementById('updateButton');
    const randomButton = document.getElementById('random-button');
    const errorArea = document.getElementById('error-message-area');
    const settingForm = document.getElementById('settingForm'); 
    
    // パスワード入力欄がある画面（パスワード設定画面）のみ実行
    if (passwordInput && confirmInput) {
        const strengthBar = document.getElementById('strength-bar');
        const strengthText = document.getElementById('strength-text');

        const displayError = (message, inputsToHighlight = []) => {
            if (!errorArea) return;
            errorArea.textContent = message;
            errorArea.style.display = message ? 'block' : 'none';

            [passwordInput, confirmInput].forEach(input => input.classList.remove('input-error'));
            inputsToHighlight.forEach(input => input.classList.add('input-error'));

            if (updateButton) updateButton.disabled = !!message; 
        };
        
        const checkPasswordStrength = (password) => {
            let strength = 0;
            if (password.length === 0) {
                strengthBar.style.width = '0%';
                strengthText.textContent = 'なし';
                return 0;
            }
            // ... (強度のロジックは以前の通り) ...
            if (password.length >= 8) strength += 1;
            if (password.length >= 10) strength += 1;
            if (password.length >= 12) strength += 1;

            const charTypeCount = [/[a-z]/, /[A-Z]/, /[0-9]/, /[^A-Za-z0-9]/].filter(re => re.test(password)).length;
            if (charTypeCount >= 4) strength += 3;
            else if (charTypeCount >= 3) strength += 2;
            else if (charTypeCount >= 2) strength += 1;

            if (strength <= 2) { 
                strengthBar.className = 'strength-bar low';
                strengthText.textContent = '低';
            } else if (strength <= 4) {
                strengthBar.className = 'strength-bar medium';
                strengthText.textContent = '中';
            } else {
                strengthBar.className = 'strength-bar high';
                strengthText.textContent = '高';
            }
            strengthBar.style.width = (strength * 14) + '%'; 
            return strength;
        };
        
        const checkInputs = () => {
            const passwordValue = passwordInput.value;
            const confirmValue = confirmInput.value;
            
            if (passwordValue.length > 0) {
                if (confirmValue.length === 0) {
                     displayError('パスワードを変更する場合は、確認のため再入力してください。', [confirmInput]);
                     return;
                }
                if (passwordValue !== confirmValue) {
                    displayError('パスワードが一致しません。', [passwordInput, confirmInput]);
                    return;
                }
                const strength = checkPasswordStrength(passwordValue);
                if (strength < 3) { 
                    displayError('パスワードの厳重度が低すぎます。', [passwordInput]);
                    return;
                }
            }
            displayError('');
        };

        passwordInput.addEventListener('input', checkInputs);
        confirmInput.addEventListener('input', checkInputs);
        if (randomButton) {
            randomButton.addEventListener('click', () => {
                const chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
                let pass = "";
                for (let i = 0; i < 12; i++) pass += chars.charAt(Math.floor(Math.random() * chars.length));
                passwordInput.value = pass;
                confirmInput.value = pass;
                checkInputs();
            });
        }
    }

    // ==========================================
    // 2. 担任/副担任設定画面用のロジック
    // ==========================================
    const mainTeacher = document.getElementById('mainTeacher');
    const subTeacher = document.getElementById('subTeacher');

    // 先生選択欄がある画面のみ実行
    if (mainTeacher && subTeacher) {
        function updateTeacherOptions() {
            const selectedMain = mainTeacher.value;
            const selectedSub = subTeacher.value;

            // 副担任のリストから担任で選んだ人を隠す
            Array.from(subTeacher.options).forEach(option => {
                if (option.value !== "" && option.value === selectedMain) {
                    option.style.display = 'none';
                    option.disabled = true;
                } else {
                    option.style.display = 'block';
                    option.disabled = false;
                }
            });

            // 担任のリストから副担任で選んだ人を隠す
            Array.from(mainTeacher.options).forEach(option => {
                if (option.value !== "" && option.value === selectedSub) {
                    option.style.display = 'none';
                    option.disabled = true;
                } else {
                    option.style.display = 'block';
                    option.disabled = false;
                }
            });
        }

        mainTeacher.addEventListener('change', updateTeacherOptions);
        subTeacher.addEventListener('change', updateTeacherOptions);
        updateTeacherOptions(); // 初期読み込み時
    }

    // 表示切り替えアイコン（全画面共通）
    document.querySelectorAll('.toggle-password').forEach(toggle => {
        toggle.addEventListener('click', () => {
            const target = document.getElementById(toggle.getAttribute('data-target'));
            const icon = toggle.querySelector('i');
            if (target.type === 'password') {
                target.type = 'text';
                icon.className = 'fas fa-eye';
            } else {
                target.type = 'password';
                icon.className = 'fas fa-eye-slash';
            }
        });
    });
});