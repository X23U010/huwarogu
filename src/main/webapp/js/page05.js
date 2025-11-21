document.addEventListener('DOMContentLoaded', () => {
    const teacherMenu = document.getElementById('teacher-menu');
    const studentMenu = document.getElementById('student-menu');

    // JSPから渡される元の値を出力
    console.log("USER_ROLE (Raw) =", USER_ROLE);

    // ★★★ 修正箇所: .trim() を使って、前後の空白や改行を確実に除去する
    const role = (USER_ROLE || "").trim(); 

    // トリミング後の値と長さを出力（デバッグ用）
    console.log("USER_ROLE (Trimmed) =", role, " (Length:", role.length, ")");

    if (role === "teacher") {
        teacherMenu.classList.remove("hidden");
        studentMenu.classList.add("hidden");
    } 
    else if (role === "student") {
        studentMenu.classList.remove("hidden");
        teacherMenu.classList.add("hidden");
    } 
    else {
        console.log("ロール不明：比較失敗。");
    }
});