window.addEventListener("load",()=>{

    let showingClass = "showing";
    let firstSlide = document.querySelector(".slide:nth-child(1)");
    let lastSlide = document.querySelector(".slide:nth-child(2)");
    let leftBtn = document.querySelector(".left");
    let rightBtn = document.querySelector(".right");

    rightBtn.onclick = ()=>{
        let currentSlide = document.querySelector(".showing");
        if (currentSlide) {
          let nextSlide = currentSlide.nextElementSibling;
          currentSlide.classList.remove(showingClass);
            if(nextSlide != leftBtn){
              nextSlide.classList.add(showingClass);
            } else{
              firstSlide.classList.add(showingClass);
            }
        }
    }

    leftBtn.onclick = ()=>{
        let currentSlide = document.querySelector(".showing");
        if (currentSlide){
        let prevSlide = currentSlide.previousElementSibling;
        currentSlide.classList.remove(showingClass);
          if(prevSlide){
            prevSlide.classList.add(showingClass);
          }
          else{
              lastSlide.classList.add(showingClass);
          }
        }
    }
    
    function slide() {
        let currentSlide = document.querySelector(".showing");
        if (currentSlide) {
          let nextSlide = currentSlide.nextElementSibling;
          currentSlide.classList.remove(showingClass);
            if(nextSlide != leftBtn){
              nextSlide.classList.add(showingClass);
            } else{
              firstSlide.classList.add(showingClass);
            }
        }
    }
    
    
    setInterval(slide, 4000);

})