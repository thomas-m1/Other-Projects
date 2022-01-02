function compute() {
    
    //vars pulling in data from user input
    var principal = document.getElementById("principal").value;
    var rate = document.getElementById("rate").value;
    var years = document.getElementById("years").value;
    
    //computations to get results
    var interest = (principal * years * rate)/ 100;
    //var amount = parseInt(principal) + parseInt(interest); can be used to calc total amount
    var futureyear = new Date().getFullYear() + parseInt(years);
    var result = document.getElementById("result");
    

    //displays results for user
    if(principal >0){
    result.innerHTML = "<br>" +"If you deposit <span class='highlight'>"+ principal + 
    "</span> ,<br> at an interest rate of <span class='highlight'>" + rate +
    "</span>% <br> You will receive an amount of <span class='highlight'>" + interest + 
    "</span>, <br> in the year <span class='highlight'>" + futureyear +"</span>" 
    }
    else{ 
    //0 or negative error alert
        alert("Enter a positive number");
        principal.focus();
        return false;
    
    } 
}
//slider function for interest rate
function slider() {
    var rate = document.getElementById("rate").value;
    document.getElementById("rate_span").innerHTML = rate + "%";
}    