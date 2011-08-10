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
              console.log(data.responseText);
            }
        });
    };
    var poll = function () {
        $.ajax({
            url: "/guisim/",
            dataType: 'json',
            data: {},
            success: function (data) {
              //alert(data.pitch);
              $("#pitch").html(data.pitch);
              $("#roll").html(data.roll);
              $("#yaw").html(data.yaw);
              setTimeout(function() { poll(); }, 500);
            }
        });
    };

    $("#go").click(send);
    //test
    poll();
})