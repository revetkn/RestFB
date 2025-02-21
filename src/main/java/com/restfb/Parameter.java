/*
 * Copyright (c) 2010-2025 Mark Allen, Norbert Bartels.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.restfb;

import static com.restfb.util.StringUtils.isBlank;
import static com.restfb.util.StringUtils.trimToEmpty;
import static java.lang.String.format;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import com.restfb.exception.FacebookJsonMappingException;

/**
 * Representation of a Facebook API request parameter.
 * 
 * @author <a href="http://restfb.com">Mark Allen</a>
 */
public final class Parameter {
  /**
   * Parameter name.
   */
  public final String name;

  /**
   * Parameter value.
   */
  public final String value;

  /**
   * Creates a new parameter with the given {@code name} and {@code value}.
   * 
   * @param name
   *          The parameter name.
   * @param value
   *          The parameter value.
   * @param jsonMapper
   *          Mapper for converting the parameter value to JSON.
   * @throws IllegalArgumentException
   *           If {@code name} is {@code null} or a blank string or either {@code value} or {@code jsonMapper} is
   *           {@code null}.
   */
  private Parameter(String name, Object value, JsonMapper jsonMapper) {
    if (isBlank(name) || value == null) {
      throw new IllegalArgumentException(Parameter.class + " instances must have a non-blank name and non-null value."
          + " Got instead name:" + name + ", value:" + value);
    }

    this.value = Optional.ofNullable(jsonMapper)
      .orElseThrow(() -> new IllegalArgumentException("Provided " + JsonMapper.class + " must not be null."))
      .toJson(value, true);
    this.name = trimToEmpty(name);
  }

  /**
   * Factory method which provides an instance with the given {@code name} and {@code value}.
   * <p>
   * The {@code value} parameter is often a {@link String} or primitive type like {@link Integer}, but you may pass in a
   * {@link java.util.List}, {@link java.util.Map}, or your own <tt>@Facebook</tt>-annotated Javabean, and it will be
   * converted to JSON automatically. See the "attachment" section of
   * <a href="http://wiki.developers.facebook.com/index.php/Stream.publish">the stream.publish API documentation</a> for
   * an example of where this is useful.
   * 
   * @param name
   *          The parameter name.
   * @param value
   *          The parameter value.
   * @return A {@code Parameter} instance with the given {@code name} and {@code value}.
   * @throws IllegalArgumentException
   *           If {@code name} or {@code value} is {@code null} or a blank string.
   * @throws FacebookJsonMappingException
   *           If an error occurs when converting {@code value} to JSON.
   */
  public static Parameter with(String name, Object value) {
    return Parameter.with(name, value, new DefaultJsonMapper());
  }

  /**
   * convenience factory method which needs a comma separated list of fields that the dev likes to fetch from the API
   * 
   * @param fieldList
   *          comma separated list of fields
   * @return Parameter object
   */
  public static Parameter withFields(String fieldList) {
    return Parameter.with("fields", fieldList);
  }

  /**
   * Convenience factory method that creates a {@code Parameter} object to retrieve the metadata from the API.
   *
   * @return Parameter object
   */
  public static Parameter withMetadata() {
    return Parameter.with("metadata", "1");
  }

  /**
   * convenience factory method which creates a {@code Parameter} object to fetch data from API with given locale
   *
   * @param locale
   *          the locale that should be used to fetch the data
   *
   * @return Parameter object
   */
  public static Parameter withLocale(Locale locale) {
    return Parameter.with("locale", locale.getLanguage());
  }

  /**
   * convenience factory method which creates a {@code Parameter} object to fetch data from API with given limit
   *
   * @param limit
   *          the limit that should be used fetching data
   *
   * @return Parameter object
   */
  public static Parameter withLimit(int limit) {
    return Parameter.with("limit", limit);
  }

  /**
   * convenience factory method which creates a {@code Parameter} object to post an object with a message parameter to
   * the API
   *
   * @param obj
   *          The content of the message, should be a String, but maybe some JSON
   *
   * @return Parameter object
   */
  public static Parameter withMessage(Object obj) {
    return Parameter.with("message", obj);
  }

  /**
   * convenience factory method which creates a {@code Parameter} object to query some information e.g. searching profiles
   * the API
   *
   * @param queryString
   *          the String used in the query
   *
   * @return Parameter object
   */
  public static Parameter withQuery(String queryString) {
    return Parameter.with("q", queryString);
  }

  /**
   * Factory method which provides an instance with the given {@code name} and {@code value}, using the provided
   * {@code jsonMapper} to turn {@code value} into a JSON string.
   * <p>
   * The {@code value} parameter is often a {@link String} or primitive type like {@link Integer}, but you may pass in a
   * {@link java.util.List}, {@link java.util.Map}, or your own <tt>@Facebook</tt>-annotated Javabean, and it will be
   * converted to JSON automatically. See the "attachment" section of
   * <a href="http://wiki.developers.facebook.com/index.php/Stream.publish">the stream.publish API documentation</a> for
   * an example of where this is useful.
   * 
   * @param name
   *          The parameter name.
   * @param value
   *          The parameter value.
   * @param jsonMapper
   *          The jsonMapper
   * @return A {@code Parameter} instance with the given {@code name} and {@code value}.
   * @throws IllegalArgumentException
   *           If {@code name} or {@code value} is {@code null} or a blank string.
   * @throws FacebookJsonMappingException
   *           If an error occurs when converting {@code value} to JSON.
   */
  public static Parameter with(String name, Object value, JsonMapper jsonMapper) {
    return new Parameter(name, value, jsonMapper);
  }

  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Parameter parameter = (Parameter) o;
    return Objects.equals(name, parameter.name) && Objects.equals(value, parameter.value);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 37 * hash + this.name.hashCode();
    hash = 41 * hash + this.value.hashCode();
    return hash;
  }

  @Override
  public String toString() {
    return format("Parameter[%s=%s]", name, value);
  }
}