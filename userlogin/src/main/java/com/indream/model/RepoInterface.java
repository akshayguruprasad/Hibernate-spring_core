package com.indream.model;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
@Resource
public interface RepoInterface<T,R> extends JpaRepository<T, R> {}