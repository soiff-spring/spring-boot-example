# Spring Boot Example

# Developer Workspace

[![Contribute](http://beta.codenvy.com/factory/resources/codenvy-contribute.svg)](http://beta.codenvy.com/f?id=omriatu352kkthua)

# Recipe

FROM [codenvy/ubuntu_jdk8](https://hub.docker.com/r/codenvy/ubuntu_jdk8/)

# Commands

| #       | Command           | 
| :------------- |:------------- |
| 1      | `mvn -f ${current.project.path} clean install && java -jar ${current.project.path}/target/*.jar` |

# App output

App output is streamed into a console. Note that if your app expects user input, do not use command but execute jars in the terminal directly.

# Features

## Encryption and Decryption

### External Dependencies

1. [JCE](http://cloud.spring.io/spring-cloud-static/spring-cloud.html#_encryption_and_decryption);

### Usage

1. Generate encrypted text value for secret;
1. Update both `logback.password` and `encrypt.key` in `bootstrap.yml`;

### Readme

1. One can use environment `ENCRYPT_KEY` instead of specifying `encrypt.key` in properties.