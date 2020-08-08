$(()=>{
    let homeButton = $(".home-button");
    let orderButton = $(".order-button");

    homeButton.click(e=>{
        window.location.href="/index";
    })
    orderButton.click(e=>{
        window.location.href="../orderitem/list";
    })
})