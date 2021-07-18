# CoinMarketCap Acceptance Test

## Prerequisites
- Maven version 3 or above and JDK version 8 or above are already installed on the host machine.

## Executing the tests

Ensure you are in the project root directory and run the following command from the command line.

To execute all the UI tests
```
$ mvn clean verify

```

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```
$  mvn clean verify -Dwebdriver.driver=firefox
```

Once executed the test results will be stored in this path `target/site/serenity/index.html`.

### Environment-specific configurations and other default config
Application's environments are configured in `test/resources/serenity.conf` file, so that the tests can be run in different environments.


