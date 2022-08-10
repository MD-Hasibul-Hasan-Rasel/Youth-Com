// "use strict";

const nav_items_phone = document.querySelector(".navigation_mobile_slider");
const overlay = document.querySelector(".overlay");
let exit_mobile_nav = document.querySelector(".exit_mobile_navigation_slider");

document.querySelector(".menu_button").addEventListener("click", function () {
  nav_items_phone.style.right = "0px";
  overlay.style.visibility = "visible";
});

// Exit mobile navigation slider
exit_mobile_nav.addEventListener("click", function () {
  nav_items_phone.style.right = "-300px";
  overlay.style.visibility = "hidden";
});

/*overlay.addEventListener("click", function () {
  nav_items_phone.style.right = "-300px";
  overlay.style.visibility = "hidden";
});*/

document.querySelector(".exit_cart").addEventListener("click", function () {
  nav_items_phone.style.right = "-300px";
  overlay.style.visibility = "hidden";
});
