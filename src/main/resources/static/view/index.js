function search() {
    var stockCode = $("#stockCode").val();
    $.ajax({
        async: false,
        type: "GET",
        dataType: 'jsonp',
        jsonp: 'callback',
        jsonpCallback: 'callbackfunction',
        url: "http://hq.sinajs.cn/list=sh601006",
        data: "",
        timeout: 3000,
        contentType: "application/json;utf-8",
        success: function(msg) {
            console.log(msg);
        }
    });
}