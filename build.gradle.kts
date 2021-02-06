import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
	kotlin("plugin.jpa") version "1.4.21"
}

group = "com.clairvoyantcoding"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator") //NOTE: Actuator is mainly used to expose operational information about the running application — health, metrics, info, dump, env, etc. It uses HTTP endpoints or JMX beans to enable us to interact with it. Docs: https://www.baeldung.com/spring-boot-actuators
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") //NOTE: Provides the CrudRepository API we use in our repositories to generate SQL for us using JPA. Docs: https://spring.io/guides/gs/accessing-data-jpa/
	implementation("org.springframework.boot:spring-boot-starter-web") //NOTE: Starter of Spring web uses Spring MVC, REST and Tomcat as a default embedded server. When we run our application on our local machine - this is the server that makes it possible. Docs: https://www.javatpoint.com/spring-boot-starter-web
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin") //	implementation "com.fasterxml.jackson.module:jackson-module-kotlin:2.10.0" //NOTE: Makes it so you don't need to annotate your models with @JsonProperty to map fields from json strings
	implementation("org.flywaydb:flyway-core") //NOTE: Flyway is used for database migration management
	implementation("org.jetbrains.kotlin:kotlin-reflect") //NOTE: Reflection is the name for the ability to inspect, load and interact with classes, fields, and methods at runtime. We can do this even when we don’t know what they are at compile time.
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") //NOTE: Adds kotlin to project
	implementation("org.modelmapper:modelmapper:2.3.5") //NOTE: Maps objects of one class to another class
	implementation("org.springdoc:springdoc-openapi-ui:1.2.24") //NOTE: For swagger-ui
	implementation("org.apache.httpcomponents:httpclient") //NOTE: Fixes integration test error: I/O error on POST request for "http://localhost:58941/path": cannot retry due to server authentication, in streaming mode; nested exception is java.net.HttpRetryException: cannot retry due to server authentication, in streaming mode

	developmentOnly("org.springframework.boot:spring-boot-devtools") //NOTE: The aim of the module is to try and improve the development time while working with the Spring Boot application. Spring Boot DevTools pick up the changes and restart the application. Docs: https://www.javatpoint.com/spring-boot-devtools

	runtimeOnly("io.micrometer:micrometer-registry-prometheus") //NOTE: Prometheus is designed to operate on a pull model, scraping metrics from application instances periodically based on service discovery.
	runtimeOnly("org.postgresql:postgresql") //NOTE: Postgres database dependency for our spring project

	testImplementation("org.springframework.boot:spring-boot-starter-test") //NOTE: Needed for juniper java unit testing framework
	testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0") //NOTE: Needed for the mockito java unit testing framework to be useable in kotlin testing classes
	testImplementation("org.mockito:mockito-junit-jupiter:3.0.0") //NOTE: Java unit testing framework
	testImplementation("org.mockito:mockito-core:3.0.0") //NOTE: Java unit testing framework
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
