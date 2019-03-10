var cookieManager = {

    flush: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "CookieManagerPlugin",
            "flush",
            []
        );
    },
};

module.exports = cookieManager;
