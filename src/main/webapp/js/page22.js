document.addEventListener('DOMContentLoaded', () => {
    // 💡 データベースやAPIから取得される「仮のデータ」を定義します
    const applicationData = [
        { id: 'app1', userId: 'X23u000', name: '船橋太郎', type: '公欠申請', detail: '部活動の遠征のため' },
        { id: 'app2', userId: 'X23u000', name: '船橋太郎', type: '報告書', detail: '海外研修の最終報告' },
        { id: 'app3', userId: 'X23u000', name: '船橋太郎', type: '欠席届提出', detail: '39.6度の熱があるため' },
        { id: 'app4', userId: 'Y23z123', name: '横浜花子', type: '公欠申請', detail: '家族の冠婚葬祭' },
        { id: 'app5', userId: 'A24p456', name: '青山一郎', type: '公欠申請', detail: '病院での定期検診' },
        { id: 'app6', userId: 'Y23z123', name: '横浜花子', type: '報告書', detail: '校外学習のレポート' },
    ];
    // -------------------------------------------------------------

    const selectButton = document.getElementById('select-button');
    const acceptButton = document.getElementById('accept-button');
    const rejectButton = document.getElementById('reject-button');
    const container = document.getElementById('application-items-container');
    const applicationForm = document.getElementById('application-form');
    
    let isSelectionMode = false;

    // --- 1. リストの動的生成 ---
    const renderApplicationList = (data) => {
        container.innerHTML = ''; 
        data.forEach(app => {
            const itemDiv = document.createElement('div');
            itemDiv.classList.add('app-item');
            itemDiv.setAttribute('data-id', app.id);
            
            // 💡 クリック時の詳細表示ロジック
            itemDiv.addEventListener('click', (event) => {
                // チェックボックスのクリック以外でのクリック時、詳細表示のロジックを実装
                if (!event.target.classList.contains('app-checkbox')) {
                     alert(`【詳細】\nID: ${app.userId}\n氏名: ${app.name}\n種別: ${app.type}\n内容: ${app.detail}`);
                }
            });
            
            // HTML要素を構築 (UI改善に合わせて変更)
            itemDiv.innerHTML = `
                <input type="checkbox" class="app-checkbox" id="${app.id}" disabled>
                <label for="${app.id}">
                    <div class="user-info">
                        <span class="app-user-id">${app.userId}</span> 
                        <span class="app-name">${app.name}</span> 
                    </div>
                    <span class="app-type">${app.type}</span>
                </label>
            `;
            container.appendChild(itemDiv);
        });
    };

    // --- 2. 処理ボタンの有効/無効制御 ---
    const updateProcessButtons = () => {
        const checkboxes = document.querySelectorAll('.app-checkbox');
        const isAnyChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);

        const enableButtons = isSelectionMode && isAnyChecked;
        
        acceptButton.disabled = !enableButtons;
        rejectButton.disabled = !enableButtons;
    };

    // --- 3. 選択モードの切り替え ---
    selectButton.addEventListener('click', () => {
        isSelectionMode = !isSelectionMode;
        
        const checkboxes = document.querySelectorAll('.app-checkbox');
        checkboxes.forEach(checkbox => {
            checkbox.disabled = !isSelectionMode;
            if (!isSelectionMode) {
                checkbox.checked = false;
            }
        });

        selectButton.textContent = isSelectionMode ? '選択を解除' : '選択';
        
        updateProcessButtons();
    });

    // --- 4. イベントリスナー設定 ---
    applicationForm.addEventListener('change', (event) => {
        if (event.target.classList.contains('app-checkbox')) {
            updateProcessButtons();
        }
    });

    // --- 5. 処理アクション (ダミー) ---
    const handleProcess = (action) => {
        const checkedItems = Array.from(document.querySelectorAll('.app-checkbox:checked'))
            .map(cb => {
                const item = applicationData.find(app => app.id === cb.id);
                return `${item.userId} ${item.name} (${item.type})`;
            });
            
        if (checkedItems.length > 0) {
            alert(`以下の申請を「${action}」しました: \n\n${checkedItems.join('\n')}`);
            console.log(`${action}処理を実行しました。`);

            // 処理後、選択モードを解除
            selectButton.click(); 
        }
    }

    acceptButton.addEventListener('click', () => handleProcess('受理'));
    rejectButton.addEventListener('click', () => handleProcess('拒否'));

    // 画面初期化
    renderApplicationList(applicationData);
    updateProcessButtons();
});