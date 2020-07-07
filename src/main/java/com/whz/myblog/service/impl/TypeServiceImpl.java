package com.whz.myblog.service.impl;

import com.whz.myblog.enums.StateEnums;
import com.whz.myblog.exception.CustomException;
import com.whz.myblog.mapper.TypeMapper;
import com.whz.myblog.pojo.Type;
import com.whz.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 卫宏哲
 * @Date 2020/6/27 11:20
 * @Version 1.0
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public void save(Type type) {
        // 查询分类是否存在
        Type t = typeMapper.getByName(type.getTypeName());
        if (t != null) {
            throw new CustomException("该分类已存在！");
        }
        typeMapper.insert(type);
    }

    @Override
    public List<Type> getAll() {
        return typeMapper.getAll();
    }

    @Override
    public List<Type> getTypeList() {
        return typeMapper.getTypeList();
    }

    @Override
    public void update(Type type) {
        typeMapper.update(type);
    }

    @Override
    public void enableById(Integer id) {
        // 先查再启用
        Type type = typeMapper.getById(id);
        type.setEnable(StateEnums.ENABLED.getCode());
        typeMapper.update(type);
    }

    @Override
    public void disableById(Integer id) {
        // 先查再弃用
        Type type = typeMapper.getById(id);
        type.setEnable(StateEnums.NOT_ENABLE.getCode());
        typeMapper.update(type);
    }

    @Override
    public void deleteById(Integer id) {
        typeMapper.deleteById(id);
    }

    @Override
    public Type getById(Integer id) {
        return typeMapper.getById(id);
    }
}
