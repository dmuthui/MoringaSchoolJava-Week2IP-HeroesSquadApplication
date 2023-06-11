//VALIDATES HEROFORM DATA ENTRY:SENDS ALERT WHEN THERE IS DUPLICATE HERO AND AVOIDS AVOIDS CLICKING BLANK FORM FOR SUBMISSION
function validateForm() {
    var heroName = document.getElementById("heroName").value.toUpperCase().trim(); // Trim whitespace
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
       return true; // Allow form submission
  }
//VALIDATES SQUADHEROES FORM DATA ENTRY:TO AVOID SUBMITTING THE FORM WHEN HERO HAS NOT BEEN SELECTED FOR SUBMISSION
  function validator() {
      var heroName = document.getElementById("heroName").value;
      if (heroName === "") {
          alert("Please select a Hero.");
          return false; // Prevent form submission
      }
      return true; // Allow form submission
  }
//AN ALERT THAT POPS TO ALLOW REMOVAL OF A HERO FROM THE ASSIGNED SQUAD
    function confirmRemoval(heroName) {
        var confirmation = confirm("Are you sure you want to remove the hero " + heroName + "?");
        if (confirmation) {
            // Proceed with the removal logic or redirect to the removal URL
        } else {
            // Cancel the removal action
        }
    }
//AN ALERT THAT POPS WHEN YOU WANT TO DELETE A HERO FROM THE HEROES LIST
    function confirmDeletion(heroName) {
         var result = confirm("Are you sure you want to delete the hero " + heroName + "?");
         if (result) {
             // Perform the deletion action
             window.location.href = "/delete-hero/" + heroName;
         }
     }