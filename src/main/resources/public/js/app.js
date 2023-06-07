    //VALIDATES HEROFORM DATA ENTRY:SENDS ALERT WHEN THERE IS DUPLICATE HERO AND AVOIDS SENDING BLANK FORM
    function validateForm() {
        var heroName = document.getElementById("heroName").value;
        var age = document.getElementById("age").value;
        var specialPower = document.getElementById("specialPower").value;
        var weakness = document.getElementById("weakness").value;

        if (heroName === "" || age === "" || specialPower === "" || weakness === "") {
            alert("Please fill in all the fields before submitting the form.");
            return false; // Prevent form submission
        }

        // Check if hero name already exists
        var existingHeroes = heroName;

        if (existingHeroes.includes(heroName)) {
            alert("Hero name already exists. Please choose a different name.");
            document.getElementById("heroName").value = ""; // Clear the hero name input field
            document.getElementById("age").value = ""; // Clear the hero age input field
            document.getElementById("specialPower").value = ""; // Clear the specialPower input field
            document.getElementById("weakness").value = ""; // Clear the weakness input field
            return false; // Prevent form submission
        }

        return true; // Allow form submission
    }