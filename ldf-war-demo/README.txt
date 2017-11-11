# ldf-war-demo 
# 以War包部署到Tomcat下运行
1. 修改打包形式
	在pom.xml里设置  <packaging>war</packaging>
2. 移除嵌入式tomcat插件
	在pom.xml里找到ldf-starter-web依赖节点，在其中添加如下代码：
	<dependencies>
		<dependency>
			<groupId>org.loushang</groupId>
			<artifactId>ldf-starter-web</artifactId>
			<version>0.2.0</version>
			<type>pom</type>
			<!-- 移除嵌入式tomcat插件 -->
			<exclusions>
			  <exclusion>
			    <groupId>org.springframework.boot</groupId>
			    <artifactId>spring-boot-starter-tomcat</artifactId>
			  </exclusion>
			</exclusions>
		</dependency>
	</dependencies>
3. 添加servlet-api的依赖,下面两种方式都可以，任选其一
	<dependency>
	  <groupId>javax.servlet</groupId>
	  <artifactId>javax.servlet-api</artifactId>
	  <version>3.1.0</version>
	  <scope>provided</scope>
	</dependency>
	<dependency>
	  <groupId>org.apache.tomcat</groupId>
	  <artifactId>tomcat-servlet-api</artifactId>
	  <version>8.0.36</version>
	  <scope>provided</scope>
	</dependency>
4. 修改启动类，并重写初始化方法
	Tomcat部署需要类似于web.xml的配置方式来启动spring上下文了，在Application类的同级添加一个SpringBootStartApplication类，其代码如下:
	/**
		* 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
	*/
	public class SpringBootStartApplication extends SpringBootServletInitializer {
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			// 注意这里要指向原先用main方法执行的Application启动类
    		return builder.sources(Application.class);
  		}
	}
