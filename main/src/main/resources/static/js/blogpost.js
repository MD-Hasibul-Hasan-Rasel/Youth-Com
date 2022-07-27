const like_count = document.querySelectorAll(".like_count");
const thumbs_up_image = document.querySelectorAll(".thumbs_up_image");
const thumbs_up_button = document.querySelectorAll(".thumbs_up_button");

thumbs_up_button.forEach((thumbs_up_btn) =>
  thumbs_up_btn.addEventListener("click", function () {
    thumbs_up_image.forEach(function (thumbs_up_img) {
      thumbs_up_img.src = "svg/thumbs_up_blue.svg";
    });
    like_count.forEach(function (like) {
      like.style.color = "#3fa9f5";
    });
  })
);
