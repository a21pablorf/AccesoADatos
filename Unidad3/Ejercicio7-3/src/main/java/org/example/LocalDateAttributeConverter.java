package org.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, String> {

    @Override
    public String convertToDatabaseColumn(LocalDate localDate) {
        if(localDate == null)
            return null;
        return DateTimeFormatter.ofPattern("yyyyMMdd").format(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(String s) {
        if(s == null)
            return null;
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
