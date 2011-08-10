$(document).ready(function () {
    var send = function (e) {
        e.preventDefault();
        var packet = {
            data:  $("#input input").val()
        }
        $.ajax({
            type: "POST",
            url: "/guisim/",
            dataType: 'json',
            data: JSON.stringify(packet),
            complete: function (data) {
              console.log(data.responseText);
            }
        });
    };
    $("#go").click(send);
})