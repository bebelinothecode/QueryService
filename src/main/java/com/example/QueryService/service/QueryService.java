package com.example.QueryService.service;

import com.example.QueryService.entity.QueryServiceEntity;
import com.example.QueryService.repository.QueryServiceRepository;
import com.example.QueryService.request.QueryServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class QueryService {
    @Autowired
    private final QueryServiceRepository queryServiceRepository;//    private final QueryServiceRepository queryServiceRepository;

    public QueryService(QueryServiceRepository queryServiceRepository) {
        this.queryServiceRepository = queryServiceRepository;
    }

    public Page<QueryServiceEntity> searchCallDetailRecords(QueryServiceRequest request, Pageable pageable) {
        if (request.getRecordDateStart() == null || request.getRecordDateEnd() == null) {
            throw new IllegalArgumentException("record_date_start and record_date_end are required.");
        }

        Page<QueryServiceEntity> result = queryServiceRepository.searchByCriteria(
                request.getRecordDateStart(),
                request.getRecordDateEnd(),
                request.getMsisdn(),
                request.getImsi(),
                pageable
        );

        if (result.isEmpty()) {
            throw new RuntimeException("No call detail records found for the given criteria.");
        }
        return result;
    }


}
