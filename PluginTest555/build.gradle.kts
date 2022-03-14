group = "com.freedomcraft"
version = "1.0"
description = "${project.name}"

plugins {
    java
	eclipse
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("io.papermc.paperweight.userdev") version "1.3.0"
    id("xyz.jpenilla.run-paper") version "1.0.4" // Adds runServer and runMojangMappedServer tasks for testing
}

repositories {
    mavenCentral()
	mavenLocal()
    gradlePluginPortal()
    
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }

    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/groups/public/")
    }
	
	maven {
		url = uri("https://nexus.velocitypowered.com/repository/maven-public/")
	}

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    
    maven {
        name = "sponge-repo"
        url = uri("https://repo.spongepowered.org/maven/")
    }
}

dependencies {
    paperDevBundle("1.18-R0.1-SNAPSHOT")
    implementation("net.kyori:adventure-text-minimessage:4.1.0-SNAPSHOT")
    implementation("org.spongepowered:configurate-yaml:4.0.0")
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

tasks {
  // Run reobfJar on build
  build {
    dependsOn("reobfJar", "exportRelease")
  }

  compileJava {
    options.encoding = Charsets.UTF_8.name()
  }
  javadoc {
    options.encoding = Charsets.UTF_8.name()
  }
  processResources {
    filteringCharset = Charsets.UTF_8.name()
  }
  shadowJar {
  	archiveFileName.set("${project.name}.jar")
  	minimize {
  	  exclude(dependency("org.spongepowered:configurate-yaml:4.0.0"))
  	}
  }
}

task("exportRelease") {
  doLast {
    copy {
      from(project.getTasks().reobfJar.get().outputJar)
      into("Release/")
      rename { name -> "${project.name}.jar" }
    }
    copy {
      from("Release/${project.name}.jar")
      into("../Local Server/plugins/")
    }
  }
}

val shadowJarArtifact = artifacts.add("archives", file("build/libs/${project.name}.jar")) {
    type = "shadowJar"
    builtBy("shadowJar")
}

publishing {
    publications.create<MavenPublication>("maven") {
        artifact(shadowJarArtifact)
    }
}