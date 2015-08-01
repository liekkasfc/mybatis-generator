package com.yolipai.server.common.module.sms.service.impl;

import com.yolipai.server.common.module.sms.persistence.dao.TestTableMapper;
import com.yolipai.server.common.module.sms.persistence.entity.TestTable;
import com.yolipai.server.common.module.sms.persistence.entity.TestTableCriteria.Criteria;
import com.yolipai.server.common.module.sms.persistence.entity.TestTableCriteria;
import com.yolipai.server.common.module.sms.service.ITestTableService;
import com.yolipai.server.common.utils.Pager;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testTableService")
public class TestTableServiceImpl implements ITestTableService {
    @Autowired
    private TestTableMapper testTableMapper;

    private static final Logger logger = LoggerFactory.getLogger(TestTableServiceImpl.class);

    public TestTable addTestTable(TestTable record) {
        if(this.testTableMapper.insert(record)==1)
        	return record; 
        return null;
    }

    public boolean deleteTestTable(String id) {
        return this.testTableMapper.deleteByPrimaryKey(id)==1;
    }

    public TestTable modifyTestTable(TestTable record) {
        if(this.testTableMapper.updateByPrimaryKeySelective(record)==1)
        	return record;
        return null;
    }

    public TestTable getTestTable(String id) {
        return this.testTableMapper.selectByPrimaryKey(id);
    }

    private void setCriteria(Criteria criteria, Map<String, Object> params) {
        if(StringUtils.isNotEmpty(params.getOrDefault("id", "").toString()))
        	criteria.andIdEqualTo(params.getOrDefault("id", "").toString());
    }

    public List<TestTable> getTestTables(Map<String, Object> params) {
        TestTableCriteria criteria=new TestTableCriteria();
        Criteria cri = criteria.createCriteria();
        setCriteria(cri, params);
        return this.testTableMapper.selectByCondition(criteria);
    }

    public Pager<TestTable> getPagerTestTable(Map<String, Object> params) {
        Pager<TestTable> pager = new Pager<TestTable>();
        int start = Integer.valueOf(params.getOrDefault("start", 0).toString());
        int size  = Integer.valueOf(params.getOrDefault("size", 10).toString());
        TestTableCriteria criteria = new TestTableCriteria();
        Criteria cri = criteria.createCriteria();
        criteria.setLimitStart(start);
        criteria.setLimitEnd(size);
        setCriteria(cri, params);
        pager.setData(testTableMapper.selectByCondition(criteria));
        pager.setTotal(testTableMapper.countByCondition(criteria));
        return pager;
    }
}