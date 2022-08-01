package am.shop.config;


import java.io.IOException;
import java.util.Map;

import am.shop.model.dto.request.UserRequestDto;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class UserRequestDtoConverter extends AbstractHttpMessageConverter<UserRequestDto> {

    private static final FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected boolean supports(Class<?> clazz) {
        return (UserRequestDto.class == clazz);
    }

    @Override
    protected UserRequestDto readInternal(Class<? extends UserRequestDto> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Map<String, String> vals = formHttpMessageConverter.read(null, inputMessage).toSingleValueMap();
        return mapper.convertValue(vals, UserRequestDto.class);
    }

    @Override
    protected void writeInternal(UserRequestDto myObject, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }

}
