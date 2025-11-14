// complete.js の内容

document.addEventListener('DOMContentLoaded', () => {
    const fortuneMessageElement = document.getElementById('fortune-message');
    const luckyItemElement = document.getElementById('lucky-item');

    // ★★★ データベースに登録されている占い結果のダミーデータ ★★★
    // 実際には、サーバーサイドの処理からこのデータを受け取ります
    const fortuneData = [
        { fortune: "寝なかったらいいことがあるかも", item: "緑の蛍光ペン" },
        { fortune: "今日は集中力が高まる日！", item: "お気に入りのコーヒーカップ" },
        { fortune: "友人の助けで難問クリア！", item: "新しい消しゴム" },
        { fortune: "課題提出が早まると吉。", item: "青いボールペン" },
        { fortune: "努力が報われる運勢！", item: "四つ葉のクローバー" },
    ];
    // ★★★

    // 占い結果をランダムに選ぶ関数 (サーバーからの応答をシミュレーション)
    function getFortuneResult() {
        const randomIndex = Math.floor(Math.random() * fortuneData.length);
        return fortuneData[randomIndex];
    }

    // 結果を取得し、画面に表示する
    const result = getFortuneResult();
    fortuneMessageElement.textContent = result.fortune;
    luckyItemElement.textContent = result.item;

});