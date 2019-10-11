var employeeName, employeeGender, employeeEmail, employeePassword, employeeConfirmPassword, employeeNumber;
var vehicleName, vehicleType, vehicleNumber;
var currentField;
var vehicleType;

let idArray = [];

var employeeFormBackgroundColour = "#E0F0FB";
var vehicleFormBackgroundColour = "#FFE8DC";
var planFormBackgroundColour = "#DFDFDF";

var convertToUSD = 71.74;
var convertToYEN = 0.68;

/* onclick of Register Here shows name input */
function registerationForm() {
    
    document.getElementById("navigation").style.display="none";
    document.getElementById("cover-img").style.display = "none";

    document.body.style.backgroundColor = employeeFormBackgroundColour;

    document.getElementById("employee-name").style.display = "block";
    document.getElementById("button-next").style.display = "block";
    document.getElementById("button-back").style.display = "block";

    document.getElementById("emp-name").focus();
    currentField = "employee-name";
    idArray.push(currentField);
}

function onBlurForm1() {

    switch (idArray[idArray.length-1]) {

        case "employee-name":
            employeeName = document.getElementById("emp-name").value;

            if (!(/^[A-z ]{3,}$/.test(employeeName))) {
                document.getElementById("error-name").innerHTML = "please enter a valid name";
                return false;
            } else {
                document.getElementById("error-name").innerHTML = " ";
            }
            
            document.getElementById("label-gender").innerHTML = "Hello " + employeeName + " !! may I know your gender ?";
            document.getElementById("employee-name").style.display = "none";
            document.getElementById("employee-gender").style.display = "block";
            
            idArray.push("employee-gender");
            break;

        case "employee-gender":
            employeeGender = document.getElementsByName("emp-gender");

            if (!employeeGender[0].checked && !employeeGender[1].checked) {
                document.getElementById("error-gender").innerHTML = "Please select gender";
                return false;
            } else {
                document.getElementById("error-gender").innerHTML = " ";
            }

            document.getElementById("employee-gender").style.display = "none";
            document.getElementById("employee-email").style.display = "block";
            
            document.getElementById("emp-email").focus();
            idArray.push("employee-email");
            break;

        case "employee-email":
            employeeEmail = document.getElementById("emp-email").value;

            if (!(/^[A-z]+@[A-z]+\.[A-z]+$/.test(employeeEmail))) {
                document.getElementById("error-email").innerHTML = "please enter valid email address";
                return false;
            } else {
                document.getElementById("error-email").innerHTML = " ";
            }

            document.getElementById("employee-email").style.display = "none";
            document.getElementById("employee-password").style.display = "block";
            document.getElementById("emp-pass").focus();

            idArray.push("employee-password");
            break;

        case "employee-password":
            employeePassword = document.getElementById("emp-pass").value;
            employeeConfirmPassword = document.getElementById("confirm-pass").value;
            
            if (employeePassword != employeeConfirmPassword) {
                document.getElementById("error-confirm").innerHTML = "password doesn't match";
                return false;
               
            } else {
                document.getElementById("error-confirm").innerHTML = " ";
            }

            document.getElementById("employee-password").style.display = "none";
            document.getElementById("employee-contact").style.display = "block";
            
            document.getElementById("next1").style.display = "block";
            document.getElementById("button-next").style.display = "none";
            document.getElementById("emp-contact").focus();

            idArray.push("employee-contact");
            break;
    }
}

function backToPrevious() {
    var field;
    
    if(idArray.length == 1) {
        document.getElementById("button-next").style.display = "none";
        document.getElementById("button-back").style.display = "none";

        document.getElementById("navigation").style.display = "block";
        document.getElementById("cover-img").style.display = "block";
        
        document.getElementById(idArray[idArray.length-1]).style.display = "none";
        idArray.pop();
        
    } else if(idArray.length == 5) {
        document.getElementById(idArray[idArray.length - 1]).style.display = "none";
        idArray.pop();
        document.getElementById(idArray[idArray.length - 1]).style.display = "block";

        document.getElementById("button-next").style.display = "block";
        document.getElementById("next1").style.display = "none";

    } else if(idArray.length == 9) {
        document.getElementById(idArray[idArray.length - 1]).style.display = "none";
        idArray.pop();
        document.getElementById(idArray[idArray.length - 1]).style.display = "block";

        document.getElementById("veh-button-next").style.display = "block";
        document.getElementById("next2").style.display = "none";

    } else {
        document.getElementById(idArray[idArray.length - 1]).style.display = "none";
        idArray.pop();
        document.getElementById(idArray[idArray.length - 1]).style.display = "block";
    }

}

function validatePassword() {

    var employeePassword = document.getElementById("emp-pass").value;
    var strongPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");

    if (employeePassword.length < 8) {
        document.getElementById("emp-pass").style.borderColor = "red";
        document.getElementById("error-password").innerHTML = "password should be atleast 8 characters long";
        return false;

    } else if (!(strongPassword.test(employeePassword))) {
        document.getElementById("emp-pass").style.borderColor = "yellow";
        document.getElementById("error-password").innerHTML = "password should contain atleast one uppercase, one lowercase and one numeric character";
        return false;

    } else {
        document.getElementById("emp-pass").style.borderColor = "green";
        document.getElementById("error-password").innerHTML = " ";
    }
}



/*  shows first input of vehcle form */
function vehicleForm() {

    employeeContact = document.getElementById("emp-contact").value;

    if (!(/^[0-9]{10}$/.test(employeeContact))) {
        document.getElementById("error-contact").innerHTML = "please enter a valid 10 digit numeric contact number";
        return false;
        
    } else {
        document.getElementById("error-contact").innerHTML = " ";
    }

    document.body.style.backgroundColor = vehicleFormBackgroundColour;
    
    document.getElementById("employee-contact").style.display = "none";
    document.getElementById("employee-buttons").style.display = "none";

    document.getElementById("vehicle-name").style.display = "block";
    document.getElementById("veh-button-next").style.display = "block";
    document.getElementById("veh-name").focus();

    idArray.push("vehicle-name");
    currentForm = 2;
}


/* switch case for vehicle  form for switching input fields */
function onBlurForm2() {

    switch (idArray[idArray.length-1]) {
        case "vehicle-name":
            vehicleName = document.getElementById("veh-name").value;

            if(vehicleName == ""){
                document.getElementById("error-vname").innerHTML = "please enter a valid vehicle name";
                return;
            }
            document.getElementById("error-vname").innerHTML = " ";

            document.getElementById("label-vtype").innerHTML = "what is the type of " + vehicleName;

            document.getElementById("vehicle-name").style.display = "none";
            document.getElementById("vehicle-type").style.display = "block";
            document.getElementById("veh-button-back").style.display = "block";
            
            idArray.push("vehicle-type");
            break;

        case "vehicle-type":
            vehicleType = document.getElementById("veh-type").value;
            
            if(vehicleType == ""){
                document.getElementById("error-vtype").innerHTML = "please select vehicle type";
                return;
            }
            document.getElementById("error-vtype").innerHTML=" ";

            document.getElementById("label-vnumber").innerHTML = "Mention the number of " + vehicleName;

            document.getElementById("vehicle-type").style.display = "none";
            document.getElementById("vehicle-number").style.display = "block";
            document.getElementById("veh-number").focus();
            
            idArray.push("vehicle-number");
            break;

        case "vehicle-number":
            vehicleNumber = document.getElementById("veh-number").value;
            
            if(vehicleNumber == ""){
                document.getElementById("error-vnumber").innerHTML = "please enter a valid vehicle number";
                return;
            }
            document.getElementById("error-vnumber").innerHTML=" ";

            document.getElementById("vehicle-number").style.display = "none";
            document.getElementById("vehicle-identification").style.display = "block";
            document.getElementById("next2").style.display = "block";
            document.getElementById("veh-button-next").style.display = "none";
            document.getElementById("veh-identity").focus();

            idArray.push("vehicle-identification");
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

    document.getElementById("select-plan").style.display = "block";
    document.getElementById("currency-type").style.display = "block";
    
    currentField = "currency";
    currentForm = 3;
}


/* showing available plans according to vehicle selected */
function showPrice() {

    currency = document.getElementById("currency").value;
    
    document.getElementById("plan").style.display = "block";
    plan = document.getElementById("plan").value;
    
    var daily, monthly , yearly;

   if(vehicleType == "Cycle")  {
        daily = 5;
        monthly = 100;
        yearly = 500;

    } else if (vehicleType == "Motocycle") {
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
}

function showSubmitButton() {
    document.getElementById("next3").style.display = "block";
}

/* on submit of plan and pricing form */
function submitForm() {
    
    document.getElementById("result").innerHTML = "Thank you for registering";

    document.getElementById("main-head").style.display = "none";
    document.getElementById("select-plan").style.display = "none";
    document.getElementById("currency-type").style.display = "none";
    document.getElementById("plan").style.display = "none";
    document.getElementById("next3").style.display = "none";
}