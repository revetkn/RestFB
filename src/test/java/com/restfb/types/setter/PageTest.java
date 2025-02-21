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
package com.restfb.types.setter;

import org.junit.jupiter.api.Test;

import com.restfb.types.Page;
import com.restfb.types.api.SetterGetterTestBase;

class PageTest extends SetterGetterTestBase {

  @Test
  void test() {
    Page obj = new Page();
    addIgnoredField("rawUpdatedTime");
    addIgnoredField("rawCreatedTime");
    addIgnoredField("rawPicture");
    addIgnoredField("rawLastUsedTime");
    addIgnoredField("rawLabels");
    addIgnoredField("rawHours");
    addIgnoredField("rawHoursMap");
    testInstance(obj);
  }

  @Test
  void testCover() {
    Page.Cover obj = new Page.Cover();
    addIgnoredField("rawUpdatedTime");
    addIgnoredField("rawCreatedTime");
    testInstance(obj);
  }

  @Test
  void testEngagement() {
    Page.Engagement obj = new Page.Engagement();
    testInstance(obj);
  }

  @Test
  void testMailingAddress() {
    Page.MailingAddress obj = new Page.MailingAddress();
    testInstance(obj);
  }

  @Test
  void testPagePaymentOptions() {
    Page.PagePaymentOptions obj = new Page.PagePaymentOptions();
    testInstance(obj);
  }

  @Test
  void testPageRestaurantServices() {
    Page.PageRestaurantServices obj = new Page.PageRestaurantServices();
    testInstance(obj);
  }

  @Test
  void testPageRestaurantSpecialties() {
    Page.PageRestaurantSpecialties obj = new Page.PageRestaurantSpecialties();
    testInstance(obj);
  }

  @Test
  void testPageStartDate() {
    Page.PageStartDate obj = new Page.PageStartDate();
    testInstance(obj);
  }

  @Test
  void testPageStartInfo() {
    Page.PageStartInfo obj = new Page.PageStartInfo();
    testInstance(obj);
  }

  @Test
  void testSettings() {
    Page.Settings obj = new Page.Settings();
    testInstance(obj);
  }

  @Test
  void testVoipInfo() {
    Page.VoipInfo obj = new Page.VoipInfo();
    testInstance(obj);
  }
}
