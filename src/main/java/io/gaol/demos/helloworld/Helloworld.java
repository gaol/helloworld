package io.gaol.demos.helloworld;

import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.RoutingContext;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Helloworld {

    @Route(path = "/hello", methods = Route.HttpMethod.GET)
    void hello(RoutingContext rc) {
        rc.response().end(System.getenv()
        .getOrDefault("HOSTNAME", "default_hostname"));
    }
}