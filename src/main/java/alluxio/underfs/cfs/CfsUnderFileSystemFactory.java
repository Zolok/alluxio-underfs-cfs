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

import java.util.Map;

import javax.annotation.concurrent.ThreadSafe;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import alluxio.Configuration;
import alluxio.underfs.UnderFileSystem;
import alluxio.underfs.UnderFileSystemFactory;

/**
 * Factory for creating {@link CfsUnderFileSystem}.
 *
 * @author Charles Akalugwu <charles.akalugwu@takeaway.com>
 * @since 02.02.2016
 */
@ThreadSafe
public class CfsUnderFileSystemFactory implements UnderFileSystemFactory {

	/**
	 * The Cassandra File System scheme
	 */
	private static final String CFS_SCHEME = "cfs://";

	/**
	 * Cache mapping {@code Path}s to existing {@link UnderFileSystem}
	 * instances. The paths should be normalized to root paths because only
	 * their schemes and authorities are needed to identify which
	 * {@link FileSystem} they belong to.
	 */
	private Map<Path, CfsUnderFileSystem> cfsUfsCache = Maps.newHashMap();

	public UnderFileSystem create(String path, Configuration alluxioConf, Object conf) {
		Preconditions.checkArgument(path != null, "path may not be null");
		
	    Path rootPath = getRoot(new Path(path));
	    synchronized (cfsUfsCache) {
	      if (!cfsUfsCache.containsKey(rootPath)) {
	    	  cfsUfsCache.put(rootPath, new CfsUnderFileSystem(path, alluxioConf, conf));
	      }
	      return cfsUfsCache.get(rootPath);
	    }
	}

	private static Path getRoot(Path path) {
		Path currPath = path;
		while (currPath.getParent() != null) {
			currPath = currPath.getParent();
		}
		return currPath;
	}

	public boolean supportsPath(String path, Configuration conf) {
		if (path == null) {
			return false;
		} else {
			return path.startsWith(CFS_SCHEME);
		}
	}
}
