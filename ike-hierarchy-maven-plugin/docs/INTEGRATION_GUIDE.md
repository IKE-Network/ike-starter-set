# Integration & Packaging Guide: Decentralized Hierarchy

### 1. The Standard Packaging (Ready for Maven Deploy / Central)

The codebase is split into three clean, decoupled artifacts:

| Artifact | Role | Why It Is Packaged Separately |
| :--- | :--- | :--- |
| `ike-hierarchy-model` | Core Data Model & Parser | Zero dependencies; shared vocabulary for graph validation and JSON indexing. |
| `ike-hierarchy-maven-plugin` | Build & Verification Plugin | Runs in Maven build lifecycle to scan directories, build index, and validate graph closure. |
| `ike-doc-extension` | AsciidoctorJ Extension | Loaded inside Asciidoctor runtime via Java SPI (`ExtensionRegistry`) to expand `include::hierarchy:*[]`. |

---

### 2. How Any Other Project Uses It (2 Snippets in `pom.xml`)

Any downstream repository (e.g. `komet`, `ikm-core`, or a brand new documentation project) can adopt this system by adding just two declarations in their `pom.xml`:

#### Step 1: Add the Hierarchy Indexing Plugin
```xml
<build>
    <plugins>
        <plugin>
            <groupId>network.ike.foundation</groupId>
            <artifactId>ike-hierarchy-maven-plugin</artifactId>
            <version>1-SNAPSHOT</version>
            <executions>
                <execution>
                    <id>hierarchy-index</id>
                    <phase>generate-resources</phase>
                    <goals>
                        <goal>index</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

#### Step 2: Add the Extension to Asciidoctor Maven Plugin
```xml
<plugin>
    <groupId>org.asciidoctor</groupId>
    <artifactId>asciidoctor-maven-plugin</artifactId>
    <dependencies>
        <dependency>
            <groupId>network.ike.foundation</groupId>
            <artifactId>ike-doc-extension</artifactId>
            <version>1-SNAPSHOT</version>
        </dependency>
    </dependencies>
    <configuration>
        <attributes>
            <ike-hierarchy-index>${project.build.directory}/ike-hierarchy-index.json</ike-hierarchy-index>
            <ike-hierarchy-base>${session.rootDirectory}</ike-hierarchy-base>
        </attributes>
    </configuration>
</plugin>
```
