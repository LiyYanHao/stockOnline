/**
 * Created by lyh on 17-5-25.
 */
define(function (require, exports, module) {
    var moduleA = require('add.js');
    console.log(moduleA.add(10,20));
});

seajs.use('jquery-3.2.0.js');