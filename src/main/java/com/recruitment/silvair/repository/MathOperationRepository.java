package com.recruitment.silvair.repository;

import com.recruitment.silvair.model.MathOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MathOperationRepository extends JpaRepository<MathOperation,Long> {

    @Query(value = "SELECT sum(score) FROM (SELECT score FROM math_operation ORDER BY date_of_adding DESC LIMIT 10) as grouped",nativeQuery = true)
    double getSumOfLastTenResults();

    @Query(value = "select count(date_of_adding)/60 from math_operation where date_of_adding>now()-interval 60 second and type_of_operation=?1",nativeQuery = true)
    double getStatForLastMin(int type);

    @Query(value = "select count(date_of_adding)/3600 from math_operation where date_of_adding>now()-interval 3600 second and type_of_operation=?1",nativeQuery = true)
    double getStatForLastH(int type);

    @Query(value = "select count(date_of_adding)/86400 from math_operation where date_of_adding>now()-interval 86400 second and type_of_operation=?1",nativeQuery = true)
    double getStatForLastDay(int type);

}
