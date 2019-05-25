function emptyCheck(name,id) 
{      var inputValue = document.getElementById(name);         
if (inputValue.value == "" || inputValue.value == null || inputValue.value == " ") {          id.style.backgroundColor = "red";                }
else{         
	id.style.backgroundColor = "";     
	}  
} 



function emailValidation(email, id) {   
	var regExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[09]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;      
	if (!regExpression.test(email)) {         
		id.style.backgroundColor = "red";       
		alert("Invalid E-mail")      }
	else{          value.style.backgroundColor = "";   
	}
	}  

	function validateForm() {  
		   
		var email = document.getElementById('email');  
		var firstname = document.getElementById('firstname');    
		var lastname = document.getElementById('lanstname');    
		var type = document.getElementById('usertype');    
		
		
		 emailValidation(email.value, email)    

		 }  
	
	
	
	
