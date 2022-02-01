import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.sql.SQLClientInfoException;

public class AddServletTest {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        Brand brand = new Brand(1,"test","test",100,"这是一条测试数据",1);
//        mapper.addBrand(brand);
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteById() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        System.out.println(mapper.deleteById(79));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByIds() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(new int[]{1, 2, 3});
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateById() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.updateById(new Brand(11, "大米", "大米科技有限公司", 20, "真好处", 1));
        sqlSession.commit();
        sqlSession.close();
    }

}

