const registerButton = document.querySelector(".register-button");
const registerInputs = document.querySelectorAll(".register-input");

for(let i = 0; i < registerInputs.length; i++) {
    registerInputs[i].onkeyup = () => {
        if(window.Event.keycode == 13) {
            if(i != 3) {
                registerInputs[i + 1].focus();
            }else {
                registerButton.click();
            }
        }
    }
}

registerButton.onclick = () => {

    let registerInfo = {
        lastName: registerInputs[0].value,
        firstName: registerInputs[1].value,
        userId: registerInputs[2].value,
        password: registerInputs[3].value,
        email: registerInputs[4].value,
        phoneNum: registerInputs[5].value
    }

    $.ajax({
        async: false,
        type: "post",
        url: "/api/account/register",
        contentType: "application/json",
        data: JSON.stringify(registerInfo),
        dataType: "json",
        success: (response) => {
            console.log(response);
            location.replace("/account/login");
        },
        error: (error) => {
            console.log(error);
            validationError(error.responseJSON.data);
        }
    })
}

function validationError(error) {
    const accountErrors = document.querySelector(".account-errors");
    const accountErrorList = document.querySelector(".errors-list");
    
    const errorValues = Object.values(error);

    accountErrorList.innerHTML = "";

    errorValues.forEach((value) => {
        accountErrorList.innerHTML += `
            <li>${value}</li>
        `;
    });

    accountErrors.classList.remove("errors-invisible");
}