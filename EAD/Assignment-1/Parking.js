function validateUserDetails() {
    var userRegisterationForm = document.forms.RegForm;

    var name = userRegisterationForm.Name;
    var email = userRegisterationForm.Email;
    var phone = userRegisterationForm.Contact;
    var password = userRegisterationForm.Password;
    var Confirm = userRegisterationForm.Conpassword;

    var nameRegEx = /^[a-zA-Z0-9]+[\s]{1}[a-zA-Z0-9]+$/i;
    var emailRegEx = /^[a-zA-Z0-9]+[@]{1}[a-zA-Z]+[\.]{1}[a-zA-Z]+$/i;
    var passwordRegEx = /^[a-zA-Z0-9]{8,20}$/i;
    
    if (!nameRegEx.test(name.value)) {
        window.alert("Please enter your full name");
        name.focus();
        return false;
    }

    if (!emailRegEx.test(email.value)) {
        window.alert("Please enter valid email address");
        email.focus();
        return false;
    }

    if (!passwordRegEx.test(password.value)) {
        window.alert("Please enter a proper password");
        password.focus();
        return false;
    }

    var count = password.value.localeCompare(Confirm.value);
    if(count != 0){
        window.alert("Password and confirm password do not match");
        Conpassword.focus();
        return false;
    }

    return true;
}

function registerUser() {
    var flag = validateUserDetails();

    if(flag) {
        var registerationId = "meta123";
        window.alert("Thank you for registration!! Your registration number is " + registerationId);
        document.getElementById("application").innerHTML = "";
        document.getElementById("vehicle").style.display = "block";
    }
}
		
function validateVehicleDetails(){
    var name = document.forms.vehicleform.vname;
    var number = document.forms.vehicleform.number;

    var nameRegEx = /^[a-zA-Z0-9\s]+$/i;
    var numberRegEx = /^[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{2}[0-9]{4}$/;

    if (!nameRegEx.test(name.value)) {
        window.alert("Please enter proper vehicle name");
        phone.focus();
        return false;
    }

    if (!numberRegEx.test(number.value)) {
        window.alert("Please enter proper vehicle number");
        phone.focus();
        return false;
    }

    return true;
}

function registerVehicle() {
    var flag = validateVehicleDetails();

    if(flag) {
        document.getElementById("curr_type").style.display= "block";
        var type = document.getElementById("vehicle_type").value;
        document.getElementById("vehicle").style.display ="none";
        document.getElementById("btns").style.display = "block";

        if (type == "cycle") {
            document.getElementById("cycle").style.display = "block";

        } else if (type == "bike") {
           document.getElementById("bike").style.display = "block";

        } else {
          document.getElementById("car").style.display = "block";

        }
        document.getElementById("bill").style.display = "block";
    }
}

function calculateBill() {
    const convertToUSD = 0.014;
    var vehicleType = document.getElementById("vehicle_type").value;
    var ele = document.getElementsByName(vehicleType);

    for (index = 0; index < ele.length; index++) {
        if (ele[index].checked)
            document.getElementById("show_price").innerHTML= "Total bill in USD : " + ele[index].value * convertToUSD;
    }
}

function changeCurrency() {
    const convertToUSD = 0.014;
    const convertToYEN = 1.48;

    var vehicleType = document.getElementById("vehicle_type").value;
    var currencyType = document.getElementById("currecy_type").value;

    var priceInINR = [[5,100,500], [10,200,1000], [20,500,3500]];
    var row;

    if(vehicleType == "cycle") {
        row = 0;
    } else if(vehicleType == "bike") {
        row = 1;
    } else if(vehicleType == "car") {
        row = 2;
    }

    switch(currencyType){      
    case "INR":
        if(vehicleType=="cycle") { 
            document.getElementById("dailyCycle").innerHTML = priceInINR[row][0];
            document.getElementById("monthlyCycle").innerHTML = priceInINR[row][1];
            document.getElementById("yearlyCycle").innerHTML = priceInINR[row][2];

        } else if(vehicleType=="bike") { 
            document.getElementById("dailyBike").innerHTML = priceInINR[row][0];
            document.getElementById("monthlyBike").innerHTML = priceInINR[row][1]
            document.getElementById("yearlyBike").innerHTML = priceInINR[row][2];

        } else if(vehicleType=="car") { 
            document.getElementById("dailyCar").innerHTML = priceInINR[row][0];
            document.getElementById("monthlyCar").innerHTML = priceInINR[row][1];
            document.getElementById("yearlyCar").innerHTML = priceInINR[row][2];
        }
        break;

    case "USD":   
        if(vehicleType=="cycle") { 
            document.getElementById("dailyCycle").innerHTML = priceInINR[row][0] * convertToUSD;
            document.getElementById("monthlyCycle").innerHTML = priceInINR[row][1] * convertToUSD;
            document.getElementById("yearlyCycle").innerHTML = priceInINR[row][2] * convertToUSD;

        } else if(vehicleType=="bike") { 
            document.getElementById("dailyBike").innerHTML = priceInINR[row][0] * convertToUSD;
            document.getElementById("monthlyBike").innerHTML = priceInINR[row][1] * convertToUSD;
            document.getElementById("yearlyBike").innerHTML = priceInINR[row][2] * convertToUSD;

        } else if(vehicleType=="car") { 
            document.getElementById("dailyCar").innerHTML = priceInINR[row][0] * convertToUSD;
            document.getElementById("monthlyCar").innerHTML = priceInINR[row][1] * convertToUSD;
            document.getElementById("yearlyCar").innerHTML = priceInINR[row][2] * convertToUSD;
        }
        break;

    case "YEN":
        if(vehicleType=="cycle") { 
            document.getElementById("dailyCycle").innerHTML = priceInINR[row][0] * convertToYEN;
            document.getElementById("monthlyCycle").innerHTML = priceInINR[row][1] * convertToYEN;
            document.getElementById("yearlyCycle").innerHTML = priceInINR[row][2] * convertToYEN;

        } else if(vehicleType=="bike") { 
            document.getElementById("dailyBike").innerHTML = priceInINR[row][0] * convertToYEN;
            document.getElementById("monthlyBike").innerHTML = priceInINR[row][1] * convertToYEN;
            document.getElementById("yearlyBike").innerHTML = priceInINR[row][2] * convertToYEN;

        } else if(vehicleType=="car") { 
            document.getElementById("dailyCar").innerHTML = priceInINR[row][0] * convertToYEN;
            document.getElementById("monthlyCar").innerHTML = priceInINR[row][1] * convertToYEN;
            document.getElementById("yearlyCar").innerHTML = priceInINR[row][2] * convertToYEN;
        }
        break;
    }   
}