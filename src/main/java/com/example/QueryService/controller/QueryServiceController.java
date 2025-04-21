package com.example.QueryService.controller;

import com.example.QueryService.entity.QueryServiceEntity;
import com.example.QueryService.request.QueryServiceRequest;
import com.example.QueryService.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/call-detail-records")
public class QueryServiceController {

    @Autowired
    private final QueryService queryService;

    public QueryServiceController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/search")
    public Page<QueryServiceEntity> searchCallDetailRecords(
            @RequestBody QueryServiceRequest request,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return queryService.searchCallDetailRecords(request, PageRequest.of(page, size));
    }
}
