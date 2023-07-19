
    function confirmDelete(button) {
    var contentId = button.getAttribute("data-contentid");
    var confirmation = confirm("Are you sure you want to delete this content?");

    if (confirmation) {
    var form = document.getElementById("form");
    var input = document.createElement("input");
    input.type = "hidden";
    input.name = "selectedContentIds";
    input.value = contentId;
    form.appendChild(input);
    form.submit();
} else {
    return false; // Prevent form submission
}
}


