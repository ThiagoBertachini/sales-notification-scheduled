package com.tbemerencio.salesnotification.repositories;

import com.tbemerencio.salesnotification.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
