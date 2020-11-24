package com.lihe.springcloud.service;

import com.lihe.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    @GetMapping("dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @GetMapping("dept/get/list")
    public List<Dept> queryAll();



    @GetMapping("dept/list")
    public boolean addDept(Dept dept);
}
