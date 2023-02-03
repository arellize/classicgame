
// ID 중복검증여부 (비동기)
document.getElementById("id").addEventListener("blur", function () {
    let getId = document.getElementById("id")

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        document.getElementById("notEqualId").innerHTML = this.responseText;
    }
    xhttp.open("POST", "controller", true);
    xhttp.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded;charset=UTF-8");
    xhttp.send("command=checkId&id=" + getId.value);
});

let userId = document.querySelector('#id');
function userIdCheck() {
    login_flag = true; // 중복되지 않았다 = 기본값 / false = 중복됨
    if (login_flag) {
        alert('사용할 수 있는 아이디입니다.');
    } else {
        alert('이미 존재하는 아이디 입니다.');
    }
}