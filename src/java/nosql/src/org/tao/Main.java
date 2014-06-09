package org.tao;

import com.netflix.astyanax.*;
import com.netflix.astyanax.impl.*;
import com.netflix.astyanax.thrift.*;
import com.netflix.astyanax.connectionpool.*;
import com.netflix.astyanax.connectionpool.impl.*;
import static java.lang.System.out;

public final class Main {
	public static final void main(String[] args) {
		AstyanaxContext<Keyspace> ctx = new AstyanaxContext.Builder()
			.forCluster("Test Cluster")
			.forKeyspace("demodb")
			.withAstyanaxConfiguration(
				new AstyanaxConfigurationImpl()
					.setDiscoveryType(NodeDiscoveryType.NONE))
			.withConnectionPoolConfiguration(
				new ConnectionPoolConfigurationImpl("ubt-pool")
					.setPort(9160)
					.setMaxConnsPerHost(1)
					.setSeeds("127.0.0.1:9160"))
			.withConnectionPoolMonitor(
				new CountingConnectionPoolMonitor())
			.buildKeyspace(ThriftFamilyFactory.getInstance());
		
		ctx.start();
		Keyspace keyspace = ctx.getEntity();
	}
}
