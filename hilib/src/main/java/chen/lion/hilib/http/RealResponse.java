package chen.lion.hilib.http;

/**
 * 下午12:22
 * by chenxiu
 **/
import java.io.InputStream;

public class RealResponse {
    public InputStream inputStream;
    public InputStream errorStream;
    public int code;
    public long contentLength;
    public Exception exception;
}