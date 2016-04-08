function getResolutionData() {
    infoArray["window_screen_height"] = window.screen.height;
    infoArray["window_screen_width"] = window.screen.width;
    infoArray["window_screen_availHeight"] = window.screen.availHeight;
    infoArray["window_screen_availWidth"] = window.screen.availWidth;
}

function getBrowserData() {
    // Opera 8.0+
    infoArray["isOpera"] = (!!window.opr && !!opr.addons) || !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
    // Firefox 1.0+
    infoArray["isFirefox"] = typeof InstallTrigger !== 'undefined';
    // At least Safari 3+: "[object HTMLElementConstructor]"
    infoArray["isSafari"] = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
    // Internet Explorer 6-11
    infoArray["isIE"] = /*@cc_on!@*/false || !!document.documentMode;
    // Edge 20+
    infoArray["isEdge"] = !infoArray["isIE"] && !!window.StyleMedia;
    // Chrome 1+
    infoArray["isChrome"] = !!window.chrome && !!window.chrome.webstore;
    // Blink engine detection
    infoArray["isBlink"] = (infoArray["isChrome"] || infoArray["isOpera"]) && !!window.CSS;
}

function detectFont(font) {
    var detector = new Detector();
    var isDetected = detector.detect(font);
    if (isDetected) {
        fontArray.push(font);
    }
}

function detectFirefoxAddon(addon) {
    var script = document.createElement('script');
    script.onload = function () {
        var addonName = addon.substring(9);
        var slashIndex = addonName.indexOf("/");
        addons.push(addonName.substring(0, slashIndex));
    }
    script.src = addon;
    document.getElementsByTagName('head')[0].appendChild(script);
}