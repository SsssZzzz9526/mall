package com.gaffey.mall.modules.pms.controller;


import com.gaffey.mall.modules.pms.model.PmsBrand;
import com.gaffey.mall.modules.pms.service.PmsBrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author gaffey
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/pms/pmsBrand")
public class PmsBrandController {

    private final PmsBrandService pmsBrandService;

    public PmsBrandController(PmsBrandService pmsBrandService) {
        this.pmsBrandService = pmsBrandService;
    }

    @GetMapping("/{id}")
    public PmsBrand getById(@PathVariable Long id) {
        return pmsBrandService.getById(id);
    }
}

