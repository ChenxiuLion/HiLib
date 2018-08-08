package chen.lion.hilib.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者 by Chenxiu on 2015/12/29 0029.
 * 描述：
 * 判断--对象/字符串/集合/数组是否为空
 */
public class GeneralUtils {
	
	public final static String	SYMBOL_CHAR = "\\s|\\-|\\+|\\(|\\)";//|\\r
	/**
	 * 判断对象是否为空 
     * @param Object
     * @author roffee.com 
     * @return boolean
     * @throws  
     */
	public static boolean isNull(Object o) {
        return o == null ? true : false;
    }
	/**
	 * 判断list是否为空 
     * @param List<?> 
     * @author roffee.com 
     * @return boolean
     * @throws  
     */
    public static boolean isNull(List<?> list) {
        return list == null || list.size() == 0 ? true : false;
    }
    /**
	 * 判断字串是否为空 
     * @param String 
     * @author roffee.com 
     * @return boolean
     * @throws  
     */
    public static boolean isNull(String str) {
        return TextUtils.isEmpty(str) ? true : false;
    }
    /**
	 * 判断map是否为空 
     * @param Map<?, ?> 
     * @author roffee.com 
     * @return boolean
     * @throws  
     */
    public static boolean isNull(Map<?, ?> map) {
        return map == null ? true : map.isEmpty();
    }
    /**
	 * 判断string[]是否为空 
     * @param String[] 
     * @author roffee.com 
     * @return boolean
     * @throws  
     */
    public static  boolean isNull(String[] arry){
		return arry == null ? true : (arry.length == 0 ? true : false);
	}
    /**
	 * 页面跳转 
     * @param Context 
     * @param Class<?> 目标页面类
     * @author roffee.com 
     * @return void
     * @throws  
     */
    public static void forwardTargetActivity(Context context, Class<?> targetActivity) {
		Intent intent = new Intent(context, targetActivity);
		context.startActivity(intent);
	}
    /**
	 * 页面跳转 
     * @param Activity 发页面对象
     * @param Class<?> 目标页面类
     * @param boolean 是否关闭发起页面
     * @author roffee.com 
     * @return void
     * @throws  
     */
	public static void forwardTargetActivity(Activity currActivity, Class<?> targetActivity, 
			boolean finish) {
		Intent intent = new Intent(currActivity, targetActivity);
		currActivity.startActivity(intent);
		if(finish){
			currActivity.finish();
		}
	}
	/**
	 * 页面跳转 
     * @param Activity 发页面对象
     * @param Class<?> 目标页面类
     * @param Bundle intent传bundle值
     * @author roffee.com 
     * @return void
     * @throws  
     */
	public static void forwardTargetActivity(Activity currActivity, Class<?> targetActivity, 
			Bundle bundle) {
		Intent intent = new Intent(currActivity, targetActivity);
		if(bundle != null){
			intent.putExtras(bundle);
		}
		currActivity.startActivity(intent);
	}
	/**
	 * 页面跳转 
     * @param Activity 发页面对象
     * @param Class<?> 目标页面类
     * @param boolean 是否关闭发起页面
     * @param Bundle intent传bundle值
     * @author roffee.com 
     * @return void
     * @throws  
     */
	public static void forwardTargetActivity(Activity currActivity, Class<?> targetActivity, 
			Bundle bundle, boolean finish) {
		Intent intent = new Intent(currActivity, targetActivity);
		if(bundle != null){
			intent.putExtras(bundle);
		}
		currActivity.startActivity(intent);
		if(finish){
			currActivity.finish();
		}
	}
	/**
	 * 页面跳转，接收返回值 
     * @param Activity 发页面对象 
     * @param Class<?> 目标页面类
     * @param int requestCode 请求识别码
     * @author roffee.com 
     * @return void
     * @throws  
     */
	public static void forwardTargetActivityForResult(Activity currActivity, Class<?> targetActivity, int requestCode) {
		Intent intent = new Intent(currActivity, targetActivity);
		currActivity.startActivityForResult(intent, requestCode);
	}
	/**
	 * 页面跳转，接收返回值 
     * @param Activity 发页面对象 
     * @param Class<?> 目标页面类
     * @param int requestCode 请求识别码
     * @param Bundle intent传bundle值
     * @author roffee.com 
     * @return void
     * @throws  
     */
	public static void forwardTargetActivityForResult(Activity currActivity, Class<?> targetActivity, 
			Bundle bundle, int requestCode) {
		Intent intent = new Intent(currActivity, targetActivity);
		if(bundle != null){
			intent.putExtras(bundle);
		}
		currActivity.startActivityForResult(intent, requestCode);
	}
	/**
	 * 页面设置传值 
     * @param Activity 发页面对象 
     * @param Class<?> 目标页面类
     * @author roffee.com 
     * @return void
     * @throws WriterException 
     */
	public static void activitySetResult(Activity currActivity, Class<?> targetActivity) {
		Intent intent = new Intent(currActivity, targetActivity);
		currActivity.setResult(Activity.RESULT_OK, intent);
	}
	/**
	 * 页面设置传值 
     * @param Activity 发页面对象 
     * @param Class<?> 目标页面类
     * @param Bundle intent传bundle值
     * @author roffee.com 
     * @return void
     * @throws  
     */
	public static void activitySetResult(Activity currActivity, Class<?> targetActivity, 
			Bundle bundle) {
		Intent intent = new Intent(currActivity, targetActivity);
		
		intent.putExtras(bundle);
		currActivity.setResult(Activity.RESULT_OK, intent);
	}
	/**
	 * 页面设置传值 
     * @param Activity 发页面对象 
     * @param Class<?> 目标页面类
     * @param Bundle intent传bundle值
     * @param boolean 是否关闭发起页面
     * @author roffee.com 
     * @return void
     * @throws  
     */
	public static void activitySetResult(Activity currActivity, Class<?> targetActivity, 
			Bundle bundle, boolean finish) {
		Intent intent = new Intent(currActivity, targetActivity);
		
		intent.putExtras(bundle);
		currActivity.setResult(Activity.RESULT_OK, intent);
		if(finish){
			currActivity.finish();
		}
	}
	/**
	 * 页面设置传值 
     * @param String pn 
     * @author roffee.com 
     * @return boolean
     * @throws  
     */
	public static boolean isMobilePhoneNo(String No) {
		if(isNull(No)){
			return false;
		}
		try {
			Pattern p = Pattern.compile("^[1][3,4,5,7,8]{1}[0-9]{9}$");
			Matcher m = p.matcher(No);
			return m.matches();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	/**
	 * 页面设置传值 
     * @param String pn 
     * @author roffee.com 
     * @return boolean
     * @throws  
     */
	public static boolean isMobilePhoneNo(String No, boolean wipe) {
		if(isNull(No)){
			return false;
		}
		try {
			String pn;
			if(wipe){
				pn = No.replaceAll(SYMBOL_CHAR, "");
			}else{
				pn = No;
			}
			if(!isNumeric(pn)){
				return false;
			}
			if(pn.length() > 11){
				pn = pn.substring(pn.length() - 11);
			}
			Pattern p = Pattern.compile("^[1][3,4,5,7,8]{1}[0-9]{9}$");
			Matcher m = p.matcher(pn);
			return m.matches();
		} catch (Exception e) {
		}
		return false;
	}
	public static boolean isNumeric(String str){
		if(isNull(str)){
			return false;
		}
	     Pattern pattern = Pattern.compile("^[0-9]*$"); 
	     return pattern.matcher(str).matches();    
	}
	public static boolean isEnglish(String str){
		if(isNull(str)){
			return false;
		}
	     Pattern pattern = Pattern.compile("^[A-Za-z]+$");//("[A-Za-z]*"); 
	     return pattern.matcher(str).matches();    
	}
	public static boolean isContainCn(String str){
		if(isNull(str)){
			return false;
		}
		//str.matches("[\\u4E00-\\u9FA5]+");
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
		Matcher m = p.matcher(str);
		return m.find();
	}
	public static boolean isChinese(String str){
		if(isNull(str)){
			return false;
		}
		Pattern p = Pattern.compile("^[\u4e00-\u9fa5]+$");
		Matcher m = p.matcher(str);
		return m.matches();
	}
	public static boolean isChinese(char c){
		Pattern p = Pattern.compile("^[\u4e00-\u9fa5]+$");
		Matcher m = p.matcher(new String(new char[]{c}));
		return m.matches();
	}
	public static boolean isNumericOrEnglish(String str){
        if(isNull(str)){
            return false;
        }
         Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$"); 
         return pattern.matcher(str).matches();    
    }
	public static boolean isNumericOrEnglishOrCn(String str){
        if(isNull(str)){
            return false;
        }
         Pattern pattern = Pattern.compile("^[A-Za-z0-9\u4e00-\u9fa5]+$"); 
         return pattern.matcher(str).matches();    
    }
	public static void hideInputMethod(Context context, IBinder windowToken){
		try {
			InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(windowToken, 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
     * 拨打电话
     * @param context
     * @param phoneNumber
     * @return
     */
    public static boolean makeCall(Context context, String phoneNumber){
        if(isNull(phoneNumber)){
            Toast.makeText(context, "电话号码为空", Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 是否是邮箱
     * @param str
     * @return
     */
    public static Boolean isEmail(String str) {
 		if (isNull(str)) {
			return false;
		}
 		Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
 		Matcher matcher = emailPattern.matcher(str);
 		if (matcher.find()) {
 			return true;
 		}else{
 			return false;
 		}
 	}
	
	/**
	 * 判断手机号是否正确
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles){
		Pattern p = Pattern.compile("^((1[3,5,6,8][0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
	  return m.matches();
}
}
