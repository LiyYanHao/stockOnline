function searchStockCode() {
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
function showRegin() {
    $('#myReginModal').modal('show');
}

function search() {
    $.getJSON('https://data.jianshukeji.com/jsonp?filename=json/usdeur.json&callback=?', function (data) {
        var startDate = new Date(data[data.length - 1][0]), // Get year of last data point
            minRate = 1,
            maxRate = 0,
            startPeriod,
            date,
            rate,
            index;
        startDate.setMonth(startDate.getMonth() - 3); // a quarter of a year before last data point
        startPeriod = Date.UTC(startDate.getFullYear(), startDate.getMonth(), startDate.getDate());
        for (index = data.length - 1; index >= 0; index = index - 1) {
            date = data[index][0]; // data[i][0] is date
            rate = data[index][1]; // data[i][1] is exchange rate
            console.log(date);
            if (date < startPeriod) {
                break; // stop measuring highs and lows
            }
            if (rate > maxRate) {
                maxRate = rate;
            }
            if (rate < minRate) {
                minRate = rate;
            }
        }
        // Create the chart
        $('#container').highcharts('StockChart', {
            rangeSelector: {
                selected: 1
            },
            title: {
                text: 'USD to EUR exchange rate'
            },
            yAxis: {
                title: {
                    text: 'Exchange rate'
                },
                plotLines: [{
                    value: minRate,
                    color: 'green',
                    dashStyle: 'shortdash',
                    width: 2,
                    label: {
                        text: 'Last quarter minimum'
                    }
                }, {
                    value: maxRate,
                    color: 'red',
                    dashStyle: 'shortdash',
                    width: 2,
                    label: {
                        text: 'Last quarter maximum'
                    }
                }]
            },
            series: [{
                name: 'USD to EUR',
                data: data,
                tooltip: {
                    valueDecimals: 4
                }
            }]
        });
    });
}
<!--帐号校验-->
$(function () {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            password: {
                message: '密码验证失败',
                validators: {
                    notEmpty: {
                        message: '登录密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 18,
                        message: '登录密码长度必须在6到18位之间'
                    },

                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '登录密码只能包含大写、小写、数字和下划线'
                    }
                }
            },
            rePassword: {
                message: '密码验证失败',
                validators: {
                    identical: {//相同
                        field: 'password', //需要进行比较的input name值
                        message: '两次密码不一致'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
                }
            }
        }
    });
});
