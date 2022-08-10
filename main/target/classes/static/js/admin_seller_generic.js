const email_modal_overlay = document.querySelector(".email_modal_overlay");
const email_seller = document.querySelectorAll(".email_seller");
const exit_emailbox = document.querySelector(".exit_emailbox");
const email_mainbox = document.querySelector(".email_mainbox");

// email_seller.addEventListener("click", function () {
//   email_modal_overlay.style.visibility = "visible";
// });

email_seller.forEach((opc) =>
  opc.addEventListener("click", function () {
    email_modal_overlay.style.visibility = "visible";
  })
);

exit_emailbox.addEventListener("click", function () {
  email_modal_overlay.style.visibility = "hidden";
});
