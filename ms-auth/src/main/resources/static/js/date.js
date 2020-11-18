$(document).ready(function () {
    $('#container2').hide();
    $('#container').css("margin-left", "700px");
    $('input[type=radio][name=radiog_dark]').change(function () {
        if (this.id === 'radio4') {
            $('#container2').show();
            alert("worked")
            $('#container').css("margin-left", "450px");

        } else if (this.id === 'radio5') {
            alert("homme")
            $('#container2').hide();
            $('#container').css("margin-left", "700px");
        }
    });
});