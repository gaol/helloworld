package io.gaol.demos.helloworld;

import java.util.Random;

import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.RoutingContext;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Helloworld {

    private static final Random random = new Random(100);

    @Route(path = "/hello", methods = Route.HttpMethod.GET)
    void hello(RoutingContext rc) {
        rc.response().end(System.getenv()
        .getOrDefault("HOSTNAME", "default_hostname"));
    }

    @Route(path = "/guess", methods = Route.HttpMethod.GET)
    void guess(RoutingContext rc) {
        rc.response().end(String.format("Guess the number: %d", random.nextInt(100)));
    }
}