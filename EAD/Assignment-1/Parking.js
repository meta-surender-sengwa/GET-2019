function validation() {

    var name = document.forms["RegForm"]["Name"];
    var email = document.forms["RegForm"]["Email"];
    var phone = document.forms["RegForm"]["Contact"];
    var password = document.forms["RegForm"]["Password"];
    var Confirm = document.forms["RegForm"]["conPassword"];
    var regex = new RegExp("\\d");
    var filtercontact = new RegExp('([a-zA-Z!@#$%^&*()_+])');
    var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");

    if (password.value.length < 8) {
        window.alert("Password should be minimum 8 character");
        password.focus();
        return false;
    }
    if(name.value.length <= 2) {
        window.alert("Name should be greater than 2 chracter");
        name.focus();
        return false;
        
    }
    if (filterPassword.test(password)){
        window.alert("Insert Valid password format eg Abc@123");
        password.focus();
        return false;

    }
    if (phone.value.length != 10 ) {
        window.alert("Phone number should be of 10 digit");
        phone.focus();
        return false;
    }
    if (name.value == "") {
        window.alert("Please enter your name.");
        name.focus();
        return false;
    } if (regex.test(name.value)) {
        window.alert("Please dont enter numeric in name");
        name.focus();
        return false;
    }
    if (filtercontact.test(phone.value)) {
        window.alert("Please enter only numeric in contacts");
        phone.focus();
        return false;
    }

    if (email.value == "") {
        window.alert("Please enter a valid e-mail address.");
        email.focus();
        return false;
    }

    if (email.value.indexOf("@", 0) < 0) {
        window.alert("Please enter a valid e-mail address.");
        email.focus();
        return false;
    }

    if (email.value.indexOf(".", 0) < 0) {
        window.alert("Please enter a valid e-mail address.");
        email.focus();
        return false;
    }

    if (phone.value == "") {
        window.alert("Please enter your telephone number.");
        phone.focus();
        return false;
    }

    if (password.value == "") {
        window.alert("Please enter your password");
        password.focus();
        return false;
    }
    if (Confirm.value == "") {
        window.alert("Please enter your password");
        password.focus();
        return false;
    }

    var n = password.value.localeCompare(Confirm.value);
    if( n != 0){
        window.alert("Password and confirm password do not match");
        password.focus();
        return false;
    }

    return true;
}

function collapse() {
    var flag = validation();
    if(flag == true) {
        window.alert("Thank you for registration!! Your registration number is 123346");
    document.getElementById("application").innerHTML = "";
    }
    document.getElementById("vehicle").style.display = "inherit";
}

function validation2(){
    var name = document.forms["vehicleform"]["vname"];
    var vnumber = document.forms["vehicleform"]["number"];
    if (name.value == "") {
        window.alert("Please enter vehicle name");
        name.focus();
        return false;
    }
    if (vnumber.value == "") {
        window.alert("Please enter vehicle number");
        vnumber.focus();
        return false;
    }
    
    return true;
}

function price() {
    var flag = validation2();
    if(flag == true) {
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

function bill_cal() {

    var ve_type = document.getElementById("vehicle_type").value;
    var ctype = document.getElementById("currecy_type").value;
    var ele = document.getElementsByName(ve_type);
    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked) {
            document.getElementById("show_price").innerHTML= "Total bill in USD : " + ele[i].value*0.014;
        }
    }
}
    

function change_currency() {
    var ve_type = document.getElementById("vehicle_type").value;
    var c_type = document.getElementById("currecy_type").value;

    switch(c_type) {
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
            element = element*0.014;
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