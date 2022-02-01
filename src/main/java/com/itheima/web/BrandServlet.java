package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<Brand> brands = brandService.selectAll();
        String s = JSON.toJSONString(brands);
        resp.getWriter().println(s);
    }

    public void addBrand(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接受数据品牌
        String s = req.getReader().readLine();
        System.out.println(s);
        Brand brand = JSON.parseObject(s, Brand.class);
        brandService.addBrand(brand);
        resp.getWriter().println(1);
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        int i = brandService.deleteById(Integer.parseInt(s));
        if (i > 0) {
            resp.getWriter().println(1);
        }
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        int[] ints = JSON.parseObject(s, int[].class);
        int i = brandService.deleteByIds(ints);
        if (i > 0) {
            resp.getWriter().println(i);
        }
    }

    public void updateById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        Brand brand = JSON.parseObject(s, Brand.class);
        int i = brandService.updateById(brand);
        if (i > 0) {
            resp.getWriter().println(i);
        }

    }
}
