# [HectaLib](https://hectus.net/lib)
Library used for creating Java code with [Hectus](https://hectus.net/) support.

## Usage

Our latest Maven and Gradle artifacts are on the [HectaLib website](https://hectus.net/lib)

Using the Library with its API features that use our [API services](https://api.hectus.net/info) will give us the right to send any type of request.  

### How to implement in your code

The first step when using the library is to create an entry point for the library  
You have to set the Environment and the hectalib-config.yml file location:  
```java
public class Main {
    public static void main(String[] args) {
        HectaLib.setEnv(Env.GENERIC);
        HectaLib.setConfig("path/to/project/hectalib-config.yml");
    }
}
```

When this is set, you can start using the HectaLib.  

Some features only work with a specific environment:

For example: `Server.getCurrent()` only works with the environment set to `Bukkit`, `Client` or `Fabric`  
Or: `this.getServerPlugin()` only works with the environment set to `Bukkit`.

### Gradle/Maven

To use the library in Maven, you have to add this to your pom.xml file:
```xml
<dependency>
    <groupId>net.hectus.api.hectalib</groupId>
    <artifactId>hectalib</artifactId>
    <version>0.0.1</version>
</dependency>
```