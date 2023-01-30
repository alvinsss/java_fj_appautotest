package android.content;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fengjr.api.R;

import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.util.SAXValue;


public class Context {

	public static final String CONNECTIVITY_SERVICE = null;
	
	static {
		try {
			SAXValue.parser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConnectivityManager getSystemService(String connectivityService) {
		throw new  UnsupportedOperationException(getClass().getName() + ":" + connectivityService);
	}

	public Resources getResources() {
		throw new  UnsupportedOperationException(getClass().getName());
	}

	public String getString(int baseCc, String corpationId) {
		String raw = getString(baseCc);
		return String.format(raw, corpationId);
	}

	public String getString(int resid) {
		Class<?> c = R.string.class;
		try {
			Field[] resids = c.getFields();
			for (int i = 0; i < resids.length; i++) {
				int value = resids[i].getInt(null);
				if (resid == value) {
					String name = resids[i].getName();
					String text = SAXValue.getValue(name);
					Logger.getLogger(getClass().getName()).log(Level.INFO, resid + "," + text);
					return text;
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public String getString(int baseCc, String loanId, double amount) {
		String raw = getString(baseCc);
		return String.format(raw, loanId, amount);
	}

	public String getString(int baseCc, String projectId,
			String investId) {
		String raw = getString(baseCc);
		return String.format(raw, projectId, investId);
	}

	public SharedPreferences getSharedPreferences(String appSharedPrefs,
			String modePrivate) {
		
		return new SharedPreferences();
	}

	public Context getApplicationContext() {
		return this;
	}


}
