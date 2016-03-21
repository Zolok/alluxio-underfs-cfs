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

import javax.annotation.concurrent.ThreadSafe;

import alluxio.Configuration;
import alluxio.underfs.UnderFileSystem;
import alluxio.underfs.hdfs.HdfsUnderFileSystem;

/**
 * Cassandra File System {@link UnderFileSystem} implementation. Since the
 * Cassandra File System is HDFS (Hadoop File System) compliant, this
 * implementation simply extends {@link HdfsUnderFileSystem}
 * 
 * @author Charles Akalugwu <charles.akalugwu@takeaway.com>
 * @since 02.02.2016
 */
@ThreadSafe
public class CfsUnderFileSystem extends HdfsUnderFileSystem {

	/**
	 * Constructs a new CFS {@link UnderFileSystem}.
	 *
	 * @param fsDefaultName the under FS prefix
	 * @param alluxioConf the configuration for Alluxio
	 * @param conf the configuration for Hadoop
	 */
	public CfsUnderFileSystem(String fsDefaultName, Configuration alluxioConf, Object conf) {
		super(fsDefaultName, alluxioConf, conf);
	}
}
