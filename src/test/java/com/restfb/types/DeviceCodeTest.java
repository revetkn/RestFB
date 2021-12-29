/*
 * Copyright (c) 2010-2022 Mark Allen, Norbert Bartels.
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
package com.restfb.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.restfb.AbstractJsonMapperTests;

class DeviceCodeTest extends AbstractJsonMapperTests {

  @Test
  void check_v23_deviceCode() {
    DeviceCode deviceCodeInfo = createJsonMapper().toJavaObject(jsonFromClasspath("v2_3/devicecode"), DeviceCode.class);
    assertNotNull(deviceCodeInfo);
    assertEquals("26743274374324753466371", deviceCodeInfo.getCode());
    assertEquals("DUY5TQRK", deviceCodeInfo.getUserCode());
    assertEquals("https://www.facebook.com/device", deviceCodeInfo.getVerificationUri());
    assertEquals(5, deviceCodeInfo.getInterval().intValue());
    assertEquals(420, deviceCodeInfo.getExpiresIn().intValue());
  }
}
