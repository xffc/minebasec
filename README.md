# Installation
### 1. Clone repository (or fork)
```shell
git clone https://github.com/xffc/bscmc
```
### 2. Run servermc:install task
```shell
mvn servermc:install
```
# Running server
```shell
mvn package servermc:copy-plugin servermc:start
```
### Or
```shell
java -jar server.jar -nogui
```
### Or run task "build and run" in Intellij IDEA