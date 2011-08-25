$(document).ready(function () {
    var send = function (e) {
        e.preventDefault();
        var packet = {
            data:  $("#data input").val()
        }
        $.ajax({
            type: "POST",
            url: "/dataloader/",
            dataType: 'json',
            data: JSON.stringify(packet),
            complete: function (data) {
              console.log(data.responseText);
            }
        });
    };
    $("#go").click(send);
})