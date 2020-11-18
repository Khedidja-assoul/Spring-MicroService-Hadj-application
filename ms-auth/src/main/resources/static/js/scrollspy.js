$(document).ready(function(){
    let scroll_link = $('.scroll');

    //smooth scrolling -----------------------
    scroll_link.click(function(e){
        e.preventDefault();
        let url = $('body').find($(this).attr('href')).offset().top;
        $('html, body').animate({
            scrollTop : url
        },700);
        $(this).parent().addClass('active');
        $(this).parent().siblings().removeClass('active');
        return false;
    });
});