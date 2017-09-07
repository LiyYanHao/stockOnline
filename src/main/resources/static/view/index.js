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
function showLogin() {
    $('#repassword').hide();
    $('#myReginModal').modal('show');
}
function queryUserInfo() {

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

/**
 * 登录
 */
function submitLogin(){
    $('#myReginModal2').data('bootstrapValidator').validate();//开启校验
    var flag = $("#myReginModal2").data("bootstrapValidator").isValid();//校验状态
    if(!flag){
        return;
    }

    var email = $("LoginEmail").val();
    var password = $("#passwordLogin").val();
    console.log(email+","+password);
    $.post("http://localhost:8080/stock/user/sendEmailCheckCode",{email:email,password:password},function(result){
        if(result.status && result.status == 1){

        }
/**
 * 注册
 */
function submitRegisterInfo(){
    //
    $('#regForm').data('bootstrapValidator').validate();//开启校验
    var flag = $("#regForm").data("bootstrapValidator").isValid();//校验状态
    if(!flag){
    return;
    }

    var email = $("#email").val();
    var password = $("#password").val();
    console.log(email+","+password);
    $.post("http://localhost:8080/stock/user/sendEmailCheckCode",{email:email,password:password},function(result){
        if(result.status && result.status == 1){
            $('#myReginModal').modal('hide');
                    //替换按钮为用户名
            $("#showReginId").hide();
            $("#userInfo").html("用户已经登录："+result.username);

                }else{
                    var errorMsg = "服务端错误";
                    errorMsg = result.MSG;
                    $("#errorMsg").html(errorMsg).show();


                }
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
            confirmPassword: {
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
