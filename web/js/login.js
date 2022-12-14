function checkLogionFrom() {
  var username = document.login_from.username.value;
  var password = document.login_from.password.value;
  if (username == "" || password == "") {
    alert("信息不完整");
    document.login_from.username.focus();
    return false;
  } else if (username == "123" && password == "123") {
    return true;
  }
  alert("用户名密码不匹配");
  //document.login_from.submit();
  return false;
}
