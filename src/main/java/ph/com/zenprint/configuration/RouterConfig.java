package ph.com.zenprint.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@Configuration
public class RouterConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*
         * 	Set all path that is not index, index.html or api
         *   to route to VueJS front end.
         *
         *   I Also put assets paths (js, css, img) here so that index.html can route on its assets :)
         * */
        registry.addViewController("/{_:^(?!index\\.html|api|js|css|img).*$}")
                .setViewName("forward:/");
        registry.addViewController("/{_:^(?!index\\.html|oauth|api|js|css|img).*$}/**")
                .setViewName("forward:/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}

@Configuration
@Primary
class LocalRoutesConfig extends RouterConfig {

    @Value(value = "${cors.urls}")
    private String corsUrls;

    @Value(value = "${cors.origin}")
    private String origin;

    @Value(value = "${cors.allowed.methods}")
    private String corsAllowedMethods;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String comma = ",";
        Stream.of(corsUrls.split(comma))
                .forEach(url -> registry.addMapping(url)
                        .allowedOrigins(origin)
                        .allowedMethods(corsAllowedMethods.split(comma)));
    }
}
