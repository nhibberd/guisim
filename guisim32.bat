@echo off
move %~dp0\lib\32\* "%~dp0\lib"
java -classpath lib\GUISIM.jar;lib\RXTXcomm.jar;lib\foil.jar;lib\gson-1.7.1.jar;lib\jetty-ajp-7.1.6.v20100715.jar;lib\jetty-annotations-7.1.6.v20100715.jar;lib\jetty-client-7.1.6.v20100715.jar;lib\jetty-continuation-7.1.6.v20100715.jar;lib\jetty-deploy-7.1.6.v20100715.jar;lib\jetty-http-7.1.6.v20100715.jar;lib\jetty-io-7.1.6.v20100715.jar;lib\jetty-jmx-7.1.6.v20100715.jar;lib\jetty-jndi-7.1.6.v20100715.jar;lib\jetty-plus-7.1.6.v20100715.jar;lib\jetty-policy-7.1.6.v20100715.jar;lib\jetty-rewrite-7.1.6.v20100715.jar;lib\jetty-security-7.1.6.v20100715.jar;lib\jetty-server-7.1.6.v20100715.jar;lib\jetty-servlet-7.1.6.v20100715.jar;lib\jetty-servlets-7.1.6.v20100715.jar;lib\jetty-util-7.1.6.v20100715.jar;lib\jetty-webapp-7.1.6.v20100715.jar;lib\jetty-websocket-7.1.6.v20100715.jar;lib\jetty-xml-7.1.6.v20100715.jar;lib\pirate.jar;lib\scala-library.jar;lib\scalaz-core_2.8.0-5.0-sources.jar;lib\scalaz-core_2.8.0-5.0.jar;lib\servlet-api-2.5.jar -Djava.library.path=%~dp0\lib lib\guisim.server.GuiSim