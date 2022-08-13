"use strict";

const exp_colp_button = document.querySelector(".exp_colp_button");
const downarrow = document.querySelector(".fa-chevron-down");
const rightportion = document.querySelector(".rightportion");

let counter = 0;

exp_colp_button.addEventListener("click", function () {
  if (counter == 0) {
    downarrow.style.transform = "rotate(180deg)";
    rightportion.style.transform = "translate(-50%, 50%)";
    counter = 1;
  } else {
    downarrow.style.transform = "rotate(0deg)";
    rightportion.style.transform = "translate(-50%, -50%)";
    counter = 0;
  }
});
