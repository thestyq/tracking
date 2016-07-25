function getResolutionData() {
    resolution["windowScreenHeight"] = window.screen.height;
    resolution["windowScreenWidth"] = window.screen.width;
    resolution["windowScreenAvailableHeight"] = window.screen.availHeight;
    resolution["windowScreenAvailableWidth"] = window.screen.availWidth;
}

function getBrowserData() {
    // Opera 8.0+
    browserData["isOpera"] = (!!window.opr && !!opr.addonArray) || !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
    // Firefox 1.0+
    browserData["isFirefox"] = typeof InstallTrigger !== 'undefined';
    // At least Safari 3+: "[object HTMLElementConstructor]"
    browserData["isSafari"] = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
    // Internet Explorer 6-11
    browserData["isIE"] = /*@cc_on!@*/false || !!document.documentMode;
    // Edge 20+
    browserData["isEdge"] = !infoArray["isIE"] && !!window.StyleMedia;
    // Chrome 1+
    browserData["isChrome"] = !!window.chrome && !!window.chrome.webstore;
    // Blink engine detection
    browserData["isBlink"] = (infoArray["isChrome"] || infoArray["isOpera"]) && !!window.CSS;
}

function detectFont(font) {
    var detector = new Detector();
    var isDetected = detector.detect(font);
    if (isDetected) {
        fontArray.push(font);
    }
}

function detectPlugin(plugin) {
    var pluginName = plugin.substring(0,1).toLocaleLowerCase() + plugin.substring(1).split(' ').join("");
    plugins[pluginName] = pluginlist.indexOf(plugin)!=-1;
}

function detectFirefoxAddon(addon) {
    var script = document.createElement('script');
    script.onload = function () {
        var addonName = addon.substring(9);
        var slashIndex = addonName.indexOf("/");
        addonArray.push(addonName.substring(0, slashIndex));
    };
    script.src = addon;
    document.getElementsByTagName('head')[0].appendChild(script);
}

function getLocalisation() {
    $.getJSON('//www.geoplugin.net/json.gp?jsoncallback=?', function (data) {
        localisation["request"] = data.geoplugin_request;
        localisation["status"] = data.geoplugin_status;
        localisation["region"] = data.geoplugin_region;
        localisation["areaCode"] = data.geoplugin_areaCode;
        localisation["dmaCode"] = data.geoplugin_dmaCode;
        localisation["countryCode"] = data.geoplugin_countryCode;
        localisation["countryName"] = data.geoplugin_countryName;
        localisation["continentCode"] = data.geoplugin_continentCode;
        localisation["latitude"] = data.geoplugin_latitude;
        localisation["longtitude"] = data.geoplugin_longitude;
        localisation["regionCode"] = data.geoplugin_regionCode;
        localisation["regionName"] = data.geoplugin_regionName;
        localisation["currencyCode"] = data.geoplugin_currencyCode;
        localisation["currencySymbol"] = data.geoplugin_currencySymbol;
        localisation["currencyConverter"] = data.geoplugin_currencyConverter;
    });
}