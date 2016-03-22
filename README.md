# alluxio-underfs-cfs

Alluxio (formerly Tachyon) Under File System Implementation for Datastax's Cassandra File System (CFS)

For more information about the Alluxio Platform, please visit http://alluxio.org/

## Integrating alluxio-underfs-cfs with Alluxio

Build alluxio-underfs-cfs

```
mvn clean install
```

Copy the alluxio-underfs-cfs jar Artifact to a location (e.g. /opt/alluxio/cfs)

Add the location of alluxio-underfs-cfs jar to the classpath of Alluxio (in ALLUXIO_HOME/conf/alluxio-env.sh)

Add the rest of the datastax enterprise jars to the classpath of Alluxio
```
export ALLUXIO_CLASSPATH="/opt/alluxio/cfs/*:/opt/dse-4.8.4/resources/hadoop/lib/hadoop-core-1.0.4.18.jar:/opt/dse-4.8.4/resources/cassandra/lib/*:/opt/dse-4.8.4/resources/dse/lib/*:/opt/dse-4.8.4/resources/driver/lib/*:/opt/dse-4.8.4/lib/dse-core-4.8.4.jar:/opt/dse-4.8.4/lib/dse-hadoop-4.8.4.jar"
```

Set other Cassandra File System-related variables in alluxio's alluxio-env.sh config file

```
export ALLUXIO_UNDERFS_ADDRESS=cfs://datastax-analytics-node.service
export ALLUXIO_UNDERFS_HDFS_IMPL=com.datastax.bdp.hadoop.cfs.CassandraFileSystem
```

## Building applications with Alluxio UnderFS for CFS

### Dependency Information

#### Apache Maven
```xml
<dependency>
  <groupId>com.takeaway.dia</groupId>
  <artifactId>alluxio-underfs-cfs</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### Gradle

```groovy
compile 'com.takeaway.dia:alluxio-underfs-cfs:1.0.0'
```

#### Apache Ant
```xml
<dependency org="com.takeaway.dia" name="alluxio-underfs-cfs" rev="1.0.0">
  <artifact name="alluxio-underfs-cfs" type="jar" />
</dependency>
```

#### SBT
```
libraryDependencies += "com.takeaway.dia" % "alluxio-underfs-cfs" % "1.0.0"
```

## Contributing to Alluxio UnderFS for Cassandra File System

Contributions via GitHub pull requests are gladly accepted from their original author. Along with
any pull requests, please state that the contribution is your original work and that you license the
work to the project under the project's open source license. Whether or not you state this
explicitly, by submitting any copyrighted material via pull request, email, or other means you agree
to license the material under the project's open source license and warrant that you have the legal
authority to do so.

