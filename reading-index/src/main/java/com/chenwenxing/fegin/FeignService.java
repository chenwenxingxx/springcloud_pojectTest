package com.chenwenxing.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "light-reading-cloud-book")
@Component
public interface FeignService {

    @RequestMapping("/book/bookList")
    public String getBookList();




}
