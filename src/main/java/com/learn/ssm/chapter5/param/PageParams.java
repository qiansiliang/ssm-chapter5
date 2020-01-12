package com.learn.ssm.chapter5.param;

import lombok.Data;

@Data
public class PageParams {
    private int offset;
    private int limit;
}
