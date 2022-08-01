package am.shop.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HppResponseConverterDTOConfig implements WebMvcConfigurer{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    private UserRequestDtoConverter converter() {
        UserRequestDtoConverter converter = new UserRequestDtoConverter();
        MediaType mediaType = new MediaType("application", "x-www-form-urlencoded", Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(mediaType));
        return converter;
    }
}
