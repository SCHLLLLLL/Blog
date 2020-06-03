package com.day1.service;

import com.day1.NotFoundException;
import com.day1.dao.TageRepository;
import com.day1.po.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TageRepository tageRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tageRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tageRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {
        return tageRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tageRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public List<Tag> listTag() {
        return tageRepository.findAll();
    }

    @Transactional
    @Override
    public List<Tag> listTag(String ids) {
        return tageRepository.findAllById(convertToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {

        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return tageRepository.findTop(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tageRepository.findById(id).get();

        if (t == null) {
            throw new NotFoundException("不存在该标签");
        }

        BeanUtils.copyProperties(tag,t);
        return tageRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tageRepository.deleteById(id);
    }


    //字符串ids(1,2,3) 转为list
    private List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null){
            String[] idarray = ids.split(",");
            for (int i = 0; i < idarray.length; i++) {
                list.add(new Long(idarray[i]));

            }
        }
        return list;
    }
}
