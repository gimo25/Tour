package com.jalasoft.Tour.application.utils;

import java.io.IOException;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 * @author Giordano Bortolini
 */
public class CSVStreamHttpConverter<T> extends AbstractHttpMessageConverter<T> {

  public CSVStreamHttpConverter() {
    super(new MediaType("text", "csv"));
  }

  @Override
  protected boolean supports(Class<?> clazz) {
    return CSVStreamingOutput.class.isAssignableFrom(clazz);
  }

  @Override
  protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage)
      throws IOException, HttpMessageNotReadableException {
    // not supported
    return null;
  }

  @Override
  protected void writeInternal(T t, HttpOutputMessage outputMessage)
      throws IOException, HttpMessageNotWritableException {

    CSVStreamingOutput streamingOutput= (CSVStreamingOutput) t;
    streamingOutput.write(outputMessage.getBody());
  }
}
