package com.mkeeper;

import com.mkeeper.service.ElasticJobService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Chapter315Main implements CommandLineRunner {

    @Resource
    private ElasticJobService elasticJobService;

    public static void main(String[] args) {
        SpringApplication.run(Chapter315Main.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        elasticJobService.scanAddJob();
    }
}
