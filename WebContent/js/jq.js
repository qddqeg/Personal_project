/**
 * 
 */
$(function (){
$(window).scroll(function(){
        var locaion = $(document).scrollTop();
        $('.scrolltop').text(locaion)

        if($(document).scrollTop()>=100){
            $('.right_menu').css({
                top:'200px'
            })    
        }else{
            $('.right_menu').css({
                top:'50%'
            })    
        } 
    })
});