const nav_items_phone = document.querySelector(".navigation_mobile_slider");
const overlay = document.querySelector(".overlay");

document.querySelector(".menu_button").addEventListener("click", function () {
  nav_items_phone.style.right = "0px";
  overlay.style.visibility = "visible";
});

document.querySelector(".exit_cart").addEventListener("click", function () {
  nav_items_phone.style.right = "-300px";
  overlay.style.visibility = "hidden";
});

overlay.addEventListener("click", function () {
  nav_items_phone.style.right = "-300px";
  overlay.style.visibility = "hidden";
});
