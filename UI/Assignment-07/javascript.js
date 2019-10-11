var employeeName, employeeGender, employeeEmail, employeePassword, employeeMatchPassword, employeeNumber;
var currentField;
var currentForm;
var vehicleType;

var idArray = [];

var employeeFormBackgroundColour = "#7FDBFF";
var vehicleFormBackgroundColour = "#FF851B";
var planFormBackgroundColour = "#DDDDDD";

var convertToUSD = 71.74;
var convertToYEN = 0.68;

/* onclick of Register Here shows name input */
function registerationForm() {
    
    document.getElementById("navigation").style.display="none";
    document.getElementById("cover-img").style.display = "none";

    document.body.style.backgroundColor = employeeFormBackgroundColour;

    document.getElementById("label").style.display = "block";
    document.getElementById("employee-name").style.display = "block";

    document.getElementById("button-next").style.display = "block";
    document.getElementById("button-back").style.display = "block";

    document.getElementById("emp-name").focus();

    currentField = "name";
    currentForm = 1;
}

function backToPrevious() {
    document.getElementById(idArr[idArr.length - 1]).style.display = "none";
    idArray.pop()
    document.getElementById(idArr[idArr.length - 1]).style.display = "block";
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

function onBlurForm1() {

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

            label.innerHTML = "please enter your contact number  ...";

            document.getElementById("confirm-password").style.display = "none";
            document.getElementById("employee-contact").style.display = "block";

            document.getElementById("next1").style.display = "block";
            document.getElementById("button-next").style.display = "none";
            
            document.getElementById("emp-contact").focus();
            currentField = "contact";

            break;
    }
}



/*  shows first input of vehcle form */
function vehicleForm() {

    var employeeContact = document.getElementById("emp-contact").value;

    if (!(/^[0-9]{10}$/.test(employeeContact))) {
        document.getElementById("error").innerHTML = "please enter a valid 10 digit numeric contact number";
        return false;
        
    } else {
        document.getElementById("error").innerHTML = " ";
    }

    document.body.style.backgroundColor = vehicleFormBackgroundColour;
    label.innerHTML = "may I know your vehicle's name";

    document.getElementById("employee-contact").style.display = "none";
    document.getElementById("next1").style.display = "none";
    
    document.getElementById("button-back").style.display = "none";
    document.getElementById("vehicle-name").style.display = "block";
    document.getElementById("veh-name").focus();
    document.getElementById("veh-button-next").style.display = "block";
    
    currentField = "vehName";
    currentForm = 2;
}


/* switch case for vehicle  form for switching input fields */
function onBlurForm2() {

    switch (currentField) {

        case "vehName":
            var vehicleName = document.getElementById("veh-name").value;

            if(vehicleName == ""){
                document.getElementById("error").innerHTML="please enter a valid vehicle name";
                return;
            }
            document.getElementById("error").innerHTML=" ";

            label.innerHTML = " whats the type of " + vehicleName;

            document.getElementById("vehicle-name").style.display = "none";
            document.getElementById("vehicle-type").style.display = "block";
            document.getElementById("veh-button-back").style.display = "block";
            
            currentField = "vehType";
            break;

        case "vehType":
            vehicleType = document.getElementById("veh-type").value;
            
            if(vehicleType == ""){
                document.getElementById("error").innerHTML="please select a vehicle type";
                return;
            }
            document.getElementById("error").innerHTML=" ";

            label.innerHTML = "Mention the number of " + vehicleName;

            document.getElementById("vehicle-type").style.display = "none";
            document.getElementById("vehicle-number").style.display = "block";
            document.getElementById("veh-number").focus();
            
            currentField = "vehNumber";
            break;

        case "vehNumber":

            var vehNumber = document.getElementById("veh-number").value;
            
            if(vehNumber == ""){
                document.getElementById("error").innerHTML="please enter a valid vehicle number";
                return;
            }
            document.getElementById("error").innerHTML=" ";

            label.innerHTML = "Tell something about " + vehicleName;
            
            document.getElementById("vehicle-number").style.display = "none";
            document.getElementById("vehicle-identification").style.display = "block";
            document.getElementById("veh-identity").focus();

            document.getElementById("next2").style.display = "block";
            document.getElementById("veh-button-next").style.display = "none";

            currentField = "vehDescription";
            break;

        default:
    }
}

/* opens up the plan and pricing form */
function planForm() {

    document.body.style.backgroundColor = planFormBackgroundColour;
    document.getElementById("vehicle-identification").style.display = "none";
    document.getElementById("next2").style.display = "none";
    document.getElementById("veh-button-back").style.display = "none";

    label.innerHTML = "choose currency for your plan";

    document.getElementById("select-plan").style.display = "block";
    document.getElementById("currency-type").style.display = "block";
    
    currentField = "currency";
    currentForm = 3;
}


/* showing available plans according to vehicle selected */
function showPrice() {

    currency = document.getElementById("currency").value;
    plan = document.getElementById("plan").value;

    document.getElementById("plan").style.display = "block";
    
    var vehicleType = document.getElementById("veh-type").value;

    if(vehicleType == "Cycle")  {
        var daily = 5;
        var monthly = 100;
        var yearly = 500;
    }

    if (vehicleType == "Motocycle") {
        daily = 10;
        monthly = 200;
        yearly = 1000;

    } else if (vehicleType == "Car") {
        daily = 20;
        monthly = 500;
        yearly = 3500;
    }

    switch (currency) {
        case "INR":
            document.getElementById("daily").innerHTML = daily;
            document.getElementById("monthly").innerHTML = monthly;
            document.getElementById("yearly").innerHTML = yearly;
            break;

        case "USD":
            document.getElementById("daily").innerHTML = (daily / convertToUSD).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / convertToUSD).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / convertToUSD).toFixed(2);
            break;

        case "YEN":
            document.getElementById("daily").innerHTML = (daily / convertToYEN).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / convertToYEN).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / convertToYEN).toFixed(2);
            break;
    }

    document.getElementById("next3").style.display = "block";
}

/* on submit of plan and pricing form */
function submitForm() {

    label.innerHTML = "Thank you for registering";

    document.getElementById("main-head").style.display = "none";
    document.getElementById("select-plan").style.display = "none";
    document.getElementById("plan").style.display = "none";
    document.getElementById("next3").style.display = "none";
    document.getElementById("currency-type").style.display = "none";

}