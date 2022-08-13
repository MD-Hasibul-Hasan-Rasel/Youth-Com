const like_count = document.querySelectorAll(".like_count");
const thumbs_up_image = document.querySelectorAll(".thumbs_up_image");
const thumbs_up_button = document.querySelectorAll(".thumbs_up_button");

let counter = 0;

console.log(thumbs_up_button);

thumbs_up_button.forEach((thumbs_up_btn) =>
  thumbs_up_btn.addEventListener("click", function () {
    if (counter == 0) {
      thumbs_up_image.forEach(function (thumbs_up_img) {
        thumbs_up_img.src = "svg/thumbs_up_blue.svg";
      });

      like_count.forEach(function (like) {
        like.style.color = "#3fa9f5";

        let number = like_count.innerHTML;
        ++number;
        like_count.innerHTML = number;
      });
      counter = 1;
    } else if (counter == 1) {
      thumbs_up_image.forEach(function (thumbs_up_img) {
        thumbs_up_img.src = "svg/thumbs_up_gray.svg";
      });

      like_count.forEach(function (like) {
        like.style.color = "#343a40";

        let number = like_count.innerHTML;
        --number;
        like_count.innerHTML = number;
      });
      counter = 0;
    }
  })
);

// collapsible
var coll = document.getElementsByClassName("collapsible");
var f;

for (f = 0; f < coll.length; f++) {
  coll[f].addEventListener("click", function () {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.maxHeight) {
      content.style.maxHeight = null;
    } else {
      content.style.maxHeight = content.scrollHeight + "px";
      content.style.height = content.scrollHeight + "px";
    }
  });
}
