package alluxio.underfs.cfs;

import com.google.common.base.Preconditions;

import alluxio.Configuration;
import alluxio.underfs.UnderFileSystem;
import alluxio.underfs.UnderFileSystemFactory;

public class CFSUnderFileSystemFactory implements UnderFileSystemFactory {

	public CFSUnderFileSystemFactory() {
	}

	public UnderFileSystem create(String path, Configuration alluxioConf, Object conf) {
		try {
			Preconditions.checkArgument(path != null, "path may not be null");
			UnderFileSystem ufs = new CFSUnderFileSystem(path, alluxioConf, conf);
			return ufs;
		} catch (RuntimeException e) {
			e.printStackTrace(System.err);
			throw e;
		}
	}

	public boolean supportsPath(String path, Configuration conf) {
		if (path == null)
			return false;
		else
			return isCFSUnderFS(path, conf);
	}

	private boolean isCFSUnderFS(String path, Configuration conf) {
		if (path.startsWith("cfs://")) {
			return true;
		} else {
			return false;
		}
	}
}
