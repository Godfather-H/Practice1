package com.itheima.mapper;

import com.itheima.pojo.user;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface mapperDemo {
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values" +
            "(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(user emp);

    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId},update_time = #{updateTime} where id = #{id}")
    public void update(user emp);

    @Select("select * from emp where id = #{id}")
    public user select(Integer id);

  /*  @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and" +
            " entrydate between #{begin} and #{end} order by update_time desc")*/
    public List<user> list(String name, Short gender, LocalDate begin, LocalDate end);

    public void updateDynamically(String username, String name, Short gender, String image, Short job, LocalDate entrydate, Integer deptId, LocalDateTime updateTime, Integer id);

    public void deleteDynamically(List<Integer> ids);
}
