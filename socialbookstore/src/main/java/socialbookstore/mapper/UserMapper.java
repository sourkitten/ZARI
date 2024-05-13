package socialbookstore.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import socialbookstore.domainmodel.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User WHERE User = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO User (User, Role, Pass, FullName, Age) VALUES (#{username}, #{role}, #{password}, #{fullName}, #{age})")
    void insertUser(User user);

    @Update("UPDATE User SET Role = #{role}, Pass = #{password}, FullName = #{fullName}, Age = #{age} WHERE User = #{username}")
    void updateUser(User user);

    @Delete("DELETE FROM User WHERE User = #{username}")
    void deleteUser(String username);
    
    @Select("SELECT * FROM User WHERE User = #{username}")
    User findById(String username);
}
