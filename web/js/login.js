function checkLogionFrom() {
  var username = document.login_from.username.value;
  var password = document.login_from.password.value;
  if (username == "" || password == "") {
    alert("信息不完整");
    document.login_from.username.focus();
    return false;
  }
  document.login_from.submit();
  return true;
}
