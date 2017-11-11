# ldf-docker-demo
1. 打包的环境下需要安装 Maven，Docker环境

2. 创建 Dockerfile
	创建文件 src/main/docker/Dockerfile:
	FROM frolvlad/alpine-oraclejdk8:slim
	VOLUME /tmp
	ADD ldf-docker-demo-1.0.0.jar app.jar
	#RUN bash -c 'touch /app.jar'
	ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

3. POM中增加Docker打包插件
	<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
			<plugin>
				<groupId>com.spotify</groupId>
				<artifactId>docker-maven-plugin</artifactId>
				<version>0.4.3</version>
				<configuration>
					<imageName>${docker.image.prefix}/${project.artifactId}</imageName>
					<dockerDirectory>src/main/docker</dockerDirectory>
					<resources>
						<resource>
							<targetPath>/</targetPath>
							<directory>${project.build.directory}</directory>
							<include>${project.build.finalName}.jar</include>
						</resource>
					</resources>
				</configuration>
			</plugin>
        </plugins>
	</build>
	
4. 构建 Docker Image
	执行Maven命令：
	mvn package docker:build
	
5. 运行Docker
	docker run -p 8080:8080 -t inspur/ldf-docker-demo