package com.eloisapaz.cloud.tema08;

import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.health.HealthCheckHandler;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;

public class Runner {
	public static void main(String[] args) {

		HealthCheckHandler healthCheckHandler = new HealthcheckResource();
		Karyon.forRequestHandler(8080,
				new RxNettyHandler("/healthcheck",
						new HealthCheckEndpoint(healthCheckHandler)),
				new KaryonBootstrapModule(healthCheckHandler),
				new ArchaiusBootstrapModule("tema-8"),
				Karyon.toBootstrapModule(KaryonWebAdminModule.class),
				ShutdownModule.asBootstrapModule(),
				KaryonServoModule.asBootstrapModule()
		).startAndWaitTillShutdown();
	}
}