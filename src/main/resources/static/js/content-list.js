// Add event listener to each delete button
var deleteForms = document.getElementsByClassName('delete-form');
Array.from(deleteForms).forEach(function(form) {
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the form from submitting directly

        if (confirm('Are you sure you want to delete this content?')) {
            this.submit(); // Submit the form
        }
    });
});

