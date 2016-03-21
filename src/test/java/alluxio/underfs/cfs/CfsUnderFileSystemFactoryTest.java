/*
 * Takeaway.com licenses this work under the Apache License, version 2.0
 * (the “License”). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.underfs.cfs;

import org.junit.Test;

import alluxio.Configuration;
import alluxio.underfs.UnderFileSystemFactory;
import alluxio.underfs.UnderFileSystemRegistry;
import junit.framework.Assert;

/**
 * Unit tests for the {@link CfsUnderFileSystemFactory}.
 * 
 * @author Charles Akalugwu <charles.akalugwu@takeaway.com>
 * @since 02.02.2016
 */
public class CfsUnderFileSystemFactoryTest {

  /**
   * This test ensures the CFS UFS module correctly accepts paths that begin with cfs://.
   */
  @Test
  public void factoryTest() {
    Configuration conf = new Configuration();

    UnderFileSystemFactory factory =
        UnderFileSystemRegistry.find("cfs://localhost/test/path", conf);
    Assert.assertNotNull(
        "A UnderFileSystemFactory should exist for CFS paths when using this module", factory);

    factory = UnderFileSystemRegistry.find("s3://localhost/test/path", conf);
    Assert.assertNull(
        "A UnderFileSystemFactory should not exist for S3 paths when using this module", factory);

    factory = UnderFileSystemRegistry.find("alluxio://localhost:19999/test", conf);
    Assert.assertNull("A UnderFileSystemFactory should not exist for non supported paths when "
        + "using this module", factory);
    
    factory = UnderFileSystemRegistry.find("glusterfs://localhost/test/path", conf);
    Assert.assertNull(
        "A UnderFileSystemFactory should not exist for GlusterFS paths when using this module", factory);
  }
}