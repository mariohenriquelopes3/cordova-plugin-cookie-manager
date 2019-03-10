package io.clay.cookiemanagerplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public class CookieManagerPlugin extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if(action.equals("flush")) {
      this.flush(callbackContext);
      return true;
    }
    return false;
  }

  private void flush(CallbackContext callbackContext) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
      CookieManager.getInstance().flush();
    } else {
      CookieSyncManager.getInstance().sync();
    }
    callbackContext.success();
  }
}
