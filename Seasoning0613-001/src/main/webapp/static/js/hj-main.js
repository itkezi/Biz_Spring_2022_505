document.addEventListener("DOMContentLoaded", () => {
  const a_fb = document.querySelector("a.hj-a-fb");
  const a_bb = document.querySelector("a.hj-a-bb");
  const a_vb = document.querySelector("a.hj-a-vb");

  const v_fb = document.querySelector("video.hj-video-fb");
  const v_bb = document.querySelector("video.hj-video-bb");
  const v_vb = document.querySelector("video.hj-video-vb");

  if (a_fb) {
    a_fb.addEventListener("mouseover", function () {
      v_fb.style.display = "block";
      v_fb.style.zIndex = 70;
      v_fb.play();
    });
    a_fb.addEventListener("mouseout", function () {
      v_fb.style.display = "none";
      v_fb.style.zIndex = 50;
      v_fb.pause();
      v_fb.currentTime = 0;
    });
  }

  if (a_bb) {
    a_bb.addEventListener("mouseover", function () {
      v_bb.style.zIndex = 70;
      v_bb.style.display = "block";
      v_bb.play();
    });
    a_bb.addEventListener("mouseout", function () {
      v_bb.style.display = "none";
      v_bb.style.zIndex = 50;
      v_bb.pause();
      v_bb.currentTime = 0;
    });
  }

  if (a_vb) {
    a_vb.addEventListener("mouseover", function () {
      v_vb.style.zIndex = 70;
      v_vb.style.display = "block";
      v_vb.play();
    });
    a_vb.addEventListener("mouseout", function () {
      v_vb.style.display = "none";
      v_vb.style.zIndex = 50;
      v_vb.pause();
      v_vb.currentTime = 0;
    });
  }
});
