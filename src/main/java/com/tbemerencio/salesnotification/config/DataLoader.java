package com.tbemerencio.salesnotification.config;

import com.tbemerencio.salesnotification.entities.Channel;
import com.tbemerencio.salesnotification.entities.Status;
import com.tbemerencio.salesnotification.repositories.ChannelRepository;
import com.tbemerencio.salesnotification.repositories.NotificationRepository;
import com.tbemerencio.salesnotification.repositories.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.ChannelEnums.values())
                .map(Channel.ChannelEnums::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.StatusEnums.values())
                .map(Status.StatusEnums::toStatus)
                .forEach(statusRepository::save);
    }
}
