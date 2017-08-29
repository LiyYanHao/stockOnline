/**
 * Created by lyh on 17-5-25.
 */
define(function (require, exports, module) {
    //隐性:var exports = module.exports
    function add(a, b) {
        return +a +b;
    }
    module.exports.add = add;
    //隐性:return module.exports
})
