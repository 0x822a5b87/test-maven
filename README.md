# test-maven
test-maven

## reference

- [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)
- [Maven 入门指南](https://www.jianshu.com/p/b4ef9978d85d)
- [Maven 生命周期](https://www.jianshu.com/p/fd43b3d0fdb0)
- [Maven 默认插件以及功能](https://www.jianshu.com/p/977b71e2837e)
- [maven 依赖管理](https://www.jianshu.com/p/f6ca45865025)
- [maven-shade-plugin 入门指南](https://www.jianshu.com/p/7a0e20b30401)
- [maven-assembly-plugin 入门指南](https://www.jianshu.com/p/14bcb17b99e0)

## Maven Getting Started Guide

### How do I make my first Maven project?

```bash
mkdir archetype

mvn archetype:generate -DgroupId=com.xxx -DartifactId=arthetype -Dpackagename=com.xxx -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

### How do I xxx my project?

> the compiled classes were placed in `${basedir}/target/classes`

```bash
mvn compile
```

> You can now take a look in the `${basedir}/target` directory and you will see the generated JAR file.

````bash
mvn package
````

> Now you'll want to install the artifact you've generated (the JAR file) in your local repository (`${user.home}/.m2/repository` is the default location)

```bash
mvn install
```

### How do I add resources to my JAR?

> You see below in our example we have added the directory `${basedir}/src/main/resources` into which we place any resources we wish to package in our JAR. The simple rule employed by Maven is this: 
>
> **any directories or files placed within the `${basedir}/src/main/resources` directory are packaged in your JAR `with the exact same structure starting at the base of the JAR`.**

### How do I filter resource files?

> Sometimes a resource file will need to contain a value that can only be supplied at build time. To accomplish this in Maven, put a reference to the property that will contain the value into your resource file using the syntax `${<property name>}`. The property can be one of the values defined in your pom.xml, a value defined in the user's settings.xml, a property defined in an external properties file, or a system property.
>
> To have Maven filter resources when copying, simply set `filtering` to true for the resource directory in your `pom.xml`:

```xml
  <build>
    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <filtering>true</filtering>
      </resource>
    </resources>
  </build>
```

> include file with property

```xml
        <resources>
            <resource>
                <directory>src/main/resources/${env}</directory>
                <includes>
                    <include>**</include>
                </includes>
            </resource>
        </resources>
```

### How do I build other types of projects?

```bash
mvn archetype:generate \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DarchetypeArtifactId=maven-archetype-webapp \
    -DgroupId=com.mycompany.app \
    -DartifactId=my-webapp
```

> use `<packaging>war</packaging>`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
 
  <groupId>com.mycompany.app</groupId>
  <artifactId>my-webapp</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>
 
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
 
  <build>
    <finalName>my-webapp</finalName>
  </build>
</project>
```

```bash
mvn package
```

### How do I build more than one project at once?

> file structure

```
+- pom.xml
+- my-app
| +- pom.xml
+- my-webapp
| +- pom.xml
```

> The POM file you'll create should contain the following:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
 
  <groupId>com.mycompany.app</groupId>
  <artifactId>app</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>
 
  <modules>
    <module>my-app</module>
    <module>my-webapp</module>
  </modules>
</project>
```

> We'll need a dependency on the JAR from the webapp, so add this to `my-webapp/pom.xml`:

```xml
  <dependencies>
    <dependency>
      <groupId>com.mycompany.app</groupId>
      <artifactId>my-app</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
    ...
  </dependencies>
```

> Finally, add the following `<parent>` element to both of the other `pom.xml` files in the subdirectories:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <groupId>com.mycompany.app</groupId>
    <artifactId>app</artifactId>
    <version>1.0-SNAPSHOT</version>
  </parent>
  ...
```





































