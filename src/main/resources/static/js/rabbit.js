
$(function(){
    $('.msg-wrap .send-msg').click(function(){
        var role = $(this).attr('data-role');
        var url;
        if(role == 'direct')
            url  = '/sendDirect';
        else if(role == 'fanout')
            url  = '/sendFanout';
        else if(role == 'topic')
            url  = '/sendTopic';
        var args = {"msg": $('.msg-wrap .msg-content').text(), "time": new Date().getTime()};
        if(role == 'topic')
            args = {"msg": $('.msg-wrap .msg-content').text(), "time": new Date().getTime(), "routingKey": $('.msg-wrap .routing-key').text()};
        $.getJSON(url, args, function(data){
            alert(data.code + "," + data.msg);
        });
    });
});