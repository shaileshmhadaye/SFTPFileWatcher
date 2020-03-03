package com.neo.demoSftpFileWatcher;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizer;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizingMessageSource;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class Polling {


    @Bean
    DefaultSftpSessionFactory sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        //factory.setPrivateKey(privateKey);

        factory.setHost("localhost");
        factory.setUser("webwerks");
        factory.setPassword("p@ssw0rd");
        factory.setPort(22);
        factory.setAllowUnknownKeys(true);
        return factory;
    }

    @Bean
    SftpInboundFileSynchronizer sftpInboundFileSynchronizer() {
        SftpInboundFileSynchronizer fileSync = new SftpInboundFileSynchronizer(sftpSessionFactory());
        fileSync.setDeleteRemoteFiles(false);
        fileSync.setRemoteDirectory("hello");
        //fileSync.setFilter(new SftpSimplePatternFileListFilter("*.pdf"));
        return fileSync;
    }

    @Bean
    @InboundChannelAdapter(channel = "sftpChannel", poller = @Poller(fixedDelay = "5000"))
    public MessageSource<File> sftpMessageSource() {
        SftpInboundFileSynchronizingMessageSource source = new SftpInboundFileSynchronizingMessageSource(sftpInboundFileSynchronizer());
        source.setLocalDirectory(new File("sftp-inbound"));
        source.setAutoCreateLocalDirectory(true);
        source.setLocalFilter(new AcceptOnceFileListFilter<File>());
        //source.setMaxFetchSize(1);
        return source;
    }

    @Bean
    @ServiceActivator(inputChannel="sftpChannel")
    MessageHandler messageHandler() {
        return new MessageHandler() {

            public void handleMessage(Message<?> arg0) throws MessagingException {
                File f = (File) arg0.getPayload();
                System.out.println(f.getName());
                //do something usefull
            }

        };
    }
}
