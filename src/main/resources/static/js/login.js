const loginForm = document.querySelector('form[action="/account/login"]');
const loginSection1 = document.querySelector('.login-current1');
const loginSection2 = document.querySelector('.login-current2');

loginForm.addEventListener('submit', (event) => {
  event.preventDefault(); // prevent the form from submitting normally

  // make an AJAX request to the server to try to log in
  const formData = new FormData(loginForm);
  fetch(loginForm.action, {
    method: 'POST',
    body: formData
  })
  .then((response) => {
    if (response.ok) {
      // login was successful, show the success message and hide the login form
      loginSection1.style.display = 'none';
      loginSection2.style.display = 'block';
    } else {
      // login was not successful, show the error message
      loginSection1.querySelector('.account-errors li').textContent = '로그인 실패';
    }
  })
  .catch((error) => {
    // there was an error with the request, show the error message
    loginSection1.querySelector('.account-errors li').textContent = '로그인 요청 실패';
  });
});