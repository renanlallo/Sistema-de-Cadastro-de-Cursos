document.addEventListener("DOMContentLoaded", function() {
    const rows = document.querySelectorAll("table tbody tr");
    rows.forEach(row => {
        row.addEventListener("mouseover", () => {
            row.style.backgroundColor = "#e6f2ff";
        });
        row.addEventListener("mouseout", () => {
            row.style.backgroundColor = "";
        });
    });
});
