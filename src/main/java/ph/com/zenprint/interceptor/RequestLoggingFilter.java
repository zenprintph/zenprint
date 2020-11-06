package ph.com.zenprint.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import ph.com.zenprint.property.LogProperty;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Choy
 * @date 11/2/2020.
 */

@Slf4j
@RequiredArgsConstructor
@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private final List<MediaType> VISIBLETYPES = Arrays.asList(
            MediaType.valueOf("text/*"),
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_FORM_URLENCODED,
            MediaType.valueOf("application/*+json"),
            MediaType.valueOf("application/*+xml"),
            MediaType.MULTIPART_FORM_DATA
    );

    private final LogProperty logProperty;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (isAsyncDispatch(request)) {
            filterChain.doFilter(request, response);
        } else {
            doFilterWrapped(wrapRequest(request), wrapResponse(response), filterChain);
        }
    }

    private void doFilterWrapped(ContentCachingRequestWrapper request,
                                 ContentCachingResponseWrapper response,
                                 FilterChain filterChain) throws IOException, ServletException {
        if (request.getRequestURI().contains("/actuator")) {
            filterChain.doFilter(request, response);
            response.copyBodyToResponse();
            return;
        }

        long startTime = System.currentTimeMillis();

        try {
            beforeRequest(request);
            filterChain.doFilter(request, response);
        } finally {
            afterRequest(request, response, (System.currentTimeMillis() - startTime));
            response.copyBodyToResponse();
        }
    }

    private void beforeRequest(ContentCachingRequestWrapper request) {
        if (log.isInfoEnabled()) {
            logRequestHeader(request, logProperty.getBeforeRequestPrefix());
        }
    }

    private void afterRequest(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response,
                              long responseTime) {
        if (log.isInfoEnabled()) {
            logRequestBody(request, logProperty.getAfterRequestPrefix(), responseTime);
            logResponse(response, logProperty.getAfterResponsePrefix(), responseTime);
        }
    }

    private void logRequestHeader(ContentCachingRequestWrapper request, String prefix) {
        String queryString = request.getQueryString();

        MDC.put("ipAddress", Optional
                .ofNullable(request.getHeader("X-Forwarder-For"))
                .orElse("0.0.0.0"));

        if (Objects.isNull(queryString)) {
            log.info("{} {} {}", prefix, request.getMethod(), request.getRequestURI());
        } else {
            log.info("{} {} {}?{}", prefix, request.getMethod(), request.getRequestURI(), queryString);
        }
    }

    private void logResponse(ContentCachingResponseWrapper response, String prefix, long responseTime) {
        int status = response.getStatus();
        byte[] content = response.getContentAsByteArray();

        if (content.length > 0) {
            logContent(content,
                    response.getContentType(),
                    response.getCharacterEncoding(),
                    HttpStatus.valueOf(status),
                    prefix,
                    responseTime);
        } else {
            log.info("{} Status={}; Time={}ms;",
                    prefix,
                    status,
                    responseTime);
        }
    }

    private void logRequestBody(ContentCachingRequestWrapper request, String prefix, long responseTime) {
        byte[] content = request.getContentAsByteArray();

        if(content.length > 0) {
            logContent(content, request.getContentType(), request.getCharacterEncoding(),
                    null, prefix, responseTime);
        } else {
            logRequestHeader(request, logProperty.getAfterRequestPrefix());
        }
    }

    private void logContent(byte[] content, String contentType, String contentEncoding,
                            HttpStatus status, String prefix, long responseTime) {
        MediaType mediaType = MediaType.valueOf(contentType);
        boolean visible = VISIBLETYPES.stream().anyMatch(visibleType -> visibleType.includes(mediaType));

        if(visible) {
            try {
                String contentString = new String(content, contentEncoding);
                log.info("{} Status={}; Time={}ms; Content={};",
                        prefix,
                        status != null ? status.value() : Strings.EMPTY,
                        responseTime,
                        contentString.replaceAll("[\n\r]", " ")
                .replaceAll("\"image\":\"(.*?)\"", "\"image\":\"base64image\""));

            } catch (UnsupportedEncodingException e) {
                log.info("{} Status={}; Time={}ms; [{} bytes content]",
                        prefix,
                        status,
                        responseTime,
                        content.length);
            }
        } else {
            log.info("{} Status={}; Time={}ms; [{} bytes content]",
                    prefix,
                    status,
                    responseTime,
                    content.length);
        }
    }

    private ContentCachingRequestWrapper wrapRequest(HttpServletRequest request) {
        if (request instanceof ContentCachingRequestWrapper) {
            return (ContentCachingRequestWrapper) request;
        } else {
            return new ContentCachingRequestWrapper(request);
        }
    }

    private ContentCachingResponseWrapper wrapResponse(HttpServletResponse response) {
        if (response instanceof ContentCachingResponseWrapper) {
            return (ContentCachingResponseWrapper) response;
        } else {
            return new ContentCachingResponseWrapper(response);
        }
    }
}