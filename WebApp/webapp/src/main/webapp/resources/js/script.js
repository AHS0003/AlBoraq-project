// script.js

document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("reservationForm");
    
    form.addEventListener("submit", function(event) {
        event.preventDefault();
        
        const fullName = document.getElementById("fullName").value;
        const email = document.getElementById("email").value;
        const age = document.getElementById("age").value;
        const phoneNumber = document.getElementById("phoneNumber").value;
        const paymentMethod = document.querySelector('input[name="paymentMethod"]:checked');

        if (!fullName || !email || !age || !phoneNumber || !paymentMethod) {
            alert("Please fill in all fields and select a payment method.");
            return;
        }

        // Additional validation can be added here

        // If validation passes, you can submit the form or perform further actions
        form.submit();
    });
});