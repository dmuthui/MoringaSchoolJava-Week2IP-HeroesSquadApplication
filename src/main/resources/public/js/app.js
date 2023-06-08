//VALIDATES HEROFORM DATA ENTRY:SENDS ALERT WHEN THERE IS DUPLICATE HERO AND AVOIDS AVOIDS CLICKING BLANK FORM FOR SUBMISSION
    function validateForm() {
      var heroName = document.getElementById("heroName").value.toUpperCase; // Trim whitespace
      var age = document.getElementById("age").value.trim();
      var specialPower = document.getElementById("specialPower").value;
      var weakness = document.getElementById("weakness").value;

      if (heroName === "" || age === "" || specialPower === "" || weakness === "") {
        alert("Please fill in all the fields before submitting the form.");
        return false; // Prevent form submission
      }
    }


//VALIDATES SQUADFORM DATA ENTRY:SENDS ALERT WHEN THERE IS DUPLICATE SQUAD AND AVOIDS CLICKING BLANK FORM FOR SUBMISSION
 function validatesForm() {
 var squad = document.getElementById("squad").value;
 var size = document.getElementById("size").value;
  var cause = document.getElementById("cause").value;
     if (squad === "" || size === "" || cause === "") {
     alert("Please fill in all the fields before submitting the form.");
     return false; // Prevent form submission
      }
  }

