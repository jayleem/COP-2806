//flyout menu
function flyout()
{
    //jQuery code
    var target = $('#hidden-menu');//select the flyoutMenu element
    
    //Logic to enable/disable the flyoutMenu
    if(target.css('display') == 'none')
    {
        $(target).fadeIn(1000);//performn fade in animation 1000ms
    }
    else
    {
        $(target).fadeOut(1000);//performn fade out animation 1000ms
    }
}