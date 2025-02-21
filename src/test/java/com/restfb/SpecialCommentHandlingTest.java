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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.restfb.types.Post;

/**
 * Facebook can return Post comment fields as an empty array instead of an empty object. These tests ensure our JSON
 * mapper correctly handles the different forms of comments FB supports.
 * 
 * @author <a href="http://restfb.com">Mark Allen</a>
 * @since 1.5.4
 */
class SpecialCommentHandlingTest extends AbstractJsonMapperTests {
  /**
   * Can we handle comments that are empty arrays?
   */
  @Test
  void emptyArrayTest() {
    Post post = createJsonMapper().toJavaObject(jsonFromClasspath("post-with-empty-comments"), Post.class);
    assertThat(post.getComments().getTotalCount()).isZero();
    assertThat(post.getComments().getData()).isEmpty();
  }

  /**
   * Can we handle comments that are objects with only a count and no data?
   */
  @Test
  void onlyCountTest() {
    Post post = createJsonMapper().toJavaObject(jsonFromClasspath("post-with-comment-count-only"), Post.class);
    assertThat(post.getComments().getTotalCount()).isEqualTo(3);
  }

  /**
   * Can we handle comments that are objects with only a count and no data?
   */
  @Test
  void normalTest() {
    Post post = createJsonMapper().toJavaObject(jsonFromClasspath("post-with-normal-comments"), Post.class);
    assertThat(post.getComments().getData()).hasSize(1);
  }
}