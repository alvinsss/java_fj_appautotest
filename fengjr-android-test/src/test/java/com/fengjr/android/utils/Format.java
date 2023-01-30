package com.fengjr.android.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author suetming ( suetming.ma@gmail.com )
 */
public class Format {

	public static String simpleDateformat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yy年M月d日 HH:mm");
		return format.format(date);
	}

	public static String simpleDateformat2(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		return format.format(date);
	}

	public static String simpleDateTimeformat(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	public static String simpleDateTimeformatWithoutTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public static int formatTimeToYear(long milliseconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliseconds);
		return calendar.get(Calendar.YEAR);
	}

	public static String formatHourOfOut(long milliseconds, int timeOut) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d1 = new Date();

			Date d2 = new Date(milliseconds);
			long diff = d1.getTime() - d2.getTime();
			long time = timeOut - diff / 1000 / 60 / 60;
			// long time=timeOut*1000*60*60-diff;
			long year = time / 24 / 30 / 365;
			long mounth = (time - year * 24 * 30 * 365) / 24 / 30;
			long days = (time - mounth * 30 * 24) / 24;
			long hours = (time - (days * 24));
			long minutes = (time * 60 - (hours * 60));
			if (year > 0) {
				if (mounth >= 6) {
					year = year + 1;
				}
				return year + "年";
			} else {
				if (mounth > 0) {
					if (days >= 15) {
						mounth = mounth + 1;
					}
					return mounth + "个月";
				} else {
					if (days > 0) {
//						if (hours >= 12) {
//							days = days + 1;
//						}
						return days + "天";
					} else {
						if (hours > 0) {
//							if (minutes >= 30) {
//								hours = hours + 1;
//							}
							if(hours>1){
								return (hours-1) + "小时";
							
							}
							return hours + "小时";
						} else {
							
							if (minutes > 0) {
								return 1+"小时";
							}
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0 + "小时";
	}

	static public String formatMillis(long val) {

		if (val > 3600000 * 24) {
			return String.format("%1$d天%2$d小时%3d分钟%4$d秒", (val / 3600000 / 24),
					(val % (3600000 * 24)) / 3600000, (val % 3600000) / 60000,
					(val % 60000) / 1000);
		} else if (val <= 3600000 * 24 && val > 3600000) {
			return String.format("%1$d小时%2d分钟%3$d秒", val / 3600000,
					((val % 3600000) / 60000), ((val % 60000) / 1000));
		} else if (val <= 3600000 && val > 60000) {
			return String.format("%1d分钟%2$d秒", val / 60000,
					((val % 60000) / 1000));
		} else if (val <= 60000) {
			return String.format("%1$d秒", (val / 1000));
		}
		return "";
	}

	static public String formatMillis2(long val) {

		if (val > 3600000 * 24) {
			return String.format("%1$2d天%2$2d小时%3$2d分", (val / 3600000 / 24),
					(val % (3600000 * 24)) / 3600000, (val % 3600000) / 60000);
		} else if (val <= 3600000 * 24 && val > 3600000) {
			return String.format("%1$2d小时%2$2d分", val / 3600000,
					((val % 3600000) / 60000));
		} else if (val <= 3600000 && val > 60000) {
			return String.format("%1$2d分", val / 60000);
		} else if (val <= 60000) {
			return String.format("%1$2d秒", (val / 1000));
		}
		return "";
	}

	static public String formatMillisToDays(long val) {

		if (val > 3600000 * 24) {
			return String.format("剩余%1$d天", (val / 3600000 / 24));
		} else {
			return "不到1天";
		}
	}

	static public String getFormatter(String str) {
		NumberFormat n = NumberFormat.getNumberInstance();
		double d;
		String outStr = null;
		try {
			d = Double.parseDouble(str);
			outStr = n.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outStr;
	}

	static public String getDecimalFormat(String str) {
		DecimalFormat fmt = new DecimalFormat("##,###,###,###,##0.00000");
		String outStr = null;
		double d;
		try {
			d = Double.parseDouble(str);
			outStr = fmt.format(d);
		} catch (Exception e) {
		}
		return outStr;
	}

	static public String getDecimalFormatWithNoPoint(String str) {
		DecimalFormat fmt = new DecimalFormat("##,###,###,###,##0");
		String outStr = null;
		double d;
		try {
			d = Double.parseDouble(str);
			outStr = fmt.format(d);
		} catch (Exception e) {
		}
		return outStr;
	}

	static public String getCurrency(String str) {
		NumberFormat n = NumberFormat.getCurrencyInstance();
		double d;
		String outStr = null;
		try {
			d = Double.parseDouble(str);
			outStr = n.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outStr;
	}

	static public String getCurrency(double d) {
		NumberFormat n = NumberFormat.getCurrencyInstance();
		String outStr = null;
		try {
			outStr = n.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outStr.subSequence(1, outStr.length()).toString();
	}

	static public String getCurrencyWithoutPoint(double d) {
		NumberFormat n = NumberFormat.getCurrencyInstance();
		String outStr = null;
		try {
			outStr = n.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int idx = outStr.lastIndexOf(".");
		return outStr.substring(0, idx);
	}

	/**
	 * no ￥
	 * 
	 * @param d
	 * @return
	 */
	static public String getCurrencyWithoutPoint_(double d) {
		NumberFormat n = NumberFormat.getCurrencyInstance();
		String outStr = null;
		try {
			outStr = n.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int idx = outStr.lastIndexOf(".");
		return outStr.substring(1, idx);
	}

	public static String getCurrencyCommontFormat(double value) {
		String currency;

		// 大于亿元
		if (value >= 100000000) {
			if ((value % 100000000) > 0) {
				currency = String.format(Locale.getDefault(), "%1$.2f亿",
						value / 100000000);
			} else {
				currency = String.format(Locale.getDefault(), "%1$.0f亿",
						value / 100000000);
			}
		}
		// 大于千万
		else if (value >= 10000000) {
			if ((value % 10000000) > 0) {
				currency = String.format(Locale.getDefault(), "%1$.2f万",
						value / 10000);
			} else {
				currency = String.format(Locale.getDefault(), "%1$.0f万",
						value / 10000);
			}
		}
		// 1万以上
		else if (value >= 10000) {
			if ((value % 10000) > 0) {
				currency = String.format(Locale.getDefault(), "%1$.2f万",
						value / 10000);
			} else {
				currency = String.format(Locale.getDefault(), "%1$.0f万",
						value / 10000);
			}
		}
		// 1万以内
		else {
			currency = String.format(Locale.getDefault(), "%1$.0f元", value);
		}

		return currency;
	}
}
