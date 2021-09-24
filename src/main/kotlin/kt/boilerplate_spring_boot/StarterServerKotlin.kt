package kt.boilerplate_spring_boot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.client.discovery.EnableDiscoveryClient



@SpringBootApplication
@EnableDiscoveryClient
class SampleSpringKotlinMicroserviceApplication

fun main(args: Array<String>) {
    runApplication<SampleSpringKotlinMicroserviceApplication>(*args)
}