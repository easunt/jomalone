package com.perfume.jomalone.user.service

import org.jvnet.hk2.annotations.Service
import org.springframework.web.client.RestTemplate

@Service
class UserDeviceService(
    val restTemplate: RestTemplate
) {
    fun test() {
        print(restTemplate.toString())
    }
}