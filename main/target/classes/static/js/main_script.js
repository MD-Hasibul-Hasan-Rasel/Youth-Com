// "use strict";

const header = document.querySelector("header");
const gotopButton = document.querySelector(".gotop");

// slider portion variables
const rightslidebutton = document.querySelector(".rightslidebutton");
const leftslidebutton = document.querySelector(".leftslidebutton");
const nav_link_button1 = document.querySelector(".nav_link_button01");
const nav_link_button2 = document.querySelector(".nav_link_button02");
const nav_link_button3 = document.querySelector(".nav_link_button03");
const nav_link_button4 = document.querySelector(".nav_link_button04");
const nav_link_button5 = document.querySelector(".nav_link_button05");
const nav_link_button6 = document.querySelector(".nav_link_button06");

// slide_01_text
const slide_text_common = document.querySelector(".slide_text_common");

// main slides
const slide_1 = document.querySelector(".slide_01");
const slide_2 = document.querySelector(".slide_02");
const slide_3 = document.querySelector(".slide_03");
const slide_4 = document.querySelector(".slide_04");
const slide_5 = document.querySelector(".slide_05");
const slide_6 = document.querySelector(".slide_06");

// slide_texts
const slide_1_text = document.querySelector(".slide_01_text");
const slide_2_text = document.querySelector(".slide_02_text");
const slide_3_text = document.querySelector(".slide_03_text");
const slide_4_text = document.querySelector(".slide_04_text");
const slide_5_text = document.querySelector(".slide_05_text");
const slide_6_text = document.querySelector(".slide_06_text");

// indicators

const indicator_1 = document.querySelector(".slide01indicator");
const indicator_2 = document.querySelector(".slide02indicator");
const indicator_3 = document.querySelector(".slide03indicator");
const indicator_4 = document.querySelector(".slide04indicator");
const indicator_5 = document.querySelector(".slide05indicator");
const indicator_6 = document.querySelector(".slide06indicator");

// cart modal
const cart = document.querySelector(".cart_popup_modal");
const exit_cart = document.querySelector(".exit_cart");
const open_cart = document.querySelectorAll(".cart_button");
const notification = document.querySelector(".notification_popup_modal");
const exit_notification = document.querySelector(".exit_notification");
const open_notification = document.querySelectorAll(".notification_button");

// slider change button value helpers
let firstCheck = 0;

const nav_link_buttons = [
  nav_link_button1,
  nav_link_button2,
  nav_link_button3,
  nav_link_button4,
  nav_link_button5,
  nav_link_button6,
];

const main_slides = [slide_1, slide_2, slide_3, slide_4, slide_5, slide_6];

const indicators = [
  indicator_1,
  indicator_2,
  indicator_3,
  indicator_4,
  indicator_5,
  indicator_6,
];

const slide_texts = [
  slide_1_text,
  slide_2_text,
  slide_3_text,
  slide_4_text,
  slide_5_text,
  slide_6_text,
];

// cart modal handler
open_cart.forEach((opc) =>
  opc.addEventListener("click", function () {
    cart.style.visibility = "visible";
  })
);

// notification modal handler
open_notification.forEach((opn) =>
  opn.addEventListener("click", function () {
    notification.style.visibility = "visible";
  })
);

// open_cart.addEventListener("click", function () {
//   cart.style.visibility = "visible";
// });

exit_cart.addEventListener("click", function () {
  cart.style.visibility = "hidden";
});

exit_notification.addEventListener("click", function () {
  notification.style.visibility = "hidden";
});

/*cart.addEventListener("click", function () {
  cart.style.visibility = "hidden";
});*/

/*notification.addEventListener("click", function () {
  notification.style.visibility = "hidden";
});*/

// slider portion

// handler functions
const sliderButtonHandler = function (button, event, transform, opacity) {
  button.addEventListener(event, function () {
    leftslidebutton.style.transform = transform;
    leftslidebutton.style.opacity = opacity;
  });
};

sliderButtonHandler(leftslidebutton, "mouseover", "translate(0%, -50%)", "1");
sliderButtonHandler(leftslidebutton, "mouseout", "translate(-20%, -50%)", "0");
sliderButtonHandler(rightslidebutton, "mouseover", "translate(0%, -50%)", "1");
sliderButtonHandler(rightslidebutton, "mouseout", "translate(-20%, -50%)", "0");

/*slider effect portion*/

let i = 0,
  sliderCounterCheck = 0;

nav_link_buttons[i].style.backgroundColor = "#3fa9f5";
nav_link_buttons[i].style.color = "#fff";

main_slides[i].style.transform = "translate(0%, -50%)";
main_slides[i].style.opacity = "1";

indicators[i].style.backgroundColor = "#3fa9f5";

slide_texts[i].style.visibility = "visible";
// slide_texts[i].style.transform = "translateY(0%)";

i++;

/*leftslidebutton.addEventListener("click", function () {
  sliderCounterCheck = 1;

  if (firstCheck === 0) {
    if (i == 0) {
      i = 5;
    } else {
      i--;
    }
    nav_link_buttons[i].style.backgroundColor = "transparent";
    nav_link_buttons[i].style.color = "#343a40";

    main_slides[i].style.transform = "translate(-100%, -50%)";
    main_slides[i].style.opacity = "0";

    indicators[i].style.backgroundColor = "#e8e9eb";

    slide_texts[i].style.visibility = "hidden";

    if (i == 0) {
      i = 5;
    } else {
      i--;
    }

    // current change
    nav_link_buttons[i].style.backgroundColor = "#3fa9f5";
    nav_link_buttons[i].style.color = "#fff";

    main_slides[i].style.transform = "translate(0%, -50%)";
    main_slides[i].style.opacity = "1";

    indicators[i].style.backgroundColor = "#3fa9f5";

    slide_texts[i].style.visibility = "visible";

    firstCheck = 1;
  } else {
    // prev change
    nav_link_buttons[i].style.backgroundColor = "transparent";
    nav_link_buttons[i].style.color = "#343a40";

    main_slides[i].style.transform = "translate(-100%, -50%)";
    main_slides[i].style.opacity = "0";

    indicators[i].style.backgroundColor = "#e8e9eb";

    slide_texts[i].style.visibility = "hidden";

    if (i == 0) {
      i = 5;
    } else {
      i--;
    }

    // current change
    nav_link_buttons[i].style.backgroundColor = "#3fa9f5";
    nav_link_buttons[i].style.color = "#fff";

    main_slides[i].style.transform = "translate(0%, -50%)";
    main_slides[i].style.opacity = "1";

    indicators[i].style.backgroundColor = "#3fa9f5";

    slide_texts[i].style.visibility = "visible";
  }
});

rightslidebutton.addEventListener("click", function () {
  sliderCounterCheck = 1;

  if (firstCheck === 0) {
    if (i == 0) {
      i = 5;
    } else {
      i--;
    }
    // prev change
    nav_link_buttons[i].style.backgroundColor = "transparent";
    nav_link_buttons[i].style.color = "#343a40";

    main_slides[i].style.transform = "translate(-100%, -50%)";
    main_slides[i].style.opacity = "0";

    indicators[i].style.backgroundColor = "#e8e9eb";

    slide_texts[i].style.visibility = "hidden";

    if (i == 5) {
      i = 0;
    } else {
      i++;
    }

    // current change
    nav_link_buttons[i].style.backgroundColor = "#3fa9f5";
    nav_link_buttons[i].style.color = "#fff";

    main_slides[i].style.transform = "translate(0%, -50%)";
    main_slides[i].style.opacity = "1";

    indicators[i].style.backgroundColor = "#3fa9f5";

    slide_texts[i].style.visibility = "visible";
  } else {
    // prev change
    nav_link_buttons[i].style.backgroundColor = "transparent";
    nav_link_buttons[i].style.color = "#343a40";

    main_slides[i].style.transform = "translate(-100%, -50%)";
    main_slides[i].style.opacity = "0";

    indicators[i].style.backgroundColor = "#e8e9eb";

    slide_texts[i].style.visibility = "hidden";

    if (i == 5) {
      i = 0;
    } else {
      i++;
    }

    // current change
    nav_link_buttons[i].style.backgroundColor = "#3fa9f5";
    nav_link_buttons[i].style.color = "#fff";

    main_slides[i].style.transform = "translate(0%, -50%)";
    main_slides[i].style.opacity = "1";

    indicators[i].style.backgroundColor = "#3fa9f5";

    slide_texts[i].style.visibility = "visible";
  }
});*/

setInterval(function () {
  console.log(i);

  nav_link_buttons[i].style.backgroundColor = "#3fa9f5";
  nav_link_buttons[i].style.color = "#fff";

  main_slides[i].style.transform = "translate(0%, -50%)";
  main_slides[i].style.opacity = "1";

  indicators[i].style.backgroundColor = "#3fa9f5";

  slide_texts[i].style.visibility = "visible";

  if (i != 0) {
    nav_link_buttons[i - 1].style.backgroundColor = "transparent";
    nav_link_buttons[i - 1].style.color = "#343a40";

    main_slides[i - 1].style.transform = "translate(-100%, -50%)";
    main_slides[i - 1].style.opacity = "0";

    indicators[i - 1].style.backgroundColor = "#e8e9eb";

    slide_texts[i - 1].style.visibility = "hidden";
  } else {
    nav_link_buttons[i + 5].style.backgroundColor = "transparent";

    nav_link_buttons[i + 5].style.color = "#343a40";
    main_slides[i + 5].style.transform = "translate(-100%, -50%)";
    main_slides[i + 5].style.opacity = "0";

    indicators[i + 5].style.backgroundColor = "#e8e9eb";

    slide_texts[i + 5].style.visibility = "hidden";
  }

  if (sliderCounterCheck === 0) {
    if (i == 5) {
      i = 0;
    } else {
      i++;
    }
  }
  sliderCounterCheck = 0;
  firstCheck = 0;
}, 10000);

// smooth scrolling
gotopButton.addEventListener("click", function () {
  header.scrollIntoView({ behavior: "smooth" });
});
