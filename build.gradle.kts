import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.7.20"
	kotlin("plugin.spring") version "1.7.20"
	kotlin("plugin.jpa") version "1.7.20"
	id("jacoco")
	id("org.sonarqube") version "3.4.0.2513"
	id("com.avast.gradle.docker-compose") version "0.16.9"
	checkstyle
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-freemarker")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		// exclude(group="junit", module="junit")
		//exclude(group="org.junit.vintage", module="junit-vintage-engine")
	}

	testImplementation("org.junit.platform:junit-platform-suite:1.9.1")
	// testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
	// testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
	testImplementation(kotlin("test"))
	testImplementation("io.cucumber:cucumber-java8:7.8.0")
	testImplementation("io.cucumber:cucumber-junit-platform-engine:7.8.0")
//	testImplementation("io.cucumber:cucumber-spring:7.8.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.test {
	useJUnitPlatform()
	testLogging.showStandardStreams = true
	exclude("**/features/**")
}

tasks.register<Test>("acceptanceTest") {
	val propertyName="calculator.url"
	useJUnitPlatform()
	println("Task: acceptanceTest")
	systemProperties[propertyName] = System.getProperty(propertyName)
	testLogging.showStandardStreams = true
	include("**/features/**")
}

tasks.jacocoTestCoverageVerification {
	violationRules {
		rule {
			limit {
				minimum = "0.2".toBigDecimal()
			}
		}
	}
}

sonarqube {
	properties {
		property("sonar.projectKey", "calculator")
	}
}

tasks.withType<JavaCompile>().configureEach {
	options.compilerArgs = listOf("-Xmx1024m", "-XX:MaxPermSize=256m")
}

dockerCompose {
	useComposeFiles.add("docker-compose.yml")
}