package com.example.vyvsyss4graphql.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
//public class ArtifactRepositoriesInitializer implements ApplicationRunner {
//
//    private final ArtifactRepositories repositories;
//
//    public ArtifactRepositoriesInitializer(ArtifactRepositories repositories) {
//        this.repositories = repositories;
//    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        List<ArtifactRepositoryR> repositoryList = Arrays.asList(
//                new ArtifactRepositoryR("spring-releases", "Spring Releases", "https://repo.spring.io/libs-releases"),
//                new ArtifactRepositoryR("spring-milestones", "Spring Milestones", "https://repo.spring.io/libs-milestones"),
//                new ArtifactRepositoryR("spring-snapshots", "Spring Snapshots", "https://repo.spring.io/libs-snapshots"));
//        repositories.saveAll(repositoryList);
//    }

//}