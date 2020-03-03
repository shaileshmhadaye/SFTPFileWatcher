package com.neo.demoSftpFileWatcher;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSftpFileWatcherApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSftpFileWatcherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ChannelSftp channelSftp = setupJsch();
		channelSftp.connect();

		String localFile = "src/main/resources/sample.txt";
		String remoteDir = "Test/";

		channelSftp.put(localFile, remoteDir + "jschFile.txt");

		channelSftp.exit();
	}

	private ChannelSftp setupJsch() throws JSchException {
		JSch jsch = new JSch();
		jsch.setKnownHosts("src/main/resources/known_hosts");
		Session jschSession = jsch.getSession("webwerks", "10.0.60.32");
		jschSession.setPassword("p@ssw0rd");
		jschSession.connect();
		return (ChannelSftp) jschSession.openChannel("sftp");
	}
}
