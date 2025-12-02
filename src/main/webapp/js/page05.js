document.addEventListener('DOMContentLoaded', () => {

    // 役割によるメニュー表示制御
    const teacherMenu = document.getElementById('teacher-menu');
    const studentMenu = document.getElementById('student-menu');

    const role = (USER_ROLE || "").trim();

    if (role === "teacher") {
        teacherMenu.classList.remove("hidden");
        studentMenu.classList.add("hidden");
    } else if (role === "student") {
        studentMenu.classList.remove("hidden");
        teacherMenu.classList.add("hidden");
    }

    /* -----------------------------
       ▼ 設定ボタンのプルダウン制御
    ----------------------------- */

    const settingsBtn = document.getElementById("settings-btn");
    const dropdownMenu = document.getElementById("settings-menu");

    // 設定ボタンをクリックしたらプルダウン表示切替
    settingsBtn.addEventListener("click", (e) => {
        e.stopPropagation(); // 他イベントへ連鎖防止
        dropdownMenu.classList.toggle("hidden");
    });

    // メニュー内クリックを閉じないように
    dropdownMenu.addEventListener("click", (e) => {
        e.stopPropagation();
    });

    // 画面のどこかクリックでメニュー閉じる
    document.addEventListener("click", () => {
        dropdownMenu.classList.add("hidden");
    });
});
