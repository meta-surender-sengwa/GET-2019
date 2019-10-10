var employeeName, employeeGender, employeeEmail, employeePassword, employeeMatchPassword, employeeNumber;

var currentField;
var currentForm;

/* onclick of Register Here shows name input */
function registerationForm() {
    
    document.getElementById("navigation").style.display="none";
    document.getElementById("cover-img").style.display = "none";

    document.body.style.backgroundColor = "#7FDBFF";

    document.getElementById("label").style.display = "block";
    document.getElementById("employee-name").style.display = "block";

    document.getElementById("emp-name").focus();

    currentField = "name";
    currentForm = 1;
}

function validatePassword() {

    var employeePassword = document.getElementById("emp-pass").value;
    
    var strongPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");

    if (employeePassword.length < 8) {
        document.getElementById("emp-pass").style.borderColor = "red";
        document.getElementById("error").innerHTML = "password should be atleast 8 characters long";
        return false;

    } else if (!(strongPassword.test(employeePassword))) {
        document.getElementById("emp-pass").style.borderColor = "yellow";
        document.getElementById("error").innerHTML = "password should contain atleast one uppercase, one lowercase and one numeric character";
        return false;

    } else {
        document.getElementById("emp-pass").style.borderColor = "green";
        document.getElementById("error").innerHTML = " ";
    }
}

/* event listener for enter key */
window.addEventListener('keypress', function (e) {
    if (e.keyCode == 13) {
        onBlur();
    }
}, false);


function onBlur() {

    if (currentForm == 2) {
        onBlurForm2();
        return false;
    }

    var label = document.getElementById("label-text");

    switch (currentField) {

        case "name":
            var employeeName = document.getElementById("emp-name").value;

            if (!(/^[A-z ]{2,}$/.test(employeeName))) {
                document.getElementById("error").innerHTML = "please enter a valid name";
                return false;

            } else {
                document.getElementById("error").innerHTML = " ";
            }

            label.innerHTML = "Hello " + employeeName + " !! may I know your gender ?";

            document.getElementById("employee-name").style.display = "none";
            document.getElementById("employee-gender").style.display = "block";
            currentField = "gender";

            break;

        case "gender":

            var employeeGender = document.getElementsByName("emp-gender");

            if (!employeeGender[0].checked && !employeeGender[1].checked) {
                document.getElementById("error").innerHTML = "Please select gender";
                return false;

            } else {
                document.getElementById("error").innerHTML = " ";
            }

            label.innerHTML = " please enter your email Id";

            document.getElementById("employee-gender").style.display = "none";
            document.getElementById("employee-email").style.display = "block";
            
            document.getElementById("emp-email").focus();
            currentField = "email";
            break;

        case "email":
            var employeeEmail = document.getElementById("emp-email").value;

            if (!(/^[A-z]+@[A-z]+\.[A-z]+$/.test(employeeEmail))) {
                document.getElementById("error").innerHTML = "please enter valid email address";
                return false;

            } else {
                document.getElementById("error").innerHTML = " ";
            }

            label.innerHTML = "Please enter your password";

            document.getElementById("employee-email").style.display = "none";
            document.getElementById("employee-password").style.display = "block";
            document.getElementById("emp-pass").focus();

            currentField = "password";

            break;

        case "password":

                var employeePassword = document.getElementById("emp-pass").value;	
            
                label.innerHTML = "Lets confirm your password";
    
                document.getElementById("employee-password").style.display = "none";
                document.getElementById("confirm-password").style.display = "block";
                document.getElementById("confirm-pass").focus();
                currentField = "confirm";
    
                break;

        case "confirm":
            var employeePassword = document.getElementById("emp-pass").value;
            var employeeMatchPassword = document.getElementById("confirm-pass").value;

            if (employeePassword != employeeMatchPassword) {
                document.getElementById("error").innerHTML = "password doesn't match";
                return false;

            } else {
                document.getElementById("error").innerHTML = " ";
            }

            label.innerHTML = "Please enter your contact number  ...";

            document.getElementById("confirm-password").style.display = "none";
            document.getElementById("employee-contact").style.display = "block";

            document.getElementById("emp-contact").focus();
            document.getElementById("next1").style.display = "block";
            currentField = "contact";

            break;
    }
}

