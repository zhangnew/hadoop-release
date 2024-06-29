/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.fs.s3a;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ClientOptions;

import java.io.IOException;
import java.net.URI;

public class NonChunkedDefaultS3ClientFactory extends DefaultS3ClientFactory {
    @Override
    public AmazonS3 createS3Client(URI name) throws IOException {
        final AmazonS3 s3 = super.createS3Client(name);
        s3.setS3ClientOptions(
                S3ClientOptions.builder()
                        .disableChunkedEncoding()
                        .setPathStyleAccess(true)
                        .build());
        return s3;
    }
}
