package com.nr.fierce_tribe.DW.ODS.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class RequsetTableInfo {
    String table_name;
    String table_type;
    String from_system;
    Date create_date;
}
