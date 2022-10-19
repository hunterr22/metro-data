package com.metro.repository;

import org.springframework.data.repository.CrudRepository;

import com.metro.domain.Events;

public interface EventsRepository extends CrudRepository<Events, Long> {

}
