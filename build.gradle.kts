group = "dev.artsman"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

plugins {
	id("java")
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

val springCloudVersion by extra("2024.0.0")
dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
	}
}

dependencies {
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
	compileOnly("org.projectlombok:lombok")
	implementation("org.mapstruct:mapstruct:1.6.3")
	implementation("org.springframework.boot:spring-boot-starter-web") {
		exclude("org.springframework.boot", "spring-boot-starter-tomcat")
		implementation("org.springframework.boot:spring-boot-starter-undertow")
	}
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(JavaVersion.VERSION_21.majorVersion)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

tasks.withType(Test::class.java) {
	useJUnitPlatform()
}

