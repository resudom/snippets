/*
package Fuck;

import okhttp3.*;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }
    private final Logger logger;
    private final java.util.logging.Level logLevel;

    public HttpLoggingInterceptor() {
        this(Logger.getLogger(String.valueOf(HttpLoggingInterceptor.class)), java.util.logging.Level.INFO);
    }

    public HttpLoggingInterceptor(Logger logger, java.util.logging.Level logLevel) {
        this.logLevel = logLevel;
        this.logger = logger;
    }



    private volatile Level level = Level.NONE;

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) throw new NullPointerException("level == null. Use Level.NONE instead.");
        this.level = level;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Level level = this.level;

        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }

        boolean logBody = level == Level.BODY;
        boolean logHeaders = logBody || level == Level.HEADERS;

        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;

        Connection connection = chain.connection();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        String requestStartMessage = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
        if (!logHeaders && hasRequestBody) {
            requestStartMessage += " (" + requestBody.contentLength() + "-byte body)";
        }

        StringBuilder logBuilder = new StringBuilder(requestStartMessage + LINE_SEPARATOR);

        if (logHeaders) {
            if (hasRequestBody) {
                // Request body headers are only present when installed as a network interceptor. Force
                // them to be included (when available) so there values are known.
                if (requestBody.contentType() != null) {
                    logBuilder.append("\t" +"Content-Type: " + requestBody.contentType() + LINE_SEPARATOR);
                }
                if (requestBody.contentLength() != -1) {
                    logBuilder.append("\t" +"Content-Length: " + requestBody.contentLength() + LINE_SEPARATOR);
                }
            }

            Headers headers = request.headers();
            for (int i = 0, count = headers.size(); i < count; i++) {
                String name = headers.name(i);
                // Skip headers from the request body as they are explicitly logged above.
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    logBuilder.append("\t" +name + ": " + headers.value(i) + LINE_SEPARATOR);
                }
            }

            if (!logBody || !hasRequestBody) {
                logBuilder.append("--> END " + request.method() + LINE_SEPARATOR);
            } else if (bodyEncoded(request.headers())) {
                logBuilder.append("--> END " + request.method() + " (encoded body omitted)" + LINE_SEPARATOR);
            } else {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);

                Charset charset = UTF8;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }

                if (isPlaintext(buffer)) {
                    logBuilder.append("\t" +buffer.readString(charset) + LINE_SEPARATOR);
                    logBuilder.append("--> END " + request.method()
                            + " (" + requestBody.contentLength() + "-byte body)" + LINE_SEPARATOR);
                } else {
                    logBuilder.append("--> END " + request.method() + " (binary "
                            + requestBody.contentLength() + "-byte body omitted)" + LINE_SEPARATOR);
                }
            }
        }
        logger.log(logLevel, logBuilder.toString());


        logBuilder.setLength(0);
        long startNs = System.nanoTime();
        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            logBuilder.append("<-- HTTP FAILED: " + e +LINE_SEPARATOR);
            throw e;
        }
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();
        String bodySize = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
        logBuilder.append("\t" +"<-- " + response.code() + ' ' + response.message() + ' '
                + response.request().url() + " (" + tookMs + "ms" + (!logHeaders ? ", "
                + bodySize + " body" : "") + ')' + LINE_SEPARATOR);

        if (logHeaders) {
            Headers headers = response.headers();
            for (int i = 0, count = headers.size(); i < count; i++) {
                logBuilder.append("\t" +headers.name(i) + ": " + headers.value(i) + LINE_SEPARATOR);
            }

            if (!logBody || !HttpHeaders.hasBody(response)) {
                logBuilder.append("<-- END HTTP" + LINE_SEPARATOR);
            } else if (bodyEncoded(response.headers())) {
                logBuilder.append("<-- END HTTP (encoded body omitted)" + LINE_SEPARATOR);
            } else {
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                Buffer buffer = source.buffer();

                Charset charset = UTF8;
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }

                if (!isPlaintext(buffer)) {
                    logBuilder.append("<-- END HTTP (binary " + buffer.size() + "-byte body omitted)" + LINE_SEPARATOR);
                    return response;
                }

                if (contentLength != 0) {
                    logBuilder.append("\t" +buffer.clone().readString(charset) + LINE_SEPARATOR);
                }

                logBuilder.append("<-- END HTTP (" + buffer.size() + "-byte body)" + LINE_SEPARATOR);
            }
        }
        logger.log(logLevel, logBuilder.toString());

        return response;
    }

    */
/**
     * Returns true if the body in question probably contains human readable text. Uses a small sample
     * of code points to detect unicode control characters commonly used in binary file signatures.
     *//*

    static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }
}*/
