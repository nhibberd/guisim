$(document).ready(function () {
    var send = function (e) {
        e.preventDefault();
        var packet = {
            pitch:  $("#pitchin input").val(),
            roll:  $("#rollin input").val(),
            yaw: $("#yawin input").val()
        }
        $.ajax({
            type: "POST",
            url: "/guisim/",
            dataType: 'json',
            data: JSON.stringify(packet),
            complete: function (data) {
              console.log("response");
            }
        });
    };
    var poll = function () {
        $.ajax({
            url: "/guisim/",
            dataType: 'json',
            data: {},
            success: function (data) {
              $("#pitch").html(data.pitch);
              $("#roll").html(data.roll);
              $("#yaw").html(data.yaw);
              setTimeout(function() { poll(); }, 1000);
            }
        });
    };

    $("#go").click(send);
    poll();
})