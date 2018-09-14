package com.wangdao.snc.dao;


import com.wangdao.snc.SncApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SncApplication.class)
@WebAppConfiguration
public class NewsDaoTest {

    //@Autowired
    //private NewsDao newsDao;
    //
    //@Test
    //public void selectAllNewsTest(){
    //    List<NewsVo> newsVos = newsDao.selectAllNews();
    //    System.out.println(newsVos.get(0));
    //}
}
