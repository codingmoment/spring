# Spring Basic & Miscellaneous Features

##### @SpringBootApplication
It is a convenience annotation that adds the following:
`@Configuration` : Tags the class as source of the beans for the application context
`@EnableAutoConfiguration` : Tells Spring to start adding beans based on classpath settings, other beans and various property settings.
`@ComponentScan` : Tells Spring to look for other components, configurations and services in the current package

##### @EnableAsync
This annotation switches on Spring's ability to run `@Async` methods in a background thread pool.

The `mode()` attribute controls how advice is applied. Default is `AdviceMode.PROXY`. The proxy mode allows for interception of calls through the proxy only; local calls within the same class cannot get intercepted that way.

##### @Async
This annotation  marks a method as a candidate for asynchronous execution. Can also be used at the type level, in which case all the type's methods are considered as asynchronous.

The attribute `value()` can be used to determine the target executor to be used when executing the asynchronous operation(s), matching the qualifier value (or the bean name) of a specific `Executor` or `TaskExecutor` bean definition.

By default, Spring searches for an associated thread pool definition: either a unique `TaskExecutor` bean in the context, or an `Executor` bean named _taskExecutor_ otherwise. If neither of the two is resolvable, a `SimpleAsyncTaskExecutor` will be used to process async method invocations.