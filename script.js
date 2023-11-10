function navigateTo(link) {
    // You can customize this function to handle navigation to different links
    // For now, let's just update the selected dish content
    const selectedDish = document.getElementById('selectedDish');
    selectedDish.innerHTML = `<h2>${link}</h2>`;
}
