/**
 * Created by CHATHURA on 2015-02-10.
 * Custom Scripts
 */

//Materialize Initialization
$(document).ready(function () {
    $(".dropdown-button").dropdown({
        hover: false
    });
    $(".button-collapse").sideNav();
    $('.modal-trigger').leanModal({
        dismissible: true,
        in_duration: 200,
        out_duration: 200
    });
});
