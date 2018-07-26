var checkMoney = (rule, value, callback) => {
    if (!value) {
        return callback(new Error('该值不能为空'));
    }
    if (isNaN(Number(value))) {
        callback(new Error('金额格式不正确'));
    } else {
        if (value.length > 13) {
            callback(new Error('金额过大'));
        } else if (value < 0) {
            callback(new Error('金额不能为负'));
        } else {
            callback();
        }
    }
};
var checkMoneyNull = (rule, value, callback) => {
    if (value) {
        if (isNaN(Number(value))) {
            callback(new Error('金额格式不正确'));
        } else {
            if (value.length > 13) {
                callback(new Error('金额过大'));
            } else if (value < 0) {
                callback(new Error('金额不能为负'));
            } else {
                callback();
            }
        }
    } else {
        callback();
    }
};

var checkRequire = (rule, value, callback) => {
    if (parseFloat(value).toString() == "NaN") {
        if (!value) {
            return callback(new Error('该值不能为空'));
        } else {
            callback();
        }
    } else {
        callback();
    }
};
var checkNum = (rule, value, callback) => {
    if (parseFloat(value).toString() == "NaN") {
        if (!value) {
            return callback(new Error('该值不能为空'));
        }
    }
    if (isNaN(Number(value))) {
        callback(new Error('该值只能填数字'));
    } else {
        if (value.length > 13) {
            callback(new Error('数字过大'));
        } else if (value < 0) {
            callback(new Error('数字不能为负'));
        } else {
            callback();
        }
    }
};
var validNum = (rule, value, callback) => {
    if (parseFloat(value).toString() == "NaN") {
        if (!value) {
            return callback();
        }
    }
    if (isNaN(Number(value))) {
        return callback(new Error('该值只能填数字'));
    } else {
        if (value.length > 13) {
            return callback(new Error('数字过大'));
        } else if (value < 0) {
            return callback(new Error('数字不能为负'));
        } else {
            callback();
        }
    }
};
var checkMonth = (rule, value, callback) => {
    if (!value) {
        return callback(new Error('月份不能为空'));
    }
    if (isNaN(Number(value))) {
        callback(new Error('请输入数字值'));
    } else {
        if (value > 12 || value < 0) {
            callback(new Error('月份格式不正确'));
        } else {
            callback();
        }
    }
};

var checkPersent = (rule, value, callback) => {
    if (!value) {
        return callback(new Error('该值不能为空'));
    }
    if (isNaN(Number(value))) {
        callback(new Error('格式不正确'));
    } else {
        if (value.length > 5) {
            callback(new Error('数值过大'));
        } else {
            callback();
        }
    }
};

export { checkMoney, checkRequire, checkNum, checkMonth, checkPersent, checkMoneyNull,validNum}
