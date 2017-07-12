package cn.xuqplus.mapper;

import cn.xuqplus.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by qqx on 2017/7/10.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user limit 1")
    User findOne();

    @Select("select user_password from user where user_email = #{user_email} limit 1")
    String findPasswordByEmail(@Param("user_email") String user_email);

    @Select("select * from user where user_email = #{user_email} and user_password = #{user_password} limit 1")
    User findUserByEmailAndPassword(@Param("user_email") String user_email, @Param("user_password") String user_password);

    @Select("select * from user where user_id = #{user_id} limit 1")
    User findByUserId(@Param("user_name") String user_id);

    @Select("select * from user where user_name = #{user_name} limit 1")
    User findByUserName(@Param("user_name") String user_name);

    @Insert("insert into user(user_id, user_name, user_email, user_password) values(#{user_id}, #{user_name}, #{user_name}, #{user_password})")
    int insertUser(
            @Param("user_id") String user_id,
            @Param("user_name") String user_name,
            @Param("user_email") String user_email,
            @Param("user_password") String user_password
    );

    @Update("update user set #{column} = #{value} where user_id = #{user_id} limit 1")
    int updateUser(
            @Param("column") String column,
            @Param("value") String value,
            @Param("user_id") String user_id
    );
}
