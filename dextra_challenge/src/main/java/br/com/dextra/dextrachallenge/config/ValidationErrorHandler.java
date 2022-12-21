package br.com.dextra.dextrachallenge.config;

import br.com.dextra.dextrachallenge.model.dto.ValidationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationDto> handle(MethodArgumentNotValidException exception) {

        List<ValidationDto> vValidationDto = new ArrayList<>();

        List<FieldError> fieldsJson = exception.getBindingResult().getFieldErrors();

        fieldsJson.forEach(e -> {
            String menssage = messageSource.getMessage(e, LocaleContextHolder.getLocale());

            ValidationDto valid = new ValidationDto(e.getField(), menssage);
            vValidationDto.add(valid);
        });

        return vValidationDto;

    }
}
