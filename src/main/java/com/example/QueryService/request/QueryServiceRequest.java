package com.example.QueryService.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class QueryServiceRequest {
    private String recordDateStart; // Required
    private String recordDateEnd;   // Required
    private String msisdn;                 // Optional
    private String imsi;
}
