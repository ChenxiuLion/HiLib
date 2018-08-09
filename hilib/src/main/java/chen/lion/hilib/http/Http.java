package chen.lion.hilib.http;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 下午12:12
 * by chenxiu
 **/
public class Http {
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";

    public static final String FILE_TYPE_FILE = "file/*";
    public static final String FILE_TYPE_IMAGE = "image/*";
    public static final String FILE_TYPE_AUDIO = "audio/*";
    public static final String FILE_TYPE_VIDEO = "video/*";

    /**
     * get请求
     * @param url：url
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void get(String url, HiCallback callBack) {
        get(url, null, null, callBack);
    }

    /**
     * get请求，可以传递参数
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void get(String url, Map<String, String> paramsMap, HiCallback callBack) {
        get(url, paramsMap, null, callBack);
    }

    /**
     * get请求，可以传递参数
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void get(String url, Map<String, String> paramsMap, Map<String, String> headerMap, HiCallback callBack) {
        new RequestUtil(METHOD_GET, url, paramsMap, headerMap, callBack).execute();
    }

    /**
     * post请求
     * @param url：url
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void post(String url, HiCallback callBack) {
        post(url, null, callBack);
    }

    /**
     * post请求，可以传递参数
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void post(String url, Map<String, String> paramsMap, HiCallback callBack) {
        post(url, paramsMap, null, callBack);
    }

    /**
     * post请求，可以传递参数
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void post(String url, Map<String, String> paramsMap, Map<String, String> headerMap, HiCallback callBack) {
        new RequestUtil(METHOD_POST,url,paramsMap,headerMap,callBack).execute();
    }
    /**
     * post请求，可以传递参数
     * @param url：url
     * @param jsonStr：json格式的键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void postJson(String url, String jsonStr, HiCallback callBack) {
        postJson(url, jsonStr, null, callBack);
    }

    /**
     * post请求，可以传递参数
     * @param url：url
     * @param jsonStr：json格式的键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void postJson(String url, String jsonStr, Map<String, String> headerMap, HiCallback callBack) {
        new RequestUtil(url,jsonStr,headerMap,callBack).execute();
    }




    /**
     * post请求，上传单个文件
     * @param url：url
     * @param file：File对象
     * @param fileKey：上传参数时file对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。还可以重写onProgress方法，得到上传进度
     */
    public  void uploadFile(String url, File file, String fileKey, String fileType, HiCallback callBack) {
        uploadFile(url, file, fileKey,fileType, null, callBack);
    }

    /**
     * post请求，上传单个文件
     * @param url：url
     * @param file：File对象
     * @param fileKey：上传参数时file对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。还可以重写onProgress方法，得到上传进度
     */
    public  void uploadFile(String url, File file, String fileKey, String fileType, Map<String, String> paramsMap, HiCallback callBack) {
        uploadFile(url, file,fileKey, fileType, paramsMap, null, callBack);
    }

    /**
     * post请求，上传单个文件
     * @param url：url
     * @param file：File对象
     * @param fileKey：上传参数时file对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。还可以重写onProgress方法，得到上传进度
     */
    public  void uploadFile(String url, File file, String fileKey, String fileType, Map<String, String> paramsMap, Map<String, String> headerMap, HiCallback callBack) {
        new RequestUtil(url,file,null,null,fileKey,fileType,paramsMap,headerMap,callBack).execute();
    }


    /**
     * post请求，上传多个文件，以list集合的形式
     * @param url：url
     * @param fileList：集合元素是File对象
     * @param fileKey：上传参数时fileList对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void uploadListFile(String url, List<File> fileList, String fileKey, String fileType, HiCallback callBack) {
        uploadListFile(url, fileList, fileKey, fileType,null, callBack);
    }

    /**
     * post请求，上传多个文件，以list集合的形式
     * @param url：url
     * @param fileList：集合元素是File对象
     * @param fileKey：上传参数时fileList对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public void uploadListFile(String url, List<File> fileList, String fileKey, String fileType, Map<String, String> paramsMap, HiCallback callBack) {
        uploadListFile(url, fileList, fileKey, fileType,paramsMap, null, callBack);
    }

    /**
     * post请求，上传多个文件，以list集合的形式
     * @param url：url
     * @param fileList：集合元素是File对象
     * @param fileKey：上传参数时fileList对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public void uploadListFile(String url, List<File> fileList, String fileKey, String fileType, Map<String, String> paramsMap, Map<String, String> headerMap, HiCallback callBack) {
        new RequestUtil(url,null,fileList,null,fileKey,fileType,paramsMap,headerMap,callBack).execute();
    }

    /**
     * post请求，上传多个文件，以map集合的形式
     * @param url：url
     * @param fileMap：集合key是File对象对应的键，集合value是File对象
     * @param fileType：File类型，是image，video，audio，file
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public void uploadMapFile(String url, Map<String, File> fileMap, String fileType, HiCallback callBack) {
        uploadMapFile(url, fileMap, fileType, null, callBack);
    }

    /**
     * post请求，上传多个文件，以map集合的形式
     * @param url：url
     * @param fileMap：集合key是File对象对应的键，集合value是File对象
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public void uploadMapFile(String url, Map<String, File> fileMap, String fileType, Map<String, String> paramsMap, HiCallback callBack) {
        uploadMapFile(url, fileMap, fileType, paramsMap, null, callBack);
    }

    /**
     * post请求，上传多个文件，以map集合的形式
     * @param url：url
     * @param fileMap：集合key是File对象对应的键，集合value是File对象
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public void uploadMapFile(String url, Map<String, File> fileMap, String fileType, Map<String, String> paramsMap, Map<String, String> headerMap, HiCallback callBack) {
        new RequestUtil(url,null,null,fileMap,null,fileType,paramsMap,headerMap,callBack).execute();
    }

    /**
     * 加载图片
     */
    public void getBitmap(String url, HiCallback.ToBitmap callBack) {
        getBitmap(url, null, callBack);
    }
    /**
     * 加载图片，带参数
     */
    public void getBitmap(String url,Map<String, String> paramsMap,  HiCallback.ToBitmap callBack) {
        get(url, paramsMap, null, callBack);
    }

    /**
     * 下载文件,不带参数
     */
    public void downloadFile(String url, HiCallback.ToFile callBack) {
        downloadFile(url,null,callBack);
    }

    /**
     * 下载文件,带参数
     */
    public void downloadFile(String url, Map<String, String> paramsMap, HiCallback.ToFile callBack) {
        downloadFile(url, paramsMap, null, callBack);
    }
    /**
     * 下载文件,带参数,带请求头
     */
    public void downloadFile(String url, Map<String, String> paramsMap,Map<String, String> headerMap, HiCallback.ToFile callBack) {
        get(url, paramsMap, headerMap, callBack);
    }

}
