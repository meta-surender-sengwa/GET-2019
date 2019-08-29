function validateUserDetails() {
    var userRegisterationForm = document.forms.RegForm;

    var name = userRegisterationForm.Name;
    var email = userRegisterationForm.Email;
    var phone = userRegisterationForm.Contact;
    var password = userRegisterationForm.Password;
    var Confirm = userRegisterationForm.Conpassword;

    var nameRegEx = /^[a-zA-Z]+[\s]{1}[a-zA-Z]+$/i;

    if (nameRegEx.test(name.value)) {
        window.alert("Please enter your full name");
        phone.focus();
        return false;
    }

    var count = password.value.localeCompare(Confirm.value);
    if( count != 0){
        window.alert("Password and confirm password do not match");
        password.focus();
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

    var nameRegEx = /^[a-zA-Z0-9]*$/i;
    var numberRegEx = /^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$/;

    if (nameRegEx.test(name.value)) {
        window.alert("Please enter proper vehicle name");
        phone.focus();
        return false;
    }

    if (numberRegEx.test(number.value)) {
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
    var ve_type = document.getElementById("vehicle_type").value;
    var ctype = document.getElementById("currecy_type").value;
    var ele = document.getElementsByName(ve_type);
    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked)
            document.getElementById("show_price").innerHTML= "Total bill in USD : " + ele[i].value*0.014;
    }
}

function changeCurrency() {
    var ve_type = document.getElementById("vehicle_type").value;
    var c_type = document.getElementById("currecy_type").value;

    switch(c_type){
        case "INR":
        var a = document.getElementById(ve_type).querySelectorAll(".p1");
        for ( var index = 0; index < a.length; index++) {	
            var element = a[index].innerHTML;
            element = element*1;
            a[index].innerHTML=element;        
        }
        break;

        case "USD":    
        var a = document.getElementById(ve_type).querySelectorAll(".p1");
        for ( var index = 0; index < a.length; index++) {	
            var element = a[index].innerHTML;
            element = element * 0.014;
            a[index].innerHTML=element;          
        }
        break;

        case "YEN":
        var a = document.getElementById(ve_type).querySelectorAll(".p1");
        for ( var index = 0; index < a.length; index++) {
        
            var element = a[index].innerHTML;
            element = element*1.48;
            a[index].innerHTML=element;
        }
        break;
    }   
}