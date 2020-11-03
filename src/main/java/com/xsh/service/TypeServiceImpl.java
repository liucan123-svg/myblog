package com.xsh.service;

import com.xsh.dao.TypeRepository;
import com.xsh.handler.NotFoundException;
import com.xsh.pojo.Blog;
import com.xsh.pojo.Tag;
import com.xsh.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;


@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getType(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<Type> listTypeTop(Integer size) {

/*        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Type> query = cb.createQuery(Type.class);
        Root<Type> root = query.from(Type.class);
        Join<Type, Blog> join = root.join("blogs", JoinType.LEFT);
        query.select(root).where(join.get("blog.published").in(true)).orderBy(cb.desc(root.get("blogs.size")));
        return manager.createQuery(query).getResultList();*/

        Sort sort=new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable=new PageRequest(0,size,sort);
        return typeRepository.findTop(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t=typeRepository.findOne(id);
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t); //将type里面的值赋值给t
        return typeRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.delete(id);
    }
}
