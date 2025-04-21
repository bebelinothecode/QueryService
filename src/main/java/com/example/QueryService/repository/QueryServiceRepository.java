package com.example.QueryService.repository;

import com.example.QueryService.entity.QueryServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;


public interface QueryServiceRepository extends JpaRepository<QueryServiceEntity, Long> {
    @Query("SELECT c FROM  QueryServiceEntity c" +
            " WHERE c.recordDate BETWEEN :startDate AND :endDate " +
            "AND (:msisdn IS NULL OR c.msisdn = :msisdn) " +
            "AND (:imsi IS NULL OR c.imsi = :imsi)")
    Page<QueryServiceEntity> searchByCriteria(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("msisdn") String msisdn,
            @Param("imsi") String imsi,
            Pageable pageable
    );
}
