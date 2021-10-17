import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
	id("org.springframework.boot") version "2.4.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
}
group = "com.cmole"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
repositories {
	mavenCentral()
	jcenter()
}
dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-cache:")
	implementation("org.springframework.boot:spring-boot-starter-actuator:")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.exposed:exposed:0.17.7")
	implementation("org.jetbrains.exposed:spring-transaction:0.17.7")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("com.h2database:h2:1.3.148")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
//tasks.withType<Test> {
//	useJUnitPlatform()
//}