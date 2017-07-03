package com.seed.dao.usermapper;


import com.seed.entity.user.SeedAddrs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ISeedAddrsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeedAddrs record);

    int insertSelective(SeedAddrs record);

    SeedAddrs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeedAddrs record);

    int updateByPrimaryKey(SeedAddrs record);


    //抽选一条默认地址。
    @Select(" select * from seed_addrs where userid = #{userid} and isdefault ORDER BY createtime desc LIMIT 1 ")
    @ResultMap("BaseResultMap")
    SeedAddrs searchAddrsByUserId(@Param("userid") int userid);


    @Select("select * from seed_addrs where userid = #{userid} ORDER BY createtime desc ")
    @ResultMap("BaseResultMap")
    List<SeedAddrs> getMyAddrListByUserId(@Param("userid") int userid);


    //清除用户的默认状态。
    @Update("UPDATE seed_addrs set isdefault=0 where userid=#{userid}")
    void cleanAddrDefault(@Param("userid")Integer userid);

    //更新为默认地址。
    @Update("UPDATE seed_addrs set isdefault=1 where id=#{addrId}")
    void updateAddrDefaultByAddrId(@Param("addrId") int addrId);


    //根据地址获取一条地址信息。
    @Select("select * from seed_addrs where id=#{addrid}")
    @ResultMap("BaseResultMap")
    SeedAddrs getResAddrsByAddrId(@Param("addrid") int addrid);
}