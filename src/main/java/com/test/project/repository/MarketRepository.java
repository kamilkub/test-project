package com.test.project.repository;

import com.test.project.model.Market;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketRepository extends CrudRepository<Market, Integer> {


}
