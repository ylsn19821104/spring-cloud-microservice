package com.shihui.cloud.user.web;

import com.shihui.cloud.user.model.User;
import com.shihui.cloud.user.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User u = this.userRepository.findOne(id);
        return u;
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance instance = this.discoveryClient.getLocalServiceInstance();
        return instance;
    }
}
