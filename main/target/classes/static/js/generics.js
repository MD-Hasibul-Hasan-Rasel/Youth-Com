// for input fields
let input_text = document.querySelectorAll(".input_text");
let label_text = document.querySelectorAll(".label_text");
let input_text_box = document.querySelectorAll(".input_text_box");

let label_text_handler = function (labelh) {
  labelh.style.top = "0%";
  labelh.style.color = "#343a40";
  labelh.style.fontSize = "1.2rem";
};

let text_box_handler = function (box) {
  box.style.border = "#343a40 2px solid";
};

input_text.forEach((inp) =>
  inp.addEventListener("change", function () {
    label_text.forEach(function (labelh) {
      label_text_handler(labelh);
    });
    input_text_box.forEach(function (box) {
      text_box_handler(box);
    });

    console.log(inp);
  })
);

// image show on file upload

let image_file = document.querySelector("#file");
let target_image = document.querySelector("#target");

function showImage(src, target) {
  let fr = new FileReader();
  fr.onload = function () {
    target.src = fr.result;
  };
  fr.readAsDataURL(src.files[0]);
}

function putImage() {
  let src = image_file;
  let target = target_image;
  showImage(src, target);
}

image_file.addEventListener("change", function () {
  target_image.style.display = "block";
});

// create prompt
