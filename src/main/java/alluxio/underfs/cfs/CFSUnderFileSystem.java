package alluxio.underfs.cfs;

import alluxio.Configuration;
import alluxio.underfs.hdfs.HdfsUnderFileSystem;

public class CFSUnderFileSystem extends HdfsUnderFileSystem
{

    public CFSUnderFileSystem(String fsDefaultName, Configuration alluxioConf, Object conf)
    {
        super(fsDefaultName, alluxioConf, conf);
    }
}
