//메뉴열닫
$(function(){

    var body = $(".admin-body");
    var adminTitle = body.find(".admin-menu-title");

    var i = 0 ;

    adminTitle.click(function(){

        $(this).next().slideToggle();

        if(i%2==0)
            $(this).css('background-image','url("../images/up-icon.png")');
        else
            $(this).css('background-image','url("../images/down-icon.png")');
        
        i++;
    
    });
});






